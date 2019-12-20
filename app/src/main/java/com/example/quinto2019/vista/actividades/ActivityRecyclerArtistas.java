package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quinto2019.R;
import com.example.quinto2019.modelo.Artista;
import com.example.quinto2019.vista.adapter.ArtistaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyclerArtistas extends AppCompatActivity {

    RecyclerView recyclerViewArtistas;
    ArtistaAdapter adapter;
    List<Artista> listaArtistas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_artistas);
        tomarControl();
        cargarRecycler();
    }

    private void tomarControl(){
        recyclerViewArtistas = findViewById(R.id.recyclerArtistas);
    }

    private void cargarRecycler(){
        Artista artista1 = new Artista();
        artista1.setNombres("Paul");
        artista1.setApellidos("McCartney");
        artista1.setNombreArtistico("Segundo Beatle");
        //artista1.setFechaNacimiento(1960,04,04);
        artista1.setFoto(R.drawable.paul);

        Artista artista2 = new Artista();
        artista2.setNombres("John");
        artista2.setApellidos("Lennon");
        artista2.setNombreArtistico("Primer Beatle");
        //artista2.setFechaNacimiento();
        artista2.setFoto(R.drawable.john);

        Artista artista3 = new Artista();
        artista3.setNombres("Ringo");
        artista3.setApellidos("Starr");
        artista3.setNombreArtistico("Cuarto Beatle");
        //artista3.setFechaNacimiento();
        artista3.setFoto(R.drawable.ringo);

        Artista artista4 = new Artista();
        artista4.setNombres("George");
        artista4.setApellidos("Harrison");
        artista4.setNombreArtistico("Tercer Beatle");
        //artista4.setFechaNacimiento();
        artista4.setFoto(R.drawable.george);


        listaArtistas = new ArrayList<Artista>();
        listaArtistas.add(artista1);
        listaArtistas.add(artista2);
        listaArtistas.add(artista3);
        listaArtistas.add(artista4);

        recyclerViewArtistas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArtistaAdapter(listaArtistas);
            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cargarDialogo(v);
                }
            });
        recyclerViewArtistas.setAdapter(adapter);
    }

    public void cargarDialogo(View view){
        Dialog dialog = new Dialog(ActivityRecyclerArtistas.this);
        dialog.setContentView(R.layout.dlg_detalles_artista);
        TextView cajaNombre = dialog.findViewById(R.id.lbl_dlg_nombre_artista);
        TextView cajaApellido = dialog.findViewById(R.id.lbl_dlg_apellido_artista);
        TextView cajaNombreArtista = dialog.findViewById(R.id.lbl_dlg_nombreartistico_artista);
        ImageView fotoArtista = dialog.findViewById(R.id.lbl_dlg_foto_artista);

        cajaNombre.setText(listaArtistas.get(recyclerViewArtistas.getChildAdapterPosition(view)).getNombres());
        cajaApellido.setText(listaArtistas.get(recyclerViewArtistas.getChildAdapterPosition(view)).getApellidos());
        cajaNombreArtista.setText(listaArtistas.get(recyclerViewArtistas.getChildAdapterPosition(view)).getNombreArtistico());
        fotoArtista.setImageResource(listaArtistas.get(recyclerViewArtistas.getChildAdapterPosition(view)).getFoto());
        dialog.show();
    }
}
