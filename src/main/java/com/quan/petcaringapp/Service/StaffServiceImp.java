package com.quan.petcaringapp.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.EmployeeSkills;
import com.quan.petcaringapp.Entity.Staff;
import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Repository.EmployeeRepos;

@Service
public class StaffServiceImp implements StaffService {
    @Autowired
    EmployeeRepos employeeRepos;

    @Override
    public Staff getStaff(String email) {
        Optional<Staff> entity = employeeRepos.findStaffByEmail(email);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the staff with email " + email + " not found");

        }
        return entity.get();
    }

    @Override
    public List<Staff> getStaffs() {
       return employeeRepos.findAll();
    }
    @Override
    public Set<Staff> getStaffsByDayAvailable(DayOfWeek dayOfWeek) {
        return employeeRepos.findStaffByDayAvailable(dayOfWeek);
     }

    @Override
    public Set<Staff> getStaffBySkill(EmployeeSkills employeeSkills) {
      return employeeRepos.findStaffBySkills(employeeSkills);
    }

    @Override
    public void saveStaff(Staff staff) {
        employeeRepos.save(staff);
        
    }

    @Override
    public Staff updateStaffDayAvailable(Long id, DayOfWeek dayOfWeek) {
        Optional<Staff> entity = employeeRepos.findById(id);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the staff with id "+ id + " not found");
        }
        Staff staff = entity.get();
        staff.getDayAvailable().add(dayOfWeek);
        return employeeRepos.save(staff);
    }

    @Override
    public Staff updateStaffRemoveDay(Long id, DayOfWeek dayOfWeek) {
        Optional<Staff> entity = employeeRepos.findById(id);
        if(!entity.isPresent()) {
            throw new EntityNotFoundException("the staff with id "+ id + " not found");
        }
        Staff staff = entity.get();
        staff.setDayAvailable(staff.getDayAvailable().stream().filter(dayOf -> !dayOf.equals(dayOfWeek)).collect(Collectors.toSet()));;
        return employeeRepos.save(staff);
    }
     
}
