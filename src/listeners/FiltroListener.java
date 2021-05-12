/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameFiltros;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gabri
 */
public class FiltroListener implements ActionListener{
    private JFramePrincipal principal;
    
    public FiltroListener(JFramePrincipal principal){
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if(item.getText().equals("Filtros")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
           JInternalFrameFiltros internalNuevo = new JInternalFrameFiltros(internal);
           internalNuevo.setVisible(true);
           this.principal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
}
