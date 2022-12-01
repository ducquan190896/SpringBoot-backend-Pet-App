package com.quan.petcaringapp.Entity;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Schedule")
@Table(name = "schedule")
@RequiredArgsConstructor
public class Schedule {
    @Id
    @SequenceGenerator(
        name = "schedule_sequence",
        sequenceName = "schedule_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "schedule_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    // @JsonIgnore
    @ManyToMany
    @JoinTable( 
        name = "schedule_pets",
        joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name= "pet_id", referencedColumnName = "id")
    )
    private List<Pet> pets = new ArrayList<>();

    // @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "schedule_staff",
        joinColumns = @JoinColumn(name ="schedule_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id")
    )
    private List<Staff> staffs = new ArrayList<>();

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", Date=" + date + "]";
    }



}
