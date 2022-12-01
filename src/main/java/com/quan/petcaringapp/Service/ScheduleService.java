package com.quan.petcaringapp.Service;

import java.util.List;

import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Entity.Schedule;

public interface ScheduleService {
    void createSchedule(Schedule schedule);
    List<Schedule> getSchedules();
   Schedule addPetToSchedule(Long ScheduleId, Long PetId );
   Schedule addStaffToSchedule(Long ScheduleId, Long StaffId);
   Schedule removePetFromSchedule(Long ScheduleId, Long PetId );
   Schedule removeStaffFromSchedule(Long ScheduleId, Long StaffId);
   List<Schedule> getScheduleByPet(Long petId);
   List<Schedule> getScheduleByStaff(Long staffId);

}
