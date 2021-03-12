package com.example.ejercicio4radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onRadioButtonClicked(View view){
        TextView texto=findViewById(R.id.textView);
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.radioButton:
                if(checked){
                    texto.setText("PULSADO LUNES");
                }
                break;
            case R.id.radioButton2:
                if(checked){
                    texto.setText("PULSADO MARTES");
                }
                break;
            case R.id.radioButton3:
                if(checked){
                    texto.setText("PULSADO MIÉRCOLES");
                }
                break;
            case R.id.radioButton4:
                if(checked){
                    texto.setText("PULSADO JUEVES");
                }
                break;
            case R.id.radioButton5:
                if(checked){
                    texto.setText("PULSADO VIERNES");
                }
                break;
            case R.id.radioButton6:
                if(checked){
                    texto.setText("PULSADO SÁBADO");
                }
                break;
            case R.id.radioButton7:
                if(checked){
                    texto.setText("PULSADO DOMINGO");
                }
                break;
        }
    }
}