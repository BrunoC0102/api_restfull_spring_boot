package com.bruno.api_restfull.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.dto.CursoDTO;
import com.bruno.api_restfull.model.Curso;
import com.bruno.api_restfull.model.Escola;
import com.bruno.api_restfull.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    @Autowired
    private EscolaService escolaService;


    public Curso fromDTO(CursoDTO objDTO){
        Curso curso = new Curso();
        curso.setNome(objDTO.getNome());
        return curso;
    }

    public CursoDTO toDTO(Curso curso){
        CursoDTO dto = new CursoDTO();
        dto.setNome(curso.getNome());
        return dto;
    }
    
    public List<Curso> getAllCursos(){
        return repository.getCursos();
    }

    public Curso getCursoByCodigo(int codigo_curso){
        Optional<Curso> op = repository.getCursoByCodigo(codigo_curso);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não cadastrado!"));
    }

    public List<CursoDTO> toListDTO(List<Curso> cursos){
        ArrayList<CursoDTO> listDTO = new ArrayList<CursoDTO>();

        for(Curso c: cursos){
            listDTO.add(toDTO(c));
        }
        return listDTO;
    }

    public Curso update(Curso curso){
        getCursoByCodigo(curso.getCodigo());
        return repository.update(curso);
    }

    public void removeByCodigo(int codigo_curso){
        repository.remove(getCursoByCodigo(codigo_curso));
    }

    public Curso save(Curso curso, int codigo_escola){

        Escola escola = escolaService.getEscolaByCodigo(codigo_escola);
        escola.addCurso(curso);

        return repository.save(curso);
    }
}
