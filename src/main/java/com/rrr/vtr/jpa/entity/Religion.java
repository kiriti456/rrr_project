package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the religion database table.
 * 
 */
@Entity
@NamedQuery(name="Religion.findAll", query="SELECT r FROM Religion r")
public class Religion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="religion_code")
	private String religionCode;

	@Column(name="religion_name")
	private String religionName; // txt fld

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="religion")
	@JsonManagedReference("religion")
	private List<VoterDetail> voterDetails;

	public Religion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReligionCode() {
		return this.religionCode;
	}

	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}

	public String getReligionName() {
		return this.religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setReligion(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setReligion(null);

		return voterDetail;
	}

}