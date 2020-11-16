package com.bruno.api_restfull.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Escola {
    
    private int codigo_escola;
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    public Escola() {
        
    }

    public Escola(int codigo_escola, String nome, String endereco, String telefone, ArrayList<Curso> cursos) {
        this.codigo_escola = codigo_escola;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cursos = cursos;
    }

    public int getCodigo_escola() {
        return codigo_escola;
    }

    public void setCodigo_escola(int codigo_escola) {
        this.codigo_escola = codigo_escola;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean addCurso(Curso curso){
        return cursos.add(curso);
    }

    public boolean removeCurso(Curso curso) {
        return cursos.remove(curso);
    }

    @JsonGetter
    public double totalCursos() {
        double total = 0;
        for (Curso curso : cursos) {
            curso.getCodigo();
            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Escola [codigo=" + codigo_escola + ", cursos=" + cursos + ", endereco=" + endereco + ", nome=" + nome + ", telefone=" + telefone + "]";
    }
}
