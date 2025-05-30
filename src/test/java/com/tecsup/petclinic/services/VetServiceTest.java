package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        assertEquals(VET_NAME, vetCreated.getFirst_name());
        assertEquals(VET_LAST_NAME, vetCreated.getLast_name());

    }

	
}
