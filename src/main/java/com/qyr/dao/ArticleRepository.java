package com.qyr.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qyr.domain.ArticleWithBLOBs;

public interface ArticleRepository extends ElasticsearchRepository<ArticleWithBLOBs, Integer>{
	   
	//实现复杂查询
		//按照标题查询,方法名称一定要按照规则写
		List<ArticleWithBLOBs> findByTitle(String key);
		//按照标题或者内容查询,方法名称一定要按照规则写
//		List<ArticleWithBLOBs> findByTitleOrContent(String title,String content);
}