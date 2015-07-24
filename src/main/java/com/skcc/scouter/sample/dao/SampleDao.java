package com.skcc.scouter.sample.dao;

import com.skcc.scouter.com.dao.DaoRepository;

@DaoRepository
public interface SampleDao {

	public Integer selectPoint(String name);

}
