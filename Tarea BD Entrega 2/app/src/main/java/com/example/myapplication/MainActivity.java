package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button insertar;
    private Button actualizar;
    private Button eliminar;
    private Button consulta;

    private EditText codigo;
    private EditText nombre;
    private TextView txtResultado;

    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();
        insertar=findViewById(R.id.insertar);
        actualizar=findViewById(R.id.actualizar);
        eliminar = findViewById(R.id.eliminar);
        txtResultado=(TextView)findViewById(R.id.txtResultado);
        codigo =findViewById(R.id.codigo);
        nombre =findViewById(R.id.nombre);
    }
    public void Insertar(View view){
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();
        int cont=0;
        if(codigo.getText().toString().equals("")||nombre.getText().toString().equals("")){
            Toast tost= Toast.makeText(this,"Faltan datos",Toast.LENGTH_LONG);
            tost.show();

        }else{
            String codig=codigo.getText().toString();
            Cursor vercodigo=db.rawQuery("SELECT codigo,nombre FROM Usuarios WHERE codigo ="+codig,null);
            if(vercodigo.moveToFirst()){
                cont=cont+1;
            }
            db.close();
            if(cont>0) {
                Toast.makeText(this, "El codigo que acabas de introducir ya existe, introduce otro", Toast.LENGTH_SHORT).show();
            }else {
                UsuariosSQLiteHelper usdb = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

                db = usdb.getWritableDatabase();

                String cod = codigo.getText().toString();
                String nom = nombre.getText().toString();
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", cod);
                nuevoRegistro.put("nombre", nom);
                db.insert("Usuarios", null, nuevoRegistro);

                 Toast.makeText(this, "Usuario añadido correctamente", Toast.LENGTH_LONG).show();

                db.close();
            }
        }
    }
    public void actualizar(View view){
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();
        int cont=0;
        if(codigo.getText().toString().equals("")){
            Toast.makeText(this,"Faltan datos",Toast.LENGTH_LONG).show();

        }else {
            String codig = codigo.getText().toString();
            Cursor c = db.rawQuery("SELECT codigo,nombre FROM Usuarios WHERE codigo=" + codig,null);
            if (c.moveToFirst()) {
            cont=cont+1;
            }
            db.close();

            if (cont <=0) {
            Toast.makeText(this,"El código no existe, ",Toast.LENGTH_LONG).show();
            } else {
                UsuariosSQLiteHelper usdb = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
                db = usdb.getWritableDatabase();
                String cod = codigo.getText().toString();
                String nom = nombre.getText().toString();
                ContentValues valores = new ContentValues();
                valores.put("nombre", nom);
                db.update("Usuarios", valores, "codigo=" + cod, null);

                Toast tostada = Toast.makeText(this, "Actualización realizada correctamente", Toast.LENGTH_LONG);
                tostada.show();
                db.close();
            }
        }
    }
    public void eliminar(View view){
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();
        int cont=0;
        if(codigo.getText().toString().equals("")){
            Toast tostada= Toast.makeText(this,"Faltan datos",Toast.LENGTH_LONG);
            tostada.show();

        }else{
            String codig=codigo.getText().toString();
            Cursor c=db.rawQuery("SELECT codigo, nombre FROM Usuarios WHERE codigo="+codig,null);
            if(c.moveToFirst()){
                cont=cont+1;

            }
            db.close();
            if(cont<=0){
                Toast.makeText(this,"El código no existe",Toast.LENGTH_LONG).show();
            }else {
                UsuariosSQLiteHelper usdb = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
                db = usdb.getWritableDatabase();
                String cod = codigo.getText().toString();
                db.delete("Usuarios", "codigo=" + cod, null);

                Toast.makeText(this, "Usuario eliminado correctamente", Toast.LENGTH_LONG).show();

                db.close();
            }
        }
    }

    public void consulta(View view){
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT codigo, nombre FROM Usuarios",null);
        txtResultado.setText("");
        if(c.moveToFirst()){
            do{
                String cod=c.getString(0);
                String nom=c.getString(1);
                txtResultado.append(" " + cod + " - " + nom + "\n");
            }while(c.moveToNext());
        }
        db.close();
    }
}