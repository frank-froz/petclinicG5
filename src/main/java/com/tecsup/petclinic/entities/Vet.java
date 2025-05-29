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
    private String first_name;
    private String last_name;

    public Vet() {
    }

    public Vet(Integer id, String name, String lastName) {
        super();
        this.id = id;
        this.first_name = name;
        this.last_name = lastName;
    }

    public Vet( String name, String lastName) {
        super();
        this.first_name = name;
        this.last_name = lastName;
    }


}
