package com.bookpartnerportal.bookpartnerportal.bean;
import java.time.LocalDate;
import java.time.LocalDateTime;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name="employee")
public class Employee {
	@Id
	 @Column(name="emp_id",nullable=false,unique=true,columnDefinition="varchar(10)")
		private String empId;
	    @Column(nullable=false,columnDefinition="varchar(20)")
		private String fname;
	    @Column(columnDefinition = "char(1)")
		private String minit;
	    @Column(nullable=false,columnDefinition = "varchar(30)")
		private String lname;
	    @ManyToOne
	    @JoinColumn(name = "job_id", nullable = false)
	    private Jobs job;
	    @Column(name="job_lvl",columnDefinition = "int default '10'")
		private int jobLvl;
	    @ManyToOne
	    @JoinColumn(name = "pub_id", nullable = false)
	    private Publisher publisher;
	    @Column(name = "hire_date",nullable=false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
		private LocalDateTime hireDate ;

		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getMinit() {
			return minit;
		}
		public void setMinit(String minit) {
			this.minit = minit;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public Jobs getJob() {
			return job;
		}
		public void setJob(Jobs job) {
			this.job = job;
		}
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		public int getJobLvl() {
			return jobLvl;
		}
		public void setJobLvl(int jobLvl) {
			this.jobLvl = jobLvl;
		}
		public Publisher getPublisher() {
			return publisher;
		}
		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}

		public LocalDateTime getHireDate() {
			return hireDate;
		}
		public void setHireDate(LocalDateTime hireDate) {
			this.hireDate = hireDate;
		}
		public Employee() {
		}
		public Employee(String empId, String fname, String minit, String lname, Jobs job, int jobLvl,
				Publisher publisher, LocalDateTime hireDate) {
			super();
			this.empId = empId;
			this.fname = fname;
			this.minit = minit;
			this.lname = lname;
			this.job = job;
			this.jobLvl = jobLvl;
			this.publisher = publisher;
			this.hireDate = hireDate;
		}

 
}
