package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quinto2019.R;
import com.example.quinto2019.vista.fragmentos.FrgDos;
import com.example.quinto2019.vista.fragmentos.FrgUno;

public class ActivityFragmento extends AppCompatActivity implements View.OnClickListener, FrgUno.OnFragmentInteractionListener, FrgDos.OnFragmentInteractionListener {

    Button botonFrg1,botonFrg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento);
        cargarComponentes();
    }

    private void cargarComponentes(){
        botonFrg1 = findViewById(R.id.btnFrg1);
        botonFrg2 = findViewById(R.id.btnFrg2);
        botonFrg1.setOnClickListener(this);
        botonFrg2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFrg1:
                FrgUno fragmento1 = new FrgUno();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.contenedorFragmentos,fragmento1);
                transaction1.commit();
                break;
            case R.id.btnFrg2:
                FrgDos fragmento2 = new FrgDos();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.contenedorFragmentos,fragmento2);
                transaction2.commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
