package com.example.formulariocoursera;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nombreEt, fechaEt, telefonoEt, emailEt, descripcionEt;
    String nombre, fecha, telefono, email, descripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btnEditar = findViewById(R.id.btnEditar);
        nombreEt = findViewById(R.id.etNombre);
        fechaEt = findViewById(R.id.etFecha);
        telefonoEt = findViewById(R.id.etTelefono);
        emailEt = findViewById(R.id.etEmail);
        descripcionEt = findViewById(R.id.etDescripcion);
        btnEditar.setOnClickListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            nombre = getIntent().getExtras().getString("nombre");
            fecha = getIntent().getExtras().getString("telefono");
            email = getIntent().getExtras().getString("email");
            telefono = getIntent().getExtras().getString("descripcion");
            descripcion = getIntent().getExtras().getString("fecha");

            nombreEt.setText(nombre);
            fechaEt.setText("Fecha de nacimiento: " + fecha);
            telefonoEt.setText("Tel. " + telefono);
            emailEt.setText("Email: " + email);
            descripcionEt.setText("Descripcion:" + descripcion);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnEditar) {
            finish();
        }
    }
}