package com.example.trabajofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivityPantalla3 extends AppCompatActivity {

    private TextView nombre, apellidos,telefono,email,direccion,sexo,fechaNacimiento,intereses;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pantalla3);
        gson=new Gson();
        nombre=(TextView) findViewById(R.id.campoNombre);
        apellidos=(TextView) findViewById(R.id.campoApellidos);

        telefono=(TextView)findViewById(R.id.campoTelefono);
        Bundle extras1 =getIntent().getExtras();
        String tlf =extras1.getString("telefonoPasar");

        email=(TextView) findViewById(R.id.campoEmail);
        direccion=(TextView)findViewById(R.id.campoDireccion);

        fechaNacimiento=(TextView)findViewById(R.id.campoFechaNac);
        Bundle extras2=getIntent().getExtras();
        String fechnac =extras2.getString("fechanac");

        sexo=(TextView) findViewById(R.id.campoSexo) ;
        Bundle extras3=getIntent().getExtras();
        String sexoDato=extras3.getString("sexoradio");

        intereses=(TextView)findViewById(R.id.campoIntereses);
        Bundle extras4=getIntent().getExtras();
        String datosInteres=extras4.getString("interes");

        Bundle objetoEnviado = getIntent().getExtras();
        Usuario usuario = null;
        Bundle extras=getIntent().getExtras();
        if (objetoEnviado != null) {
            usuario = (Usuario) objetoEnviado.getSerializable("usuario");

            nombre.setText(usuario.getNombre().toString());
            apellidos.setText(usuario.getApellidos().toString());
            email.setText(usuario.getEmail().toString());
            direccion.setText(usuario.getDireccion().toString());
            sexo.setText(sexoDato);
            telefono.setText(tlf);
            fechaNacimiento.setText(fechnac);
            intereses.setText(datosInteres);
        }

    }
    public void volverPantalla2(View view){
        Intent intent=new Intent(this,MainActivityPantalla2.class);
        startActivity(intent);
    }
    public void irPantalla1(View view){
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}