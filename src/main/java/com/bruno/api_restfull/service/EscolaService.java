package com.bruno.api_restfull.service;

import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.dto.EscolaDTO;
import com.bruno.api_restfull.model.Escola;
import com.bruno.api_restfull.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService { 
    
    @Autowired
    private EscolaRepository repository;

    public Escola fromDTO(EscolaDTO objDTO){
        Escola escola = new Escola();
        escola.setNome(objDTO.getNome());
        escola.setEndereco(objDTO.getEndereco());
        return escola;
    }

    public List<Escola> getAllEscolas(){
        return repository.getEscolas();
    }

    public Escola getEscolaByCodigo(int codigo_escola){
        Optional<Escola> op = repository.getEscolaByCodigo(codigo_escola);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escola não cadastrada!"));
    }

    public Escola save(Escola escola){
        return repository.save(escola);
    }
}

