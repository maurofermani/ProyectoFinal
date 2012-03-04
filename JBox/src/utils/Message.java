/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public class Message implements Serializable{
    private int contador;
    private String texto;
    
    public Message(int contador, String texto){
        this.contador=contador;
        this.texto=texto;
    }
    
    public int getContador(){
        return this.contador;
    }
    
    public String getTexto(){
        return this.texto;
    }
    
    void setContador (int contador){
        this.contador = contador;
    }
    
    void setText(String texto){
        this.texto=texto;
    }
    
   
    public String toString(){
        return this.contador+": "+this.texto;
    }
    
}
