package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
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

    private final VetService vetService;
    private final VetMapper mapper;
    private VetMapper vetMapper;

    public VetController(VetService vetService, VetMapper vetMapper) {
        this.vetService = vetService;
        this.vetMapper = vetMapper;
        this.mapper = vetMapper;
    }

    @GetMapping(value = "/vets")
    public ResponseEntity<List<VetDTO>> findVets(
            @RequestParam(value = "firstName", required = false) String firstName) {

        List<Vet> vets;

        try {
            if (firstName == null) {
                vets = vetService.findAll();
            } else {
                vets = vetService.findByFirstName(firstName);
            }

            List<VetDTO> vetsTO = this.mapper.toVetTOList(vets);
            return ResponseEntity.ok(vetsTO);

        } catch (Exception e) {
            log.error("Error retrieving vets", e);
            return ResponseEntity.notFound().build();
        }
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

// buscar por id
    @GetMapping(value = "/vets/{id}")
    public ResponseEntity<VetDTO> findVetById(@PathVariable Integer id) {
        try {
            Vet vet = vetService.findById(id);
            VetDTO vetTO = this.mapper.toVetTO(vet);
            return ResponseEntity.ok(vetTO);
        } catch (VetNotFoundException e) {
            log.warn("Vet not found with id {}", id);
            return ResponseEntity.notFound().build();
        }

    }
}
