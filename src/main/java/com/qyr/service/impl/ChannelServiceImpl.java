package com.qyr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qyr.dao.CategoryMapper;
import com.qyr.dao.ChannelMapper;
import com.qyr.domain.Category;
import com.qyr.domain.Channel;
import com.qyr.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channerMapper;
	
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Channel> selects() {
		return channerMapper.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectsByChannelId(channelId);
	}

	@Override
	public int getChannelCount() {
		return channerMapper.getChannelCount();
	}


	@Override
	public Integer[] getCategoryById(int channelId) {
		return channerMapper.getCategoryById(channelId);
	}

}
