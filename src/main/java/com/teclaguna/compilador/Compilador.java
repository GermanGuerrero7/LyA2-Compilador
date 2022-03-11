/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.teclaguna.compilador;

/**
 *
 * @author keyge
 */
public class Compilador {

    // Constantes
//    public final static int ERR_LEXICO = 1;
//    public final static int ERR_SINTACTICO = 2;
//    public final static int ERR_SEMANTICO = 3;
//    public final static int WARNING_SEMANTICO = 4;

    // Objetos clave del compilador
    Lexico lexico = new Lexico(this);
//    SintacticoSemantico ss = new SintacticoSemantico(this);
    BufferEntrada be = new BufferEntrada(this);
    TablaSimbolos ts = new TablaSimbolos(this);
//    ManejadorErrores me = new ManejadorErrores(this);
//    ErroresListener erroresListener = null;

    // Constructor predeterminado
    public Compilador() {
    }
    
    // Constructor con inicializacion de objeto para escuchar errores
//    public Compilador(ErroresListener errList) {
//        erroresListener = errList;
//    }
    
    // Metodo para el analisis lexico 
    public void analizarLexico(String codigoFuente) {
//        me.inicializar();
        be.inicializar();
        ts.inicializar();
        lexico.Inicia();
        lexico.Analiza(codigoFuente);
    }
    
    // Metodo para el analisis sintactico (false porque no hay semantico) 
//    public void analizarSintaxis() {
//        me.inicializar();
//        be.restablecer();             
//        ss.analizar(false);          
//    }
    
    // Metodo para el analisis sintactico/semantico (true porque si hay semantico) 
//    public void analizarSemantica() {
//        me.inicializar();
//        be.restablecer();             
//        ss.analizar(true);           
//    }
    
    // Metodo para obtener el total de todos los tipos de errores
//    public int getTotalErrores(int tipoError) {
//        int totalErrores = 0;
//        switch (tipoError) {
//            case Compilador.ERR_LEXICO:
//                totalErrores = me.getTotalErroresLexico();
//                break;
//            case Compilador.ERR_SINTACTICO:
//                totalErrores = me.getTotalErroresSintacticos();
//                break;
//            case Compilador.ERR_SEMANTICO:
//                totalErrores = me.getTotalErroresSemanticos();
//                break;
//            case Compilador.WARNING_SEMANTICO:
//                totalErrores = me.getTotalWarningsSemantico();
//        }
//        return totalErrores;
//    }
    
//    public void agregErroresListener(ErroresListener listener) {
//        erroresListener = listener;
//    }
    
    // Se crea un arreglo con todos los elementos del buffer de entrada
    public Linea_BE[] getBufferEntrada() {
        int tam = be.getTamaño();
        Linea_BE[] buffer = new Linea_BE[tam];

        for (int i = 0; i < tam; i++) {
            buffer[i] = be.obtElemento(i);
        }
        
        return buffer;
    }

   
}
