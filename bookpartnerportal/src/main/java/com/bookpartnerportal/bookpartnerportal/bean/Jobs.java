package com.bookpartnerportal.bookpartnerportal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id", nullable = false, columnDefinition = "smallint")
	private int jobId;
	@Column(name = "job_desc", nullable = false, columnDefinition = "varchar(50) default 'New Position - title not formalized yet'")
	private String jobDesc;
	@Column(name = "min_lvl", nullable = false, columnDefinition = "int")
	private int minLvl;
	@Column(name = "max_lvl", nullable = false, columnDefinition = "int")
	private int maxLvl;

	public Jobs(int jobId, String jobDesc, int minLvl, int maxLvl) {

		this.jobId = jobId;
		this.jobDesc = jobDesc;
		this.minLvl = minLvl;
		this.maxLvl = maxLvl;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public int getMinLvl() {
		return minLvl;
	}

	public void setMinLvl(int minLvl) {
		this.minLvl = minLvl;
	}

	public int getMaxLvl() {
		return maxLvl;
	}

	public void setMaxLvl(int maxLvl) {
		this.maxLvl = maxLvl;
	}

	public Jobs() {

	}

}
