package com.mobile.guestlist;

public class Evento {

    private String keyEvento;
    private String nome;
    private String data;
    private String hora;
    private String endereco;
    private String capacidade;
    private String responsavel;

    public Evento() {
    }

    public String getKeyEvento() {
        return keyEvento;
    }

    public void setKeyEvento(String keyEvento) {
        this.keyEvento = keyEvento;
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
                "keyEvento='" + keyEvento + '\'' +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", endereco='" + endereco + '\'' +
                ", capacidade='" + capacidade + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}


