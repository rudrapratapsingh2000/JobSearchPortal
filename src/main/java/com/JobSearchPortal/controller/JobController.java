package com.JobSearchPortal.controller;

import com.JobSearchPortal.model.Job;
import com.JobSearchPortal.model.JobType;
import com.JobSearchPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/job  ")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("/findAll-api")
    public List<Job> getAllJobs(){
        return  jobService.getAllJob();
    }
    @PostMapping(value = "/addjob")
    public String insertJobs(@RequestBody List<Job> jobList)
    {
        return jobService.addJobs(jobList);
    }
    @PutMapping(value = "/job/type/id")
    public void updateJobTypeById(@RequestParam JobType jobType, @RequestParam Integer id)
    {
         jobService.updateJobTypeById(jobType,id);
    }
    @PutMapping(value = "/job/{id}")
    public void updateJobById(@PathVariable Integer id, @RequestBody Job myJob)
    {
         jobService.updateJobById(id,myJob);
    }
    @DeleteMapping(value = "/deletejob/{id}")
    public void deleteJobById(@PathVariable  Integer id)
    {
         jobService.deleteJobById(id);
    }
}
