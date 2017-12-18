package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author admin
 */
public class asiento {
    private String id;
    private int estado;
    //Estado 0 libre, 1 reservado, 2 comprado
    asiento(String id){
        this.id =id;
        estado= 0;
    }

    public boolean validar(){
        return (estado==0)?true:false;
    }
    public boolean setEstado(int estado){
        if (validar()){
           this.estado=estado;  
           return true;
        }else{
            return false;
        }
       
    }
    public int getEstado(){
        return estado;
    }
    public String getId(){
        return id;
    }
}
