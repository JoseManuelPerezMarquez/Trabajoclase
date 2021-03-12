package com.example.trabajofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivityPantalla2 extends AppCompatActivity {

    private EditText nombre, apellidos,telefono, email, direccion, fechanacimiento;
    private RadioButton hombre, mujer;
    private Gson gson;
    private String sexo;
    private CheckBox caja1,caja2,caja3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pantalla2);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.Apellidos);
        telefono =findViewById(R.id.Telefono);
        email = findViewById(R.id.Email);
        direccion = findViewById(R.id.Direccion);
        fechanacimiento = findViewById(R.id.FechaNacimiento);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);

        caja1=(CheckBox)findViewById(R.id.checkBox);
        caja2=(CheckBox)findViewById(R.id.checkBox2);
        caja3=(CheckBox)findViewById(R.id.checkBox3);

        gson=new Gson();
    }


    public void volverPrincipal(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void irpantalla3(View view) {

        if (nombre.getText().toString().trim().equals("") ||
                apellidos.getText().toString().trim().equals("") ||
                telefono.getText().toString().trim().equals("") ||
                email.getText().toString().trim().equals("") ||
                direccion.getText().toString().trim().equals("") ||
                fechanacimiento.getText().toString().trim().equals("")){
            Toast.makeText(this, "Completa los datos", Toast.LENGTH_SHORT).show();
        }else if(telefono.length()<9||telefono.length()>9) {
            Toast.makeText(this, "El número de teléfono debe tener 9 dígitos", Toast.LENGTH_SHORT).show();

        } else {
            Usuario usuario=new Usuario(nombre.getText().toString(),apellidos.getText().toString(),Integer.parseInt(telefono.getText().toString()),email.getText().toString(),direccion.getText().toString(),fechanacimiento.getText().toString());
            Intent intent2 = new Intent(this, MainActivityPantalla3.class);
            String cadenaUsuario=gson.toJson(usuario);
            Bundle bundle=new Bundle();
            bundle.putSerializable("usuario",usuario);
            intent2.putExtra("datos",cadenaUsuario);
            intent2.putExtra("telefonoPasar", telefono.getText().toString());
            intent2.putExtra("fechanac",fechanacimiento.getText().toString());
            String resultSexo="";
            if(hombre.isChecked()==true){
                resultSexo="hombre";
            }else if(mujer.isChecked()==true){
                resultSexo="mujer";
            }
            intent2.putExtra("sexoradio",resultSexo);

            String resultado="";
            if(caja1.isChecked()==true){
                resultado="| PHP |";
            }if(caja2.isChecked()==true){
                resultado+="| Android |";
            }if(caja3.isChecked()==true){
                resultado+="| JavaScript |";
            }
            intent2.putExtra("interes",resultado);
            intent2.putExtras(bundle);
            startActivity(intent2);
        }
    }
}