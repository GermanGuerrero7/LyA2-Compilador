/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teclaguna.compilador;

import java.util.Vector;
import java.util.ArrayList;

    // Declaracion de variables
    public class TablaSimbolos {
    private Vector < Linea_TS > arrTabla = null;
    private int intInd;
    private Compilador compilador;
    
    // Constructor con parametro que recibe un objeto de la clase Compilador
    public TablaSimbolos( Compilador c ) {
        arrTabla   = new Vector < Linea_TS > ( );
        intInd     = 0;
        compilador = c;
    }
    
    // Metodo inicializar que inizializa el arreglo
    public void inicializar() {
        arrTabla = new Vector < Linea_TS > ( );
        intInd   = 0;
    }
    
    // Se inserta un valor a arrTabla
    public int insertar( Linea_TS l ) {
        int entrada;
        if ( ( entrada = buscar ( l.getLexema (), l.getAmbito () ) )  > 0  )
            return entrada;
        else {
            arrTabla.add( l );
            return intInd++;
        }
    }
    
    // Se obtiene el objeto en la posicion deseada
    public Linea_TS obt_elemento( int n ) {
        return arrTabla.get( n );
    }
    
    // Se coloca un tipo en la posicion deseada
    public void  anadeTipo( int p , String t ) {
        arrTabla.get( p ).setTipo( t );
    }
    
    // Se obtiene el tipo en la posicion deseada
    public String buscaTipo( int n ) {
        return arrTabla.get( n ).getTipo( );
    }
    
    // Se busca el tipo
    public int buscar( String lex ) {
        for( int i = 0 ; i < arrTabla.size( ) ; i++ )
            if( arrTabla.get( i ).getLexema( ).equals( lex ) )
                return i; //+ 1;
                return 0;
    }
    
    // Obtencion del tamaño del arreglo
    public int getTamaño( ) {
        return arrTabla.size( );
    }

    // Metodo para añadir ambito en posicon deseada
    public void anadeAmbito ( int p, String t ) {
        arrTabla.get( p ).setAmbito( t );
    }

    // Se obtiene el ambito de la posicion deseada
    public String buscaAmbito ( int n ) {
        return arrTabla.get( n ).getAmbito ( );
    }

    // Se busca el ambito
    public int buscar ( String lex, String amb ) {
        for( int i = 0 ; i < arrTabla.size( ) ; i++ )
            if (  arrTabla.get( i ).getLexema( ).equals( lex ) &&
                  arrTabla.get( i ).getAmbito( ).equals( amb )  )
                return i;
        return 0;
    }

    // Busca el lexema segun su posicion 
    public String buscaLexema ( int pos ) {
        return arrTabla.get ( pos ).getLexema ( );
    }

    // Devuelve una lista de todas las entradas que sean num, numnum y literal
    // para asignarles tipo
    public ArrayList sinTipo ( ) {
        ArrayList ids = new ArrayList ( );
        
        for ( int i = 0; i < arrTabla.size ( ); i++ )
            if ( arrTabla.get ( i ).getComplex ( ).equals ( "num" ) ||
                 arrTabla.get ( i ).getComplex ( ).equals ( "numnum" ) ||
                 arrTabla.get ( i ).getComplex ( ).equals ( "literal" ) )
                ids.add ( i ); 

        return ids;
    }

}
