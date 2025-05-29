package com.tecsup.petclinic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "vets")
@Data
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;

    public Vet() {

    }

    public Vet(String name, String lastName) {
        super();
        this.name = name;
        this.lastName = lastName;
    }


}
