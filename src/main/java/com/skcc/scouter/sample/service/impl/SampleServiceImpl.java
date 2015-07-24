package com.skcc.scouter.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skcc.scouter.sample.dao.SampleDao;
import com.skcc.scouter.sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Resource(name = "sampleDao")
	SampleDao sampleDao;
	
	@Override
	public Integer getPoint(String name) {
		
		return sampleDao.selectPoint(name);
	}

}
