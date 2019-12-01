package com.mobile.guestlist;

public class Evento {

    private int id;

    private String nome;

    private String data;

    private int numConvidados;

    private int numConfirmados;

    private int numPendentes;


    public Evento() {
    }


    public Evento(int id, String nome, String data, int numConvidados, int numConfirmados, int numPendentes) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.numConvidados = numConvidados;
        this.numConfirmados = numConfirmados;
        this.numPendentes = numPendentes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumConvidados() {
        return numConvidados;
    }

    public void setNumConvidados(int numConvidados) {
        this.numConvidados = numConvidados;
    }

    public int getNumConfirmados() {
        return numConfirmados;
    }

    public void setNumConfirmados(int numConfirmados) {
        this.numConfirmados = numConfirmados;
    }

    public int getNumPendentes() {
        return numPendentes;
    }

    public void setNumPendentes(int numPendentes) {
        this.numPendentes = numPendentes;
    }
}

