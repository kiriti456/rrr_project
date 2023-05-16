package com.rrr.vtr.service;

import java.util.List;

import com.rrr.vtr.jpa.entity.Section;

public interface SectionService {

	List<Section> findAll();
	Section save(Section section);
	Section find(Section section);
	Section findById(Long id);
	Section update(Section section);
}
