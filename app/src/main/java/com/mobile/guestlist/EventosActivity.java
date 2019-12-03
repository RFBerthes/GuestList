package com.mobile.guestlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventosActivity extends AppCompatActivity implements View.OnClickListener{


    private ViewHolder mViewHolder = new ViewHolder();
    private ListView lvEventos;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<Evento> listEvento = new ArrayList<Evento>();
    private ArrayAdapter<Evento> arrayAdapterEvento;

    ChildEventListener childEventListener;
    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inicializaFirebase();

        lvEventos = (ListView) findViewById(R.id.lvEventos);

        arrayAdapterEvento = new ArrayAdapter<Evento>(this, android.R.layout.simple_list_item_1, listEvento);
        lvEventos.setAdapter(arrayAdapterEvento);

        query = databaseReference.child("Eventos").orderByChild("nome");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Evento ev = objSnapshot.getValue(Evento.class);
                    ev.setId( dataSnapshot.getKey() );
                    listEvento.add(ev);
                }
                arrayAdapterEvento.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });



        this.mViewHolder.mfabAddEvento = this.findViewById(R.id.btnNovoEvento);
        this.setListeners();

    }

    private void inicializaFirebase() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
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
