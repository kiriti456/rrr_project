package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.Section;
import com.rrr.vtr.jpa.repo.SectionRepository;
import com.rrr.vtr.service.SectionService;

@Component
public class SectionServiceImpl implements SectionService {
	
	@Autowired(required=true)
	SectionRepository sectionRepo;

	@Override
	public List<Section> findAll() {
		return sectionRepo.findAll();
	}

	@Override
	public Section save(Section section) {
		return section!=null && section.getSectionNo()!=null ?
				sectionRepo.save(section): null;
	}
	
	@Override
	public Section find(Section section) {
		if(section==null) {
			return section;
		}
		return section.getId()!=null?
				findById(section.getId()):
					section.getSectionNo()!=null?
							sectionRepo.findBySectionNo(section.getSectionNo()):
								null;
	}

	@Override
	public Section findById(Long id) {
		return sectionRepo.getById(id);
	}

	@Override
	public Section update(Section section) {
		return section.getId()!=null? sectionRepo.save(section): null;
	}
}