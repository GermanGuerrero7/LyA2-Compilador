/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teclaguna.compilador;

/**
 *
 * @author keyge
 */
public class Linea_TS 
{
        // Declaracion de variables
        private String tipo;
        private String lexema;
        private String ambito;
        private String complex;

        // Getter y Setter de complex
        public void setComplex ( String Complex ){
            complex = Complex;
        }
        
        public String getComplex (){
            return complex;
        }
        
        // Getter y Setter de lexema
         public void setLExema ( String Lexema ){
            lexema = Lexema;
        }
        
        public String getLexema (){
            return lexema;
        }
        
        // Getter y Setter de tipo
         public void setTipo ( String Tipo ){
            tipo = Tipo;
        }
        
        public String getTipo (){
            return tipo;
        }
       
        // Getter y Setter de ambito
        public void setAmbito ( String Ambito ){
            ambito = Ambito;
        }
        
        public String getAmbito (){
            return ambito;
        }
        
       //Constructores predeterminado
        public Linea_TS()
        {
            complex = "";
            lexema  = "";
            tipo    = "";
            ambito  = "";
        }

        // Constructor utilizando un objeto similar como base 
        public Linea_TS(Linea_TS T)
        {
            this.complex = T.complex;
            this.lexema  = T.lexema;
            this.tipo    = T.tipo;
            this.ambito  = T.ambito;
        }
        
        // Constructor con asignacion de todas las variables
        public Linea_TS( String _complex, String _lexema, String _tipo, String _ambito)
        {
            complex = _complex;
            lexema  = _lexema;
            tipo    = _tipo;
            ambito  = _ambito;
        }

}
