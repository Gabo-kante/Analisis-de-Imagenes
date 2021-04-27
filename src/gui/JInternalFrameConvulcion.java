/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import herramientas.Convulcion;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author gabri
 */
public class JInternalFrameConvulcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameModificar
     */
    
   private JInternalFrameImagen internal;
    private Image imagenOriginal;
    
    
    public JInternalFrameConvulcion( JInternalFrameImagen internal, Image Oimage) {
        this.internal = internal;
        this.imagenOriginal=Oimage;
        initComponents();

        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                       
                Convulcion ce = new Convulcion(imagenOriginal);
        //jLabelImagenBin.setIcon(new ImageIcon(ce.convolucionar3x3(new int[][]{(1,1,1),(1,1,1),(1,1,1)});
        imagenOriginal = ce.convolucionar(new int [][]{{1,1,1},{0,0,0},{-1,-1,-1}},0,1);
        

//                Image nueva = herramientas.HerramientasImagen.toImage(bi);
                internal.setImagen(imagenOriginal); 
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 255));
        setClosable(true);
        setIconifiable(true);

        jButton1.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}