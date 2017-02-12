/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Clases.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Principal extends javax.swing.JFrame {
    int contador = 0;
    JTextField[] cajas = new JTextField[5];
    Ventana_crear_Automata aux;
    ArrayList<Automata> Lista_Automatas;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        String[] archivo = {"Nuevo autómata...","Modificar autómata..."};
        String[] editar = {"Comparar autómatas...", "Minimizar autómatas..."};
        for(int i=0; i<2; i++) {
       //     this.menu_archivo.add(archivo[i]);
            this.menu_editar.add(editar[i]);
        }
        Lista_Automatas = new ArrayList<Automata>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grafico1 = new javax.swing.JScrollPane();
        Automatas1 = new javax.swing.JComboBox<>();
        Grafico2 = new javax.swing.JScrollPane();
        Automatas2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        Nuevo_automata = new javax.swing.JMenuItem();
        menu_editar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Grafico1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Automatas1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                Automatas1ComponentAdded(evt);
            }
        });
        Automatas1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Automatas1ItemStateChanged(evt);
            }
        });

        Automatas2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Automatas2ItemStateChanged(evt);
            }
        });

        menu_archivo.setText("Archivo");

        Nuevo_automata.setText("Nuevo Automata");
        Nuevo_automata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nuevo_automataActionPerformed(evt);
            }
        });
        menu_archivo.add(Nuevo_automata);

        jMenuBar1.add(menu_archivo);

        menu_editar.setText("Editar");
        jMenuBar1.add(menu_editar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Grafico2)
                            .addComponent(Automatas2, 0, 311, Short.MAX_VALUE)))
                    .addComponent(Automatas1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Automatas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Automatas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grafico2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nuevo_automataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nuevo_automataActionPerformed
//          aux = new Ventana_crear_Automata();
//          Automata nuevo = aux.getAutomata().getNuevo();
        String[] alfabeto = {"0", "1"}, nombresEstados = {"s000", "s1", "s2"};
        Automata nuevo = new Automata(alfabeto, 3);
        nuevo.setNombre("Primer Automata");
        nuevo.setDescripcion("ESTE ES EL PRIMER AUTÓMATA");
        nuevo.setNombresEstados(nombresEstados);
        nuevo.getEstados()[0].setAceptable(false);
        nuevo.getEstados()[0].setTransicion(0, nuevo.getEstados()[1]);
        nuevo.getEstados()[0].setTransicion(1, nuevo.getEstados()[0]);
        nuevo.getEstados()[1].setAceptable(false);
        nuevo.getEstados()[1].setTransicion(0, nuevo.getEstados()[1]);
        nuevo.getEstados()[1].setTransicion(1, nuevo.getEstados()[2]);
        nuevo.getEstados()[2].setAceptable(true);
        nuevo.getEstados()[2].setTransicion(0, nuevo.getEstados()[1]);
        nuevo.getEstados()[2].setTransicion(1, nuevo.getEstados()[0]);
        
        Automata nuevo2 = new Automata(alfabeto, 3);
        nuevo2.setNombre("segundo Automata");
        nuevo2.setDescripcion("ESTE ES EL SEGUNDO AUTÓMATA, QUE SE GUARDA DESPUÉS DEL PRIMERO");
        nuevo2.setNombresEstados(nombresEstados);
        nuevo2.getEstados()[0].setAceptable(false);
        nuevo2.getEstados()[0].setTransicion(0, nuevo2.getEstados()[1]);
        nuevo2.getEstados()[0].setTransicion(1, nuevo2.getEstados()[0]);
        nuevo2.getEstados()[1].setAceptable(false);
        nuevo2.getEstados()[1].setTransicion(0, nuevo2.getEstados()[1]);
        nuevo2.getEstados()[1].setTransicion(1, nuevo2.getEstados()[2]);
        nuevo2.getEstados()[2].setAceptable(true);
        nuevo2.getEstados()[2].setTransicion(0, nuevo2.getEstados()[1]);
        nuevo2.getEstados()[2].setTransicion(1, nuevo2.getEstados()[0]);
        
          ManejoArchivo archivo = new ManejoArchivo();
          archivo.guardarAutomata(nuevo);
          archivo.guardarAutomata(nuevo2);
          IndiceAutomatas[] referencias = archivo.obtenerReferencias();
          System.out.println("IndiceAutomatas[0] = "+referencias[0].toString());
          System.out.println("IndiceAutomatas[1] = "+referencias[1].toString());
          archivo.eliminarAutomata(referencias[1]);
//          archivo.eliminarAutomata(referencias[1]);
          Lista_Automatas.add(nuevo);
          Automatas1.addItem(nuevo.getNombre());
          Automatas2.addItem(nuevo.getNombre());
          
    }//GEN-LAST:event_Nuevo_automataActionPerformed

    private void Automatas1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Automatas1ItemStateChanged
        int numero = Automatas1.getSelectedIndex();
        Graficos a = new Graficos(Lista_Automatas.get(numero),Lista_Automatas.get(numero).getNombre());
           BufferedImage ima = null;
           try {
             ima = ImageIO.read(new File(Lista_Automatas.get(numero).getNombre()));
            
             JLabel imagen = new JLabel(new ImageIcon(ima));
             Grafico1.setViewportView(imagen);
            
           } catch (Exception e) {
          }
    }//GEN-LAST:event_Automatas1ItemStateChanged

    private void Automatas2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Automatas2ItemStateChanged
         int numero = Automatas2.getSelectedIndex();
        Graficos a = new Graficos(Lista_Automatas.get(numero),Lista_Automatas.get(numero).getNombre());
           BufferedImage ima = null;
           try {
             ima = ImageIO.read(new File(Lista_Automatas.get(numero).getNombre()));
            
             JLabel imagen = new JLabel(new ImageIcon(ima));
             Grafico2.setViewportView(imagen);
            
           } catch (Exception e) {
          }
    }//GEN-LAST:event_Automatas2ItemStateChanged

    private void Automatas1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_Automatas1ComponentAdded
        
    }//GEN-LAST:event_Automatas1ComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Automatas1;
    private javax.swing.JComboBox<String> Automatas2;
    private javax.swing.JScrollPane Grafico1;
    private javax.swing.JScrollPane Grafico2;
    private javax.swing.JMenuItem Nuevo_automata;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_editar;
    // End of variables declaration//GEN-END:variables
}
