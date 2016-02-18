package com.example.adrian.pruebamenulateral;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Interfaz.MenuLateral;
import Interfaz.PostAdapter;
import Interfaz.Swipe.SwipeMenu;
import Interfaz.Swipe.SwipeMenuCreator;
import Interfaz.Swipe.SwipeMenuItem;
import Interfaz.Swipe.SwipeMenuListView;

public class Principal extends ActionBarActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    MenuLateral menu;

    JSONArray listaPost;
    JSONObject ob1,obj2,obj3,obj4,obj5;

    private SwipeMenuListView lista;
    PostAdapter adapter;
    SwipeMenuCreator creator;




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
        lista=(SwipeMenuListView)findViewById(R.id.listView);
        menu=new MenuLateral(getApplicationContext(),lvNav,drawerLayout,Principal.this);
        Login.nActivity="Principal";
        try {
            adapter=new PostAdapter(this, datos());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        lista.setAdapter(adapter);
        creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.parseColor("#1E88E5")));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Llamar");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        lista.setMenuCreator(creator);



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

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    /*****Funcion que crea un objeto json para cada post y los guarda en u jsonArray para poder mostralos en el post
    de la pagina principal************/

    private JSONArray datos() throws JSONException {
        ob1=new JSONObject();
        obj2=new JSONObject();
        obj3=new JSONObject();
        obj4=new JSONObject();
        obj5=new JSONObject();
        listaPost= new JSONArray();

        ob1.put("titulo","Cobro mes Enero");
        ob1.put("indicador","Realizado");
        ob1.put("contenido","NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA " +
                "NADA NADA NADA  ");

        obj2.put("titulo","Solicitud de Arreglo");
        obj2.put("indicador","Pendiente");
        obj2.put("contenido","NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA " +
                "NADA NADA NADA  ");

        obj3.put("titulo","Descuento 25%");
        obj3.put("indicador","Pendiente");
        obj3.put("contenido","NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA " +
                "NADA NADA NADA  ");

        obj4.put("titulo","Requerimiento");
        obj4.put("indicador","Realizado");
        obj4.put("contenido", "NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA " +
                "NADA NADA NADA ");

        obj5.put("titulo","Validar Cuenta");
        obj5.put("indicador","Pendiente");
        obj5.put("contenido", "NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA NADA " +
                "NADA NADA NADA NADA ");

        listaPost.put(ob1);
        listaPost.put(obj2);
        listaPost.put(obj3);
        listaPost.put(obj4);
        listaPost.put(obj5);

        return  listaPost;
    }



}
