package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;

import java.util.List;

public interface OwnerService {

    Owner create(Owner owner);

    Owner update(Owner owner);

    Owner delete(Owner owner);

    List<Owner> findAll();

    List<Owner> findAllByLastName(String lastName);

    List<Owner> findAllByFirstName(String firstName);

}
