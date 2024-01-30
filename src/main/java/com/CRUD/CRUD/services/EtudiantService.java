package com.CRUD.CRUD.services;

import com.CRUD.CRUD.DTO.EtudiantDto;
import com.CRUD.CRUD.Mappers.EtudiantMapper;
import com.CRUD.CRUD.Util.PaginatedResponse;
import com.CRUD.CRUD.models.Etudiant;
import com.CRUD.CRUD.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantService {


    private final EtudiantRepository etudiantRepository;

    private final EtudiantMapper etudiantMapper;

    //private final PaginatedResponseMapper paginatedResponseMapper;

    /*public Etudiant AddEtudiant(Etudiant etudiant){
        Etudiant etudiantDTO = etudiantRepository.save(etudiant);
        return etudiantDTO;
    }

    public Etudiant EditEtudiant(Etudiant etudiantDTO ){
        Etudiant etudiantDTO1 = etudiantRepository.save(etudiantDTO);
        return etudiantDTO1;
    }*/

    public EtudiantDto AddEtudiant(EtudiantDto etudiantDto) {
        EtudiantDto etudiantDTO = etudiantMapper.mapToDto(etudiantRepository.save(etudiantMapper.mapToEntity(etudiantDto)));
        return etudiantDTO;
    }

    public EtudiantDto EditEtudiant(EtudiantDto etudiantDto) {
        //EtudiantDto etudiantDTO = etudiantMapper.mapToDto(etudiantRepository.save(etudiantMapper.mapToEntity(etudiantDTO)));
        return null;
    }

    public EtudiantDto findbyid(Long id) {
        Etudiant etudiant = getbyid(id);
        EtudiantDto etudiantDto = etudiantMapper.mapToDto(etudiant);
        return etudiantDto;
    }

    //for the other use
    private Etudiant getbyid(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        return etudiant;
    }

    public List<EtudiantDto> findAll() {

        List<Etudiant> etudiants = etudiantRepository.findAll().stream()
                .peek(etudiant -> etudiant.setNote(20))
                .collect(Collectors.toList());
        List<EtudiantDto> etudiantDtos = etudiantMapper.mapToListDto(etudiants);
        return etudiantDtos;
    }

    public List<EtudiantDto> setwithForeach() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for (Etudiant etudiant : etudiants) {
            etudiant.setNote(20);
        }
        //pour Enregistrer dans la Base de donneés
        List<EtudiantDto> etudiantDtos = etudiantMapper.mapToListDto(etudiantRepository.saveAll(etudiants));
        return etudiantDtos;
    }

    public EtudiantDto setwithBuilder() {
        Etudiant etudiant = new Etudiant();
        etudiant = Etudiant.builder()
                .age(22)
                .name("ELHAJLY")
                .prenom("MED")
                .build();
        EtudiantDto etudiantDto = etudiantMapper.mapToDto(etudiant);
        return etudiantDto;
    }

    public Etudiant editEtudiant1(EtudiantDto etudiantDto, Long id) {

        Etudiant etudiant = getbyid(id);

        if(etudiant!=null){
            etudiantDto.setId(id);
            Etudiant etudiant1 = etudiantMapper.mapToEntity(etudiantDto);
            return etudiantRepository.save(etudiant1);
        }
        return null;
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public PaginatedResponse<EtudiantDto> paginateEtudiantByMc(String mc, int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        Sort sort = Sort.by(direction, sortBy);
        Page<EtudiantDto> etudiants;
        Pageable pageable1 = PageRequest.of(pageNo, pageSize);   //TODO  , sort
        Pageable pageable2 = PageRequest.of(pageNo, pageSize, sort);
        if (!Objects.equals(mc, "") || !mc.trim().isEmpty()) {

            etudiants = etudiantRepository.searchNewsByMC(mc, pageable1).map(etudiant -> etudiantMapper.mapToDto(etudiant));

        } else {
            etudiants = etudiantRepository.findAll(pageable2).map(etudiant -> etudiantMapper.mapToDto(etudiant));
        }

        PaginatedResponse<EtudiantDto> response = PaginatedResponse.<EtudiantDto>builder()
                .content(etudiants.getContent())
                .last(etudiants.isLast())
                .pageNo(etudiants.getNumber())
                .pageSize(etudiants.getSize())
                .totalElements(etudiants.getTotalElements())
                .totalPages(etudiants.getTotalPages())
                .build();
        return response;
    }
}
