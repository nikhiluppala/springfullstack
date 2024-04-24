package com.springfullstack.FirstJobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long>{

}
