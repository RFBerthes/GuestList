package com.mobile.guestlist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EventosActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private ListView lvEventos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvEventos = findViewById(R.id.lvEventos);
        lvEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //excluir((Evento) adapterView.getItemAtPosition(i));
                return true;
            }
        });

        this.mViewHolder.mfabAddEvento = this.findViewById(R.id.btnNovoEvento);
        this.setListeners();

    }


    private void setListeners() {
        this.mViewHolder.mfabAddEvento.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarLista();

    }

    private void carregarLista() {

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.btnNovoEvento){
            Intent novoEvento = new Intent(this, CadastroEventoActivity.class);
            this.startActivity(novoEvento);
        }

    }

    private static class ViewHolder{
        FloatingActionButton mfabAddEvento;
    }

}
