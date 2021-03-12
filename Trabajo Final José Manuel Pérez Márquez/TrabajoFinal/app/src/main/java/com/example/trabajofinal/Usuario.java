package com.example.trabajofinal;

import android.widget.RadioButton;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellidos;
    private int telefono;
    private String email;
    private String direccion;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellidos, int telefono,String email,String direccion,String fechaNacimiento){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.telefono=telefono;
        this.email=email;
        this.direccion=direccion;
        this.fechaNacimiento=fechaNacimiento;
    }


    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public String getApellidos(){return apellidos;}
    public void setApellidos(String apellidos){this.apellidos=apellidos;}

    public int getTelefono(){return telefono;}
    public void setTelefono(int telefono){this.telefono=telefono;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion){this.direccion=direccion;}

    public String getFechaNacimiento(){return fechaNacimiento;}
    public void setFechaNacimiento(String fechaNacimiento){this.fechaNacimiento=fechaNacimiento;}



}
