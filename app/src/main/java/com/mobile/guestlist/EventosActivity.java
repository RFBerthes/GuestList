package com.mobile.guestlist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventosActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Evento");

    private ViewHolder mViewHolder = new ViewHolder();
    private ListView lvEventos;
    ArrayList<String> arrayEventos = new ArrayList<>();


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



        // Read from the database

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

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
