package com.palma.hugo.catedraseminario;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.MenuItem;
import android.widget.TextView;

public class CentroActivity extends AppCompatActivity implements LocationListener{

    TextView textViewTitulo, textViewDescripcion;
    AppCompatImageView imageView;
    private LocationManager manejador;
    private String proveedor;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    Location locacionCentro, milocation;
    int imagen, contadorActualizaciones = 0;
    String titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro);
        Bundle bundle = getIntent().getExtras();
        titulo = bundle.getString("titulo");
        imagen = bundle.getInt("imagen");

        textViewTitulo = findViewById(R.id.titulo_centro);
        textViewDescripcion = findViewById(R.id.textView_Descipcion);
        imageView = findViewById(R.id.imagen_centro);
        textViewTitulo.setText(titulo);
        imageView.setImageResource(imagen);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        locaion();
        setDescripcion();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;

    }
    private void locaion(){
        if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_NETWORK_STATE },
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }
        manejador = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        proveedor = manejador.getBestProvider(criteria, true);
        manejador.requestLocationUpdates(proveedor, 100, 1, this);
        milocation = manejador.getLastKnownLocation(proveedor);
        setLocacionCentro();

    }
    private void setLocacionCentro(){
        switch (imagen){
            case R.drawable.boqueron:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.7371339);
                locacionCentro.setLongitude(-89.2908347);
                break;
            case R.drawable.coate:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.8632001);
                locacionCentro.setLongitude(-89.5651721);
                break;
            case R.drawable.ilama:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.8554409);
                locacionCentro.setLongitude(-89.6370017);
                break;
            case R.drawable.marte:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.692555);
                locacionCentro.setLongitude(-89.244114);
                break;
            case R.drawable.pital:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(14.3885894);
                locacionCentro.setLongitude(-89.1347838);
                break;
            case R.drawable.tazumal:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.979616);
                locacionCentro.setLongitude(-89.6763642);
                break;
            case R.drawable.tunco:
                locacionCentro = new Location(proveedor);
                locacionCentro.setLatitude(13.4945688);
                locacionCentro.setLongitude(-89.3835828);
                break;
        }
    }
    private void setDescripcion(){
        switch (imagen){
            case R.drawable.boqueron:
                String descripcion = "El volcán de San Salvador está ubicado en la zona central de El Salvador. Abarca los municipios de Quezaltepeque, San Juan Opico, Colón y Santa Tecla en el departamento de La Libertad; y Nejapa en el departamento de San Salvador. \n" +
                        "Última erupción: 1917\n" +
                        "Elevación: 1,893 m\n" +
                        "Ubicación: El Salvador, San Salvador, La Libertad\n" +
                        "Tipo: Complejo\n" +
                        "Era geológica: Geología histórica\n" +
                        "Ruta: Carretera al Boquerón";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.coate:
                descripcion = "El lago Coatepeque es un lago de origen volcánico, situado a 18 km al sur de la ciudad de Santa Ana en el municipio de El Congo. Tiene una altitud de 745 msnm y una superficie de 25.3 km². Además, su profundidad de 115 m.\n" +
                        "Superficie: 26 km²\n" +
                        "Elevación: 746 m\n" +
                        "Profundidad: Media: 35 m; Máxima: 115 m\n" +
                        "País(es): El Salvador\n" +
                        "Cuenca hidrográfica: Cuenca endorreica\n" +
                        "Islas interiores: Isla Teopán ó del Cerro";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.ilama:
                descripcion = "El volcán Lamatepec o de Santa Ana, ubicado en el departamento homónimo en El Salvador, tiene una altura de 2.381 msnm y es el más alto de este país. Sus últimas erupciones ocurrieron en 1920, en 1904 y en 2005. \n" +
                        "Elevación: 2,381 m\n" +
                        "Última erupción: 2008\n" +
                        "Ubicación: El Salvador, Santa Ana\n" +
                        "Tipo: Estratovolcanes\n" +
                        "Era geológica: Geología histórica\n" +
                        "Cordillera: Cordillera de Apaneca-Ilamatepec";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.marte:
                descripcion = "El Museo de Arte de El Salvador, localizado en la ciudad de San Salvador, es una institución privada sin fines de lucro encargada de la conservación y difusión del arte de ese país. \n" +
                        "Dirección: Colonia San Benito, Final Avenida la Revolución, San Salvador\n" +
                        "Teléfono: 2243 6099\n" +
                        "País: El Salvador\n" +
                        "Ciudad: San Salvador";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.pital:
                descripcion = "El cerro El Pital es una montaña transnacional, ubicada exactamente en la frontera entre El Salvador y Honduras. \n" +
                        "Elevación: 2,730 m\n" +
                        "Prominencia: 1,530 m\n" +
                        "Cordillera: Sierra Madre de Chiapas\n" +
                        "Cordillera principal: Sierra Madre de Chiapas";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.tazumal:
                descripcion = "El Tazumal está ubicada en el corazón del municipio de Chalchuapa, departamento de Santa Ana, El Salvador a ochenta kilómetros al occidente de la capital. \n" +
                        "Dirección: Calle Tazumal, Chalchuapa\n" +
                        "Teléfono: 2444 0010";
                textViewDescripcion.setText(descripcion);
                break;
            case R.drawable.tunco:
                descripcion = "La playa El Tunco se ubica a 42 kilómetros de San Salvador y forma parte de la Ruta Sol y Playa de El Salvador, por lo que es un destino turístico muy visitado tanto por turistas nacionales como extranjeros.\n" +
                        "Dirección: CA-2\n" +
                        "País: El Salvador\n" +
                        "Ciudad: La libertad";
                textViewDescripcion.setText(descripcion);
                break;
        }
    }

    @Override
    protected void onResume() {
        if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_NETWORK_STATE }, MY_PERMISSIONS_REQUEST_LOCATION);
        }
        else
        {
            manejador.requestLocationUpdates(proveedor, 100, 1, this);

        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        manejador.removeUpdates(this);
        contadorActualizaciones = 0;
        super.onPause();

    }

    @Override
    public void onLocationChanged(Location location) {
        milocation = location;
        if(locacionCentro != null){
            showLocation(milocation.distanceTo(locacionCentro));
        }
        if(contadorActualizaciones >0 ){
            if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

                ActivityCompat.requestPermissions( this, new String[] {  Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_NETWORK_STATE }, MY_PERMISSIONS_REQUEST_LOCATION);
            }
            manejador.requestLocationUpdates(proveedor, 10000, 1, this);
        }
        contadorActualizaciones++;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    private void showLocation(float distancia){
        String texto = "La distancia hacia " + titulo + " es de: " + distancia + " metros";
        textViewTitulo.setText(texto);
    }
}
