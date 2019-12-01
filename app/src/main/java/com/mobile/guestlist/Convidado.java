package com.mobile.guestlist;

public class Convidado {
    private int id;
    private String nome;
    private int status;

    public int getId(String s) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Convidado() {
    }

    public Convidado(int id, String nome, int status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }
}
