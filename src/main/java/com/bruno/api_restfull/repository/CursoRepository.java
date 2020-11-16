package com.bruno.api_restfull.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {
    
    private List<Curso> cursos = new ArrayList<Curso>();
    private static int nextCodigo_Curso = 1;

    public Curso save(Curso curso){
        curso.setCodigo(nextCodigo_Curso);
        cursos.add(curso);
        nextCodigo_Curso++;
        return curso;
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    public Optional<Curso> getCursoByCodigo(int codigo_curso){
        for(Curso aux : cursos) {
            if(aux.getCodigo() == codigo_curso){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }
}
