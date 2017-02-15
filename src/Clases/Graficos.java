/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author pc
 */
public class Graficos {

    public Graficos(Automata A, String Direccion) {
        IOGraficos gra  = new IOGraficos(A);
        JFrame f =new JFrame("HOli");
        f.setSize(400,400);
        f.add(gra);
        f.setVisible(true);
        f.dispose();
        try{guardar(gra, Direccion);}
        catch(Exception e){
            
        }
    }
    public static BufferedImage screenShot(Component comp){
        BufferedImage imagen = new BufferedImage(comp.getWidth(), comp.getHeight(),BufferedImage.TYPE_INT_ARGB);
        comp.paint(imagen.getGraphics());
        return imagen;
        
    }
    public static void guardar(Component comp, String Direccion) throws Exception{
        BufferedImage imagen = screenShot(comp);
        ImageIO.write(imagen, "PNG", new File(Direccion));
    }
}
class IOGraficos  extends JPanel{
    private Estado[] estados;
    int cantidadEstados;
    int x=10, y=100;
    Point a[], b[];
    String[] alfabeto;
    Color[] colores;
    
    public IOGraficos(Automata A){
        estados= A.getEstados();
        cantidadEstados = estados.length; 
        a = new Point[cantidadEstados]; b = new Point[cantidadEstados];
        alfabeto = A.getAlfabeto();
        setBackground(Color.WHITE);
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
           int  bl= B.nextInt(255);
            B.ints(0, 255);
            colores[i] = new Color(r, g,  bl);
        }
    }
}
