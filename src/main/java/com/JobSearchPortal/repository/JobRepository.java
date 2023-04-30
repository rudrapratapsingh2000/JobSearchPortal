package com.JobSearchPortal.repository;

import com.JobSearchPortal.model.Job;
import com.JobSearchPortal.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job,Long> {
    @Query(value = "select * from JOB" , nativeQuery = true)
    List<Job> getAllJobs();
    @Modifying
    @Query(value = "Delete from Job where id=:id" , nativeQuery = true)
    void deleteJobById(Integer id);
    @Modifying
    @Query(value = "update JOB set JOB_TYPE=:jobType where id =:id ", nativeQuery = true)
    void updateJobTypeById(JobType jobType, Integer id);
    @Modifying
    @Query(value = "update JOB set id=:id1, company_name=:companyName, description=:description, " +
            "employer_name=:employerName, job_type=:jobType, location=:location, salary=:salary , " +
            " title =: title where id =:id ",nativeQuery = true)
    void updateJobById(Integer id, Integer id1, JobType jobType, String description, String location, Double salary,
                       String title, String companyName, String employerName);
}
