package com.example.JobTracker;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table
public class Job {

	@Id
	@SequenceGenerator(name="job_sequence", sequenceName="job_sequence", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
	private Long id; 
	private String title;
	private String contactEmail;
	private String company; 
	private Date appliedDate;
	private String description;
	
	/**
	 * 
	 */
	public Job() {
		super();
	}

	/**
	 * @param title
	 * @param company
	 * @param appliedDate
	 * @param description
	 * Constructor without id
	 */
	public Job(String title, String company, Date appliedDate, String description, String contactEmail) {
		super();
		this.title = title;
		this.company = company;
		this.appliedDate = appliedDate;
		this.description = description;
		this.contactEmail = contactEmail;
	}

	
	/**
	 * @param id
	 * @param title
	 * @param company
	 * @param appliedDate
	 * @param description
	 */
	public Job(Long id, String title, String company, Date appliedDate, String description, String contactEmail) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.contactEmail = contactEmail;
		this.appliedDate = appliedDate;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the appliedDate
	 */
	public Date getAppliedDate() {
		return appliedDate;
	}

	/**
	 * @param appliedDate the appliedDate to set
	 */
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", company=" + company + ", appliedDate=" + appliedDate
				+ ", description=" + description + "]";
	}
	
}
