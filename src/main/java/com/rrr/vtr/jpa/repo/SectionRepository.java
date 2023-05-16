package com.rrr.vtr.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rrr.vtr.jpa.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{

	@Query("select s from Section s where s.sectionNameEn = ?1")
	Section findBySectionNameEn(String sectionNameEn);
	
	@Query("select s from Section s where s.sectionNo = :sectionNo")
	Section findBySectionNo(@Param("sectionNo")String sectionNo);
}
