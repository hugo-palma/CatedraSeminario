package com.palma.hugo.catedraseminario;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hugo on 24/1/2018.
 */

public class Adaptador extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<Centro> listaCentros;
    Context context;
    private LocationManager manejador;
    private MainActivity mainActivity;

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    public Adaptador(List<Centro>listaCentros, Context context, MainActivity mainActivity){
        this.listaCentros = listaCentros;
        this.context = context;
        this.mainActivity = mainActivity;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta_centro_turistico, parent, false);
        return new RecyclerViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.titulo.setText(listaCentros.get(position).getTitulo());
        holder.imagen.setImageResource(listaCentros.get(position).getImagen());
        holder.carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("imagen", listaCentros.get(position).getImagen());
                bundle.putString("titulo", listaCentros.get(position).getTitulo());
                Intent intent = new Intent(context, CentroActivity.class);
                intent.putExtras(bundle);
                mainActivity.setMiIntent(intent);
                if ( ContextCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

                    ActivityCompat.requestPermissions(mainActivity , new String[] {  Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_NETWORK_STATE },
                            MY_PERMISSIONS_REQUEST_LOCATION);
                }
                else {
                    context.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaCentros.size();
    }
}
