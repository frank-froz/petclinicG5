package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class VetController {
    private VetService vetService;
    private VetMapper mapper;

    public VetController(VetService vetService, VetMapper mapper) {
        this.vetService = vetService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/vets")
    public ResponseEntity<List<VetDTO>> findAllVets() {
        List<Vet> vets = vetService.findAll();
        log.info("vets:"+ vets);
        vets.forEach(item -> log.info("Vet >>  {} ", item));

        List<VetDTO> vetsTO = this.mapper.toVetTOList(vets);
        log.info("vetsTO: " + vetsTO);
        vetsTO.forEach(item -> log.info("VetTO >>  {} ", item));

        return ResponseEntity.ok(vetsTO);
    }

}
