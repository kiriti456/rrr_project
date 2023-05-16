package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.DataSource;

public interface DataSourceService {

	List<DataSource> findAll();
	DataSource save(DataSource dataSource);
	DataSource find(DataSource dataSource);
	DataSource findById(Long id);
	DataSource update(DataSource dataSource);
}
