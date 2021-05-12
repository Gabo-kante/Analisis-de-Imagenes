/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Ruidos {
    public static Image aplicandoSal(Image imagen, int porcentaje){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight()*bi.getWidth();
        int p_n = ((tamanio*porcentaje)/100);
        Random ran = new Random();
        int x, y;
        while(p_n != 0){
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, Color.WHITE.getRGB());
            p_n--;
        }
        
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image aplicandoPimienta(Image imagen, int porcentaje){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight()*bi.getWidth();
        int p_n = ((tamanio*porcentaje)/100);
        Random ran = new Random();
        int x, y;
        while(p_n != 0){
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, 0);
            p_n--;
        }
        
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image aplicandoAmbos(Image imagen, int porcentaje){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight()*bi.getWidth();
        int p_n = ((tamanio*porcentaje)/100);
        Random ran = new Random();
        int x, y,cambio=1;
        while(p_n != 0){
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            if(cambio==1){
                bi.setRGB(x, y, Color.WHITE.getRGB());
                cambio=2;
            }else if(cambio==2){
                bi.setRGB(x, y, 0);
                cambio=1;
            }
            p_n--;
        }
        
        return herramientas.HerramientasImagen.toImage(bi);
    }
}
