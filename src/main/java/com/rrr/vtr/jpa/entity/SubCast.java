package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the sub_cast database table.
 * 
 */
@Entity
@Table(name="sub_cast")
@NamedQuery(name="SubCast.findAll", query="SELECT s FROM SubCast s")
public class SubCast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="sub_cast_name")
	private String subCastName; //1 txt fld

	//bi-directional many-to-one association to Cast
	@ManyToOne
	@JsonBackReference
	private Cast cast;

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="subCast")
	@JsonManagedReference("subCast")
	private List<VoterDetail> voterDetails;

	public SubCast() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubCastName() {
		return this.subCastName;
	}

	public void setSubCastName(String subCastName) {
		this.subCastName = subCastName;
	}

	public Cast getCast() {
		return this.cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setSubCast(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setSubCast(null);

		return voterDetail;
	}

}