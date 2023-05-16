package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.SubCast;

public interface SubCastService {

	List<SubCast> findAll();
	SubCast save(SubCast subCast);
	SubCast find(SubCast subCast);
	SubCast findById(Long id);
	SubCast update(SubCast subCast);
}
