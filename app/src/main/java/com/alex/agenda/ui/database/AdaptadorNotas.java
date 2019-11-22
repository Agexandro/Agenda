package com.alex.agenda.ui.database;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.agenda.R;

import java.util.ArrayList;

public class AdaptadorNotas extends RecyclerView.Adapter<AdaptadorNotas.ViewHolderDatos> {
    ArrayList<Notes> lista;

    public AdaptadorNotas(ArrayList<Notes> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(lista.get(position).get_titulo(),lista.get(position).get_fecha());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView fecha;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            fecha = (TextView) itemView.findViewById(R.id.fecha);
        }

        public void asignarDatos(String s,String t) {
            titulo.setText(s);
            fecha.setText(t);

        }
    }
}
