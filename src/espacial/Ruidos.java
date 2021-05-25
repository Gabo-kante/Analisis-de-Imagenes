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

    public static Image aplicandoSal(Image imagen, int porcentaje) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight() * bi.getWidth();
        int p_n = ((tamanio * porcentaje) / 100);
        Random ran = new Random();
        int x, y;
        while (p_n != 0) {
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, Color.WHITE.getRGB());
            p_n--;
        }

        return herramientas.HerramientasImagen.toImage(bi);
    }

    public static Image aplicandoPimienta(Image imagen, int porcentaje) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight() * bi.getWidth();
        int p_n = ((tamanio * porcentaje) / 100);
        Random ran = new Random();
        int x, y;
        while (p_n != 0) {
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            bi.setRGB(x, y, 0);
            p_n--;
        }

        return herramientas.HerramientasImagen.toImage(bi);
    }

    public static Image aplicandoAmbos(Image imagen, int porcentaje) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        //BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        int tamanio = bi.getHeight() * bi.getWidth();
        int p_n = ((tamanio * porcentaje) / 100);
        Random ran = new Random();
        int x, y, cambio = 1;
        while (p_n != 0) {
            x = ran.nextInt(bi.getWidth());
            y = ran.nextInt(bi.getHeight());
            if (cambio == 1) {
                bi.setRGB(x, y, Color.WHITE.getRGB());
                cambio = 2;
            } else if (cambio == 2) {
                bi.setRGB(x, y, 0);
                cambio = 1;
            }
            p_n--;
        }

        return herramientas.HerramientasImagen.toImage(bi);
    }

    public static Image limpiaRuido(Image imagen) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color aux1 = null;
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                aux1 = new Color(bi.getRGB(x, y));
                
                if (aux1.getRGB() == Color.BLACK.getRGB()) {
                    System.out.println("PIMIENTA");
                    int rgb = limpiaPimienta(x, y, bi);
                    nuevo.setRGB(x, y, rgb);
                } else if (aux1.getRGB() == Color.WHITE.getRGB()) {
                    System.out.println("SAL");
                    int rgb = limpiaSal(x, y, bi);
                    nuevo.setRGB(x, y, rgb);
                }else{
                    nuevo.setRGB(x,y,bi.getRGB(x, y));
                }
               
            }
        }
        return herramientas.HerramientasImagen.toImage(nuevo);
    }

    public static int limpiaPimienta(int x, int y, BufferedImage original) {
        int comparaR = 0;
        Color aux = null, aux2 = null;
        int mayor = -1;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                try {
                    if (i == x && j == y) {

                    } else {
                        aux2 = new Color(original.getRGB(i, j));
                        comparaR = (aux2.getRed() + aux2.getGreen() + aux2.getBlue()) / 3;
                        if (comparaR > mayor) {
                            mayor = comparaR;
                            aux = aux2;
                        }
                    }

                } catch (Exception e) {

                }
            }
        }
        System.out.println(aux.getRGB());
        return aux.getRGB();
    }

    public static int limpiaSal(int x, int y, BufferedImage original) {
        //int auxx = x - 1, auxy = y - 1;
        int comparaR = 0;
        Color aux = null, aux2 = null;
        int menor = 300;
        //aux = new Color(original.getRGB(x, y));
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                try {
                    if (i == x && j == y) {

                    } else {
                        aux2 = new Color(original.getRGB(i, j));
                        comparaR = (aux2.getRed() + aux2.getAlpha() + aux2.getBlue()) / 3;
                        if (comparaR < menor) {
                            menor = comparaR;
                            aux = aux2;
                        }
                    }

                } catch (Exception e) {

                }

            }

        }

        //aux = new Color(verificar(R + offset), verificar(G + offset), verificar(B + offset));
         System.out.println(aux.getRGB());
        return aux.getRGB();
    }

}
