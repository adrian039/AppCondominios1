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
    Switch conexion;
    EditText Password;
    static Connection connect;
    static String usuario;
    ClienteServicio Cliente;
    Conexion conectar;

    private void inicializar()
    {
        Login.connect = CONN("usuario_condominios", "123456789", "appCondominios", "192.168.0.124:1433");
    }

    @SuppressLint("NewApi")
    private Connection CONN(String _user, String _pass, String _DB, String _server )
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + _server + ";" + "databaseName=" + _DB + ";user=" + _user + ";password=" + _pass + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR",e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        return conn;
    }



    public void QuerySQL(String COMANDOSQL){
        ResultSet rs;
        boolean valor=false;
        try {

            Statement statement = Login.connect.createStatement();
            rs = statement.executeQuery(COMANDOSQL);
            System.out.print(rs);

            while(rs.next()){
                if(Username.getText().toString().equals(rs.getString("UserName")) &&
                        Password.getText().toString().equals(rs.getString("Clave"))){
                    usuario=rs.getString("Nombre");
                    Toast.makeText(Login.this, "Login Exitoso",
                            Toast.LENGTH_LONG).show();
                    Username.setText("");
                    Password.setText("");
                    conexion.setChecked(false);
                    startActivity(new Intent(Login.this, Principal.class));

                    valor=true;
                    break;
                }else{

                }

            }
            if(valor==false){
                Toast.makeText(Login.this, "Usuario o contraseña incorrectos",
                        Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Log.e("ERROR",e.getMessage());
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Password = (EditText) findViewById(R.id.txtClave);
        Username=(EditText) findViewById(R.id.txtNombre);
        Entrar=(Button)findViewById(R.id.btnEntrar);
        conexion=(Switch)findViewById(R.id.switch1);
        conectar=new Conexion();

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
                        conexion.setChecked(false);
                        startActivity(new Intent(Login.this, Principal.class));
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
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
        conexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conexion.isChecked()) {
                    inicializar();
                    Toast.makeText(Login.this, "Conexión con el servidor establecida", Toast.LENGTH_LONG).show();
                }
            }
        });


    }





}

