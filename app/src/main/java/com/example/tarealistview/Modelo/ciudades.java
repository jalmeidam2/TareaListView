package com.example.tarealistview.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ciudades {

    private String ciudad;
    private String total_confirmado;
    private String nuevas_muertes;
    private String total_muertes;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTotal_confirmado() {
        return total_confirmado;
    }

    public void setTotal_confirmado(String total_confirmado) {
        this.total_confirmado = total_confirmado;
    }

    public String getNuevas_muertes() {
        return nuevas_muertes;
    }

    public void setNuevas_muertes(String nuevas_muertes) {
        this.nuevas_muertes = nuevas_muertes;
    }

    public String getTotal_muertes() {
        return total_muertes;
    }

    public void setTotal_muertes(String total_muertes) {
        this.total_muertes = total_muertes;
    }


    public ciudades(JSONObject a) throws JSONException {
        ciudad = a.getString("Country").toString();
        total_confirmado = a.getString("TotalConfirmed").toString();
        nuevas_muertes = a.getString("NewDeaths").toString();
        total_muertes = a.getString("TotalDeaths").toString();


    }

    public static ArrayList<ciudades> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<ciudades> ciudad = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            ciudad.add(new ciudades(datos.getJSONObject(i)));
        }
        return ciudad;
    }


}
