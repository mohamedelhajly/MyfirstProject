package com.CRUD.CRUD.controllers;


import com.CRUD.CRUD.DTO.EtudiantDto;
import com.CRUD.CRUD.Util.Pageable;
import com.CRUD.CRUD.Util.PaginatedResponse;
import com.CRUD.CRUD.models.Etudiant;
import com.CRUD.CRUD.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")
public class EtudiantController {



    private final EtudiantService etudiantService;


   /* @PostMapping
    public void addEtudiant(@RequestBody Etudiant etudiant){
        System.out.println("fffffffff");
        etudiantService.AddEtudiant(etudiant);
    }*/

    @GetMapping("/{id}")
    public EtudiantDto getById(@PathVariable Long id){
        System.out.println("fffffffff");
        return etudiantService.findbyid(id);
    }


    @GetMapping("/AllwithPeek")
    public List<EtudiantDto> findAll(){
        return etudiantService.findAll();
    }

    @GetMapping("/AllwithForeach")
    public List<EtudiantDto> setWithForeach(){
        return etudiantService.setwithForeach();
    }

    @GetMapping("/AllWithBuilder")
    public EtudiantDto setWithBuilder(){
        return etudiantService.setwithBuilder();
    }

    /*@PostMapping("")
    public ResponseEntity<Void> addEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.AddEtudiant(etudiant);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Void> putEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.EditEtudiant(etudiant);
        return new ResponseEntity<>(HttpStatus.OK);
        //return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }*/

    @PostMapping("")
    public ResponseEntity<Void> addEtudiant(@RequestBody EtudiantDto etudiantDto){
        etudiantService.AddEtudiant(etudiantDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Void> putEtudiant(@RequestBody EtudiantDto etudiantDTO ){
        etudiantService.EditEtudiant(etudiantDTO);
        return new ResponseEntity<>(HttpStatus.OK);
        //return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putEtudiant1(@RequestBody EtudiantDto etudiant, @PathVariable Long id ){
        etudiantService.editEtudiant1(etudiant, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id ){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/EtudiantByMc")
    public PaginatedResponse<EtudiantDto> PaginateEtudiantByMc(@RequestParam Map<String, String> params,
                                                               @RequestParam(value = "pageNo", defaultValue = Pageable.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                               @RequestParam(value = "pageSize", defaultValue = Pageable.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                               @RequestParam(value = "sortBy", defaultValue = Pageable.DEFAULT_SORT_BY, required = false) String sortBy,
                                                               @RequestParam(value = "sortDir", defaultValue = Pageable.DEFAULT_SORT_DIRECTION, required = false) String sortDir ){

        String mc = params.get("mc");

        return etudiantService.paginateEtudiantByMc(mc, pageNo, pageSize, sortBy, sortDir);

    }


}
