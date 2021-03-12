package com.example.trabajofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int angulo;
    private ImageView imagen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1=(ImageView) findViewById(R.id.imageView);
        Toast mensajeBienvenida=Toast.makeText(this,"Bienvenido a mi aplicación",Toast.LENGTH_LONG);
        mensajeBienvenida.show();
    }
    public void irPantalla2(View view){
        Intent intent=new Intent(this,MainActivityPantalla2.class);
        startActivity(intent);
    }
    public void girar(View view){
        float deg = imagen1.getRotation() + 180F;
        imagen1.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
    }
}