/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Clases.Automata;
import Clases.Estado;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.*;
/**
 *
 * @author jonathanmiranda
 */
public class VentanaAutomata implements ActionListener {
    /*Los utilizo para poder verificar que estado es inicial*/
    JRadioButton[] etiqueta_estado_inicial;
    int estado_inicial;
    
    private ActionListener identificar_estado_inicial = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int a =0;
            boolean encontrado = false;
            while(encontrado !=true){
                if(ae.getSource() == etiqueta_estado_inicial[a]){
                    encontrado =true;
                }
                else a++;
            }
            etiqueta_estado_inicial[estado_inicial].setSelected(false);
          estado_inicial = a;   
       }
    };
    
    /*Automata que se crea*/
    Automata nuevo;
    /* Definicón de la ventana principal */
    JDialog ventana;
    
    /* Definición de Paneles Primarios */
    JPanel panel_alfabeto, panel_estados, panel_transiciones;
    /* Definición de Paneles Secundarios (Los que van dentro de un Primario) */
    JPanel panel_etiquetas_alfabeto, panel_cajas_alfabeto, panel_etiquetas_estados, panel_cajas_estados, panel_etiquetas_transiciones, panel_cajas_transiciones;
    /*Panel para comprobar estado inicial*/
    JPanel panel_estado_inicial;
    /* Definición de etiquetas */
    JLabel[] etiquetas_estados, etiquetas_transiciones;
    JLabel titulo_alfabeto, titulo_estados, titulo_transiciones;
    /* Definición de JTextFiel */
    JTextField[] cajas_alfabeto, cajas_estados;
    /* Definición de ComboBox */
    JComboBox[] tipo_estado,cajas_transicion;
    
    /* Definición de los botones */
    JButton guardar_alfabeto_estados, guardar_transiciones;
    
    /* Definición de otras variables */
    int cantidadEstados, cantidadSimbolos;
    String[] alfabeto, estados;
    
    public VentanaAutomata(int cantidadEstados, int cantidadSimbolos){
        ventana = new JDialog();
        ventana.setModal(true);
        ventana.setLayout(null);
        estado_inicial =0;   
        this.cantidadEstados = cantidadEstados;
        this.cantidadSimbolos = cantidadSimbolos;
        nuevo = new Automata();
        
        creacion_espacio_alfabeto_estados();
        
/*        panel_etiquetas_transiciones.setBounds(posX, posY, ancho, alto); */
        /* Inicialización de los botones */
        // Botón para comprobar la validez del alfabeto
        guardar_alfabeto_estados = new JButton("Verificar");
        guardar_alfabeto_estados.addActionListener(this);
        guardar_alfabeto_estados.setBounds(75, panel_alfabeto.getY()+panel_alfabeto.getHeight(), 100, 30);
        ventana.add(guardar_alfabeto_estados);
        
        
        ventana.setLocation(100,50);
        //vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.setSize(ancho, alto);
        ventana.setSize(1000, panel_alfabeto.getHeight()+200);
        ventana.setResizable(false);
        ventana.setVisible(true);
        
    }
    private void creacion_espacio_alfabeto_estados() {
        /* Inicialización de los paneles secundarios que se agregarán al 'panel_alfabeto' */
        // Panel de las etiquetas "Simbolo {i} = ":
        panel_etiquetas_alfabeto = new JPanel(new GridLayout(cantidadSimbolos, 1, 0, 0));
        panel_etiquetas_alfabeto.setBounds(10, 50, 85, 20*cantidadSimbolos);
        JLabel[] etiquetas_alfabeto = new JLabel[cantidadSimbolos];
        for(int i=0; i<cantidadSimbolos; i++) {
            etiquetas_alfabeto[i] = new JLabel("Símbolo "+(i+1)+" = ");
            panel_etiquetas_alfabeto.add(etiquetas_alfabeto[i]);
        }
        panel_etiquetas_alfabeto.setVisible(true);
        // Panel de las entradas de texto para los Símbolos
        panel_cajas_alfabeto = new JPanel(new GridLayout(cantidadSimbolos, 1, 0, 0));
        panel_cajas_alfabeto.setBounds(100, 50, 50, 30*cantidadSimbolos);
        cajas_alfabeto = new JTextField[cantidadSimbolos];
        for(int i=0; i<cantidadSimbolos; i++) {
            cajas_alfabeto[i] = new JTextField();
            panel_cajas_alfabeto.add(cajas_alfabeto[i]);
        }
        panel_cajas_alfabeto.setVisible(true);
        
        /* Inicialización del 'panel_alfabeto' que contendrá a los anteriores */
        titulo_alfabeto = new JLabel("DEFINICIÓN DEL ALFABETO:");
        titulo_alfabeto.setBounds(50, 50, 200, 30);
        panel_alfabeto = new JPanel(new GridLayout(1, 2, 10, 10));
        panel_alfabeto.setBounds(50, titulo_alfabeto.getY()+titulo_alfabeto.getHeight(), 170, 30*cantidadSimbolos);
        panel_alfabeto.add(panel_etiquetas_alfabeto);
        panel_alfabeto.add(panel_cajas_alfabeto);
        panel_alfabeto.setVisible(true);
        
        ventana.add(titulo_alfabeto);
        ventana.add(panel_alfabeto);
        
        /* Inicialización de los paneles secundarios que se agregarán al 'panel_estados' */
        // Panel de las etiquetas "Simbolo {i} = ":
        panel_estado_inicial = new JPanel(new GridLayout(cantidadEstados,1));
        etiqueta_estado_inicial = new JRadioButton[cantidadEstados];
        panel_etiquetas_estados = new JPanel(new GridLayout(cantidadEstados, 1, 0, 0));
        panel_etiquetas_estados.setBounds(10, 50, 85, 20*cantidadEstados);
        JLabel[] etiqueta_estado = new JLabel[cantidadEstados];
        for(int i=0; i<cantidadEstados; i++) {
            etiqueta_estado[i] = new JLabel("Estado "+(i+1)+" = ");
            panel_etiquetas_estados.add(etiqueta_estado[i]);
            if(i == 0) etiqueta_estado_inicial[i] = new JRadioButton("EI", true);
            else  etiqueta_estado_inicial[i] = new JRadioButton("EI", false);
            
            etiqueta_estado_inicial[i].addActionListener(identificar_estado_inicial);
            
            panel_estado_inicial.add(etiqueta_estado_inicial[i]);
        }
        panel_etiquetas_estados.setVisible(true);
        // Panel de las entradas de texto para los Estados
        panel_cajas_estados = new JPanel(new GridLayout(cantidadEstados, 1, 0, 0));
        panel_cajas_estados.setBounds(100, 50, 50, 30*cantidadEstados);
        cajas_estados = new JTextField[cantidadEstados];
        for(int i=0; i<cantidadEstados; i++) {
            cajas_estados[i] = new JTextField(3);
            panel_cajas_estados.add(cajas_estados[i]);
        }
        panel_cajas_estados.setVisible(true);
        
        /* Inicialización del 'panel_estados' que contendrá a los anteriores */
        titulo_estados = new JLabel("DEFINICIÓN DE LOS ESTADOS:");
        titulo_estados.setBounds(300, 10, 200, 30);
        panel_estados = new JPanel(new GridLayout(1, 3, 10, 10));
        panel_estados.setBounds(300, titulo_estados.getY()+titulo_estados.getHeight(), 220, 30*cantidadEstados);
        panel_estados.add(panel_etiquetas_estados);
        panel_estados.add(panel_cajas_estados);
        panel_estados.add(panel_estado_inicial);
        panel_estados.setVisible(true);
        
        ventana.add(titulo_estados);
        ventana.add(panel_estados);
    }
    private void creacion_espacio_transiciones() {
        /* Inicialización de los paneles secundarios que se agregarán al 'panel_transiciones' */
        // Panel de etiquetas para los estados:
        int cantidad_etiquetas = (cantidadSimbolos + 1)*cantidadEstados;
        int contador = 0;
        panel_etiquetas_transiciones = new JPanel(new GridLayout(cantidad_etiquetas, 1, 0, 0));
        etiquetas_transiciones = new JLabel[cantidad_etiquetas];
        for(int i=0; i<cantidadEstados; i++) {
            etiquetas_transiciones[contador] = new JLabel("El estado '"+estados[i]+"' es final?");
            panel_etiquetas_transiciones.add(etiquetas_transiciones[contador]);
            contador++;
            for(int j=0; j<cantidadSimbolos; j++) {
                etiquetas_transiciones[contador] = new JLabel("("+estados[i]+","+alfabeto[j]+") =");
                panel_etiquetas_transiciones.add(etiquetas_transiciones[contador]);
                contador++;
            }
        }
        panel_etiquetas_transiciones.setVisible(true);
        // Panel de entradas de información de los estados (tipo y transiciones):
        panel_cajas_transiciones = new JPanel(new GridLayout(cantidad_etiquetas, 1, 0, 0));
        tipo_estado = new JComboBox[cantidadEstados];
        cajas_transicion = new JComboBox[cantidadSimbolos*cantidadEstados];
        contador = 0;
        for(int i=0; i<cantidadEstados; i++) {
            tipo_estado[i] = new JComboBox();
            tipo_estado[i].addItem("No");
            tipo_estado[i].addItem("Si");
            panel_cajas_transiciones.add(tipo_estado[i]);
            for(int j=0; j<cantidadSimbolos; j++) {
                cajas_transicion[contador] = new JComboBox();
                for (int k = 0; k < cantidadEstados; k++) {
                    cajas_transicion[contador].addItem(cajas_estados[k].getText());
                }
                panel_cajas_transiciones.add(cajas_transicion[contador]);
                contador++;
            }
        }
        panel_cajas_transiciones.setVisible(true);
        
        /* Inicialización del 'panel_transiciones' que contendrá a los anteriores */
        titulo_transiciones = new JLabel("DEFINICIÓN DE LAS TRANSICIONES:");
        titulo_transiciones.setBounds(500, 10, 200, 30);
        titulo_transiciones.setVisible(false);
        panel_transiciones = new JPanel(new GridLayout(1, 2, 10, 10));
        panel_transiciones.setBounds(500, titulo_transiciones.getY()+titulo_transiciones.getHeight(), 250, 500);
        panel_transiciones.add(panel_etiquetas_transiciones);
        panel_transiciones.add(panel_cajas_transiciones);
        panel_transiciones.setVisible(false);
        
        ventana.add(titulo_transiciones);
    }
    private boolean esAlfabetoValido(String mensaje) {
        for(int cont=0; cont<cantidadSimbolos; cont++) {
            String simbolo = cajas_alfabeto[cont].getText();   // Obtengo el i-esimo simbolo
            if (simbolo.length() == 0) {
                mensaje+="\nNo puede definir el Símbolo "+(cont+1)+" como nulo";
                return false;
            }
            else if (simbolo.length() > 1) {
                mensaje+="\nNo puede definir el Símbolo "+(cont+1)+" con más de un caracter";
                return false;
            }
            for(int cont2=cont+1; cont2<cantidadSimbolos; cont2++) {
                String simbolo2 = cajas_alfabeto[cont2].getText();
                if (simbolo2.equals(simbolo) == true) {
                    mensaje+="\nLos Símbolos "+(cont+1)+" y "+(cont2+1)+" son iguales";
                    return false;
                }
            }
        }
        return true;
    }
    private boolean sonEstadosValidos(String mensaje) {
        for(int cont=0; cont<cantidadEstados; cont++) {
            String estado = cajas_estados[cont].getText();
            if (estado.length() == 0) {
                mensaje+="\n";
                return false;
            }
            for(int cont2=cont+1; cont2<cantidadEstados; cont2++) {
                String estado2 = cajas_estados[cont2].getText();
                if (estado2.equals(estado) == true)
                    return false;
            }
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando se quiere guardar el alfabeto: inicio la commprobación del mismo
        if (e.getSource() == guardar_alfabeto_estados) {
            String mensaje = "Error.";
            boolean alfabetoValido = esAlfabetoValido(mensaje);
            boolean estadosValidos = sonEstadosValidos(mensaje);
            if (alfabetoValido == false || estadosValidos == false) {
                JOptionPane.showMessageDialog(ventana, mensaje, "Error en Alfabeto o Estadeos", JOptionPane.ERROR_MESSAGE, null);
            }
            else {
                JOptionPane.showMessageDialog(ventana, "Alfabeto y Estados correctos", "Alfabeto y Estados guardado", JOptionPane.INFORMATION_MESSAGE, null);
                // Inicio el guardado de los Símbolos del Alfabeto:
                alfabeto = new String[cantidadSimbolos];
                for(int cont=0; cont<cantidadSimbolos; cont++)
                    alfabeto[cont] = cajas_alfabeto[cont].getText();
                // Inicio el guardado de los Nombres de los Estados:
                estados = new String[cantidadEstados];
                for(int cont=0; cont<cantidadEstados; cont++)
                    estados[cont] = cajas_estados[cont].getText();
                
                creacion_espacio_transiciones();
                // Botón para comprobar la validez del Autómata
                guardar_transiciones = new JButton("Guardar");
                guardar_transiciones.addActionListener(this);
                guardar_transiciones.setBounds(350, panel_transiciones.getY()+panel_transiciones.getHeight(), 100, 30);
                guardar_transiciones.setVisible(true);
                ventana.add(guardar_transiciones);
                ventana.add(panel_transiciones);
                ventana.setSize(1000, panel_transiciones.getHeight()+150);
                
                // Ocultación de los componentes
                titulo_alfabeto.setVisible(false);
                panel_alfabeto.setVisible(false);
                titulo_estados.setVisible(false);
                panel_estados.setVisible(false);
                titulo_transiciones.setVisible(true);
                panel_transiciones.setVisible(true);
                guardar_alfabeto_estados.setVisible(false);
                
                guardar_transiciones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                          Guardar_Automata();
                    }
                });
            }
        }
        
    }
    
    private void Guardar_Automata(){
        /*Construir el alfabeto*/
        String[] Alfabeto = new String[cajas_alfabeto.length];
        for (int i = 0; i < alfabeto.length; i++) {
            Alfabeto[i] = cajas_alfabeto[i].getText();
        }
        
        /*Creo el arreglo de Estados*/
        Estado[] Estados = new Estado[cajas_estados.length];
        int c=1;
        int b=0;
        for (int i = 0; i < Estados.length; i++) {
            Estado nuevo = new Estado(Alfabeto.length);
            String tipo = (String)(tipo_estado[i].getSelectedItem());
            nuevo.setSimbolo(cajas_estados[i].getText());
                if(tipo.equals("Si")==true){
                    nuevo.setAceptable(true);
                }
                else nuevo.setAceptable(false);
            if(i != estado_inicial){
               Estados[i] = nuevo;                
               c++;
            }
            else{
                Estados[0]= nuevo;
                b=i;
            }
        }
        
        /*Conecto las transiciones*/
        int N_caja_transicion =0;
        for (int i = 0; i < Estados.length; i++) {
           
            for (int j = 0; j < Alfabeto.length; j++) {
                int N_estado = 0;
                String transicion = (String)cajas_transicion[N_caja_transicion].getSelectedItem();
                transicion.replaceAll(" ", "");
                boolean encontrado = false;
                while(encontrado!=true){
                    if(transicion.equals(Estados[N_estado].getSimbolo())== true){
                        if(b!=0){
                            if(i==0){
                                Estados[b].setTransicion(j, Estados[N_estado]);
                            }
                            else{
                                Estados[i].setTransicion(j, Estados[N_estado]);
                            }
                        
                        }
                        else Estados[i].setTransicion(j, Estados[N_estado]);
                        
                        encontrado = true;
                    }
                    else{
                        N_estado++;
                    }
                }
                N_caja_transicion++;
            }
        }
        
        /*Si el inicial no esta en la posicion 0 lo reacomodo*/
        
        nuevo = new Automata(Alfabeto, Estados.length);
        
        nuevo.setEstados(Estados);
        ventana.dispose();
    } 

    public Automata getNuevo() {
        return nuevo;
    }
    
}
