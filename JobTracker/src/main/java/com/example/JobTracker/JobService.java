package com.example.JobTracker;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobService {

	private final JobRepository jobRepository;
	
	
	/**
	 * @param jobRepository
	 */
	@Autowired
	public JobService(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	public List<Job> getJobs() {
		return jobRepository.findAll();
	}

	public void postJob(Job job) {
		
		if(job.getTitle() != null  && job.getTitle().length() >0 || job.getCompany() != null && job.getCompany().length() >0) {
			jobRepository.save(job);
		}
	}
	
	
	public void deleteJob(Long jobId){
		boolean exists = jobRepository.existsById(jobId);
		
		if(!exists) {
			throw new JobNotFoundException(jobId);
		}
	
		jobRepository.deleteById(jobId);
	}
	
	@Transactional
	public void updateJob(Long jobId, String title, String company, String contactEmail, String description) {
		
		Job job = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException(jobId));

		if(title!=null && title.length()>0 && !Objects.equals(job.getTitle(), title)) {
			job.setTitle(title);
		}
		
		if(company!=null && company.length()>0 && !Objects.equals(job.getCompany(), company)) {
			job.setCompany(company);
		}
		
		if(contactEmail!=null && contactEmail.length()>0 && !Objects.equals(job.getContactEmail(), contactEmail)) {
			job.setContactEmail(contactEmail);
		}
		
		if(description!=null && description.length()>0 && !Objects.equals(job.getDescription(), description)) {
			job.setDescription(description);		
		}
		
		
		
	}
	
}
