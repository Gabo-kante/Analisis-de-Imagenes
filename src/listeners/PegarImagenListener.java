/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import gui.JInternalFramePegar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class PegarImagenListener implements ActionListener {

    private Image segmento;
    private JFramePrincipal principal;
    private int x, y;

//    public PegarImagenListener(JFramePrincipal principal, Image segmento, int x, int y) {
//        this.segmento = segmento;
//        this.principal = principal;
//        this.x = x;
//        this.y = y;
//        JInternalFrameImagen internal = (JInternalFrameImagen) principal.getjDesktopPanePrincipal().getSelectedFrame();
//        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(internal.getImagenOriginal());
//        BufferedImage b2 = herramientas.HerramientasImagen.toBufferedImage(segmento);
//        int w = 0;
//        int h = 0;
//        for (int j = x; j < x + b2.getWidth(); j++) {
//            for (int m = y; m < y + b2.getHeight(); m++) {
//                bi.setRGB(x, y, b2.getRGB(w, h));
//                w++;
//            }
//            w = 0;
//            h++;
//        }
//        Image nueva = herramientas.HerramientasImagen.toImage(bi);
//        internal.setImagen(nueva);
//
//    }
//
//    public PegarImagenListener(Image nueva, JFramePrincipal principal) {
//        this.principal = principal;
//        this.segmento = nueva;
//        //JInternalFrameImagen internal =  (JInternalFrameImagen) principal.getjDesktopPanePrincipal().getSelectedFrame();
//        JInternalFramePegar pegatin = new JInternalFramePegar(nueva, principal);
//        pegatin.setVisible(true);
//        principal.getjDesktopPanePrincipal().add(pegatin);
//    }

    public PegarImagenListener(JFramePrincipal principal) {
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item.getText().equals("Pegar")) {
            if (this.principal.getSegmento() != null) {
                JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
                JInternalFramePegar internalNuevo = new JInternalFramePegar(internal,this.principal);
                internalNuevo.setVisible(true);
                this.principal.getjDesktopPanePrincipal().add(internalNuevo);
            }else{
                JOptionPane.showMessageDialog(null, "No existe un recorte");
            }

        }
    }
}
