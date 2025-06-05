package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VetController {

    String firstName = null;

    private VetService vetService;

    private VetMapper vetMapper;

    public VetController(VetService vetService, VetMapper vetMapper) {
        this.vetService = vetService;
        this.vetMapper = vetMapper;
    }

    @GetMapping(value = "/vets")
    public ResponseEntity<List<VetDTO>> findAllVets() {

        List<Vet> vets = vetService.findAll();
        log.info("vets: "+ vets);
        vets.forEach(item -> log.info("Vet >>  {} ", item));

        List<VetDTO> vetsTO = this.vetMapper.toVetTOList(vets);
        log.info("vetsTO: " + vetsTO);
        vetsTO.forEach(item -> log.info("VetTO >>  {} ", item));

        return ResponseEntity.ok(vetsTO);
    }

    @PostMapping(value = "/vets")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<VetDTO> create(@RequestBody VetDTO vetTO) {

        Vet newVet = this.vetMapper.toVet(vetTO);
        VetDTO newVetTO = this.vetMapper.toVetTO(vetService.create(newVet));

        return  ResponseEntity.status(HttpStatus.CREATED).body(newVetTO);
    }

    @PutMapping(value = "/vets/{id}")
    ResponseEntity<VetDTO> update(@RequestBody VetDTO vetTO, @PathVariable Integer id) {

        VetDTO updateVetTO = null;

        try {

            Vet updateVet = vetService.findById(id);

            updateVet.setFirstName(vetTO.getFirstName());
            updateVet.setLastName(vetTO.getLastName());

            vetService.update(updateVet);

            updateVetTO = this.vetMapper.toVetTO(updateVet);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateVetTO);
    }


}
