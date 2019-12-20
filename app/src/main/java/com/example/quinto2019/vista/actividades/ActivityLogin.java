package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quinto2019.R;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    EditText cajaUsuario,cajaPassword;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cargarComponentes();
    }

    private void cargarComponentes(){
        cajaUsuario= findViewById(R.id.txtUsuario);
        cajaPassword= findViewById(R.id.txtClave);
        boton= findViewById(R.id.btnLogin);
        boton.setOnClickListener(this);
    }

    public void onClick(View view){
        Toast.makeText(ActivityLogin.this, "Usuario: "+cajaUsuario.getText()+" Clave:"+cajaPassword.getText(),
                Toast.LENGTH_LONG).show();
    }
}
