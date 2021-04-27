/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameEcualizar;
import gui.JInternalFrameIluminar;
import gui.JInternalFrameImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gabri
 */
public class EcualizarListener implements ActionListener{
     private JFramePrincipal principal;
    
    public EcualizarListener(JFramePrincipal principal){
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if(item.getText().equals("EcualizarHisto")){
           System.out.println("EcualizarHisto");
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
           JInternalFrameEcualizar internalNuevo = new JInternalFrameEcualizar(internal);
           internalNuevo.setVisible(true);
           this.principal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
}
