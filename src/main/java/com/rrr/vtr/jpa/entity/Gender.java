package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="gender_code")
	private String genderCode;

	@Column(name="gender_name")
	private String genderName; // 1

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="gender")
	@JsonManagedReference("gender")
	private List<VoterDetail> voterDetails;

	public Gender() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderName() {
		return this.genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setGender(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setGender(null);

		return voterDetail;
	}

}