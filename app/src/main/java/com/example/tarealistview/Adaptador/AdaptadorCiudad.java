package com.example.tarealistview.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tarealistview.Modelo.ciudades;
import com.example.tarealistview.R;

import java.util.ArrayList;

public class AdaptadorCiudad extends ArrayAdapter<ciudades> {

    public AdaptadorCiudad(Context context, ArrayList<ciudades> datos) {
        super(context, R.layout.ly_segundo, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_segundo, null);

        TextView ciudad = (TextView) item.findViewById(R.id.lblciudad);
        ciudad.setText(getItem(position).getCiudad());
        TextView total_confirmado1 = (TextView) item.findViewById(R.id.lblTotalConfirmado);
        total_confirmado1.setText(getItem(position).getTotal_confirmado());
        TextView nuevas_muertes1 = (TextView) item.findViewById(R.id.lblNuevasMuertes);
        nuevas_muertes1.setText(getItem(position).getNuevas_muertes());
        TextView total_muertes1 = (TextView) item.findViewById(R.id.lblTotalMuertes);
        total_muertes1.setText(getItem(position).getNuevas_muertes());
        return (item);
    }
}
