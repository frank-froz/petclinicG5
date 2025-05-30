package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VetServiceImpl implements VetService {


    VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {this.vetRepository = vetRepository; }

    @Override
    public Vet create(Vet vet){
        return vetRepository.save(vet);
    }

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
        return vetRepository.findAll();

    }
}
