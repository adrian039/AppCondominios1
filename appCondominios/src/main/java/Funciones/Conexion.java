package Funciones;

import android.os.StrictMode;

/**
 * Created by Adrian on 18/01/2016.
 */
public class Conexion {

    public Conexion(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}
