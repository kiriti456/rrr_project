package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="section_name")
	private String sectionName; //1 drp dwm

	@Column(name="section_name_en")
	private String sectionNameEn;

	@Column(name="section_no")
	private String sectionNo; //1 txt fld

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="section")
	@JsonManagedReference("section")
	private List<VoterDetail> voterDetails;

	public Section() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionNameEn() {
		return this.sectionNameEn;
	}

	public void setSectionNameEn(String sectionNameEn) {
		this.sectionNameEn = sectionNameEn;
	}

	public String getSectionNo() {
		return this.sectionNo;
	}

	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setSection(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setSection(null);

		return voterDetail;
	}

}