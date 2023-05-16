package com.rrr.vtr.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the data_source database table.
 * 
 */
@Entity
@Table(name="data_source")
@NamedQuery(name="DataSource.findAll", query="SELECT d FROM DataSource d")
public class DataSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;

	@Column(name="source_code")
	private String sourceCode;

	@Column(name="source_name")
	private String sourceName; //1 id : 5

	@Column(name="source_original_id")
	private String sourceOriginalId;

	public DataSource() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceOriginalId() {
		return this.sourceOriginalId;
	}

	public void setSourceOriginalId(String sourceOriginalId) {
		this.sourceOriginalId = sourceOriginalId;
	}

}