package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quinto2019.R;

public class ActivityRecepcion extends AppCompatActivity {
    TextView cajaApellido,cajaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion);
        cargarComponentes();
        Bundle bundle = this.getIntent().getExtras();
        cajaNombre.setText(bundle.getString("nombres"));
        cajaApellido.setText(bundle.getString("apellidos"));
        //String nombre = getIntent().getStringExtra("Nombre");
        //String apellidos = getIntent().getStringExtra("Apellido");
        //cajaNombre.setText(nombre);
        //cajaApellido.setText(apellidos);
    }

    private void cargarComponentes(){
        cajaNombre = findViewById(R.id.lblNombre);
        cajaApellido = findViewById(R.id.lblApellido);
    }

}
