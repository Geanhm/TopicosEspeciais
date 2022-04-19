package com.example.core.Model;

public class Alocacao {

    private String id;
    private Veiculo veiculo;
    private Agente agente;

    public Alocacao(){}

    public Alocacao(String id, Veiculo veiculo, Agente agente) {
        this.id = id;
        this.veiculo = veiculo;
        this.agente = agente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
    
    
}
