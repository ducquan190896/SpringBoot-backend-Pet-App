package com.quan.petcaringapp.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Table(name = "customer")
@Entity(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
        name = "customer_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "phone number cannot be blank")
    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Email(message = "email cannot be blank")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "notes cannot be blank")
    @Column(name = "notes", nullable = false)
    private String notes;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    public Customer(@NotBlank(message = "name cannot be blank") String name,
            @NotBlank(message = "phone number cannot be blank") String phoneNumber,
            @Email(message = "email cannot be blank") String email,
            @NotBlank(message = "notes cannot be blank") String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;
    }

    
}
