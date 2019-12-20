package com.example.quinto2019.vista.actividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quinto2019.R;
import com.example.quinto2019.modelo.Artista;
import com.example.quinto2019.vista.adapter.ArtistaAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ActivityMI extends AppCompatActivity implements View.OnClickListener {

    private EditText cajaNombres,cajaApellidos,cajaNombreArtistico;
    private TextView datos;
    private ImageView foto;
    private Button botonGuardar,botonListar,botonCargarFoto;
    RecyclerView recyclerViewArtistas;
    ArtistaAdapter adapter;
    List<Artista> listaArtistas = new ArrayList<Artista>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);
        tomarControl();
    }

    private void tomarControl(){
        recyclerViewArtistas = findViewById(R.id.RecyclerMI);
        cajaNombres = findViewById(R.id.txtNombresMI);
        cajaApellidos = findViewById(R.id.txtApellidosMI);
        cajaNombreArtistico = findViewById(R.id.txtNombreArtisticoMI);
        foto = findViewById(R.id.lblMIFoto);
        //datos = findViewById(R.id.txtVerificarMI);
        botonGuardar = findViewById(R.id.btnMIAnadir);
        botonListar = findViewById(R.id.btnMIListar);
        botonCargarFoto = findViewById(R.id.btnMICargarImagen);
        botonGuardar.setOnClickListener(this);
        botonListar.setOnClickListener(this);
        botonCargarFoto.setOnClickListener(this);

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

    private void guardarEnLista() throws IOException {
        Artista artista = new Artista();
        artista.setNombres(cajaNombres.getText().toString());
        artista.setApellidos(cajaApellidos.getText().toString());
        artista.setNombreArtistico(cajaNombreArtistico.getText().toString());
        artista.setFoto(R.id.lblMIFoto);
        OutputStreamWriter escritor = new OutputStreamWriter(openFileOutput("arti.txt", Context.MODE_APPEND));
        escritor.write(cajaNombres.getText().toString()+","+cajaApellidos.getText().toString()+","+cajaNombreArtistico.getText().toString()+","+artista.getFoto()+";");
        escritor.close();
    }

    private void cargarLista(String cadena){
        String[] aux = cadena.split(";");
        for(int i=0;i<aux.length;i++){
            String[] aux2 = aux[i].split(",");
            Artista a = new Artista();
            a.setNombres(aux2[0]);
            a.setApellidos(aux2[1]);
            a.setNombreArtistico(aux2[2]);
            a.setFoto(Integer.parseInt(aux2[3]));
            listaArtistas.add(a);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMIAnadir:
                try {
                    guardarEnLista();
                    limpiar();
                    Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
                } catch (Exception ex){
                    Log.e("ArchivoMI","Error de escritura" + ex.getMessage());
                }
                break;
            case R.id.btnMIListar:
                try {
                    BufferedReader lector = new BufferedReader(new InputStreamReader(openFileInput("arti.txt")));
                    String lineas = lector.readLine();
                    //datos.setText(lineas);
                    cargarLista(lineas);
                    cargarRecycler();
                    lector.close();
                } catch (Exception ex){
                        Log.e("ArchivoMI","Error de escritura" + ex.getMessage());
                    }
                break;
            case R.id.btnMICargarImagen:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent.createChooser(intent,"Elija la opción que prefiera"),10);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Uri path = data.getData();
            foto.setImageURI(path);
        }
    }

    public void limpiar(){
        cajaNombres.setText("");
        cajaApellidos.setText("");
        cajaNombreArtistico.setText("");
    }


    public void cargarDialogo(View view){
        Dialog dialog = new Dialog(ActivityMI.this);
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
