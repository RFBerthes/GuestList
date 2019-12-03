package com.mobile.guestlist.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.guestlist.R;

public class ConvidadoViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvNomeConvidado;

    public ConvidadoViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mtvNomeConvidado = itemView.findViewById(R.id.tvNomeConvidado);
    }
}
