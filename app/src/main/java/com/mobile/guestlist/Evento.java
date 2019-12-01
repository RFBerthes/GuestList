package com.mobile.guestlist;

import android.media.Image;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;


public class Evento {

    private int id;

    private Image img;

    private String nome;

    private Date data;

    private int numConvidados;

    private int numConfirmados;

    private int numPendentes;


    public Evento() {
    }


    public Evento(int id, Image img, String nome, Date data, int numConvidados, int numConfirmados, int numPendentes) {
        this.id = id;
        this.img = img;
        this.nome = nome;
        this.data = data;
        this.numConvidados = numConvidados;
        this.numConfirmados = numConfirmados;
        this.numPendentes = numPendentes;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("Eventos");
}
