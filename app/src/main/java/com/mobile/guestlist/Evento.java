package com.mobile.guestlist;

public class Evento {

    private String id;
    private String nome;
    private String data;
    private String hora;
    private String endereco;
    private String capacidade;
    private String responsavel;

    public Evento() {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Evento{" +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", endereco='" + endereco + '\'' +
                ", capacidade='" + capacidade + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}


