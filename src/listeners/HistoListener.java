/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.Histograma;
import graficar.Grafica;
import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author gabri
 */
public class HistoListener implements ActionListener{
    private JFramePrincipal principal;
    
    public HistoListener(JFramePrincipal principal){
        this.principal = principal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem  item = (JMenuItem) e.getSource();
        if(item.getText().equals("Histograma")){
            JInternalFrameImagen imagen = (JInternalFrameImagen) this.principal.getjDesktopPanePrincipal().getSelectedFrame();
            Histograma h = new Histograma(imagen.getImagenOriginal());
            h.calcularHistogramas();
            Grafica nuevo = new Grafica("RGB", "Muestras", "Histograma de una imagen");
            nuevo.agregarSerie("Rojo", h.getR());
            nuevo.agregarSerie("Azul", h.getB());
            nuevo.agregarSerie("Verde",h.getG());
            nuevo.crearGrafica();
            nuevo.muestraGrafica();
        }
    }
    
}
