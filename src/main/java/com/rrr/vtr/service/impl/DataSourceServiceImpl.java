package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.DataSource;
import com.rrr.vtr.jpa.repo.DataSourceRepository;
import com.rrr.vtr.service.DataSourceService;

@Component
public class DataSourceServiceImpl implements DataSourceService {
	
	@Autowired(required=true)
	DataSourceRepository dataSourceRepo;

	@Override
	public List<DataSource> findAll() {
		return dataSourceRepo.findAll();
	}
	
	@Override
	public DataSource save(DataSource dataSource) {
		return dataSource!=null && dataSource.getSourceCode() !=null
				&& dataSource.getSourceName()!=null ? 
						dataSourceRepo.save(dataSource):null;
	}

	@Override
	public DataSource find(DataSource dataSource) {
		if(dataSource==null) {
			return dataSource;
		}
		return dataSource.getId()!=null?
				findById(dataSource.getId()):
					dataSource.getSourceCode()!=null?
							dataSourceRepo.findBySourceCode(dataSource.getSourceCode()):
								dataSource.getSourceName()!=null?
										dataSourceRepo.
										findBySourceName(dataSource.getSourceName()):
											dataSource.getSourceOriginalId()!=null?
													dataSourceRepo
													.findBySourceOriginalId(
															dataSource.getSourceOriginalId()):null;
	}

	@Override
	public DataSource findById(Long id) {
		return dataSourceRepo.getById(id);
	}

	@Override
	public DataSource update(DataSource dataSource) {
		return dataSource.getId()!=null? dataSourceRepo.save(dataSource): null;
	}
	
}