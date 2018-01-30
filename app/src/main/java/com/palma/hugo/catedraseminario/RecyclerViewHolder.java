package com.palma.hugo.catedraseminario;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hugo on 24/1/2018.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    CardView carta;
    AppCompatImageView imagen;
    TextView titulo;
    LinearLayout linearLayoutTituloCentroTuristico;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imagen = itemView.findViewById(R.id.imagen_centro_turistico);
        titulo = itemView.findViewById(R.id.titulo_centro_turistico);
        carta = itemView.findViewById(R.id.carta_centro_turistico);
        carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
