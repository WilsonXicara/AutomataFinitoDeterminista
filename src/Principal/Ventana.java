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
public class Ventana implements ActionListener{
    JPanel panel1, panel2;
    JLabel[] etiquetas;
    JTextField[] cajas;
    JButton guardar;
    JFrame vent;
    int cant, est, calf;
    String[] alf;
    public Boolean[] estados;
    public String[] transiciones;
    public Ventana(int estado, String[] alfabeto){
        vent = new JFrame("Ventana java");
        vent.setLayout(null);
        cant = (estado*alfabeto.length)+estado;
        est=estado;
        calf=alfabeto.length;
        alf=alfabeto;
        Panel1();
        Panel2();
        
        
        panel1.setBounds(10, 10, 200, 30*cant);
        panel2.setBounds(210, 10, 200, 30*cant);
        vent.add(panel1);
        vent.add(panel2);
        guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBounds(175, 20+(30*cant), 100, 30);
        vent.add(guardar);
        
        
        vent.setLocation(100,50);
        //vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vent.setSize(450, 80+(30*cant));
        vent.setResizable(false);
        vent.setVisible(true);
        
    }

    public void Panel1(){
        panel1 = new JPanel(new GridLayout(cant, 1, 5, 7));
        
        etiquetas = new JLabel[cant];
        
        int cont=0, cont2=0;
        etiquetas[0] = new JLabel("El estado S"+0+" es Final (si o no)");
        panel1.add(etiquetas[0]);
        for (int i = 1; i < cant; i++) {
            if (cont < calf){
                etiquetas[i] = new JLabel("(S"+cont2+","+alf[cont]+ "). ejemplo s1");
                System.out.println("(S"+cont2+","+alf[cont]+ "). ejemplo s1");
            }
            if (cont >= calf){
                cont2++;
                etiquetas[i] = new JLabel("El estado S"+cont2+" es Final (si o no)");
                System.out.println("El estado S"+cont2+" es Final (si o no)");
                cont=-1;
            }
            cont++;
            panel1.add(etiquetas[i]);
        }
        panel1.setVisible(true);
    }
    public void Panel2(){
        panel2 = new JPanel(new GridLayout(cant, 1, 5, 7));
        
        cajas = new JTextField[cant];
        for (int i = 0; i < cant; i++) {
            cajas[i] = new JTextField();
            panel2.add(cajas[i]);
        }
        panel2.setVisible(true);
    }
    public void Datos(){
        estados= new Boolean[est];
        transiciones = new String[est*calf];
        int cont=0;
        for (int i = 0; i < cant; i+=(calf+1)) {
            if (cajas[i].getText().equals("si")){
                estados[cont]=true;
            }else{
                estados[cont]=false;
            }
            cont++;
        }
        cont=0;
        int cont2=0;
        for (int i = 1; i < cant; i++) {
            if(cont2<calf){
                transiciones[cont]=cajas[i].getText();
                cont++;
            }else cont2 = -1;
                   cont2++;
        }
        for (Boolean estado : estados) {
            System.out.print(estado + ", ");
        }
        
        for (String transicione : transiciones) {
            System.out.print(transicione + ", ");
        }

        //vent.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {  
        Datos();
    }
}
