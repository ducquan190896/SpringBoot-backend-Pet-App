package com.quan.petcaringapp.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import com.quan.petcaringapp.Entity.EmployeeSkills;
import com.quan.petcaringapp.Entity.Staff;

public interface StaffService {
    Staff getStaff(String email);
    List<Staff> getStaffs();
    public Set<Staff> getStaffsByDayAvailable(DayOfWeek dayOfWeek);
    public Set<Staff> getStaffBySkill(EmployeeSkills employeeSkills);
    void saveStaff(Staff staff);
    Staff updateStaffDayAvailable(Long id, DayOfWeek dayOfWeek);
    Staff updateStaffRemoveDay(Long id, DayOfWeek dayOfWeek);
}
