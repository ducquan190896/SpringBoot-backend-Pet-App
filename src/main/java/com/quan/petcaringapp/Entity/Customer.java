package com.quan.petcaringapp.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity(name = "Customer")
public class Customer {
    @Id
    // @SequenceGenerator(
    //     name = "customer_sequence",
    //     sequenceName = "customer_sequence",
    //     allocationSize = 1
    // )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
        // generator = "customer_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "phone number cannot be blank")
    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    // @Email(message = "email cannot be blank")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "notes cannot be blank")
    @Column(name = "notes", nullable = false)
    private String notes;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    public Customer( String name,
            String phoneNumber,
            String email,
            String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", notes=" + notes + "]";
    }

    
}
