package Interfaz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.pruebamenulateral.R;

import java.util.List;

import Interfaz.NavItem;

/**
 * Created by Adrian on 07/01/2016.
 */
public class NavListAdapter extends ArrayAdapter<NavItem> {

    Context context;
    int resLayout;
    List<NavItem> listNavItems;
    public NavListAdapter(Context context, int resLayout, List<NavItem> listNavItems) {
        super(context, resLayout, listNavItems);


        this.context=context;
        this.resLayout=resLayout;
        this.listNavItems=listNavItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=View.inflate(context,resLayout,null);

        TextView tvTitle=(TextView)v.findViewById(R.id.title1);
        TextView tvSubTitle=(TextView)v.findViewById(R.id.subtitle);
        ImageView navIcon=(ImageView)v.findViewById(R.id.nav_icon);

        NavItem navItem=listNavItems.get(position);
        tvTitle.setText(navItem.getTitle());
        tvSubTitle.setText(navItem.getSubTitle());
        navIcon.setImageResource(navItem.getResIcon());


        return v;
    }
}
