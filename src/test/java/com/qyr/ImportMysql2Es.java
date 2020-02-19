package com.qyr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.qyr.dao.ArticleRes;
import com.qyr.domain.Article;
import com.qyr.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ImportMysql2Es {
	@Autowired
	ArticleRes articleRes;
	
	@Autowired
	ArticleService articleService;
	
	@Test
	public void testImportMysql2Es() {
		Article article = new Article();
		
		article.setStatus(1);
		
		PageInfo<Article> selects = articleService.selects(article, 1, 10000);
		
		articleRes.saveAll(selects.getList());
	}
}
