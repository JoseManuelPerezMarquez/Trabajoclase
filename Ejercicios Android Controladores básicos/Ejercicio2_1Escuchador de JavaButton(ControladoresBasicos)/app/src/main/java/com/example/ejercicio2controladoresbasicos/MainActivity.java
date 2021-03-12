package com.example.ejercicio2controladoresbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto1;
    Button boton1;
    Button boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1=(TextView)findViewById(R.id.modificarTexto);
        boton1 = (Button) findViewById(R.id.button3);
        boton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        texto1.setText("Mi nuevo texto primera parte");
                        texto1.setTextColor(Color.BLUE);
                    }
                }
        );
        boton2=(Button)findViewById(R.id.button);
        boton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        texto1.setText("Mi nuevo texto segunda parte");
                        texto1.setTextColor(Color.GREEN);
                    }
                }
        );
    }

}
