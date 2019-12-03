package com.mobile.guestlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroConvidadoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadstro_convidado);
        this.mViewHolder.mEtNome = this.findViewById(R.id.etNome);
        this.mViewHolder.mrbConfirm = this.findViewById(R.id.rbConfirmado);
        this.mViewHolder.mrbPendente = this.findViewById(R.id.rbPendente);
        this.mViewHolder.mrbNegado = this.findViewById(R.id.rbNegado);
        this.mViewHolder.mbtnSalvar = this.findViewById(R.id.btnSalvar);

        this.setListeners();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSalvar) {
            salvar();
        }
    }

    private void setListeners() {
        this.mViewHolder.mbtnSalvar.setOnClickListener(this);
    }


    private void salvar() {

        if (!this.validarSalvar()) {
            return;
        }

        Convidado convidado = new Convidado();

        convidado.setNome(this.mViewHolder.mEtNome.getText().toString());

        if (this.mViewHolder.mrbConfirm.isChecked()) {
            convidado.setStatus(Constantes.CONFIRMACAO.CONFIRMADO);
        } else if (this.mViewHolder.mrbPendente.isChecked()) {
            convidado.setStatus(Constantes.CONFIRMACAO.PENDENTE);
        } else if (this.mViewHolder.mrbNegado.isChecked()) {
            convidado.setStatus(Constantes.CONFIRMACAO.NEGADO);
        } else {
            convidado.setStatus(Constantes.CONFIRMACAO.NEGADO);
        }

        // Insere no firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Convidados");
        myRef.push().setValue(convidado);

        if (true) {
            Toast.makeText(this, getString(R.string.sucessoSalvar), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.erroSalvar), Toast.LENGTH_LONG).show();
        }

        finish();

    }

    private boolean validarSalvar() {
        if (this.mViewHolder.mEtNome.getText().toString().equals("")) {
            this.mViewHolder.mEtNome.setError(getString(R.string.erroNome));
            return false;
        }
        return true;
    }

    private static class ViewHolder {
        EditText mEtNome;
        RadioButton mrbConfirm;
        RadioButton mrbPendente;
        RadioButton mrbNegado;
        Button mbtnSalvar;

    }
}
