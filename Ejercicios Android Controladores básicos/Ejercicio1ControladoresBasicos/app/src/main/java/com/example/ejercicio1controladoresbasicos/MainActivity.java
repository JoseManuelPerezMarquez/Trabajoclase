package com.example.ejercicio1controladoresbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto1;
    TextView texto2;
    TextView texto3;
    TextView texto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView texto1 = (TextView) findViewById(R.id.textView);
        TextView texto2 = (TextView) findViewById(R.id.textView2);
        TextView texto3 = (TextView) findViewById(R.id.textView3);
        String texto = "<font color=#000000>Text View 3</font> <font color=#ff0000>Ejercicio 1</font>";
        texto3.setText(Html.fromHtml(texto));

        TextView texto4 = (TextView) findViewById(R.id.textView4);
    }
}