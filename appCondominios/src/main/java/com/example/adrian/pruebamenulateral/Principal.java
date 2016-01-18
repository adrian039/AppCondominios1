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

public class Principal extends ActionBarActivity {

    TextView nombre;
    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    List<NavItem> listNavItems;


    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        nombre = (TextView) findViewById(R.id.txtNombre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombre.setText(Login.usuario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerPane=(RelativeLayout)findViewById(R.id.content_frame);
        lvNav=(ListView)findViewById(R.id.left_drawer);
        listNavItems=new ArrayList<NavItem>();

        listNavItems.add(new NavItem("", "", R.drawable.home));
        listNavItems.add(new NavItem("Home", "Página Principal", R.drawable.home));
        listNavItems.add(new NavItem("Mapa", "Ver mapa", R.drawable.map));
        listNavItems.add(new NavItem("Requerimientos", "Enviar un requerimiento", R.drawable.edit));
        listNavItems.add(new NavItem("Configuración", "Ver Configuración de cuenta", R.drawable.setting));
        listNavItems.add(new NavItem("Salir", "Cerrar Sesión", R.drawable.logout));

        NavListAdapter navListAdapter= new NavListAdapter(getApplicationContext(),R.layout.item_nav_list,listNavItems);

        lvNav.setAdapter(navListAdapter);

        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Toast.makeText(Principal.this, "Home",
                            Toast.LENGTH_LONG).show();
                } else if(position==2){
                    startActivity(new Intent(Principal.this, MapasActivity.class));
                }else if(position==3){
                    startActivity(new Intent(Principal.this, Requerimientos.class));
                }
                else if (position == 5) {
                    startActivity(new Intent(Principal.this, Login.class));
                }
            }
        });

        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
