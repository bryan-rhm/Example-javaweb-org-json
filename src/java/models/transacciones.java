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
public class transacciones {
    private persona cliente;
    private int idPelicula=-1;
    private sala sala;
    public transacciones (persona cliente,sala sala){
        this.cliente = cliente;
        this.sala =sala;
    }
    public void setSala(sala sala){
        this.sala = sala;
    }
    public void asignarPelicula(pelicula pelicula){
        cliente.setPelicula(pelicula);
    }
    public boolean asignarAsientos(int fila,int columna){
        if (validar() && sala.getAsientos().get(idPelicula)[fila][columna].setEstado(1)){
           // sala.getAsientos().get(idPelicula)[fila][columna].setEstado(1);
            asiento Asiento = sala.getAsientos().get(idPelicula)[fila][columna];
            cliente.setAsientos(Asiento);
            return true;
        }else{
            return false;
        }
    }
    public int getIdPelicula(){
        return idPelicula;
    }
    public void setIdPelicula(int id){
        idPelicula = id;
    }
    public boolean validar (){
        return (idPelicula>-1)?true:false;
    }
    public  asiento [][] getAsientos(){
        return sala.getAsientos().get(idPelicula);
    }
    public boolean procesarCompra(){
        return (!cliente.getAsientos().isEmpty())?true:false;
    }
    public int getTotal(){
        return sala.getPrecio()* cliente.getAsientos().size();
    }
    public pelicula getPelicula(){
        return cliente.getPelicula();
    }
    public  ArrayList<asiento> getAsientosAsignados(){
        return cliente.getAsientos();
    }
}
