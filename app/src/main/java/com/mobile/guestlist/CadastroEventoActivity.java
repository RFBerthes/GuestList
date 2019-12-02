package com.mobile.guestlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroEventoActivity extends AppCompatActivity {

    EditText nomeEvento, dataEvento, horaEvento, enderecoEvento, capacidadeEvento;
    Button bntSalvar;
    Evento evento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadstro_evento);

        nomeEvento = findViewById(R.id.etNomeEvento);
        dataEvento = findViewById(R.id.etData);
        horaEvento = findViewById(R.id.etHora);
        enderecoEvento = findViewById(R.id.etEndereco);
        capacidadeEvento = findViewById(R.id.etCapacidade);
        bntSalvar = findViewById(R.id.btnSalvarEvento);
        evento = new Evento();


        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar() {

        if (!this.validarSalvar()) {
            return;
        }

        String nome = nomeEvento.getText().toString();
        String data = dataEvento.getText().toString();
        String hora = horaEvento.getText().toString();
        String endereco = enderecoEvento.getText().toString();
        String capacidade = capacidadeEvento.getText().toString();


        evento.setNome(nome);
        evento.setData(data);
        evento.setHora(hora);
        evento.setEndereco(endereco);
        evento.setCapacidade(capacidade);

        // Insere no firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Eventos");
        DatabaseReference EventoRef = myRef.child("Evento");
        EventoRef.push().setValue(evento);


        if (true) {
            Toast.makeText(this, getString(R.string.sucessoSalvar), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.erroSalvar), Toast.LENGTH_LONG).show();
        }

        finish();

    }

    private boolean validarSalvar() {
        if (nomeEvento.toString().equals("")) {
            nomeEvento.setError(getString(R.string.erroNome));
            return false;
        }
        return true;
    }

}
