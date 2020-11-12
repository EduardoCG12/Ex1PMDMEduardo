package com.example.ex1pmdmeduardo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //creamos la variables necesarias
    ArrayList<Animal> ar_animal;
    RecyclerView recycler;
    static TextView receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //"Enganchamos" el recyclerView con su id
        recycler = findViewById(R.id.recycler);
        //Llamamos al texto recibido
        receptor = findViewById(R.id.NotaRecibida);
        //le decimos al recycler que tipo de layaout va a tener en este caso va a ser un linearLayout
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //iniciamos el arraylist
        ar_animal = new ArrayList<>();
        //llenamos el arraylist
        for (int i = 0; i <= 0; i++) {
            Animal L1 = new Animal("Araña " + i, R.drawable.aranya);
            Animal L2 = new Animal("Ardilla " + i, R.drawable.ardilla);
            Animal L3 = new Animal("Hormiga " + i, R.drawable.hormiga);
            Animal L4 = new Animal("Loro " + i, R.drawable.loro);
            Animal L5 = new Animal("Rata " + i, R.drawable.rata);
            ar_animal.add(L1);
            ar_animal.add(L2);
            ar_animal.add(L3);
            ar_animal.add(L4);
            ar_animal.add(L5);

            //Recepcion de datos.
            Bundle b = this.getIntent().getExtras();
            if (b != null) {
                String dato = b.getString("dato");
                receptor.setText(dato);
            }

            //creamos un objeto de tipo AdapterItems y le pasamos por parametro el arraylist
            AdaptadorAnimal adapter = new AdaptadorAnimal(ar_animal);
            adapter.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ElementoSelecionado.class);
                intent.putExtra("titulo", ar_animal.get(recycler.getChildAdapterPosition(v)).getNombre());
                intent.putExtra("img", ar_animal.get(recycler.getChildAdapterPosition(v)).getImagen());
                startActivityForResult(intent, 1);
            });
            //metemos el adapter creado al recyclerView
            recycler.setAdapter(adapter);
        }
    }
}