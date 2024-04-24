package com.springfullstack.FirstJobApp.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springfullstack.FirstJobApp.job.Job;
import com.springfullstack.FirstJobApp.review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String companyName;
	private String description;
	
	@JsonIgnore	
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<Review> reviews;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Long id, String companyName, String description, List<Job> jobs) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.description = description;
		this.jobs = jobs;
	}

	public Long getId() {
		return id;
	}

	public void setCompanyId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
