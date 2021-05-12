/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.BinarioAutomatico;
import gui.JFramePrincipal;
import gui.JInternalFrameBin2;
import gui.JInternalFrameBinario;
import gui.JInternalFrameFiltros;
import gui.JInternalFrameImagen;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class BinarioListener implements ActionListener{
     private JFramePrincipal principal;
    
    public BinarioListener(JFramePrincipal principal){
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if(item.getText().equals("1 umbral")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
           JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal);
           internalNuevo.setVisible(true);
           this.principal.getjDesktopPanePrincipal().add(internalNuevo);
        }else if(item.getText().equals("2 umbrales")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
           JInternalFrameBin2 internalNuevo = new JInternalFrameBin2(internal);
           internalNuevo.setVisible(true);
           this.principal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        else if(item.getText().equals("Automático")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            double[] umbral = BinarioAutomatico.devuelveHisto(imagen);
            JOptionPane.showMessageDialog(this.principal.getjDesktopPanePrincipal(), "El umbral es: "+BinarioAutomatico.calculaUmbral(umbral));
            Image nueva = BinarioAutomatico.Binariza(imagen, BinarioAutomatico.calculaUmbral(umbral));
            
            JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            i.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(i);
        }
        else if(item.getText().equals("Otsu")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            double[] umbral = BinarioAutomatico.devuelveHisto(imagen);
            JOptionPane.showMessageDialog(this.principal.getjDesktopPanePrincipal(), "El umbral es: "+BinarioAutomatico.otsu(umbral));
            Image nueva = BinarioAutomatico.Binariza(imagen, BinarioAutomatico.otsu(umbral));
            
            JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            i.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(i);
        }
    }
}
