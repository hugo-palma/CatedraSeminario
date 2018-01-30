package com.palma.hugo.catedraseminario;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    List<Centro> listaCentros = new ArrayList<>();
    Intent miIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaCentros.add(new Centro("Lago de Coatepeque", R.drawable.coate));
        listaCentros.add(new Centro("Volcan Ilamatepec", R.drawable.ilama));
        listaCentros.add(new Centro("Cerro El Pital", R.drawable.pital));
        listaCentros.add(new Centro("Centro Arqueologico El Tazumal", R.drawable.tazumal));
        listaCentros.add(new Centro("Playa El Tunco", R.drawable.tunco));
        listaCentros.add(new Centro("Museo de Arte MARTE", R.drawable.marte));
        listaCentros.add(new Centro("Volcan de San Salvador", R.drawable.boqueron));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_centros_turisticos);
        recyclerView.setHasFixedSize(true);
        Adaptador adaptador = new Adaptador(listaCentros, this, this);
        recyclerView.setAdapter(adaptador);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_LOCATION:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startActivity(miIntent);
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    public void setMiIntent(Intent intent){
        miIntent = intent;
    }
}
