package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "vets")
@Data
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public Vet() {
    }

    public Vet(Integer id, String name, String lastName) {
        super();
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
    }

    public Vet( String name, String lastName) {
        super();
        this.firstName = name;
        this.lastName = lastName;
    }


}
