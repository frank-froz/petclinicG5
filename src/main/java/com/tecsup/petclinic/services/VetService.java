package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Vet;

public interface VetService {

    Vet create(Vet vet);
    Vet findById(Integer id);
    List<Vet> findByName(String name);
    List<Vet> findAll();
}
