package com.quan.petcaringapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Schedule;

@Repository
public interface ScheduleRepos extends JpaRepository<Schedule, Long> {
    
}
