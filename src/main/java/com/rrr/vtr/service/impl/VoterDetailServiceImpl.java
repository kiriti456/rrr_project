package com.rrr.vtr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rrr.vtr.jpa.entity.VoterDetail;
import com.rrr.vtr.jpa.repo.VoterDetailRepository;
import com.rrr.vtr.service.VoterDetailService;

@Component
public class VoterDetailServiceImpl implements VoterDetailService {
	
	@Autowired(required=true)
	VoterDetailRepository voterdetailRepo;

	@Override
	public List<VoterDetail> findAll() {
		return voterdetailRepo.findAll();
	}

	@Override
	public VoterDetail save(VoterDetail voterdetail) {
		return voterdetail!=null && voterdetail.getFmNameEn() !=null 
				&& voterdetail.getLastnameEn()!=null ? 
						voterdetailRepo.save(voterdetail): null;
	}
	
	@Override
	public VoterDetail find(VoterDetail voterdetail) {
		if(voterdetail==null) {
			return voterdetail;
		}
		return voterdetail.getId()!=null?
				findById(voterdetail.getId()):
					voterdetail.getVidNo()!=null?
							voterdetailRepo.findByVidNo(voterdetail.getVidNo()):
								null;
	}

	@Override
	public VoterDetail findById(Long id) {
		return voterdetailRepo.getById(id);
	}

	@Override
	public VoterDetail update(VoterDetail voterdetail) {
		return voterdetail.getId()!=null? voterdetailRepo.save(voterdetail): null;
	}


}