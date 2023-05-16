package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the cast database table.
 * 
 */
@Entity
@NamedQuery(name="Cast.findAll", query="SELECT c FROM Cast c")
public class Cast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="cast_code")
	private String castCode; //1

	@Column(name="cast_name")
	private String castName; //1

	//bi-directional many-to-one association to SubCast
	@OneToMany(mappedBy="cast",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List<SubCast> subCasts; //drop down data comes from backend

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="cast")
	@JsonManagedReference("cast")
	private List<VoterDetail> voterDetails;

	public Cast() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCastCode() {
		return this.castCode;
	}

	public void setCastCode(String castCode) {
		this.castCode = castCode;
	}

	public String getCastName() {
		return this.castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public List<SubCast> getSubCasts() {
		return this.subCasts;
	}

	public void setSubCasts(List<SubCast> subCasts) {
		this.subCasts = subCasts;
	}

	public SubCast addSubCast(SubCast subCast) {
		getSubCasts().add(subCast);
		subCast.setCast(this);

		return subCast;
	}

	public SubCast removeSubCast(SubCast subCast) {
		getSubCasts().remove(subCast);
		subCast.setCast(null);

		return subCast;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setCast(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setCast(null);

		return voterDetail;
	}

}