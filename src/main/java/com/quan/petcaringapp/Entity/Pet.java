package com.quan.petcaringapp.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pet")
@Table(name = "pet")
public class Pet {

    @Id
    @SequenceGenerator(
        name = "pet_sequence",
        sequenceName = "pet_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "pet_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    //format the localdate birthDate to send the string  birthdate in postman
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @NotBlank(message = "note cannot be blank")
    @Column(name = "notes", nullable = false)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PetType type;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets")
    private List<Schedule> schedules = new ArrayList<>();

    public Pet( String name, LocalDate birthDate, String notes,
            PetType type) {
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", notes=" + notes + ", type=" + type
                + "]";
    }


    



}
