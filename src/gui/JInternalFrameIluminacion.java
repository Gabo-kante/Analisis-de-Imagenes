/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author carli
 */
public class JInternalFrameIluminacion extends javax.swing.JInternalFrame implements ActionListener{

    /**
     * Creates new form JInternalFrameIluminación
     */
    private JInternalFrameImagen internal;
    private Image imagenOriginal;
    public JInternalFrameIluminacion(JInternalFrameImagen internal, Image imagenOriginal) {
        this.internal = internal;
        this.imagenOriginal = imagenOriginal;
        initComponents();
        jButton1.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(255);
        jSlider1.setMinimum(-255);
        jSlider1.setMinorTickSpacing(5);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButton1.setText("Iluminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(454, 454, 454))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TOBufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
        
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     int r = color.getRed()+jSlider1.getValue();
                     int g = color.getGreen()+jSlider1.getValue();
                     int b = color.getBlue()+jSlider1.getValue();
                     
                     color = new Color(verificar(r),verificar(g),verificar(b));
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
            Image nueva = herramientas.HerramientasImagen.toImage(bi);
            
            this.internal.setImagen(nueva);
    }//GEN-LAST:event_jSlider1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
         BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     int r = color.getRed()+jSlider1.getValue();
                     int g = color.getGreen()+jSlider1.getValue();
                     int b = color.getBlue()+jSlider1.getValue();
                     
                     color = new Color(verificar(r),verificar(g),verificar(b));
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
            Image nueva = herramientas.HerramientasImagen.toImage(bi);
            
            this.internal.setImagen(nueva);
    }
    
    public int verificar(int valor){
        if(valor>255) return 255;
        if(valor<0) return 0;
        return valor;
    }
}