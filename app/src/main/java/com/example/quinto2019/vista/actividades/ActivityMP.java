package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quinto2019.R;
import com.example.quinto2019.modelo.Artista;
import com.example.quinto2019.vista.adapter.ArtistaAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ActivityMP extends AppCompatActivity implements View.OnClickListener{
    InputStream input;
    BufferedReader lector;
    Button boton;
    TextView dato;
    ArtistaAdapter adapter;
    List<Artista> lista = new ArrayList<Artista>();
    RecyclerView recyclerViewArtistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);
        tomarControl();
    }

    public void cargarCadena(){
        try {
            String cadena = lector.readLine();
            dato.setText(cadena);
            cargarLista(cadena);
            cargarRecycler();
            lector.close();
        } catch (IOException e){
            Log.e("ArchivoMI","Error de lectura" + e.getMessage());
        }
    }

    public void tomarControl(){
        recyclerViewArtistas = findViewById(R.id.Recycler_MP);
        input = getResources().openRawResource(R.raw.archivo_raw);
        lector = new BufferedReader(new InputStreamReader(input));
        boton = findViewById(R.id.btnMpLeer);
        dato = findViewById(R.id.lblMPVerificar);
        boton.setOnClickListener(this);
    }

    private void cargarLista(String cadena){
        String[] aux = cadena.split(";");
        for(int i=0;i<aux.length;i++){
            String[] aux2 = aux[i].split(",");
            Artista a = new Artista();
            a.setNombres(aux2[0]);
            a.setApellidos(aux2[1]);
            a.setNombreArtistico(aux2[2]);
            a.setFoto(R.drawable.dog4);
            lista.add(a);
        }
    }

    private void cargarRecycler(){
        recyclerViewArtistas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArtistaAdapter(lista);
        recyclerViewArtistas.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        cargarCadena();

    }
}
