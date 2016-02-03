package com.example.adrian.pruebamenulateral;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Funciones.ClienteServicio;
import Funciones.Conexion;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {
    Button Entrar;
    EditText Username;
    EditText Password;
    static Connection connect;
    static String usuario;
    ClienteServicio Cliente;
    Conexion conectar;
    public static String nActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Password = (EditText) findViewById(R.id.txtClave);
        Username=(EditText) findViewById(R.id.txtNombre);
        Entrar=(Button)findViewById(R.id.btnEntrar);
        conectar=new Conexion();
        Login.this.setTitle("CISA Condominios");
        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
             /*  if(conexion.isChecked()){
                    QuerySQL("SELECT * FROM tblUsuarios");
                }else {
                   Toast.makeText(Login.this, "Debe establecer la conexión con el servidor", Toast.LENGTH_LONG).show();
               }
                */

                //** Para la funcion del web service no es necesario usar el switch de conexion ya que ese era para usar directamente con los
                //comandos de SQL Server

                Cliente=new ClienteServicio();
                boolean aut;
                if(conectar.Comprobar(Login.this)){
                    aut=Cliente.lfAutenticar(Username.getText().toString(),Password.getText().toString());
                    if(aut){
                        Toast.makeText(Login.this, "Login Exitoso",
                                Toast.LENGTH_LONG).show();
                        Username.setText("");
                        Password.setText("");

                        startActivity(new Intent(Login.this, Principal.class));
                        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    }else{
                        Toast.makeText(Login.this, "Usuario o contraseña incorrectos",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Login.this, "Debe estar conectado a una red wifi o de datos moviles.", Toast.LENGTH_LONG).show();

                }

            }
        });



    }





}

