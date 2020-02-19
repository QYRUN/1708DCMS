package com.qyr.dao;

import java.util.List;

import com.qyr.domain.Complain;
import com.qyr.vo.ComplainVO;

public interface ComplainMapper {
	
	int insert(Complain complain);
	
	//查询举报
	List<Complain> selects(ComplainVO complainVO);

}
