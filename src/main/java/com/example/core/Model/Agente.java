package com.example.core.Model;

public class Agente {
	
    private String id;
    private String nome;
    private Integer matricula;

    public Agente (){}

    public Agente(String id, String nome, Integer matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
