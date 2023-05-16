package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ch.qos.logback.core.subst.Token.Type;

import java.util.List;


/**
 * The persistent class for the constituency database table.
 * 
 */
@Entity
@NamedQuery(name="Constituency.findAll", query="SELECT c FROM Constituency c")
public class Constituency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="assembly_constituency_no")
	private String assemblyConstituencyNo; //1 txt fld

	@Column(name="constituency_name")
	private String constituencyName; //1 txt fld

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="constituency" ,  fetch = FetchType.LAZY)
	@JsonManagedReference("constituency")
	private List<VoterDetail> voterDetails;

	public Constituency() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssemblyConstituencyNo() {
		return this.assemblyConstituencyNo;
	}

	public void setAssemblyConstituencyNo(String assemblyConstituencyNo) {
		this.assemblyConstituencyNo = assemblyConstituencyNo;
	}

	public String getConstituencyName() {
		return this.constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setConstituency(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setConstituency(null);

		return voterDetail;
	}

}