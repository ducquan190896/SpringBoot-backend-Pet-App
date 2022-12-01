package com.quan.petcaringapp.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.DayOfWeek;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "staff")
@Entity(name = "Staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Staff {
    @Id
    @SequenceGenerator(
        name = "staff_sequence",
        sequenceName = "staff_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "staff_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Email(message = "email must be in the form of email")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EmployeeSkills.class)
    private Set<EmployeeSkills> skills = new HashSet<>();

    @ElementCollection(targetClass = DayOfWeek.class)
    private Set<DayOfWeek> dayAvailable = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "staffs")
    private List<Schedule> schedules = new ArrayList<>(); 

    public Staff( String email,
            String name, Set<EmployeeSkills> skills,
            Set<DayOfWeek> dayAvailable) {
        this.email = email;
        this.name = name;
        this.skills = skills;
        this.dayAvailable = dayAvailable;
    }

    public Staff( String email,
           String name) {
        this.email = email;
        this.name = name;
    } 
    
  

}
