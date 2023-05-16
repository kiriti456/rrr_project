package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long>{

	@Query("select ds from DataSource ds where ds.sourceCode = ?1")
	DataSource findBySourceCode(String sourceCode);
	
	@Query("select ds from DataSource ds where ds.sourceName = :name")
	DataSource findBySourceName(@Param("name")String name);
	
	@Query("select ds from DataSource ds where ds.sourceOriginalId = :sourceOriginalId")
	DataSource findBySourceOriginalId(@Param("sourceOriginalId")String sourceOriginalId);
}
