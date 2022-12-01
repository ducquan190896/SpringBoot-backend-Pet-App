package com.quan.petcaringapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Entity.Schedule;
import com.quan.petcaringapp.Entity.Staff;

@Repository
public interface ScheduleRepos extends JpaRepository<Schedule, Long> {
    List<Schedule> findScheduleByPets(Pet pet);
    List<Schedule> findScheduleByStaffs(Staff staff);

}
