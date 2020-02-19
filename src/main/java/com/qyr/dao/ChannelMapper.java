package com.qyr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qyr.domain.Channel;

public interface ChannelMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
    
    int getChannelCount();

	Integer[] getCategoryById(@Param("channelId")int channelId);
}