package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quinto2019.R;

public class ActivitySuma extends AppCompatActivity implements View.OnClickListener {
    EditText N1,N2;
    Button botonSumar;
    TextView Respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);
        cargarComponentes();
    }

    private void cargarComponentes(){
        N1 = findViewById(R.id.txtUno);
        N2 = findViewById(R.id.txtDos);
        botonSumar = findViewById(R.id.btnSumar);
        botonSumar.setOnClickListener(this);
        Respuesta = findViewById(R.id.lblRespuesta);
    }

    public void onClick (View view){
        int valor1=Integer.parseInt(N1.getText().toString());
        int valor2=Integer.parseInt(N2.getText().toString());
        int suma=valor1+valor2;
        Respuesta.setText(suma+"");
    }
}
