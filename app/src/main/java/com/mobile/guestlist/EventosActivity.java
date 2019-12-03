package com.mobile.guestlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mobile.guestlist.Adapter.AdapterEvento;

import java.util.ArrayList;
import java.util.List;

public class EventosActivity extends AppCompatActivity {


    private ListView lvEventos;
    private List<Evento> listaDeEventos;
    private AdapterEvento adapterEvento;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ChildEventListener childEventListener;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvEventos = findViewById(R.id.lvEventos);

        listaDeEventos = new ArrayList<>();
        adapterEvento = new AdapterEvento(listaDeEventos, EventosActivity.this, getLayoutInflater());
        lvEventos.setAdapter(adapterEvento);

        FloatingActionButton fabAddEvento = findViewById(R.id.btnNovoEvento);
        fabAddEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EventosActivity.this, CadastroEventoActivity.class);
                startActivity( i );
            }
        });

        lvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Evento ev = (Evento) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(EventosActivity.this, ConvidadoActivity.class);
                //intent.putExtra("acao", "editar");
                intent.putExtra("keyEvento", ev.getKeyEvento() );
                startActivity( intent );
            }
        });

        lvEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //excluir( (Evento) adapterView.getItemAtPosition(i)  );
                return true;
            }
        });

/*        private void excluir (final Evento evento){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Excluir Produto");
            alerta.setMessage("Confirma a exclusão do produto "
                    + evento.getNome() + "?");
            alerta.setNeutralButton("Cancelar", null);
            alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                }
            });
            alerta.show();

        }*/

    }


    @Override
    protected void onStart() {
        super.onStart();

        listaDeEventos.clear();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        query = reference.child("Eventos").orderByChild("nome");

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Evento ev = new Evento();
                ev.setKeyEvento ( dataSnapshot.getKey());
                ev.setNome( dataSnapshot.child("nome").getValue(String.class) );
                ev.setData( dataSnapshot.child("data").getValue(String.class) );
                ev.setHora( dataSnapshot.child("hora").getValue(String.class) );
                ev.setEndereco( dataSnapshot.child("endereco").getValue(String.class) );
                ev.setResponsavel( dataSnapshot.child("responsavel").getValue(String.class) );
                listaDeEventos.add( ev );
                adapterEvento.notifyDataSetChanged();

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
        };
        query.addChildEventListener( childEventListener );

    }

    @Override
    protected void onStop() {
        super.onStop();
        query.removeEventListener( childEventListener );
    }



}
