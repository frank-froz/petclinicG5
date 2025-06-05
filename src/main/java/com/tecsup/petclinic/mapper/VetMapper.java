package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface VetMapper {

    VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);
    Vet toVet(VetDTO vetTO);
    VetDTO toVetTO(Vet vet);

    List<VetDTO> toVetTOList(List<Vet>vetList);

    List<Vet> toVetList(List<VetDTO> vetDTOList);
}
