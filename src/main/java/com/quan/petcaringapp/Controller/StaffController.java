package com.quan.petcaringapp.Controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quan.petcaringapp.Entity.EmployeeSkills;
import com.quan.petcaringapp.Entity.Staff;
import com.quan.petcaringapp.Service.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> getStaffs() {
        return new ResponseEntity<List<Staff>>(staffService.getStaffs(), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Staff> getStaff(@PathVariable String email) {
        return new ResponseEntity<Staff>(staffService.getStaff(email), HttpStatus.OK);
    }
    @GetMapping("/day/{dayEmployee}")
    public ResponseEntity<Set<Staff>> getStaffsByDayAvailable(@PathVariable DayOfWeek dayEmployee) {
        return new ResponseEntity<Set<Staff>>(staffService.getStaffsByDayAvailable(dayEmployee), HttpStatus.OK);
    }

    @GetMapping("/skill/{skill}")
    public ResponseEntity<Set<Staff>> getStaffsBySKills(@PathVariable("skill") EmployeeSkills skill) {
        return new ResponseEntity<Set<Staff>>(staffService.getStaffBySkill(skill), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<HttpStatus> saveStaff(@Valid @RequestBody Staff staff) {
        staffService.saveStaff(staff);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}/addDay/{availableday}")
    public ResponseEntity<Staff> updateStaffAvailableDay(@PathVariable("availableday") DayOfWeek availableday, @PathVariable("id") Long id ) {
        return new ResponseEntity<Staff>(staffService.updateStaffDayAvailable(id, availableday), HttpStatus.OK);
    }

    @PutMapping("/id/{id}/removeDay/{availableday}")
    public ResponseEntity<Staff> updateStaffRemoveAvailableDay(@PathVariable("availableday") DayOfWeek availableday, @PathVariable("id") Long id ) {
        return new ResponseEntity<Staff>(staffService.updateStaffRemoveDay(id, availableday), HttpStatus.OK);
    }
}
