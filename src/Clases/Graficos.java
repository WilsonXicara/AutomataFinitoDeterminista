/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author pc
 */
public class Graficos extends JFrame{

    public Graficos(String nombreAutomata, Automata A) throws HeadlessException{
        setSize(600,400);
        setTitle("Dibujo Atumata \""+nombreAutomata+"\"");
        setLocationRelativeTo(null);
        setContentPane(new manejoDibujo(A));
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton boton= new JButton();
        boton.setText("Salir");
        boton.setBounds(135, 150, 130, 50);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(boton);
        setVisible(true);
    }
     
}

class manejoDibujo extends JPanel{
    private Estado[] estados;
    int cantidadEstados;
    int x=10, y=175;
    Point a[], b[];
    String[] alfabeto;
    Color[] colores;
    
    public manejoDibujo(Automata A){
        estados= A.getEstados();
        cantidadEstados = estados.length; 
        a = new Point[cantidadEstados]; b = new Point[cantidadEstados];
        alfabeto = A.getAlfabeto();
    }
    
     @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(x+26, y, x+46, y+25);
        g.drawLine(x+46, y+25, x+26, y+50);
        dibujarEstado1_2(g);
        dibujarTransiciones(g);
        
    }   
    
    private void dibujarEstado1_2(Graphics g){
        for (int i = 0; i < cantidadEstados; i++) {
             if (estados[i].esAceptable()) {
                 g.setColor(Color.GREEN);
                 g.drawOval(x+50, y, 50, 50);
                 g.drawOval(x+46, y-4, 58, 58);
                 g.drawString("q"+i, x+70, y+30);
                 a[i] = new Point(x+75,y-12);
                 g.fillOval(a[i].x, a[i].y, 4, 4);
                 g.fillOval(a[i].x-1, a[i].y-1, 6, 6);
                 b[i] = new Point(x+75,y+58);
                 g.drawOval(b[i].x, b[i].y, 4, 4);
                 a[i].x= a[i].x+2;
                 a[i].y= a[i].y+2;
                 b[i].x= b[i].x+2;
                 b[i].y= b[i].y+2;
              
                 x+=70;
             }else{
                 g.setColor(Color.RED);
                 g.drawOval(x+50, y, 50, 50);
                 g.drawString("q"+i, x+70, y+30);
                 a[i] = new Point(x+75,y-12);
                 g.drawOval(a[i].x, a[i].y, 4, 4);
                 g.drawOval(a[i].x-1, a[i].y-1, 6, 6);
                 b[i] = new Point(x+75,y+58);
                 g.drawOval(b[i].x, b[i].y, 4, 4);
                 a[i].x= a[i].x+2;
                 a[i].y= a[i].y+2;
                 b[i].x= b[i].x+2;
                 b[i].y= b[i].y+2;
                 
                 x+=70;
             }

         }
    }
    private void dibujarTransiciones(Graphics g){
        definirColores();
        for (int i = 0; i < cantidadEstados; i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                Estado aux = estados[i].getTransicion(j);
                int numeroEstado= buscarEstado(aux);
                g.setColor(colores[j]);
                g.drawLine(a[i].x, a[i].y, b[numeroEstado].x, b[numeroEstado].y);
                g.drawString(alfabeto[j], 10+(j*10), y-40);
            }
        }
    }
    private int buscarEstado(Estado aux){
        int j=0;
        for (int i=0; i < cantidadEstados; i++) {
            if(aux == estados[i]) j=i;
        }
        return j;
    }
    private void definirColores(){
        Random R= new Random(),G= new Random(),B= new Random();
       
        colores= new Color[alfabeto.length];
        for (int i = 0; i < alfabeto.length; i++) {
           int r= R.nextInt(255);
           int g= G.nextInt(255);
           int b= B.nextInt(255);
            B.ints(0, 255);
            colores[i] = new Color(r, g, b);
        }
    }
}




