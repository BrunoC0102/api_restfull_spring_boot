package com.bruno.api_restfull.service;

import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.dto.EscolaDTO;
import com.bruno.api_restfull.model.Curso;
import com.bruno.api_restfull.model.Escola;
import com.bruno.api_restfull.repository.CursoRepository;
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

    public boolean removeByCodigo(int codigo_escola){
        Escola escola = getEscolaByCodigo(codigo_escola);
        if(escola.totalCursos() != 0){
            return false;
        }
        repository.remove(getEscolaByCodigo(codigo_escola));
        return true;
    }

    public void removeCursoByCodigo(int codigo_escola,int codigo_curso){
        Escola escola = getEscolaByCodigo(codigo_escola);
        for(Curso aux: escola.getCursos()){
            if(aux.getCodigo() == codigo_curso){
                repository.removeCursoByCodigo(escola,aux);
            }
        }
    }

    public Escola update(Escola escola){
        getEscolaByCodigo(escola.getCodigo_escola());
        return repository.update(escola);
    }
    
    public Escola save(Escola escola){
        return repository.save(escola);
    }
}

