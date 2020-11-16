package com.bruno.api_restfull.controller;

import java.util.List;

import com.bruno.api_restfull.dto.CursoDTO;
import com.bruno.api_restfull.model.Curso;
import com.bruno.api_restfull.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> getAllCursos(){
        return service.getAllCursos();
    }

    @GetMapping("/{codigo_curso}")
    public ResponseEntity<Curso> getCursoByCodigo(@PathVariable int codigo_curso){
        Curso curso = service.getCursoByCodigo(codigo_curso);
        return ResponseEntity.ok(curso);
    }
    
    @PutMapping("/{codigo_curso}")
    public ResponseEntity<Curso> atualizar(@RequestBody CursoDTO cursoDTO, @PathVariable int codigo_curso){
        Curso curso = service.fromDTO(cursoDTO);
        curso.setCodigo(codigo_curso);
        curso = service.update(curso);
        return ResponseEntity.ok(curso);
    }
}
