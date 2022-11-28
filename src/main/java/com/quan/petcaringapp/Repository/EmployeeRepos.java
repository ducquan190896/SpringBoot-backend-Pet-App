package com.quan.petcaringapp.Repository;

import java.time.DayOfWeek;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quan.petcaringapp.Entity.Staff;

@Repository
public interface EmployeeRepos extends JpaRepository<Staff, Long> {

//    @Query(
//     value = "select s.name, s.email, s.id from staff s left join staff_day_available d on s.id = d.staff_id where d.day_available = ?1",
//     nativeQuery = true
//    ) 
 Set<Staff> findStaffByDayAvailable(DayOfWeek dayOfWeek);
}
