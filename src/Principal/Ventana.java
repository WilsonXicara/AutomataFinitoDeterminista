/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author pc
 */
public class Ventana extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel[] etiquetas;
    private JTextField[] entradas;
    private JTextField entrada;
    private JTextArea salida;

    public Ventana(int cantidadEstados, int cantidadSimbolos){
        //Establecemos las propiedades de nuestro Frame
        super("Nuevo Autómata");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(400, 70, 500, 370);
//        this.setResizable(false);
        //Creamos un panel para agregar todos nuestros objetos
        JPanel todo=(JPanel)this.getContentPane();
        todo.setLayout(new GridLayout(3,5));
        // Para cada estado se deben definir las 'cantidadSimbolos' de transiciones, y también su tipo (aceptable o no aceptable)
        int cantidadEntradas = (cantidadSimbolos + 1)*cantidadEstados;
        JPanel[] cabecera = new JPanel[5];
        for(int i=0; i<5; i++) {cabecera[i] = new JPanel(); cabecera[i].setBackground(Color.ORANGE); }
        JPanel columna_etiquetas = new JPanel();
        JPanel columna_entradas = new JPanel();
        JPanel columna_vacia = new JPanel();
        JPanel columna_vacia2 = new JPanel();
        //panelEntradas.setLayout(new GridLayout(filas, columnas));
        columna_vacia.setBackground(Color.yellow);
        columna_vacia2.setBackground(Color.BLUE);
        columna_etiquetas.setLayout(new GridLayout(cantidadEntradas, 1));
        columna_entradas.setLayout(new GridLayout(cantidadEntradas, 1));
        
        etiquetas = new JLabel[cantidadEntradas];
        entradas = new JTextField[cantidadEntradas];
        for(int i=0; i<cantidadEntradas; i++) {
            etiquetas[i] = new JLabel("Etiqueta "+(i+1));
            etiquetas[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            etiquetas[i].setForeground(Color.BLUE);
            columna_etiquetas.add(etiquetas[i]);
            entradas[i] = new JTextField();
            entradas[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            entradas[i].setForeground(Color.BLUE);
//            entradas[i].setSize(50, 25);
//            entradas[i].setLocation(100, 10+i*30);
            columna_entradas.add(entradas[i]);
        }
        for(int i=0; i<5; i++) {
            JLabel label = new JLabel("Hola "+(i+1));
            cabecera[i].add(label, BorderLayout.WEST);
        }
        for(int i=0; i<5; i++) {
            todo.add(cabecera[i], BorderLayout.WEST);
        }
        todo.add(columna_vacia, BorderLayout.WEST);
        todo.add(columna_etiquetas, BorderLayout.WEST);
        todo.add(columna_entradas, BorderLayout.WEST);
        todo.add(columna_vacia2, BorderLayout.WEST);
        for(int i=0; i<5; i++) {
            JLabel label = new JLabel("Hola "+(i+1));
            cabecera[i].add(label, BorderLayout.WEST);
            cabecera[i].setBackground(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Obtenemos el primer caracter del nombre del boton clickeado
        char caracter=((JButton) actionEvent.getSource()).getText().charAt(0);
        //Dependiendo del caracter, procedemos a hacer los procedimientos correspondientes
        switch(caracter){
        case 'C':
            JOptionPane.showMessageDialog(null, "Se presionó 'Comprimir'","Aviso",JOptionPane.INFORMATION_MESSAGE);
            //obtenemos el texto ingresado en la caja de texto
            String texto=entrada.getText();
            //Verificamos que la cadena no sea nula, si lo es se lanza una excepcion
            if(texto.length()==0){
                JOptionPane.showMessageDialog(null, "Error. No hay datos que comprimir","Error",JOptionPane.ERROR_MESSAGE);
            }
            //Utilizamos la funcion comprimir del objeto winzip y le pasamos la cadena a comprimir
            String[] cadenas={"Hola","Mundo"};
            //Mostramos la cadena de direcciones y la cadena de bytes
            salida.setText("Direcciones: "+cadenas[0]+"\nCaracteres: "+cadenas[1]);
        break;
        case 'D':
            entrada.setText("");
            //Utilizamos la funcion descomprimir de la clase Winzip
            salida.setText("El mensaje original es: ");
        break;
        case 'L':
            //Limpiamos las cajas de texto
            salida.setText("");
            entrada.setText("");
        break;
        }
    }
}
