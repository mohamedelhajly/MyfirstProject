package com.CRUD.CRUD.services;

import com.CRUD.CRUD.models.Ecole;
import com.CRUD.CRUD.repositories.EcoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EcoleService {

    private final EcoleRepository ecoleRepository;


    public List<Ecole> getAll() {
        System.out.println("med");
        List<Ecole> ecoles = ecoleRepository.findAll();
        return ecoles;
    }
}
