package com.example.cursoenigma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PantallaPrincipal extends Activity {

    public RecyclerView rvPersonas;
    public Button btnAgregar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);

        rvPersonas = findViewById(R.id.rvPersonas);
        btnAgregar = findViewById(R.id.btnAgregar);

        LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext());
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        rvPersonas.setLayoutManager(linearLayout);

        List<Personas> personas = new ArrayList<>();
        personas.add(new Personas("Nathalia", "Ospina", 23, "1234567890"));
        personas.add(new Personas("Oscar", "Lisarazo", 24, "1234567891"));
        personas.add(new Personas("Juan", "Rengifo", 21, "1234567892"));
        personas.add(new Personas("Andres", "García", 29, "1234567893"));

        PersonasAdapter adapter = new PersonasAdapter(personas);
        rvPersonas.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PantallaPrincipal.this);
                View dialogPersonas = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_agregar_persona, null);

                EditText etNombre = dialogPersonas.findViewById(R.id.etNombre);
                EditText etApellido = dialogPersonas.findViewById(R.id.etApellido);
                EditText etEdad = dialogPersonas.findViewById(R.id.etEdad);
                EditText etTelefono = dialogPersonas.findViewById(R.id.etTelefono);

                builder.setTitle("Agregar")
                        .setMessage("aqui agregas una nueva persona")
                        .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                personas.add(new Personas(etNombre.getText().toString(),
                                        etApellido.getText().toString(),
                                        Integer.parseInt(etEdad.getText().toString()),
                                        etTelefono.getText().toString()));
                                adapter.notifyDataSetChanged();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.setView(dialogPersonas);
                dialog.show();
            }
        });
    }
}
