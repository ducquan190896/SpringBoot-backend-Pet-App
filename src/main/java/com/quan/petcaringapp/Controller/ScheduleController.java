package com.quan.petcaringapp.Controller;

import java.util.List;

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

import com.quan.petcaringapp.Entity.Schedule;
import com.quan.petcaringapp.Service.ScheduleService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/")
    public ResponseEntity<HttpStatus> saveSchedule(@Valid @RequestBody Schedule schedule) {
        scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Schedule>> getSchedules() {
        return new ResponseEntity<List<Schedule>>(scheduleService.getSchedules(), HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}/pet/{petId}")
    public ResponseEntity<Schedule> addPetToschedule(@PathVariable Long scheduleId, @PathVariable Long petId) {
        return new ResponseEntity<Schedule>(scheduleService.addPetToSchedule(scheduleId, petId), HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}/staff/{staffId}")
    public ResponseEntity<Schedule> addStaffToschedule(@PathVariable Long scheduleId, @PathVariable Long staffId) {
        return new ResponseEntity<Schedule>(scheduleService.addStaffToSchedule(scheduleId, staffId), HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}/removepet/{petId}")
    public ResponseEntity<Schedule> removePetFromschedule(@PathVariable Long scheduleId, @PathVariable Long petId) {
        return new ResponseEntity<Schedule>(scheduleService.removeStaffFromSchedule(scheduleId, petId), HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}/removestaff/{staffId}")
    public ResponseEntity<Schedule> removeStaffFromschedule(@PathVariable Long scheduleId, @PathVariable Long staffId) {
        return new ResponseEntity<Schedule>(scheduleService.removeStaffFromSchedule(scheduleId, staffId), HttpStatus.OK);
    }


    @GetMapping("/pet/{id}")
    public ResponseEntity<List<Schedule>> getScheduleByPet(@PathVariable Long id) {
        return new ResponseEntity<List<Schedule>>(scheduleService.getScheduleByPet(id), HttpStatus.OK);

    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<List<Schedule>> getScheduleByStaff(@PathVariable Long id) {
        return new ResponseEntity<List<Schedule>>(scheduleService.getScheduleByStaff(id), HttpStatus.OK);

    }
}
