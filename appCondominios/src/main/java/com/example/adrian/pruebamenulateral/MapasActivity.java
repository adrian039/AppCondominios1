package com.example.adrian.pruebamenulateral;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import Interfaz.MenuLateral;

public class MapasActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraUpdate zoom; //valor del zoom
    private LatLng coordenadas; //Objeto que almacenará los valores de la ubicacion
    private boolean buscarme=true;
    private Handler hiloBusqueda; //Hilo que actualiza las coordenadas #REVISAR NO FUNKA
    private static int puntaje;
    private double Lat;
    private double Lon;
    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    MenuLateral menuM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mapa Condominios");
        mMap = googleMap;
        zoom= CameraUpdateFactory.zoomTo(10);
        // Add a marker in Sydney and move the camera
        LatLng sanJose = new LatLng(9.935697, -84.1483647);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sanJose));
        mMap.animateCamera(zoom);

        Bitmap bMapCasa = BitmapFactory.decodeResource(getResources(), R.drawable.mapcasa);
        final LatLng Posicion = new LatLng(9.904051, -84.093735);
        final LatLng Posicion1 = new LatLng(9.854495, -83.921311);
        Marker RecursoA = mMap.addMarker(new MarkerOptions()
                .position(Posicion)
                .title("Condominio Lopez Mateos") //Cmabiar por el nombre del recurso
                .snippet("Zona sur de San José") //Agregar nota adicional
                .icon(BitmapDescriptorFactory.fromBitmap(bMapCasa))); //Color del marcador
        Marker RecursoB = mMap.addMarker(new MarkerOptions()
                .position(Posicion1)
                .title("Condominio Manuel de Jesús") //Cmabiar por el nombre del recurso
                .snippet("1.5 KM sur del centro de Cartago") //Agregar nota adicional
                .icon(BitmapDescriptorFactory.fromBitmap(bMapCasa))); //Color del marcador
    }
    private void zoomUbicacion(LatLng location){
        try {
            CameraUpdate ubicar = CameraUpdateFactory.newLatLng(location);
            mMap.moveCamera(ubicar);
            mMap.animateCamera(zoom);

        }catch(Exception e){

        }
    }



}
