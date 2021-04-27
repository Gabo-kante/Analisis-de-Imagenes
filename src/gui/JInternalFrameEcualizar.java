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
 * @author working
 */
public class JInternalFrameEcualizar extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameModificar
     */
    
    private JInternalFrameImagen internal;
    private Image imagenOriginal;
   


    
    public JInternalFrameEcualizar( JInternalFrameImagen internal) {
        this.internal = internal;
        initComponents();
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color2;
                int sumatotalR=0;
                int sumatotalG=0;
                int sumatotalB=0;
                int constante1=0;
                int constante2=0;
                int constante3=0;
                int[]r1 = new int[256];
                int[]g1 = new int[256];
                int[]b1 = new int[256];
                
                float[]r2 = new float[256];
                float[]g2 = new float[256];
                float[]b2 = new float[256];
                
                int[]r3 = new int[256];
                int[]g3 = new int[256];
                int[]b3 = new int[256];
                
                BufferedImage bi2 = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
                
                int totalpixels= bi2.getWidth()*bi2.getHeight();

                for(int j = 0 ; j< bi2.getHeight();j++){
                    for(int i = 0 ; i < bi2.getWidth();i++){
                        color2 = new Color(bi2.getRGB(i, j));
                       
//                        sumatotalR = sumatotalR + color2.getRed(); 
//                        sumatotalG = sumatotalG + color2.getGreen();
//                        sumatotalB = sumatotalB + color2.getBlue(); 
                        
                        int r4 = color2.getRed();
                        int g4 = color2.getGreen();
                        int b4 = color2.getBlue();
                        
                        r1[r4]++;
                        g1[g4]++;
                        b1[r4]++;
                        
                    }
                }
                for(int i=0;i<r2.length;i++){
                    sumatotalR = sumatotalR + r1[i]; 
                    sumatotalG = sumatotalG + g1[i];
                    sumatotalB = sumatotalB + b1[i]; 
                    
                    
//                    
//                    r2[i]=Math.round( (sumatotalR)*255 / totalpixels);
//                    g2[i]=Math.round( (sumatotalG)*255 / totalpixels);
//                    b2[i]=Math.round( (sumatotalB)*255 / totalpixels);
                    
                    r2[i]= (sumatotalR)*255 / totalpixels;
                    g2[i]= (sumatotalG)*255 / totalpixels;
                    b2[i]= (sumatotalB)*255 / totalpixels;
                
                }
             
                float pe=5.51f;
                int b7=Math.round(pe); 

                
                BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
                 Color color;
                 System.out.println("valor");// obtenemos el valor del slider
                 for(int j = 0 ; j< bi.getHeight();j++){
                    for(int i = 0 ; i < bi.getWidth();i++){
                        color = new Color(bi.getRGB(i, j));
                       
                        int r = (int) r2[color.getRed()]; 
                        int g = (int) g2[color.getGreen()] ; 
                        int b = (int) b2[color.getBlue()]; 
                        
                        color = new Color(verificar(r),verificar(g),verificar(b));
                        bi.setRGB(i, j, color.getRGB());  
                        
                    }
                }
                Image nueva = herramientas.HerramientasImagen.toImage(bi);
                internal.setImagen(nueva); 

//                int width =bi.getWidth();
//                int height =bi.getHeight();
//                int anzpixel= width*height;
//                
//                int[] histogram = new int[255];
//                int[] iarray = new int[1];
//                int i =0;
//
//                //read pixel intensities into histogram
//                for (int x = 1; x < width; x++) {
//                    for (int y = 1; y < height; y++) {
//                        int valueBefore=bi.getRaster().getPixel(x, y,iarray)[0];
//                        histogram[valueBefore]++;
//                    }
//                }
//
//                int sum =0;
//                // build a Lookup table LUT containing scale factor
//                float[] lut = new float[anzpixel];
//                for ( i=0; i < 255; ++i ){
//                    sum += histogram[i];
//                    lut[i] = sum * 255 / anzpixel;
//                }
//
//                // transform image using sum histogram as a Lookup table
//                for (int x = 1; x < width; x++) {
//                    for (int y = 1; y < height; y++) {
//                        int valueBefore=bi.getRaster().getPixel(x, y,iarray)[0];
//                        int valueAfter= (int) lut[valueBefore];
//                        iarray[0]=valueAfter;
//                        bi.getRaster().setPixel(x, y, iarray);
//                    }
//                }               
            }
        });
    }
    public static int verificar(int valor){
        if(valor>=255){            
            return 255;
        }
        if(valor<=0){
            return 0;
        }
        return valor;            
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

        jButton1.setText("Ecualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
