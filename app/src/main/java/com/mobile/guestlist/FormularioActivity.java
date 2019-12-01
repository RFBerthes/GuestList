package com.mobile.guestlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.mViewHolder.mEtNome = this.findViewById(R.id.etNome);
        this.mViewHolder.mrbConfirm = this.findViewById(R.id.rbConfirmado);
        this.mViewHolder.mrbPendente = this.findViewById(R.id.rbPendente);
        this.mViewHolder.mrbNegado = this.findViewById(R.id.rbNegado);
        this.mViewHolder.mbtnSalvar = this.findViewById(R.id.btnSalvar);

        this.setListeners();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSalvar){
            this.salvar();
        }
    }

    private void setListeners() {
        this.mViewHolder.mbtnSalvar.setOnClickListener(this);
    }


    private void salvar() {

        Convidado c = new Convidado();
        c.setNome(this.mViewHolder.mEtNome.getText().toString());

        if (this.mViewHolder.mrbConfirm.isChecked()){
            c.setStatus(Constantes.CONFIRMACAO.CONFIRMADO);
        }else if (this.mViewHolder.mrbPendente.isChecked()){
            c.setStatus(Constantes.CONFIRMACAO.PENDENTE);
        }else{
            c.setStatus(Constantes.CONFIRMACAO.NEGADO);
        }

    }

    private static class  ViewHolder {
        EditText mEtNome;
        RadioButton mrbConfirm;
        RadioButton mrbPendente;
        RadioButton mrbNegado;
        Button mbtnSalvar;

    }
}
