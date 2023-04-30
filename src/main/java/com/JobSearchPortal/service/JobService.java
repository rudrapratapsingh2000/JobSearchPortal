package com.JobSearchPortal.service;

import com.JobSearchPortal.model.Job;
import com.JobSearchPortal.model.JobType;
import com.JobSearchPortal.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJob() {
        return jobRepository.getAllJobs();
    }
    public String addJobs(List<Job> jobList) {

        Iterable<Job> list = jobRepository.saveAll(jobList);
        if(list!=null)
        {
            return "Added list of Jobs.....!!!";
        }
        else
        {
            return "Could not added..!!!";
        }
    }

    @Transactional
    public void deleteJobById(Integer id) {
         jobRepository.deleteJobById(id);
    }


    public void updateJobById(Integer id, Job myJob) {
        jobRepository.updateJobById(id,myJob.getId(),myJob.getJobType(),myJob.getDescription(),myJob.getLocation(),
                myJob.getSalary(),myJob.getTitle(),myJob.getCompanyName(),myJob.getEmployerName());
    }

    public void updateJobTypeById(JobType jobType, Integer id) {
        jobRepository.updateJobTypeById(jobType,id);
    }
}
