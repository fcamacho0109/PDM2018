package com.example.fcamacho.tarea1;

/**
 * Created by fcamacho on 2/1/18.
 */

public class Alumno {
    public String Nombre = "";
    public String Tel = "";
    public String Educacion = "";
    public String Libro = "";
    public boolean Hombre = false;
    public boolean Check = false;

    public void setNombre(String nom) {
        this.Nombre = nom;
    }
    public void setTelefono(String tel) {
        this.Tel = tel;
    }
    public void setEducacion(String edu) {
        this.Educacion = edu;
    }
    public void setLibro(String lib) {
        this.Libro = lib;
    }
    public void setHombre(boolean h) {
        this.Hombre = h;
    }
    public void setCheckBox(boolean c) {
        this.Check = c;
    }
    public String ToString (){
        String choosen_options = "";
        choosen_options =   "Nombre: "+Nombre+"\n"+
                            "Telefono: "+Tel+"\n"+
                            "Escolaridad: "+Educacion+"\n"+
                            "Genero: "+(Hombre?"Hombre":"Mujer")+"\n"+
                            "Libro favorito: "+Libro+"\n"+
                            "Practica deporte: "+(Check?"Si":"No");
        return choosen_options;
    }
}
