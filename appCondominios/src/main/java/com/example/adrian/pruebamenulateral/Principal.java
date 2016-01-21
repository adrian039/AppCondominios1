package com.example.adrian.pruebamenulateral;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Interfaz.MenuLateral;
import Interfaz.PostAdapter;

public class Principal extends ActionBarActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    MenuLateral menu;

    String[] titulo;
    String[] contenido;
    String[] indicador;

    private ListView lista;
    PostAdapter adapter;

    int currentViewPager;
    String nombreCircuito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerPane=(RelativeLayout)findViewById(R.id.content_frame);
        lvNav=(ListView)findViewById(R.id.left_drawer);
        lista=(ListView)findViewById(R.id.listView);
        menu=new MenuLateral(getApplicationContext(),lvNav,drawerLayout,Principal.this);
        Login.nActivity="Principal";

        titulo= new String[]{"Cobro mes Enero", "Solicitud de Arreglo", "Descuento 25%", "Requerimiento", "Validar Cuenta"};
        indicador=new String[]{"Realizado", "Pendiente", "Pendiente", "Realizado","Pendiente"};
        contenido=new String[]{"NADA NADA NADA NADA NADA NADA NADA", "NADA NADA NADA NADA NADA NADA NADA", "NADA NADA NADA NADA NADA NADA NADA", "NADA NADA NADA NADA NADA NADA NADA","NADA NADA NADA NADA NADA NADA NADA"};


        adapter=new PostAdapter(this,indicador,titulo,contenido);
        lista.setAdapter(adapter);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.actionBarDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.main, menu1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (menu.actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
