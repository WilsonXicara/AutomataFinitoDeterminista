/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatafd;

import Clases.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilson Xicará
 */
public class AutomataFD {

    /**
     * @param args the command line arguments
     */
    /**public static void main(String[] args) {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
        comparacionDeAutomatas(teclado);
//        compararAutomatas(new Automata(), new Automata());
    }**/
    
    public static void main(String[] args) {
        //try {
            InputStreamReader entrada = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader(entrada);
            
        /**    System.out.print("Ingrese el Nombre del Automata Finito Determinista = "); String nombreAutomata = teclado.readLine();
            String[] alfabeto = {"0", "1"};
            int cantidadEstados;
            System.out.print("Cantidad de Estados = ");  cantidadEstados = Integer.parseInt(teclado.readLine());
            Automata A = new Automata(alfabeto, cantidadEstados);
            A.definirTransiciones(teclado);
            new Graficos(nombreAutomata, A);
            A = A.minimizar();
            new Graficos("Minimizado", A);
            String cadena, continuar = "s";
            while (continuar.equals("n") == false) {
                System.out.print("Cadena a probar = ");  cadena = teclado.readLine();
                boolean aceptado = A.probarCadena(cadena);
                if (aceptado == true)
                    System.out.println("La cadena pertenece al Lenguaje");
                else
                    System.out.println("La cadena NO pertenece al Lenguaje");
                System.out.print("Continuar? ");  continuar = teclado.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(AutomataFD.class.getName()).log(Level.SEVERE, null, ex);
        }**/
//        comparacionDeAutomatas(teclado);
        concatenacionNulaACadena();
    }
    public static void concatenacionNulaACadena() {
        String cadena = "Hola";
        System.out.println("Cadena original = "+cadena);
        int longitud = cadena.length();
        for(int i=0; i<(8-longitud); i++) cadena = (char)0+cadena;
        System.out.println("Cadena modificada = "+cadena);
        try {
            String finArchivo = ""+(char)0xFF+(char)0xFF;
            RandomAccessFile archivo = new RandomAccessFile("C:\\Users\\pc\\Desktop\\SistemaSeguridad_3bits", "rw");
            int cantidad = 1;
            System.out.println("Cantidad = "+cantidad);
            cantidad+= archivo.skipBytes(5);
            System.out.println("Cantidad = "+cantidad+", con skiyBytes(5)");
            System.out.println("skipBytes(10) = "+archivo.skipBytes(10));
            System.out.println("0xFFFF = '"+finArchivo+"'");
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutomataFD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutomataFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void compararAutomatas(Automata A1, Automata A2) {
/**        String[] alfabeto = {"0", "1"};
        Automata A1 = new Automata(); Automata A2 = new Automata();
        A1.setAlfabeto(alfabeto);     A2.setAlfabeto(alfabeto);
        A1.setCantidadEstados(2);
        A1.getEstados()[0].setAceptable(true);
        A1.getEstados()[0].setTransicion(0, A1.getEstados()[0]);
        A1.getEstados()[0].setTransicion(1, A1.getEstados()[1]);
        A1.getEstados()[1].setAceptable(false);
        A1.getEstados()[1].setTransicion(0, A1.getEstados()[0]);
        A1.getEstados()[1].setTransicion(1, A1.getEstados()[1]);
        A2.setCantidadEstados(3);
        A2.getEstados()[0].setAceptable(true);
        A2.getEstados()[0].setTransicion(0, A2.getEstados()[1]);
        A2.getEstados()[0].setTransicion(1, A2.getEstados()[2]);
        A2.getEstados()[1].setAceptable(true);
        A2.getEstados()[1].setTransicion(0, A2.getEstados()[1]);
        A2.getEstados()[1].setTransicion(1, A2.getEstados()[2]);
        A2.getEstados()[2].setAceptable(false);
        A2.getEstados()[2].setTransicion(0, A2.getEstados()[0]);
        A2.getEstados()[2].setTransicion(1, A2.getEstados()[2]);**/
        
        AlgoritmoMoore comparador = new AlgoritmoMoore();
        System.out.println("Los autómatas son equivalentes?: "+comparador.compararAutomatas(A1, A2));
    }
    public static void comparacionDeAutomatas(BufferedReader teclado) {
        try {
            String[] alfabeto = {"0", "1"};
            Automata[] automatas = new Automata[2];
            for(int i=0; i<2; i++) {
                automatas[i] = new Automata();
                automatas[i].setAlfabeto(alfabeto);
            }
            for (int cont=0; cont<2; cont++) {
                System.out.println("Automata "+(cont+1));
                System.out.print("Cantidad de Estados = ");  int cantidadEstados = Integer.parseInt(teclado.readLine());
                automatas[cont].setCantidadEstados(cantidadEstados);
                automatas[cont].definirTransiciones(teclado);
            }
/**            System.out.println("AUTÓMATA 1:");
            System.out.println(automatas[0].toString());
            System.out.println("AUTÓMATA 2:");
            System.out.println(automatas[1].toString());**/
                
            String cadena, continuar = "s";
            new Graficos("Original", automatas[0]);
            automatas[1] = automatas[0].minimizar();
            new Graficos("Minimizado", automatas[1]);
            while (continuar.equals("n") == false) {
                System.out.print("Automata a utlilizar: ");  int numeroAutomata = Integer.parseInt(teclado.readLine());
                System.out.print("Cadena a probar = ");  cadena = teclado.readLine();
                boolean aceptado = automatas[numeroAutomata].probarCadena(cadena);
                if (aceptado == true)
                    System.out.println("La cadena pertenece al Lenguaje");
                else
                    System.out.println("La cadena NO pertenece al Lenguaje");
                System.out.print("Continuar? ");  continuar = teclado.readLine();
            }
            compararAutomatas(automatas[0],automatas[1]);
        } catch (IOException ex) {
            Logger.getLogger(AutomataFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean compararArregloString(String[] arreglo1, String[] arreglo2) {
        return Arrays.equals(arreglo1, arreglo2);
    }
}
