package com.example.tarealistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tarealistview.Adaptador.AdaptadorCiudad;
import com.example.tarealistview.Modelo.ciudades;
import com.example.tarealistview.WebService.Asynchtask;
import com.example.tarealistview.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ListView Listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://api.covid19api.com/summary", datos, this, this);
        ws.execute("GET");
        Listar = (ListView) findViewById(R.id.LstPrincipal);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<ciudades> c = new ArrayList<ciudades>();
        try {
            JSONObject JSONlista = new JSONObject(result);
            JSONArray JSONlistaciudades = JSONlista.getJSONArray("Countries");
            c = ciudades.JsonObjectsBuild(JSONlistaciudades);
            AdaptadorCiudad adapatorUsuario = new AdaptadorCiudad(this, c);
            Listar.setAdapter(adapatorUsuario);
        } catch (JSONException e) {

        }

    }
}