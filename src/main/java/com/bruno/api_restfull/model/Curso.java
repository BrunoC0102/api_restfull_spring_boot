package com.bruno.api_restfull.model;

public class Curso {
    
    private int codigo;
    private String categoria;
    private String nome;
    private String destinatarios;
    private String descricao;
    
    public Curso(){
        
    }

    public Curso(int codigo, String categoria, String nome, String destinatarios, String descricao) {
		this.codigo = codigo;
		this.categoria = categoria;
		this.nome = nome;
		this.destinatarios = destinatarios;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

	@Override
	public String toString() {
		return "Curso [categoria=" + categoria + ", codigo=" + codigo + ", descricao=" + descricao + ", destinatarios="	+ destinatarios + ", nome=" + nome + "]";
	}

    
    
}
