package com.servicsofts.desarrolloaplicacion_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     private Button btnSiguiente;
     private EditText editTextEmail, editTextNombre, editTextTelefono,  EditTextDescrip, EditTextFecha;
     String valorDatella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //definir  una referencia a la variable que hemos creado
        btnSiguiente=findViewById(R.id.buttonSiguiente);
        editTextEmail =findViewById(R.id.ediatTextEmail);
        editTextNombre = findViewById(R.id.editextNombre);
        editTextTelefono = findViewById(R.id.editextTelefon);
        EditTextDescrip = findViewById(R.id.editTestDescripcion);
        EditTextFecha = findViewById(R.id.editFechaNacimiento);

        //asignacion evento click
        btnSiguiente.setOnClickListener(this);
/*
       if(getIntent().getExtras().getString("variableDetalle") =="uno"){
        Bundle extrasDetalle = getIntent().getExtras();
        valorDatella = extrasDetalle.getString("variableDetalle");

            //inicializamos los campos del formulario con los  datos
            editTextEmail.setText(extrasDetalle.getString("valorEmail"));
            editTextNombre.setText(extrasDetalle.getString("valorNombre"));
            editTextTelefono.setText(extrasDetalle.getString("valortelefono"));
            EditTextDescrip.setText(extrasDetalle.getString("valorDescripcion"));
            EditTextFecha.setText(extrasDetalle.getString("valorFecha"));

       }
*/

    }

    @Override
    public void onClick(View view) {
        Log.i("app","click en siguiente");
          String fecha;
        fecha = EditTextFecha.getText().toString();
        String email = editTextEmail.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String descripcion = EditTextDescrip.getText().toString();
        //Log.i("app","click "+ email +"  fecha"+ fecha+ " tel "+telefono +" descripcion "+ descripcion);
        try {
            if(!email.isEmpty() &&  !nombre.isEmpty()){
                //este componente nos permite navegar hacia una actividad
                Intent intentDatos= new Intent(MainActivity.this,DetalleDatos.class);
                //pasar parametros extras
                intentDatos.putExtra("valorNombre", nombre);
                intentDatos.putExtra("valortelefono", telefono);
                intentDatos.putExtra("valorEmail", email);
                intentDatos.putExtra("valorDescripcion", descripcion);
                intentDatos.putExtra("valorFecha", fecha);
                startActivity(intentDatos);
            }else{
                editTextEmail.setError("Por revisar los campos del formulario");
                editTextNombre.setError("Por revisar los campos del formulario");

            }


        } catch (NullPointerException e) {
            Log.i("error","erro"+e.getMessage());
        }


    }


}