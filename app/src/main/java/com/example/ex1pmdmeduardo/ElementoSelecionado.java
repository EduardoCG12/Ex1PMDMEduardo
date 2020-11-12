package com.example.ex1pmdmeduardo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ElementoSelecionado extends AppCompatActivity {
    TextView tvNombre;
    ImageView img;
    EditText nota;
    Button ponernota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento_seleccionado);

        tvNombre = findViewById(R.id.textNombre);
        img = findViewById(R.id.imgAnimal);
        nota = findViewById(R.id.nota);
        ponernota = findViewById(R.id.agregarnota);

        tvNombre.setText(getIntent().getStringExtra("titulo"));
        img.setImageResource(getIntent().getIntExtra("img",0));

        Log.d("IMAGEN", "onCreate: "+img);

        //Ponemos la nota y la mandamos al MainActivity
        ponernota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Envio el texto introducido en mi EditText
                if (nota.getText().length() != 0) {
                    Bundle b = new Bundle();
                    b.putString("datos", MainActivity.receptor.getText().toString());
                    Intent v = new Intent(ElementoSelecionado.this, MainActivity.class);
                    v.putExtras(b);
                    startActivity(v);
                }
            }
        });
    }
}

