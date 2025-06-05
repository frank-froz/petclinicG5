package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface VetMapper {
    List<VetDTO> toVetTOList(List<Vet>vetList);
}
