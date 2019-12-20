package com.example.quinto2019.vista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinto2019.R;
import com.example.quinto2019.modelo.Artista;
import com.example.quinto2019.vista.actividades.ActivityLogin;

import java.util.List;

import android.view.View;
import android.widget.Toast;

public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.ViewHolderArtista> implements View.OnClickListener {

    private View.OnClickListener clickDetalles;
    List<Artista> lista;



    public ArtistaAdapter(List<Artista> lista){
        this.lista = lista;
    }



    @Override
    public ViewHolderArtista onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_artista,null);
        view.setOnClickListener(this);
        return new ViewHolderArtista(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderArtista viewHolderArtista, int i) {
        viewHolderArtista.datoNombres.setText(lista.get(i).getNombres());
        viewHolderArtista.datoApellidos.setText(lista.get(i).getApellidos());
        viewHolderArtista.datoNombreArtistico.setText(lista.get(i).getNombreArtistico());
        //viewHolderArtista.datoFecha.setText((CharSequence) lista.get(i).getFechaNacimiento());
        viewHolderArtista.datoFoto.setImageResource(lista.get(i).getFoto());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.clickDetalles=onClickListener;
    }

    @Override
    public void onClick(View v) {
        if (clickDetalles != null){
            clickDetalles.onClick(v);
        }
    }

    public static class ViewHolderArtista extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView datoNombres;
        TextView datoApellidos;
        TextView datoNombreArtistico;
        TextView datoFecha;
        ImageView datoFoto;
        Button botonArtista;

        public ViewHolderArtista(@NonNull View itemView) {
            super(itemView);
            datoNombres = itemView.findViewById(R.id.lblNombreArtista);
            datoApellidos = itemView.findViewById(R.id.lblApellidoArtista);
            datoNombreArtistico = itemView.findViewById(R.id.lblNombreArtisticoArtista);
            //datoFecha = itemView.findViewById(R.id.lblFechaNacimientoArtista);
            datoFoto = itemView.findViewById(R.id.lblImagenArtista);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(null, "Usuario: ",
                    Toast.LENGTH_LONG).show();
        }
    }


}
