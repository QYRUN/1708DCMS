package com.qyr.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.qyr.dao.ArticleRes;
import com.qyr.domain.Article;
import com.qyr.domain.ArticleWithBLOBs;
import com.qyr.service.ArticleService;

public class ArticleListener implements MessageListener<String, String> {
	@Autowired
	ArticleRes articleRes;

	@Autowired
	ArticleService articleService;

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {

		String jsonString = data.value();

		System.err.println("接收成功");

		ArticleWithBLOBs awb = JSON.parseObject(jsonString, ArticleWithBLOBs.class);

		Article article = new Article();

		article.setStatus(1);

		PageInfo<Article> selects = articleService.selects(article, 1, 10000);

		articleRes.save(awb);
		articleRes.saveAll(selects.getList());

		articleService.add(awb);

	}

}
