package com.example.JobTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/jobs")
public class JobController {

	private final JobService jobService;
	
	
	/**
	 * @param jobService
	 */
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}


	@GetMapping
	public List<Job> getJobs() {
		return jobService.getJobs();
	}
	
	@PostMapping
	public void postJob(@RequestBody Job job) {
		jobService.postJob(job);
	}
	
	
	@DeleteMapping(path = "{jobId}")
	public void deleteJob(@PathVariable Long jobId) {
		jobService.deleteJob(jobId);
	}
	
	
	@PutMapping(path = "{jobId}")
	public void updateJob(@PathVariable Long jobId,
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String company,
			@RequestParam(required = false) String contactEmail,
			@RequestParam(required = false) String description) {
		
		jobService.updateJob(jobId, title, company, contactEmail, description);
	}
	
}
