package com.collaboration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collaboration.DAO.JobDAO;
import com.collaboration.model.Blog;
import com.collaboration.model.Job;

public class JobDAOTestCase {

static JobDAO jobDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	@Ignore
	//@Test
	public void addJobTest() 
	{
		Job job=new Job();
		job.setDesignation("programmer");
		job.setJobDesc("java skills req");
		job.setQualification("BE");
		job.setStatus("P");
		job.setLastDate(new java.util.Date());
		assertTrue("Problem in adding Job",jobDAO.addJobDetail(job));
		
	}
   @Ignore
   //@Test
   public void listJobTest() 
   {
	
	List<Job> listJobs=jobDAO.getJobDetails();
	assertTrue("Problem in Listing Jobs",listJobs.size()>0);
	
	
	for(Job job:listJobs)
		
	{
		System.out.print(job.getJobId()+"::");
		System.out.print(job.getDesignation()+":");
		System.out.print(job.getJobDesc()+":");
		
	}
	
	
   }
   
   @Ignore
	//@Test
	public void updateJobTest() 
	{
	   Job job=jobDAO.getJob(952);
	   job.setJobDesc("python req");
		assertTrue("Problem in updating Job",jobDAO.updateJobDetail(job));
	}
	
	
	//@Ignore
	@Test
	public void deleteJobTest() 
	{
		Job job=jobDAO.getJob(952);
		assertTrue("Problem in deleting Job",jobDAO.deleteJobDetail(job));
	}
	
   
   
   
}
