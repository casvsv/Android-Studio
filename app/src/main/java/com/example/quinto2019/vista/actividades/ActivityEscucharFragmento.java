package com.example.quinto2019.vista.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.quinto2019.R;
import com.example.quinto2019.modelo.Comunicador;
import com.example.quinto2019.vista.fragmentos.FrgDosAEF;
import com.example.quinto2019.vista.fragmentos.FrgUnoAEF;

public class ActivityEscucharFragmento extends AppCompatActivity implements Comunicador,View.OnClickListener, FrgUnoAEF.OnFragmentInteractionListener, FrgDosAEF.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuchar_fragmento);
        cargarFragmentos();
    }

    private void cargarFragmentos(){
        FrgUnoAEF fragmento1 = new FrgUnoAEF();
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.layoutFrg1AEF,fragmento1);
        transaction1.commit();

        FrgDosAEF fragmento2 = new FrgDosAEF();
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.layoutFrg2AEF,fragmento2);
        transaction2.commit();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void responder(String datos) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FrgDosAEF fragment=(FrgDosAEF) fragmentManager.findFragmentById(R.id.layoutFrg2AEF);
        fragment.cambiarTexto(datos);
    }
}
