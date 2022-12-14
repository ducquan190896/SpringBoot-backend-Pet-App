package com.quan.petcaringapp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quan.petcaringapp.Entity.Customer;
import com.quan.petcaringapp.Entity.EmployeeSkills;
import com.quan.petcaringapp.Entity.Pet;
import com.quan.petcaringapp.Entity.PetType;
import com.quan.petcaringapp.Entity.Schedule;
import com.quan.petcaringapp.Entity.Staff;
import com.quan.petcaringapp.Repository.CustomerRepos;
import com.quan.petcaringapp.Repository.EmployeeRepos;
import com.quan.petcaringapp.Repository.PetRepos;
import com.quan.petcaringapp.Repository.ScheduleRepos;

@SpringBootApplication
public class PetcaringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetcaringappApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PetRepos petRepos, CustomerRepos customerRepos, EmployeeRepos employeeRepos, ScheduleRepos scheduleRepos) {
		return args -> {
			Customer quan = new Customer("quan", "0913209809", "quan@gmail.com", "take care of my pets");
			customerRepos.save(quan);
			Customer thong1 = new Customer("thong1", "0913209807", "thong123456789@gmail.com", "take care of my pets 123");
			customerRepos.save(thong1);

			Pet a = new Pet("ben", LocalDate.of(2015, 8, 17), "he is quite aggressive", PetType.DOG);
			a.setCustomer(quan);
			Pet b = new Pet("duy", LocalDate.of(2012, 11, 9), "he is quite inactive", PetType.DOG);
			b.setCustomer(thong1);

			petRepos.save(a);
			petRepos.save(b);
			Set<EmployeeSkills> skills = new HashSet<>();
			skills.add(EmployeeSkills.PETTING);
			skills.add(EmployeeSkills.SHAVING);

			Staff thong = new Staff("thong@gmail.com", "thong", skills , new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)));

			employeeRepos.save(thong);
			Set<Staff> employees = employeeRepos.findStaffBySkills(EmployeeSkills.SHAVING);
			
			Schedule schedule1 = new Schedule(LocalDate.of(2022, 12, 30));
			schedule1.getPets().add(a);
			schedule1.getStaffs().add(thong);

			scheduleRepos.save(schedule1);

			List<Customer> customers = customerRepos.findAll();
			// customers.stream().forEach(cust -> System.out.println(cust));
			// employees.stream().forEach(employee -> System.out.println(employee.getName() + " _ skill _ " + employee.getEmail()));

			List<Schedule> schedules = scheduleRepos.findScheduleByPets(a);
			
			List<Schedule> schedules2 = scheduleRepos.findScheduleByStaffs(thong);
			// schedules.stream().forEach(sche -> System.out.println(sche));

			// schedules2.stream().forEach(sche -> System.out.println(sche));
		};
	}
}
