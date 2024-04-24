package com.springfullstack.FirstJobApp.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getById(@PathVariable("id") Long id) {
		Job job = jobService.getJobById(id);

		if (job == (null)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} else
			return new ResponseEntity<>(job, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
		Boolean deleted = jobService.deleteJobById(id);
		if (deleted)
			return ResponseEntity.ok("Deleted Successfully");

		return new ResponseEntity<>("User with " + id + " not found", HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody Job job) {

		Boolean updated = jobService.updateJob(id, job);

		if (updated)
			return new ResponseEntity<>("User Updated", HttpStatus.OK);
		return new ResponseEntity<>("User with " + id + " not found", HttpStatus.NOT_FOUND);

	}

}
