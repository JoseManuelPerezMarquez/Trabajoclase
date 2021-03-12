package com.example.ejercicio2controladoresbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.ejercicio2controladoresbasicos.MESSAGE";
    TextView texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
    }
        public void enviarMensaje1(View view){
            TextView editText = (TextView) findViewById(R.id.modificarTexto);
            String message = editText.getText().toString();
            TextView texto1=(TextView) findViewById(R.id.modificarTexto);
            texto1.setText("Mi nuevo texto primera parte");
            texto1.setTextColor(Color.BLUE);

        }

    public void enviarMensaje2(View view){
        TextView editText = (TextView) findViewById(R.id.modificarTexto);
        String message = editText.getText().toString();
        TextView texto1=(TextView) findViewById(R.id.modificarTexto);
        texto1.setText("Mi nuevo texto segunda parte");
        texto1.setTextColor(Color.GREEN);
    }
}