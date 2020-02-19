package com.qyr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qyr.dao.SlideMapper;
import com.qyr.domain.Slide;
import com.qyr.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService {
	@Resource
	private SlideMapper slideMapper;

	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slideMapper.selects();
	}

}
