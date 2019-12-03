package com.mobile.guestlist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.guestlist.R;
import com.mobile.guestlist.viewholder.ConvidadoViewHolder;

public class AdapterConvidado extends RecyclerView.Adapter<ConvidadoViewHolder> {
    @NonNull
    @Override
    public ConvidadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View eView = layoutInflater.inflate(R.layout.layout_convidado, parent, false);

        return new ConvidadoViewHolder(eView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConvidadoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
