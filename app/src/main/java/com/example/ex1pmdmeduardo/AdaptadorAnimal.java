package com.example.ex1pmdmeduardo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAnimal extends RecyclerView.Adapter<AdaptadorAnimal.ViewHolderDatos>  implements View.OnClickListener {

    //creamos un arraylist para guardar los datos
    ArrayList<Animal> ar_animal;
    private View.OnClickListener listener;

    public AdaptadorAnimal(ArrayList<Animal> ar_animal) {
        this.ar_animal = ar_animal;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //"inflamos" el items_recycler.xml
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,null,false);
        //Para escuchar el evento de selecion
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.NombreAnimal.setText(ar_animal.get(position).getNombre());
        holder.ImagenAnimal.setImageResource(ar_animal.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        //le decimos cuantos "items nos va a devolver"
        return ar_animal.size();
    }

    public void setOnClickListener(View.OnClickListener listenerclick){
        this.listener=listenerclick;
    }

    //Llamada al OnCLickListener
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {
        //creamos los items que tenemos en el items_rerycler
        TextView NombreAnimal;
        ImageView ImagenAnimal;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            //Enganchamos los datos de los TextView i ImageView
            NombreAnimal = itemView.findViewById(R.id.tvNombre);
            ImagenAnimal=itemView.findViewById(R.id.imagen);
        }
    }
}