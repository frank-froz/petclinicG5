package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(VET_NAME, vetCreated.getFirst_name());
        assertEquals(VET_LAST_NAME, vetCreated.getLast_name());

    }

    @Test
    public void testFindVetByName() {

        String FIND_NAME = "James";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.vetService.findByName(FIND_NAME);

        assertEquals(SIZE_EXPECTED, vets.size());
    }

    @Test
    public void testFindVetById() {

        String NAME_EXPECTED = "Sharon";

        Integer ID = 1;

        Vet vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
        assertEquals(NAME_EXPECTED, vet.getFirst_name());
    }

}