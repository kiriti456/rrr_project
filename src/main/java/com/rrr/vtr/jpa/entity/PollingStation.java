package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the polling_station database table.
 * 
 */
@Entity
@Table(name="polling_station")
@NamedQuery(name="PollingStation.findAll", query="SELECT p FROM PollingStation p")
public class PollingStation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="booth_no")
	private String boothNo; // drp dwm comes from back end

	@Column(name="polling_station_address")
	private String pollingStationAddress;  // drp dwm comes from back end

	@Column(name="polling_station_address_en")
	private String pollingStationAddressEn;

	//bi-directional many-to-one association to Voter_detail
	@OneToMany(mappedBy="pollingStation")
	@JsonManagedReference("pollingStation")
	private List<VoterDetail> voterDetails;

	public PollingStation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoothNo() {
		return this.boothNo;
	}

	public void setBoothNo(String boothNo) {
		this.boothNo = boothNo;
	}

	public String getPollingStationAddress() {
		return this.pollingStationAddress;
	}

	public void setPollingStationAddress(String pollingStationAddress) {
		this.pollingStationAddress = pollingStationAddress;
	}

	public String getPollingStationAddressEn() {
		return this.pollingStationAddressEn;
	}

	public void setPollingStationAddressEn(String pollingStationAddressEn) {
		this.pollingStationAddressEn = pollingStationAddressEn;
	}

	public List<VoterDetail> getVoterDetails() {
		return this.voterDetails;
	}

	public void setVoterDetails(List<VoterDetail> voterDetails) {
		this.voterDetails = voterDetails;
	}

	public VoterDetail addVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().add(voterDetail);
		voterDetail.setPollingStation(this);

		return voterDetail;
	}

	public VoterDetail removeVoterDetail(VoterDetail voterDetail) {
		getVoterDetails().remove(voterDetail);
		voterDetail.setPollingStation(null);

		return voterDetail;
	}

}