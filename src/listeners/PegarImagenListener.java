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
