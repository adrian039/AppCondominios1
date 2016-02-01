package Interfaz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adrian.pruebamenulateral.Login;
import com.example.adrian.pruebamenulateral.MapasActivity;
import com.example.adrian.pruebamenulateral.Principal;
import com.example.adrian.pruebamenulateral.R;
import com.example.adrian.pruebamenulateral.Requerimientos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 19/01/2016.
 */
public class MenuLateral extends Activity  {
    List<NavItem> listNavItems;

    public ActionBarDrawerToggle actionBarDrawerToggle;


    public MenuLateral(final Context context,ListView lvNav, DrawerLayout drawerLayout,final Activity activity){
        listNavItems=new ArrayList<NavItem>();

        listNavItems.add(new NavItem("", "", R.drawable.home));
        listNavItems.add(new NavItem("Home", "Página Principal", R.drawable.home));
        listNavItems.add(new NavItem("Mapa", "Ver mapa", R.drawable.map));
        listNavItems.add(new NavItem("Requerimientos", "Enviar un requerimiento", R.drawable.edit));
        listNavItems.add(new NavItem("Pagos", "Ver lista de pagos", R.drawable.monedas));
        listNavItems.add(new NavItem("Configuración", "Ver Configuración de cuenta", R.drawable.setting));
        listNavItems.add(new NavItem("Salir", "Cerrar Sesión", R.drawable.logout));

        NavListAdapter navListAdapter= new NavListAdapter(context,R.layout.item_nav_list,listNavItems);

        lvNav.setAdapter(navListAdapter);

        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1 && (Login.nActivity.equals("Principal")==false)) {
                    Intent i =new Intent(context,Principal.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    (activity).overridePendingTransition(R.anim.left_in, R.anim.left_out);
                } else if(position==2 && (Login.nActivity.equals("Mapa")==false)){
                    Intent i =new Intent(context,MapasActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    (activity).overridePendingTransition(R.anim.left_in, R.anim.left_out);
                }else if(position==3 && (Login.nActivity.equals("Requerimientos")==false)){
                    Intent i =new Intent(context,Requerimientos.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    (activity).overridePendingTransition(R.anim.left_in, R.anim.left_out);
                }
                else if (position == 6) {
                    Intent i =new Intent(context,Login.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    (activity).overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                }
            }
        });

        actionBarDrawerToggle=new ActionBarDrawerToggle(activity, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
//                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
              //  invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


    }

}
