package com.springfullstack.FirstJobApp.job.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfullstack.FirstJobApp.job.Job;
import com.springfullstack.FirstJobApp.job.JobRepo;
import com.springfullstack.FirstJobApp.job.JobService;

@Service
public class JobServiceImpl implements JobService{

	//private List<Job> jobs = new ArrayList<>();
	@Autowired
	private JobRepo jobRepo;
	
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	
	@Override
	public void createJob(Job job) {
		jobRepo.save(job);
		
	}


	@Override
	public Job getJobById(Long id) {
		
	return jobRepo.findById(id)
		 .orElse(null);
	}


	@Override
	public Boolean deleteJobById(Long id) {
		try {
			jobRepo.deleteById(id);
			 return true;
		}
		catch(Exception e) {
			return false;
		}
		
		
	}


	@Override
	public Boolean updateJob(Long id, Job job) {
		Optional<Job> jobOptional = jobRepo.findById(id);
		
			
			if(jobOptional.isPresent()){
				Job job1 = jobOptional.get();
				job1.setTitle(job.getTitle());
				job1.setDescription(job.getDescription());
				job1.setMinSalary(job.getMinSalary());
				job1.setMaxSalary(job.getMaxSalary());
				job1.setLocation(job.getLocation());
				jobRepo.save(job1);
				return true;
			}
		return false;
			
	}
	

}
