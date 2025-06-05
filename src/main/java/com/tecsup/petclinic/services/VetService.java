package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Vet;

public interface VetService {
    Vet create(Vet vet);
    Vet update(Vet vet);
    Vet findById(Integer id);
    List<Vet> findByFirstName(String firstName);
    List<Vet> findAll();
}
