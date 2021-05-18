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
 * @author gabri
 */
public class JInternalFrameBinario extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameBinario
     */
    private JInternalFrameImagen internal;
    private Image imagenOriginal;
    public JInternalFrameBinario(JInternalFrameImagen internal) {
        
        this.internal = internal;
        initComponents();
        int umbral = this.jSlider1.getValue();
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        this.jButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
                 Color color;
                 System.out.println(jSlider1.getValue());
                 for(int j = 0 ; j< bi.getWidth();j++){
                    for(int m = 0 ; m < bi.getHeight();m++){
                        color = new Color(bi.getRGB(j, m));
                       
                        int r = color.getRed(); // (0-255)
                        int g = color.getGreen(); // (0-255)
                        int b = color.getBlue(); // (0-255)
                        int med = (r+g+b)/3;
                        
                        if(med<=jSlider1.getValue()){
                          bi.setRGB(j, m, Color.WHITE.getRGB());  
                        }else{
                           bi.setRGB(j, m, 0); 
                        }
                    }
                }
                Image nueva = herramientas.HerramientasImagen.toImage(bi);
                internal.setImagen(nueva); 
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

        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(255);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(17);

        jButton1.setText("BW");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
