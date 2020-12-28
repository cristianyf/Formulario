package com.example.formulariocoursera;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFecha, btnSiguiente;
    EditText etFecha;
    private int dia, mes, ano;
    TextInputEditText nombre, telefono, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFecha = findViewById(R.id.btnFecha);
        etFecha = findViewById(R.id.etFecha);
        nombre = findViewById(R.id.etNombre);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(this);
        btnFecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnFecha) {
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    etFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }, dia, mes, ano);
            datePickerDialog.show();
        } else if (v == btnSiguiente) {
            String nombreEt = nombre.getText().toString();
            String telefonoEt = telefono.getText().toString();
            String emailEt = email.getText().toString();
            String descripcionEt = descripcion.getText().toString();
            String fechaEt = etFecha.getText().toString();

            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("nombre", nombreEt);
            intent.putExtra("telefono", telefonoEt);
            intent.putExtra("email", emailEt);
            intent.putExtra("descripcion", descripcionEt);
            intent.putExtra("fecha", fechaEt);
            startActivity(intent);
        }
    }
}