package com.mobile.guestlist;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.guestlist.Adapter.AdapterConvidado;


public class TodosFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todos_convidados, container, false);
        Context context = view.getContext();

        //Obter a Racycler
        this.mViewHolder.mRecyclerViewTodos = view.findViewById(R.id.recycler_todos);

        //Definir um adapter
        AdapterConvidado adapterConvidado = new AdapterConvidado();
        this.mViewHolder.mRecyclerViewTodos.setAdapter(adapterConvidado);

        //Definir um Layout
        this.mViewHolder.mRecyclerViewTodos.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }


    private static class ViewHolder {
        RecyclerView mRecyclerViewTodos;
    }


}
