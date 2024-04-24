package com.springfullstack.FirstJobApp.job.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springfullstack.FirstJobApp.job.Job;
import com.springfullstack.FirstJobApp.job.JobService;

@Service
public class JobServiceImpl implements JobService{

	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	
	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobs.add(job);
		
	}


	@Override
	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		for (Job job : jobs) {
			if(job.getId().equals(id)) return job;
		}
		
		return null;
	}


	@Override
	public Boolean deleteJobById(Long id) {
		for (Job job : jobs) {
			if(job.getId().equals(id)) {
				jobs.remove(job);
				return true;
			}
		}
		return false;
		
	}


	@Override
	public Boolean updateJob(Long id, Job job) {
		Iterator<Job> iterator = jobs.iterator();
		while(iterator.hasNext())
		{
			Job job1 = iterator.next();
			if(job1.getId().equals(id)){
				job1.setTitle(job.getTitle());
				job1.setDescription(job.getDescription());
				job1.setMinSalary(job.getMinSalary());
				job1.setMaxSalary(job.getMaxSalary());
				job1.setLocation(job.getLocation());
				return true;
			}
		}
		return false;
		
	}

}
