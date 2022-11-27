package com.quan.petcaringapp.Entity;

import java.time.LocalDate;

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
        generator = "petsequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @NotBlank(message = "note cannot be blank")
    @Column(name = "notes", nullable = false)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PetType type;

    public Pet( String name, LocalDate birthDate, String notes,
            PetType type) {
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.type = type;
    }




}
