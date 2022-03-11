/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teclaguna.compilador;

/**
 *
 * @author keyge
 */
import java.util.Vector;

public class BufferEntrada {

    // Declaracion de variables
    private int UltimoElemento;
    private Vector<Linea_BE> Lis_BE;
    public Linea_BE preAnalisis;
    private int Ptr;
    Compilador compilador;
    
    // Metodo para inicializar el buffer de entrada
    public void inicializar() {
        UltimoElemento = 0;
        Lis_BE.clear();
        Lis_BE.add(new Linea_BE("$", "$", 0, 999));     
        Ptr = 0;
        preAnalisis = obtElemento(Ptr);
    }
    
    // Constructor de Buffer de entrada con un parametro que recibe un objeto de la clase Compilador
    public BufferEntrada(Compilador c) {
        compilador = c;
        UltimoElemento = 0;
        Lis_BE = new Vector<Linea_BE>();
        preAnalisis = new Linea_BE();
        Ptr = 0;
    }
    
    // Método para regresar el puntero al inicio del buffer
    public void restablecer() {
        Ptr = 0;
        preAnalisis = obtElemento(Ptr);
    }
    
    // Metodo para continuar con la siguiente linea del buffer
    public void siguiente() {
        if (Ptr < Lis_BE.size() - 1) {
            Ptr += 1;
        }
        preAnalisis = obtElemento(Ptr);
    }
    
    // Metodo para retroceder el preAnalisis en una posicion.
    public void anterior() {
        if (Ptr > 0) {
            Ptr -= 1;
        }
        preAnalisis = obtElemento(Ptr);
    }
    
    // Metodo que inserta el elemento en la linea actual del buffer 
    public void insertar(Linea_BE objTL) {
        Lis_BE.add(UltimoElemento, objTL);
        UltimoElemento++;
    }
    
    // Metodo que obtiene el elemento de la posicion deseada en el buffer    
    public Linea_BE obtElemento(int intPosicion) {
        return Lis_BE.elementAt(intPosicion);
    }

    //
    
    // Obtiene la posición actual del puntero
    public int getptr() {
        return Ptr;
    }
    
    // Coloca el puntero en un índice específico
    public void setprt(int PTR) {
        Ptr = PTR;
    }

    // Metodo que reubica el puntero y preAnalisis en la posicion deseada
    public void setPrt(int pos) {
        Ptr = pos;
        preAnalisis = obtElemento(Ptr);
    }

    // Obtiene el tamaño del buffer 
    public int getTamaño() {
        return Lis_BE.size();
    }

}
