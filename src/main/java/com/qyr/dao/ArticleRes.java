package com.qyr.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qyr.domain.Article;

public interface ArticleRes extends ElasticsearchRepository<Article, Integer>{
	
	List<Article> findByTitle(String key);
}
