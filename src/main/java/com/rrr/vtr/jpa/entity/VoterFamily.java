package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the voter_family database table.
 * 
 */
@Entity
@Table(name="voter_family")
@NamedQuery(name="VoterFamily.findAll", query="SELECT v FROM VoterFamily v")
public class VoterFamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="family_id")
	private Long familyId;

	//bi-directional many-to-one association to Voter_detail
	@ManyToOne
	@JoinColumn(name="voter_id")
	private VoterDetail voterDetailFromRelation;

	//bi-directional many-to-one association to Voter_detail
	@ManyToOne
	@JoinColumn(name="relation_voter_id")
	private VoterDetail voterDetailToRelation;
	
	@ManyToOne
	@JoinColumn(name="relation_id")
	private Relation relation;
	

	public VoterFamily() {
	}

	public Long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public VoterDetail getVoterDetailFromRelation() {
		return this.voterDetailFromRelation;
	}

	public void setVoterDetailFromRelation(VoterDetail voterDetail1) {
		this.voterDetailFromRelation = voterDetail1;
	}

	public VoterDetail getVoterDetailToRelation() {
		return this.voterDetailToRelation;
	}

	public void setVoterDetailToRelation(VoterDetail voterDetail2) {
		this.voterDetailToRelation = voterDetail2;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

}