package com.CRUD.CRUD.Mappers;
import com.CRUD.CRUD.DTO.EtudiantDto;
import com.CRUD.CRUD.models.Etudiant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EtudiantMapper {

    Etudiant mapToEntity(EtudiantDto etudiantDTO);
    EtudiantDto mapToDto(Etudiant etudiantDto);
    List<Etudiant> mapToListEntity(List<EtudiantDto> etudiantDto);
    List<EtudiantDto> mapToListDto(List<Etudiant> newsLetterDto);


}
