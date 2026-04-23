package com.example.teste;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.ViewHolder> {
    private List<Registro> lista;

    public RegistroAdapter(List<Registro> lista){
        this.lista = lista;
    }//Fim do construtor

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView codigo, assunto, data, descricao;
        //Representando esses botões
        ImageButton btnEditar, btnExcluir;
        //Construtor
        public ViewHolder(View itemView){
            super(itemView);

            codigo = itemView.findViewById(R.id.txtCodigo);
            assunto = itemView.findViewById(R.id.txtAssunto);
            data = itemView.findViewById(R.id.txtData);
            descricao = itemView.findViewById(R.id.txtDescricao);

            this.btnEditar = itemView.findViewById(R.id.btnEditar);
            this.btnEditar = itemView.findViewById(R.id.btnEditar);


        }//Fim do viewHolder
    }//Fim da class viewHolder



}//Fim da class RegistroAdapter
