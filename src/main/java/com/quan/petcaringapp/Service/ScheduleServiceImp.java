package com.quan.petcaringapp.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Entity.Schedule;
import com.quan.petcaringapp.Entity.Staff;
import com.quan.petcaringapp.Exception.EntityNotFoundException;
import com.quan.petcaringapp.Repository.EmployeeRepos;
import com.quan.petcaringapp.Repository.PetRepos;
import com.quan.petcaringapp.Repository.ScheduleRepos;

@Service 
public class ScheduleServiceImp implements ScheduleService{

    @Autowired
    ScheduleRepos scheduleRepos;
    @Autowired
    PetRepos petRepos;
    @Autowired
    EmployeeRepos employeeRepos;

    @Override
    public void createSchedule(Schedule schedule) {
        scheduleRepos.save(schedule);
        
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepos.findAll();
    }

    @Override
    public Schedule addPetToSchedule(Long ScheduleId, Long PetId) {
       Optional<Pet> entityPet = petRepos.findById(PetId);
       if(!entityPet.isPresent()) {
        throw new EntityNotFoundException("the pet with id " + PetId  + " not found");
       }
       Pet pet = entityPet.get();
       Optional<Schedule> entitySchedule = scheduleRepos.findById(ScheduleId);
       if(!entitySchedule.isPresent()) {
        throw new EntityNotFoundException("the schedule with id " + ScheduleId  + " not found");
       }
       Schedule schedule = entitySchedule.get();
       schedule.getPets().add(pet);
      return scheduleRepos.save(schedule);
    }

    @Override
    public Schedule addStaffToSchedule(Long ScheduleId, Long StaffId) {
        Optional<Schedule> entitySchedule = scheduleRepos.findById(ScheduleId);
       if(!entitySchedule.isPresent()) {
        throw new EntityNotFoundException("the schedule with id " + ScheduleId  + " not found");
       }
       Schedule schedule = entitySchedule.get();
       Optional<Staff> entityStaff = employeeRepos.findById(StaffId);
       if(!entityStaff.isPresent()) {
        throw new EntityNotFoundException("the staff with id " + StaffId + " not found");
       }
       Staff staff = entityStaff.get();
       schedule.getStaffs().add(staff);
      return scheduleRepos.save(schedule);

    }

    @Override
    public List<Schedule> getScheduleByPet(Long petId) {
        Optional<Pet> entityPet = petRepos.findById(petId);
        if(!entityPet.isPresent()) {
         throw new EntityNotFoundException("the pet with id " + petId  + " not found");
        }
        Pet pet = entityPet.get();
        return scheduleRepos.findScheduleByPets(pet);
    }

    @Override
    public List<Schedule> getScheduleByStaff(Long staffId) {
        Optional<Staff> entityStaff = employeeRepos.findById(staffId);
        if(!entityStaff.isPresent()) {
         throw new EntityNotFoundException("the staff with id " + staffId + " not found");
        }
        Staff staff = entityStaff.get();
        return scheduleRepos.findScheduleByStaffs(staff);
    }

    @Override
    public Schedule removePetFromSchedule(Long ScheduleId, Long PetId) {
       
        Optional<Schedule> entitySchedule = scheduleRepos.findById(ScheduleId);
        if(!entitySchedule.isPresent()) {
         throw new EntityNotFoundException("the schedule with id " + ScheduleId  + " not found");
        }
        Schedule schedule = entitySchedule.get();
        schedule.setPets(schedule.getPets().stream().filter(pee -> pee.getId() != PetId).collect(Collectors.toList()));;
       return scheduleRepos.save(schedule);
    }

    @Override
    public Schedule removeStaffFromSchedule(Long ScheduleId, Long StaffId) {
        Optional<Schedule> entitySchedule = scheduleRepos.findById(ScheduleId);
       if(!entitySchedule.isPresent()) {
        throw new EntityNotFoundException("the schedule with id " + ScheduleId  + " not found");
       }
       Schedule schedule = entitySchedule.get();
      schedule.setStaffs( schedule.getStaffs().stream().filter(sta -> sta.getId() != StaffId).collect(Collectors.toList()));

       return scheduleRepos.save(schedule);
    }

    
    
    
}
