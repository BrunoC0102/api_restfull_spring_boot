package com.bruno.api_restfull.dto;

import javax.validation.constraints.NotBlank;
public class EscolaDTO {
    
    @NotBlank(message = "Nome obrigatório!")
    private String nome;
    
    @NotBlank(message = "Endereço obrigatório!")
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
