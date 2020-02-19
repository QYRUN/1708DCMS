
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.qyr.domain.ArticleWithBLOBs;
import com.qyr.service.ChannelService;
import com.qyr.util.FileUtilIo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class SendTest {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ChannelService service;
	
	@Test
	public void sendTest() throws IOException {
		File article = new File("D:/1708D22");
		String[] list = article.list();
		
		for (String string : list) {
//			System.out.println(string);
			String readFile = FileUtilIo.readFile(new File("D:/1708D22/"+string), "utf8");
//			System.err.println(readFile);
			string = string.replace(".txt", "");
//			System.out.println(string);
			ArticleWithBLOBs awb = new ArticleWithBLOBs();
			
			awb.setTitle(string);
			awb.setContent(readFile);
			awb.setSummary(readFile.substring(50));
			int min = 1;
			int max = 1000;
			int hits = min + ((int)(new Random().nextFloat() * (max - min)));
			awb.setHits(hits);
			hits = hits % 2;
			awb.setHot(hits);
			int min1 = 1;
			int max1 = service.getChannelCount();
			int channelId = min1 + ((int)(new Random().nextFloat() * (max1 - min1)));
			System.err.println(channelId);
			awb.setChannelId(channelId);
			Integer[] categoryId = service.getCategoryById(channelId);
			int randouId = (int)(Math.random()*categoryId.length);
			int aaa = categoryId[randouId];
			awb.setCategoryId(aaa);
			
			String jsonString = JSON.toJSONString(awb);
			
			kafkaTemplate.send("articles", jsonString);
		}
	}
}
