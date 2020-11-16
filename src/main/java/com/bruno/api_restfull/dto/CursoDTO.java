package com.bruno.api_restfull.dto;

import javax.validation.constraints.NotBlank;

public class CursoDTO {
    
    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
