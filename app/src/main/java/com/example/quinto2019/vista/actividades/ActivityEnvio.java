package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.example.quinto2019.R;

public class ActivityEnvio extends AppCompatActivity {
    EditText nombre,apellido;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);
        cargarComponentes();
    }

    private void cargarComponentes(){
        nombre= (EditText) findViewById(R.id.txtNombre);
        apellido=(EditText) findViewById(R.id.txtApellido);
        boton= findViewById(R.id.btnEnviarDatos);
        boton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Intent i = new Intent(ActivityEnvio.this, ActivityRecepcion.class);
                Intent intent=new Intent(ActivityEnvio.this, ActivityRecepcion.class);
                bundle.putString("nombres",nombre.getText().toString());
                bundle.putString("apellidos",apellido.getText().toString());
                //i.putExtra("Nombre", nombre.getText()+"");
                //i.putExtra("Apellido", apellido.getText()+"");
                intent.putExtras(bundle);
                //startActivity(i);
                startActivity(intent);
            }
        });
    }
}
