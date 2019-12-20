package com.example.quinto2019;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.quinto2019.vista.actividades.ActivityEnvio;
import com.example.quinto2019.vista.actividades.ActivityEscucharFragmento;
import com.example.quinto2019.vista.actividades.ActivityFragmento;
import com.example.quinto2019.vista.actividades.ActivityLogin;
import com.example.quinto2019.vista.actividades.ActivityMI;
import com.example.quinto2019.vista.actividades.ActivityMP;
import com.example.quinto2019.vista.actividades.ActivityRecyclerArtistas;
import com.example.quinto2019.vista.actividades.ActivitySuma;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Este método permite realizar eventos en cada item hijo de los menús
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent = new Intent(ActivityMenu.this, ActivityLogin.class);
                startActivity(intent);
                break;
            case R.id.opcionSumar:
                intent = new Intent(ActivityMenu.this, ActivitySuma.class);
                startActivity(intent);
                break;
            case R.id.opcionParametros:
                intent = new Intent(ActivityMenu.this, ActivityEnvio.class);
                startActivity(intent);
                break;
            case R.id.opcionColores:
                intent = new Intent(ActivityMenu.this, ActivityFragmento.class);
                startActivity(intent);
                break;
            case R.id.opcionClick:
                intent = new Intent(ActivityMenu.this, ActivityEscucharFragmento.class);
                startActivity(intent);
                break;
            case R.id.opcionDlgSumar:
                final Dialog dlgSumar = new Dialog(ActivityMenu.this);
                dlgSumar.setContentView(R.layout.dlg_sumar);

                final EditText cajaDlgN1 = dlgSumar.findViewById(R.id.txtN1dlg);
                final EditText cajaDlgN2 = dlgSumar.findViewById(R.id.txtN2dlg);
                Button botonSumarDlg=dlgSumar.findViewById(R.id.btnSumardlg);
                botonSumarDlg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int valor1=Integer.parseInt(cajaDlgN1.getText().toString());
                        int valor2=Integer.parseInt(cajaDlgN2.getText().toString());
                        int respuestadlg=valor1+valor2;
                        Toast.makeText(ActivityMenu.this,"La suma es "+respuestadlg,Toast.LENGTH_SHORT).show();
                        dlgSumar.hide();
                    }
                });
                dlgSumar.show();
                break;
            case R.id.opcionRecyclerArtistas:
                intent = new Intent(ActivityMenu.this, ActivityRecyclerArtistas.class);
                startActivity(intent);
                break;

            case R.id.opcionInterno:
                intent = new Intent(ActivityMenu.this, ActivityMI.class);
                startActivity(intent);
                break;
            case R.id.opcionPrograma:
                intent = new Intent(ActivityMenu.this, ActivityMP.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
