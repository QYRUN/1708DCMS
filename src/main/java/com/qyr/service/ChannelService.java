package com.qyr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qyr.domain.Category;
import com.qyr.domain.Channel;

public interface ChannelService {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	
	
	/**
	 * 
	 * @Title: selectsByChannelId 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectsByChannelId(Integer channelId);
	
	int getChannelCount();


	Integer[] getCategoryById(@Param("channelId")int channelId);
	
}
