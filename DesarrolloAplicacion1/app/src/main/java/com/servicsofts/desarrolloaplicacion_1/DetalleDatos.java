package com.servicsofts.desarrolloaplicacion_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleDatos extends AppCompatActivity implements View.OnClickListener {

     //definimos los textView a setear
      TextView textDatoEmail, textDatoTelefo, textDatoNombre, textDatoDescrip, textFechaDato;
      Button btnRegresar;

    private String nombre;
    private String email;
    private String telefono ;
    private String fechaNaci;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);

        //capturamos valorex extras definidops
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("valorNombre");
        email = extras.getString("valorEmail");
        telefono = extras.getString("valortelefono");
        fechaNaci = extras.getString("valorFecha");
        descripcion = extras.getString("valorDescripcion");

        btnRegresar=findViewById(R.id.buttonIdRegresar);

        textDatoNombre =findViewById(R.id.textIngNombre);
        textDatoNombre.setText(nombre);

        textDatoEmail=findViewById(R.id.textIngEmail);
        textDatoEmail.setText(email);

        textDatoDescrip =findViewById(R.id.textIngDescrip);
        textDatoDescrip.setText(descripcion);

        textDatoTelefo =findViewById(R.id.textIngTelefo);
        textDatoTelefo.setText(telefono);

        textFechaDato = findViewById(R.id.textIngFecha);
        textFechaDato.setText(fechaNaci);
        //asignacion evento click
        btnRegresar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //este componente nos permite navegar hacia una actividad
        Intent intentDatos= new Intent(DetalleDatos.this,MainActivity.class);

        //paso los parametros apra ser editados
        intentDatos.putExtra("valorNombre", nombre);
        intentDatos.putExtra("valortelefono", telefono);
        intentDatos.putExtra("valorEmail", email);
        intentDatos.putExtra("valorDescripcion", descripcion);
        intentDatos.putExtra("valorFecha", fechaNaci);
        intentDatos.putExtra("variableDetalle", "uno");
        startActivity(intentDatos);

    }


}