package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VetServiceImpl implements VetService {

    VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {this.vetRepository = vetRepository; }

    @Override
    public Vet create(Vet vet){
        return vetRepository.save(vet);
    }
}
