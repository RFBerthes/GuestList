package com.mobile.guestlist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.guestlist.Evento;
import com.mobile.guestlist.R;

import java.util.List;

public class AdapterEvento extends BaseAdapter {

    private List<Evento> listEvento;
    private Context context;
    private LayoutInflater inflater;

    public AdapterEvento(List<Evento> listEvento, Context context, LayoutInflater inflater) {
        this.listEvento = listEvento;
        this.context = context;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return listEvento.size();
    }

    @Override
    public Object getItem(int i) {
        return listEvento.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        EventoSuporte es = new EventoSuporte();

        if ( view == null){
            view = inflater.inflate(R.layout.layout_lista_eventos, null);
            es.tvNomeEvento = view.findViewById(R.id.tvNomeEvento);
            es.tvDataEvento = view.findViewById(R.id.tvDataEvento);
            es.tvHoraEvento = view.findViewById(R.id.tvHoraEvento);
            es.tvLocalEvento = view.findViewById(R.id.tvLocalEvento);
            es.tvRespEvento = view.findViewById(R.id.tvRespEvento);
            es.layout = view.findViewById(R.id.layout);

            view.setTag( es );
        }else {
            es = (EventoSuporte) view.getTag();
        }

        Evento evento = listEvento.get( i );
        es.tvNomeEvento.setText( evento.getNome() );
        es.tvDataEvento.setText( evento.getData() );
        es.tvHoraEvento.setText( evento.getHora() );
        es.tvLocalEvento.setText( evento.getEndereco() );
        es.tvRespEvento.setText( evento.getResponsavel() );

        return view;

    }

    private class EventoSuporte{
        TextView tvNomeEvento, tvDataEvento, tvHoraEvento, tvLocalEvento, tvRespEvento;
        LinearLayout layout;
    }
}
