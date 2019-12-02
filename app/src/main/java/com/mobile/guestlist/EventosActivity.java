package com.mobile.guestlist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventosActivity extends AppCompatActivity implements View.OnClickListener{


    DatabaseReference databaseReference;
    private ViewHolder mViewHolder = new ViewHolder();
    private ListView lvEventos;
    ArrayList<String> arrayEventos = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseReference = FirebaseDatabase.getInstance().getReference("Eventos");
        lvEventos = findViewById(R.id.lvEventos);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.layout_lista_eventos);
        lvEventos.setAdapter(arrayAdapter);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String valor=dataSnapshot.getValue(Evento.class).toString();
                arrayEventos.add(valor);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
