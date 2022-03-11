/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teclaguna.compilador;

/**
 *
 * @author keyge
 */
public class Linea_BE{

        //Declaracion de variables 
        protected int entrada;    
        protected int numLinea;
        protected String complex;
        protected String lexema;
        
        // Getter y Setter de complex
        public void setComplex(String Compleex){
            complex = Compleex;
        }

        public String getComplex() {
            return complex;
        }

        // Getter y Setter de lexema
        public void setLexema(String Lexemaa) {
            lexema = Lexemaa;
        }

        public String getLexema(){
            return lexema;
        }
        
        // Getter y Setter de entrada
        public void setEntrada(int Entradaa){
            entrada = Entradaa;
        }

        public int getEntrada(){
            return entrada;
        }

        // Getter y Setter de numLinea
       public void setNumLinea ( int numLinea ) {
           this.numLinea = numLinea;
       }

       public int getNumLinea () {
           return numLinea;
       }
        
        //  Constructor predeterminado
        public Linea_BE( )
        {
            complex = "";
            lexema = "";
            entrada = 0;      
            numLinea = 0;
        }

        // Constructor para asignar valores a todas las variables
        public Linea_BE(String compleX, String lexemA, int entradA, int numLineA ) {    
            complex = compleX;
            lexema = lexemA;
            entrada = entradA;
            numLinea = numLineA;
        }

        
      
}

