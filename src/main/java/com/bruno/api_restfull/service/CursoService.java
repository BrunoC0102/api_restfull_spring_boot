package com.bruno.api_restfull.service;

import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.dto.CursoDTO;
import com.bruno.api_restfull.model.Curso;
import com.bruno.api_restfull.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    public Curso fromDTO(CursoDTO objDTO){
        Curso curso = new Curso();
        curso.setNome(objDTO.getNome());
        return curso;
    }
    
    public List<Curso> getAllCursos(){
        return repository.getCursos();
    }

    public Curso getCursoByCodigo(int codigo_curso){
        Optional<Curso> op = repository.getCursoByCodigo(codigo_curso);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não cadastrada!"));
    }

    public Curso save(Curso curso){
        return repository.save(curso);
    }
}
