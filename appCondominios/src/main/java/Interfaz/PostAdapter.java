package Interfaz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.pruebamenulateral.R;

/**
 * Created by Adrian on 21/01/2016.
 */
public class PostAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] indicador;
    String[] titulos;
    String[] contenido;
    LayoutInflater inflater;

    public PostAdapter(Context context, String[] indicador, String[] titulos, String[] contenido) {
        this.context = context;
        this.indicador = indicador;
        this.titulos = titulos;
        this.contenido = contenido;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitulo;
        TextView txtContenido;
        TextView txtIndicador;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.post_principal, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitulo = (TextView) itemView.findViewById(R.id.titulo_postPrincipal);
        txtContenido = (TextView) itemView.findViewById(R.id.descripcion_postPrincipal);
        txtIndicador=(TextView) itemView.findViewById(R.id.indicador_postPrincipal);

        // Capture position and set to the TextViews

        txtTitulo.setText(titulos[position]);
        txtContenido.setText(contenido[position]);
        if(indicador[position].equals("Pendiente")){
            txtIndicador.setText("Pendiente");
            txtIndicador.setTextColor(Color.RED);
        }else{
            txtIndicador.setText("Realizado");
            txtIndicador.setTextColor(Color.GREEN);
        }

        return itemView;
    }
}
