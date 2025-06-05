package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {

        String VET_NAME = "Frank";
        String VET_LAST_NAME = "Huaytalla";

        Vet vet = new Vet(VET_NAME, VET_LAST_NAME);

        Vet vetCreated = this.vetService.create(vet);

        log.info("PET CREATED :" + vetCreated.toString());

        assertNotNull(vetCreated.getId());
        assertEquals(VET_NAME, vetCreated.getFirstName());
        assertEquals(VET_LAST_NAME, vetCreated.getLastName());

    }

    @Test
    public void testUpdateVet() {

        String FIRST_NAME = "Castro";
        String LAST_NAME = "Peñaloza";

        String UP_FIRST_NAME = "Hanmer";
        String UP_LAST_NAME = "Hector";
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        // ------------ Create ---------------

        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);

        // ------------ Update ---------------

        // Prepare data for update
        vetCreated.setFirstName(UP_FIRST_NAME);
        vetCreated.setLastName(UP_LAST_NAME);

        // Execute update
        Vet upgradeVet = this.vetService.update(vetCreated);
        log.info(">>>>" + upgradeVet);

        //            EXPECTED        ACTUAL
        assertEquals(UP_FIRST_NAME, upgradeVet.getFirstName());
        assertEquals(UP_LAST_NAME, upgradeVet.getLastName());
    }

    @Test
    public void testFindVetByFirstName() {

        String FIND_NAME = "James";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.vetService.findByFirstName(FIND_NAME);

        assertEquals(SIZE_EXPECTED, vets.size());
    }

    @Test
    public void testFindVetById() {

        String NAME_EXPECTED = "James";

        Integer ID = 1;

        Vet vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
        assertEquals(NAME_EXPECTED, vet.getFirstName());
    }

}