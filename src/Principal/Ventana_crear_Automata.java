/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class Ventana_crear_Automata  {
    JPanel panel1,descripcion;
    JLabel simbolos, estados, nombre, des;
    JTextField[] cajas;
    JTextArea caja_descripcion;
    JButton Crear;
    JDialog ventana;
    VentanaAutomata automata;
    int Can_simbolos, Can_estados;

    public Ventana_crear_Automata() {
          ventana = new JDialog();
        ventana.setLayout(null);
        ventana.setModal(true);
        nombre = new JLabel("Nombre del Automata: ");
        simbolos = new JLabel("Cantidad de Simbolos: ");
        estados = new JLabel("Cantidad de Estados: ");
        des = new JLabel("Descripcion: ");
        cajas = new JTextField[3];
        Crear = new JButton("Crear");
        Crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String C_simbolos = cajas[0].getText();
                String C_estados = cajas[1].getText();
                String nombre = cajas[2].getText();
                String desrip = caja_descripcion.getText();
                C_simbolos.replaceAll(" ", "");
                C_estados.replaceAll(" ", "");
                
                  if(C_estados.length()==0 || C_simbolos.length()==0){
                          JOptionPane.showMessageDialog(ventana, "El campo de simbolos o estados esta vacio", "Error", JOptionPane.ERROR_MESSAGE, null);
                  }
                  
                  else{
                      Can_estados = Integer.parseInt(C_estados);
                      Can_simbolos = Integer.parseInt(C_simbolos);
                      if(Can_estados==0 || Can_simbolos == 0){
                          JOptionPane.showMessageDialog(ventana, "No se puede crear un Automata con 0 estados o 0 simbolos", "Error", JOptionPane.ERROR_MESSAGE, null);
                      }
                      else {automata = new VentanaAutomata(Can_estados, Can_simbolos);
                      automata.getNuevo().setNombre(nombre);
                      automata.getNuevo().setDescripcion(desrip);
                     ventana.dispose();
                     
                      }
                  }
            }
        });
        Crear();
        
        
        panel1.setBounds(10, 10, 300, 100);
        descripcion.setBounds(10,110,300,100);
        ventana.add(panel1);
        ventana.add(descripcion);
       // guardar.addActionListener(this);
        Crear.setBounds(100, 230, 100, 30);
        ventana.add(Crear);
        
        
        ventana.setLocation(300,200);
        //vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(350, 310);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    

    private void Crear() {
        panel1 = new JPanel(new GridLayout(4,2));
        descripcion = new JPanel();
        caja_descripcion = new JTextArea();
        caja_descripcion.setPreferredSize(new Dimension(300,80));
        descripcion.add(caja_descripcion);
        cajas[0] = new JTextField();
        cajas[1] = new JTextField();
        cajas[2] = new JTextField();
        panel1.add(nombre);
        panel1.add(cajas[2]);
        panel1.add(simbolos);
        panel1.add(cajas[0]);
        panel1.add(estados);
        panel1.add(cajas[1]);
        panel1.add(des);
 
    }

    public VentanaAutomata getAutomata() {
        return automata;
    }
    
}
