/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author gabri
 */
public class Convolucion {

    public static Image convolucioname(Image imagen, int[][] mascara, int div, int offset) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                int rgb = nuevoTono(x, y, bi, mascara, div, offset);
                nuevo.setRGB(x, y, rgb);
            }
        }
        return herramientas.HerramientasImagen.toImage(nuevo);
    }

    public static int nuevoTono(int x, int y, BufferedImage original, int[][] mascara, int div, int offset) {
        int auxx = 0, auxy = 0;
        if (mascara.length == 3) {
            auxx = x - 1;
            auxy = y - 1;
        } else if (mascara.length == 5) {
            auxx = x - 2;
            auxy = y - 2;
        }
        int R = 0, G = 0, B = 0;
        Color aux = null;
        for (int i = 0; i < mascara.length; i++) {
            for (int j = 0; j < mascara.length; j++) {
                try {
                    if (mascara[i][j] != 0) {
                        aux = new Color(original.getRGB(auxx, auxy));
                        R += aux.getRed() * mascara[i][j];
                        G += aux.getGreen() * mascara[i][j];
                        B += aux.getBlue() * mascara[i][j];
                    }
                } catch (Exception e) {

                }
                auxy++;
            }
            auxx++;
            if (mascara.length == 3) {
                auxy = y - 1;
            } else if (mascara.length == 5) {
                auxy = y - 2;
            }
        }
        if (div != 0) {
            R /= div;
            G /= div;
            B /= div;
        }
        aux = new Color(verificar(R + offset), verificar(G + offset), verificar(B + offset));
        return aux.getRGB();
    }

    public static int verificar(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }

    public static Image kirsch(Image imagen) {
        //BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
       // BufferedImage nuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        double[][][] kirschi = espacial.MascarasBordes.arregloMascaras;
        int[][] mascara = new int[kirschi[0][1].length][kirschi[0][1].length];
        Image nuevo = null;
        Image aux = null;
        for (int z= 0; z<kirschi.length; z++) {
            for (int x = 0; x < kirschi[0][1].length; x++) {
                for (int y = 0; y < kirschi[0][1].length; y++) {
                    mascara[x][y]=(int) kirschi[z][x][y];
                    System.out.println(mascara[x][y]);
                }
            }
            nuevo = convolucioname(imagen,mascara,0,0);
            mascara= new int[kirschi[0][1].length][kirschi[0][1].length];
        }

        return nuevo;
    }
}
