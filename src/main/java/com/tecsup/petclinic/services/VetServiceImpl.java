package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import java.util.List;
import java.util.Optional;
public class VetServiceImpl implements VetService {





























































    @Override
    public Vet findById(Integer id) throws VetNotFoundException {

        Optional<Vet> vet = vetRepository.findById(id);

        if ( !vet.isPresent())
            throw new VetNotFoundException("Record not found...!");

        return vet.get();
    }
    @Override
    public List<Vet> findByName(String name) {

        List<Vet> vets = vetRepository.findByName(name);

        vets.stream().forEach(vet -> log.info("" + vet));

        return vets;
    }

    @Override
    public List<Vet> findAll() {
        //
        return VetRepository.findAll();

    }
}
