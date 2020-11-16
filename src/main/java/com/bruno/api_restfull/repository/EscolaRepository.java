package com.bruno.api_restfull.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bruno.api_restfull.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    
    private List<Escola> escolas = new ArrayList<Escola>();
    private static int nextCodigo_escola=1;

    public Escola save(Escola escola){
        escola.setCodigo_escola(nextCodigo_escola);
        escolas.add(escola);
        nextCodigo_escola++;
        return escola;
    }

    public List<Escola> getEscolas(){
        return escolas;
    }

    public Optional<Escola> getEscolaByCodigo(int codigo_escola){
        for(Escola aux : escolas) {
            if(aux.getCodigo_escola() == codigo_escola){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public void remove(Escola escola){
        escolas.remove(escola);
    }

    public Escola update(Escola escola){
        Escola aux = getEscolaByCodigo(escola.getCodigo_escola()).get();

        if(aux != null){
            aux.setNome(escola.getNome());
            aux.setEndereco(escola.getEndereco());
        }

        return aux;
    }
}
