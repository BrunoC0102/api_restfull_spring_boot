package com.bruno.api_restfull.controller;

import java.util.List;

import com.bruno.api_restfull.model.Escola;
import com.bruno.api_restfull.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService service;
    
    @GetMapping
    public List<Escola> getAllEscolas(){
        return service.getAllEscolas();
    }

    @GetMapping("/{codigo_escola}")
    public ResponseEntity<Escola> getEscolaByCodigo(@PathVariable int codigo_escola){
        Escola escola = service.getEscolaByCodigo(codigo_escola);
        return ResponseEntity.ok(escola);
    }

    // @GetMapping("/{codigo_escola}/cursos")
    

}
