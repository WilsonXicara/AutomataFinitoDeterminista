/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.*;
/**
 *
 * @author jonathanmiranda
 */
public class VentanaAutomata2 implements ActionListener {
    /* Definicón de la ventana principal */
    JFrame ventana;
    
    /* Definición de Paneles Primarios */
    JPanel panel_alfabeto, panel_estados, panel_transiciones;
    /* Definición de Paneles Secundarios (Los que van dentro de un Primario) */
    JPanel panel_etiquetas_alfabeto, panel_cajas_alfabeto, panel_etiquetas_estados, panel_cajas_estados, panel_etiquetas_transiciones, panel_cajas_transiciones;
    /* Definición de etiquetas */
    JLabel[] etiquetas_estados, etiquetas_transiciones;
    JLabel titulo_alfabeto, titulo_estados, titulo_transiciones;
    /* Definición de JTextFiel */
    JTextField[] cajas_alfabeto, cajas_estados, cajas_transicion;
    /* Definición de ComboBox */
    JComboBox[] tipo_estado;
    
    /* Definición de los botones */
    JButton guardar_alfabeto_estados, guardar_transiciones;
    
    /* Definición de otras variables */
    int cantidadEstados, cantidadSimbolos;
    String mensaje_error;
    String[] alfabeto, estados;
    
    public VentanaAutomata2(int cantidadEstados, int cantidadSimbolos){
        ventana = new JFrame("Creación del Autómata");
        ventana.setLayout(null);
        
        this.cantidadEstados = cantidadEstados;
        this.cantidadSimbolos = cantidadSimbolos;
        
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
        panel_etiquetas_estados = new JPanel(new GridLayout(cantidadEstados, 1, 0, 0));
        panel_etiquetas_estados.setBounds(10, 50, 85, 20*cantidadEstados);
        JLabel[] etiqueta_estado = new JLabel[cantidadEstados];
        for(int i=0; i<cantidadEstados; i++) {
            etiqueta_estado[i] = new JLabel("Estado "+(i+1)+" = ");
            panel_etiquetas_estados.add(etiqueta_estado[i]);
        }
        panel_etiquetas_estados.setVisible(true);
        // Panel de las entradas de texto para los Estados
        panel_cajas_estados = new JPanel(new GridLayout(cantidadEstados, 1, 0, 0));
        panel_cajas_estados.setBounds(100, 50, 50, 30*cantidadEstados);
        cajas_estados = new JTextField[cantidadEstados];
        for(int i=0; i<cantidadEstados; i++) {
            cajas_estados[i] = new JTextField();
            panel_cajas_estados.add(cajas_estados[i]);
        }
        panel_cajas_estados.setVisible(true);
        
        /* Inicialización del 'panel_estados' que contendrá a los anteriores */
        titulo_estados = new JLabel("DEFINICIÓN DE LOS ESTADOS:");
        titulo_estados.setBounds(300, 10, 200, 30);
        panel_estados = new JPanel(new GridLayout(1, 2, 10, 10));
        panel_estados.setBounds(300, titulo_estados.getY()+titulo_estados.getHeight(), 170, 30*cantidadEstados);
        panel_estados.add(panel_etiquetas_estados);
        panel_estados.add(panel_cajas_estados);
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
        cajas_transicion = new JTextField[cantidadSimbolos*cantidadEstados];
        contador = 0;
        for(int i=0; i<cantidadEstados; i++) {
            tipo_estado[i] = new JComboBox();
            tipo_estado[i].addItem("No");
            tipo_estado[i].addItem("Si");
            panel_cajas_transiciones.add(tipo_estado[i]);
            for(int j=0; j<cantidadSimbolos; j++) {
                cajas_transicion[contador] = new JTextField();
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
    private boolean esAlfabetoValido() {
        for(int cont=0; cont<cantidadSimbolos; cont++) {
            String simbolo = cajas_alfabeto[cont].getText();   // Obtengo el i-esimo simbolo
            if (simbolo.length() == 0) {
                mensaje_error+="\nNo puede definir el Símbolo "+(cont+1)+" como nulo";
                return false;
            }
            else if (simbolo.length() > 1) {
                mensaje_error+="\nNo puede definir el Símbolo "+(cont+1)+" con más de un caracter";
                return false;
            }
            for(int cont2=cont+1; cont2<cantidadSimbolos; cont2++) {
                String simbolo2 = cajas_alfabeto[cont2].getText();
                if (simbolo2.equals(simbolo) == true) {
                    mensaje_error+="\nLos Símbolos "+(cont+1)+" y "+(cont2+1)+" son iguales";
                    return false;
                }
            }
        }
        return true;
    }
    private boolean sonEstadosValidos() {
        for(int cont=0; cont<cantidadEstados; cont++) {
            String estado = cajas_estados[cont].getText();
            if (estado.length() == 0) {
                mensaje_error+="\nNo puede definir el Estado "+(cont+1)+" como nulo";
                return false;
            }
            for(int cont2=cont+1; cont2<cantidadEstados; cont2++) {
                String estado2 = cajas_estados[cont2].getText();
                if (estado2.equals(estado) == true) {
                    mensaje_error+="\nLos Estados "+(cont+1)+" y "+(cont2+1)+"son iguales";
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando se quiere guardar el alfabeto: inicio la commprobación del mismo
        if (e.getSource() == guardar_alfabeto_estados) {
            mensaje_error = "Error.\n";
            boolean alfabetoValido = esAlfabetoValido();
            boolean estadosValidos = sonEstadosValidos();
            if (alfabetoValido == false || estadosValidos == false) {
                JOptionPane.showMessageDialog(ventana, mensaje_error, "Error en Alfabeto o Estadeos", JOptionPane.ERROR_MESSAGE, null);
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
            }
        }
        
    }
}
