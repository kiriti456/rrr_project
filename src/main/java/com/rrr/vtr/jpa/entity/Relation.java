package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the relation database table.
 * 
 */
@Entity
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r")
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="relation_name")
	private String relationName; //1 txt fld

	@Column(name="relation_name_en")
	private String relationNameEn;

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="relation")
	@JsonManagedReference("relation")
	private List<VoterDetail> voterDetails;

	public Relation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelationName() {
		return this.relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationNameEn() {
		return this.relationNameEn;
	}

	public void setRelationNameEn(String relationNameEn) {
		this.relationNameEn = relationNameEn;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setRelation(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setRelation(null);

		return voterDetail;
	}

}