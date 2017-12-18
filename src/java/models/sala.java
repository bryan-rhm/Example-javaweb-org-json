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
public class sala {

    private ArrayList<pelicula> peliculas = new ArrayList();
    private ArrayList<String> horarios = new ArrayList();
    private ArrayList<asiento[][]> asientos = new ArrayList();
    private asiento[][] asientostemp;
    private int filas;
    private int columnas;
    private int precio;

    //public asiento [][] asientos;
    public sala(ArrayList<pelicula> peliculas, int filas, int columnas, int precio) {
        this.peliculas = peliculas;
        this.filas = filas;
        this.columnas = columnas;
        this.precio = precio;

        //creando los horarios y asientos 
        int index = 12;
        int index2 = 0;
        for (pelicula p : peliculas) {
            horarios.add(index + ":00");
            index++;
            asiento[][] asientostemp = new asiento[filas][columnas];
            //creando los asientos
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    asientostemp[i][j] = new asiento(filas + "" + columnas);
                }
            }
            //creando clones del primer assiento
            asientos.add(asientostemp);
        }
    }

    public ArrayList<pelicula> getPeliculas() {
        return peliculas;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public ArrayList<asiento[][]> getAsientos() {
        return asientos;
    }

    public int getPrecio(){
        return precio;
    }
}
