package com.mobile.guestlist;

public class Convidado {
    private String id;
    private String evento;
    private String nome;
    private int status;

    public Convidado() {
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "id='" + id + '\'' +
                ", evento='" + evento + '\'' +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
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





}
