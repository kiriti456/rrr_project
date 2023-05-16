package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.PollingStation;

@Repository
public interface PollingStationRepository extends JpaRepository<PollingStation, Long>{

	@Query("select ps from PollingStation ps where ps.boothNo = ?1")
	PollingStation findByBoothNo(String boothNo);
	
	@Query("select ps from PollingStation ps where ps.pollingStationAddressEn = :pollingStationAddressEn")
	PollingStation findByPollingStationAddressEn(@Param("pollingStationAddressEn")String pollingStationAddressEn);
}
