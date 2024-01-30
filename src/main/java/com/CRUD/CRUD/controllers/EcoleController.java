package com.CRUD.CRUD.controllers;

import com.CRUD.CRUD.models.Ecole;
import com.CRUD.CRUD.services.EcoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecole")
public class EcoleController {

    private final EcoleService ecoleService;

    @GetMapping
    public List<Ecole> getAll(){
        System.out.println(" TEST ");
        return ecoleService.getAll();
    }
}
