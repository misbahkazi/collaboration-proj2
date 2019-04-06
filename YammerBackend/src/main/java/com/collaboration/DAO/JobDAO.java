package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.Job;

public interface JobDAO 
{
	
	public boolean addJobDetail(Job job);
	public boolean updateJobDetail(Job job);
	public boolean deleteJobDetail(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobDetails();
	

}
