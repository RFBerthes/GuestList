package com.mobile.guestlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterEvento extends BaseAdapter {

    private List<Evento> listEvento;
    private Context context;
    private LayoutInflater inflater;

    public AdapterEvento(List<Evento> listEvento, Context context, LayoutInflater inflater) {
        this.listEvento = listEvento;
        this.context = context;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return listEvento.size();
    }

    @Override
    public Object getItem(int i) {
        return listEvento.get(i);
    }

    public long getItemId(String s) {
        return listEvento.get(s);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

    }

    private class EventoSuporte{
        //parei aqui
        TextView tvListaNome, tvCamisa, tvPosicao;
        LinearLayout layout;
    }
}
