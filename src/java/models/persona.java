package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;


/**
 *
 * @author admin
 */
public class persona {
    private String email;
    private String nombre;
    private int edad;
    private pelicula pelicula;
    private ArrayList<asiento> asientos= new ArrayList();
    public persona(String nombre){
        this.nombre=nombre;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(asiento asiento) {
        this.asientos.add(asiento);
    }
    public void setPelicula(pelicula pelicula){
        this.pelicula = pelicula;
    }
    public pelicula getPelicula(){
        return pelicula;
    }
    
    
}
