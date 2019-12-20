package com.example.quinto2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.quinto2019.vista.actividades.ActivityEnvio;
import com.example.quinto2019.vista.actividades.ActivityEscucharFragmento;
import com.example.quinto2019.vista.actividades.ActivityFragmento;
import com.example.quinto2019.vista.actividades.ActivityLogin;
import com.example.quinto2019.vista.actividades.ActivitySuma;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonLogin,botonSumar,botonEnvio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarComponentes();
    }

    private void cargarComponentes(){
        botonLogin = findViewById(R.id.btnIrLogin);
        botonSumar = findViewById(R.id.btnIrSumar);
        botonEnvio = findViewById(R.id.btnIrEnvio);
        botonLogin.setOnClickListener(this);
        botonSumar.setOnClickListener(this);
        botonEnvio.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnIrLogin:
                intent = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(intent);
                break;
            case R.id.btnIrSumar:
                intent = new Intent(MainActivity.this, ActivitySuma.class);
                startActivity(intent);
                break;
            case R.id.btnIrEnvio:
                intent = new Intent(MainActivity.this, ActivityEnvio.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Método para cargar menú
        //MenuInflater permite crear un objeto para manejar el archivo xml (main)
        //El método inflate permite agregar un menú implementado de un archivo xml a la actividad
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Este método permite realizar eventos en cada item hijo de los menús
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent = new Intent(MainActivity.this,ActivityLogin.class);
                startActivity(intent);
                break;
            case R.id.opcionSumar:
                intent = new Intent(MainActivity.this,ActivitySuma.class);
                startActivity(intent);
                break;
            case R.id.opcionParametros:
                intent = new Intent(MainActivity.this,ActivityEnvio.class);
                startActivity(intent);
                break;
            case R.id.opcionColores:
                intent = new Intent(MainActivity.this, ActivityFragmento.class);
                startActivity(intent);
                break;
            case R.id.opcionClick:
                intent = new Intent(MainActivity.this, ActivityEscucharFragmento.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
