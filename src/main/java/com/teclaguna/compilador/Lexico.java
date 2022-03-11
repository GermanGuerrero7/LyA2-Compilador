/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teclaguna.compilador;

/**
 *
 * @author keyge
 */
public class Lexico {
   // Declaracion de constantes
   final int MAXTOKENS = 500;
   final int TOKREC = 17;
   
   // Delcaracion de variables
   private String[] _lexemas;
   private String[] _tokens;
   private int   [] _noLineas;   
   private String _lexema;
   private int _noTokens;
   private int _i;
   private int _iniToken;
   private Automata oAFD;
   private Compilador cmp;
   private int _noLinea;       
   
   // Constructor predeterminado
   public Lexico ( Compilador cmp ) {
     this.cmp = cmp;   
     _lexemas = new String[MAXTOKENS];
     _tokens = new String[MAXTOKENS];
     _noLineas = new int [MAXTOKENS];
     oAFD = new Automata();
     _i = 0;
     _iniToken = 0;
     _noTokens = 0;
   }

   // Getter y Setter de _i 
   public int getI() {
       return _i;
   } 
   
   public void setI(int valor) {
       _i=valor;
   }

   // Getter y Setter de _noLinea
   public void setNoLinea ( int valor ) { 
       _noLinea = valor;
   }
  
   public int getNoLinea () {
       return _noLinea;
   }
 
   // Getter de _iniToken
   public int getIniToken() {
       return _iniToken;
   }
   
   // Getter de _tokens
   public String[] Tokens() {
       return _tokens;
   }

   // Getter de _lexemas 
   public String[] Lexemas() {
       return _lexemas;
   }
   
   // Getter de _noTokens
   public int NOTOKENS() {
       return _noTokens;
   }
   
   // Se inicializan las variables en 0
   public void Inicia() {
     _i = 0;
     _iniToken = 0;
     _noTokens = 0;
     _noLinea  = 1;                      
     _lexemas = new String[MAXTOKENS];
     _tokens = new String[MAXTOKENS];
     _noLineas = new int [MAXTOKENS];   
   }
   
   // Método de asignacion del token con su lexema
   public void Analiza(String texto) {
     Boolean recAuto;
     int noAuto;
     while (_i < texto.length()) 
     {
       recAuto=false;
       noAuto=0;
       for(;noAuto<TOKREC&&!recAuto;)
         if(oAFD.Reconoce(texto,this,noAuto))
           recAuto=true;
         else
           noAuto++;
       if (recAuto)
       {
         _lexema = texto.substring(_iniToken, _i);
         switch (noAuto)
         {     
           //                    Automata  Delimita 
          case 0 : 
                        break;
           //                    Automata  Opmult
          case 1 : _tokens[_noTokens] = "opmult";
                        break;
           //                   Automata  Opsuma
          case 2 : _tokens[_noTokens] = "opsuma";
                        break;
           //                   Automata  Identi
          case 3 : _tokens[_noTokens] = "id";
              break;
           //                   Automata  Literal 
          case 4 : _tokens[_noTokens] = "literal";
                        break;
           //                   Automata  Signo
          case 5 : _tokens[_noTokens] = "signo";
                        break;
           //                   Automata  Opasig
          case 6 : _tokens[_noTokens] = "opasig";
                        break;
           //                   Automata  Reales1
          case 7 : _tokens[_noTokens] = "num.num";
                        break;
           //                   Automata  Reales2
          case 8 : _tokens[_noTokens] = "num.num";
                        break;
           //                   Automata  Reales3
          case 9 : _tokens[_noTokens] = "num.num";
                        break;
           //                   Automata  Enteros
          case 10 : _tokens[_noTokens] = "num";
                        break;
           //                   Automata  Oprel
          case 11 : _tokens[_noTokens] = "oprel";
                        break;
           //                   Automata  Oprel2
          case 12 : _tokens[_noTokens] = "oprel";
                        break;
           //                   Automata  ASignacion
          case 13 : _tokens[_noTokens] = "opasig";
                        break;
           //                   Automata  Punto
          case 14 : _tokens[_noTokens] = "punto";
                        break;
           //                   Automata  CarEsp
          case 15 : 
                    _tokens[_noTokens] = "caresp";
                        break;
           //                   Automata  Caracter
          case 16 : _tokens[_noTokens] = "caracter";
                        break;
         }
         if(noAuto != 0) {
             _lexemas  [_noTokens  ] = _lexema;
             _noLineas [_noTokens++] = _noLinea;   
         }
       }
       else
         _i++;
       
       _iniToken = _i;
     }

     pasarBufferTabla ();
   }  
   
    // Toma los tokens y los pasa a la tabla de simbolos y buffer de entrada
    private void pasarBufferTabla() {
        
        // Comenzamos con establecer la entrada, la linea y una bandera para
        // palabras reservadas
        int entrada = 0;
        Linea_BE lineaBE = null;
        Linea_TS lineaTS = null;

        Boolean noPalres = true;

        // Tabla de simbolos, linea reservada
        lineaTS = new Linea_TS("", "", "", "");
        entrada = cmp.ts.insertar(lineaTS);
        lineaTS = null;

        // Se comparan todos los tokens obtenidos 
        for (int i = 0; i < _noTokens; i++) {
            
            // Se verifica que el ID no sea palabra reservada
            if (_tokens[i].equals("id")) {
                if (EsPalabraReservada(_lexemas[i])) {
                    lineaBE = new Linea_BE(
                            _lexemas[i], _lexemas[i], 0, _noLineas[i]);
                } else {
                    lineaTS = new Linea_TS(
                            _tokens[i], _lexemas[i], "", "");
                    entrada = cmp.ts.insertar(lineaTS);
                    lineaBE = new Linea_BE(
                            _tokens[i], _lexemas[i], entrada, _noLineas[i]);
                }

            } // Variables que se dejan pasar
            else if (_tokens[i].equals("num")
                    || _tokens[i].equals("num.num")
                    || _tokens[i].equals("literal")
                    || _tokens[i].equals("caracter")) {
                lineaTS = new Linea_TS(
                        _tokens[i], _lexemas[i], "", "");
                entrada = cmp.ts.insertar(lineaTS);
                lineaBE = new Linea_BE(
                        _tokens[i], _lexemas[i], entrada, _noLineas[i]);
                
            } // Los siguientes no se insertan en tabla simbolos
            else if (_tokens[i].equals("opmult")
                    || _tokens[i].equals("opsuma")
                    || _tokens[i].equals("signo")
                    || _tokens[i].equals("opdif")
                    || _tokens[i].equals("opasig")
                    || _tokens[i].equals("oprel")) {
                lineaBE = new Linea_BE(
                        _tokens[i], _lexemas[i], 0, _noLineas[i]);
            } else if (_tokens[i].equals("caresp")
                    || _tokens[i].equals("punto")) {
                lineaBE = new Linea_BE(
                        _lexemas[i], _lexemas[i], 0, _noLineas[i]);
            }

            // Verificar que la línea no está vacía para agregar a la tabla
            if (lineaBE != null) {
                cmp.be.insertar(lineaBE);
            }

            // Limpiar lineas
            lineaBE = null;
            lineaTS = null;
        }

    }
   
   private Boolean EsPalabraReservada(String lex) {      
       String palres[] = {
               "public", "class", "static", "int",
               "float", "string", "void",
               "main", "args", "if", "else",
               "while", "literal", "return", "pow", "sqrt"
                         };
       
       for (int i = 0; i < palres.length; i++) {
           if (lex.equals ( palres[i] ) )     
               return true;
       }
       return false;
   }
   
}
