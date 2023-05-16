package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the `voter_ details` database table.
 * 
 */
@Entity
@Table(name="`voter_ details`")
@NamedQuery(name="VoterDetail.findAll", query="SELECT v FROM VoterDetail v")
public class VoterDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Override
	public String toString() {
		return "VoterDetail [id=" + id + ", cHouseNo=" + cHouseNo + ", fmNameEn=" + fmNameEn + ", fnNameV1=" + fnNameV1
				+ ", housenoEn=" + housenoEn + ", isHead=" + isHead + ", lastnameEn=" + lastnameEn + ", lastnameV1="
				+ lastnameV1 + ", relaionName=" + relaionName + ", relationNameEn=" + relationNameEn
				+ ", relationSurName=" + relationSurName + ", relationSurNameEn=" + relationSurNameEn + ", vidNo="
				+ vidNo + ", voterAge=" + voterAge + ", voterMobile=" + voterMobile + ", voterAltPhone=" + voterAltPhone
				+ ", votersl=" + votersl + ", cast=" + cast + ", constituency=" + constituency + ", gender=" + gender
				+ ", party=" + party + ", pollingStation=" + pollingStation + ", relation=" + relation + ", religion="
				+ religion + ", section=" + section + ", subCast=" + subCast + ", votersFamily=" + votersFamily
				+ ", voterFamilies2=" + voterFamilies2 + "]";
	}

	@Column(name="c_house_no")
	private String cHouseNo;

	@Column(name="fm_name_en")
	private String fmNameEn;

	@Column(name="fn_name_v1")
	private String fnNameV1;

	@Column(name="houseno_en")
	private String housenoEn;

	@Column(name="is_head")
	private String isHead;

	@Column(name="lastname_en")
	private String lastnameEn;

	@Column(name="lastname_v1")
	private String lastnameV1;

	@Column(name="relaion_name")
	private String relaionName;

	@Column(name="relation_name_en")
	private String relationNameEn;

	@Column(name="relation_sur_name")
	private String relationSurName;

	@Column(name="relation_sur_name_en")
	private String relationSurNameEn;

	@Column(name="vid_no")
	private String vidNo;

	@Column(name="`voter_ age`")
	private int voterAge;

	@Column(name="`voter_ mobile`")
	private String voterMobile;

	@Column(name="voter_alt_phone")
	private String voterAltPhone;

	private String votersl;

	//bi-directional many-to-one association to Cast
	@ManyToOne
	@JoinColumn(name="voter_cast_id")
	@JsonBackReference("cast")
	private Cast cast;

	//bi-directional many-to-one association to Constituency
	@ManyToOne
	@JoinColumn(name="voter_constituency_id")
	@JsonBackReference("constituency")
	private Constituency constituency;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name="voter_gender_id")
	@JsonBackReference("gender")
	private Gender gender;

	//bi-directional many-to-one association to Party
	@ManyToOne
	@JoinColumn(name="voter_favorite_party_id")
	@JsonBackReference("party")
	private Party party;

	//bi-directional many-to-one association to PollingStation
	@ManyToOne
	@JoinColumn(name="voter_pollong_station_id")
	@JsonBackReference("pollingStation")
	private PollingStation pollingStation;

	//bi-directional many-to-one association to Relation
	@ManyToOne
	@JoinColumn(name="`voter_ relation_id`")
	@JsonBackReference("relation")
	private Relation relation;

	//bi-directional many-to-one association to Religion
	@ManyToOne
	@JoinColumn(name="voter_religion_id")
	@JsonBackReference("religion")
	private Religion religion;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="voter_section_id")
	@JsonBackReference("section")
	private Section section;

	//bi-directional many-to-one association to SubCast
	@ManyToOne
	@JoinColumn(name="voter_subcast_id")
	@JsonBackReference("subCast")
	private SubCast subCast;

	//bi-directional many-to-one association to VoterFamily
	@OneToMany(mappedBy="voterDetailFromRelation", cascade = CascadeType.PERSIST)
	private List<VoterFamily> votersFamily;

	//bi-directional many-to-one association to VoterFamily
	@OneToMany(mappedBy="voterDetailToRelation")
	private List<VoterFamily> voterFamilies2;

	public VoterDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCHouseNo() {
		return this.cHouseNo;
	}

	public void setCHouseNo(String cHouseNo) {
		this.cHouseNo = cHouseNo;
	}

	public String getFmNameEn() {
		return this.fmNameEn;
	}

	public void setFmNameEn(String fmNameEn) {
		this.fmNameEn = fmNameEn;
	}

	public String getFnNameV1() {
		return this.fnNameV1;
	}

	public void setFnNameV1(String fnNameV1) {
		this.fnNameV1 = fnNameV1;
	}

	public String getHousenoEn() {
		return this.housenoEn;
	}

	public void setHousenoEn(String housenoEn) {
		this.housenoEn = housenoEn;
	}

	public String getIsHead() {
		return this.isHead;
	}

	public void setIsHead(String isHead) {
		this.isHead = isHead;
	}

	public String getLastnameEn() {
		return this.lastnameEn;
	}

	public void setLastnameEn(String lastnameEn) {
		this.lastnameEn = lastnameEn;
	}

	public String getLastnameV1() {
		return this.lastnameV1;
	}

	public void setLastnameV1(String lastnameV1) {
		this.lastnameV1 = lastnameV1;
	}

	public String getRelaionName() {
		return this.relaionName;
	}

	public void setRelaionName(String relaionName) {
		this.relaionName = relaionName;
	}

	public String getRelationNameEn() {
		return this.relationNameEn;
	}

	public void setRelationNameEn(String relationNameEn) {
		this.relationNameEn = relationNameEn;
	}

	public String getRelationSurName() {
		return this.relationSurName;
	}

	public void setRelationSurName(String relationSurName) {
		this.relationSurName = relationSurName;
	}

	public String getRelationSurNameEn() {
		return this.relationSurNameEn;
	}

	public void setRelationSurNameEn(String relationSurNameEn) {
		this.relationSurNameEn = relationSurNameEn;
	}

	public String getVidNo() {
		return this.vidNo;
	}

	public void setVidNo(String vidNo) {
		this.vidNo = vidNo;
	}

	public int getVoterAge() {
		return this.voterAge;
	}

	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}

	public String getVoterMobile() {
		return this.voterMobile;
	}

	public void setVoterMobile(String voterMobile) {
		this.voterMobile = voterMobile;
	}

	public String getVoterAltPhone() {
		return this.voterAltPhone;
	}

	public void setVoterAltPhone(String voterAltPhone) {
		this.voterAltPhone = voterAltPhone;
	}

	public String getVotersl() {
		return this.votersl;
	}

	public void setVotersl(String votersl) {
		this.votersl = votersl;
	}

	public Cast getCast() {
		return this.cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

	public Constituency getConstituency() {
		return this.constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public PollingStation getPollingStation() {
		return this.pollingStation;
	}

	public void setPollingStation(PollingStation pollingStation) {
		this.pollingStation = pollingStation;
	}

	public Relation getRelation() {
		return this.relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public Religion getReligion() {
		return this.religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public SubCast getSubCast() {
		return this.subCast;
	}

	public void setSubCast(SubCast subCast) {
		this.subCast = subCast;
	}

	public List<VoterFamily> getVoterFamily() {
		return this.votersFamily;
	}

	public void setVoterFamily(List<VoterFamily> votersFamily) {
		this.votersFamily = votersFamily;
	}

	public VoterFamily addVoterFamily(VoterFamily voterFamily) {
		getVoterFamily().add(voterFamily);
		voterFamily.setVoterDetailFromRelation(this);

		return voterFamily;
	}

	public VoterFamily removeVoterFamily(VoterFamily voterFamily) {
		getVoterFamily().remove(voterFamily);
		voterFamily.setVoterDetailFromRelation(null);

		return voterFamily;
	}

	public List<VoterFamily> getVoterFamilies2() {
		return this.voterFamilies2;
	}

	public void setVoterFamilies2(List<VoterFamily> voterFamilies2) {
		this.voterFamilies2 = voterFamilies2;
	}

	public VoterFamily addVoterFamilies2(VoterFamily voterFamilies2) {
		getVoterFamilies2().add(voterFamilies2);
		voterFamilies2.setVoterDetailToRelation(this);

		return voterFamilies2;
	}

	public VoterFamily removeVoterFamilies2(VoterFamily voterFamilies2) {
		getVoterFamilies2().remove(voterFamilies2);
		voterFamilies2.setVoterDetailToRelation(null);

		return voterFamilies2;
	}

}