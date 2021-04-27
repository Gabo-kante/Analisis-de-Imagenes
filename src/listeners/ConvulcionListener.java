/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameConvulcion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameLineal;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gabri
 */
public class ConvulcionListener implements ActionListener{
    private JFramePrincipal principal;

    public ConvulcionListener(JFramePrincipal principal) {
        this.principal = principal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem  item = (JMenuItem) e.getSource();
        if(item.getText().equals("Convolucion")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameConvulcion internalNuevo = new JInternalFrameConvulcion(internal,imagen);
            internalNuevo.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
    
}
