/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.BinarioAutomatico;
import espacial.Histograma;
import graficar.Grafica;
import gui.JFramePrincipal;
import gui.JInternalFrameConvolucion;
import gui.JInternalFrameEcualizar;
import gui.JInternalFrameLnExponencial;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameLnLineal;
import gui.JInternalFrameLn;
import gui.JInternalFrameRuido;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gabri
 */
public class IluminaListener implements ActionListener{
    private JFramePrincipal principal;

    public IluminaListener(JFramePrincipal principal) {
        this.principal = principal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem  item = (JMenuItem) e.getSource();
        if(item.getText().equals("Iluminación")){
            JInternalFrameImagen imagen = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameIluminacion in = new JInternalFrameIluminacion(imagen,imagen.getImagenOriginal());
            in.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(in);
        }else if(item.getText().equals("Lineal")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameLnLineal li = new JInternalFrameLnLineal(internal,imagen);
            li.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(li);
        }else if(item.getText().equals("Logarítmica")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            //Image nueva = espacial.Expansion.ExpandeLog(imagen);
            //JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            JInternalFrameLn i = new JInternalFrameLn(internal,imagen);
            i.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(i);
        }else if(item.getText().equals("Exponencial")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameLnExponencial li = new JInternalFrameLnExponencial(internal,imagen);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(li);
        }else if(item.getText().equals("Ecualizar")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameEcualizar li = new JInternalFrameEcualizar(internal,imagen);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(li);
        }else if(item.getText().equals("Convolución")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameConvolucion li = new JInternalFrameConvolucion(imagen,internal,principal);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(li);
        }else if(item.getText().equals("Ruido Sal y Pimienta")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();     
            Image imagen = internal.getImagenOriginal();
            JInternalFrameRuido li = new JInternalFrameRuido(imagen,internal,principal);
            //JInternalFrameLineal li = new JInternalFrameLineal(internal,imagen);
            li.setVisible(true);
            this.principal.getjDesktopPanePrincipal().add(li);
        }
    }
}
