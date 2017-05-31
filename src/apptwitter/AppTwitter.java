/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptwitter;

import javax.swing.JOptionPane;


/**
 *
 * @author Jorge
 */
public class AppTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos.acceso();
        int opcion;

        do { 
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Nuevo tweet \n 2.Lista TL \n 3.Buscar TT \n 4.MP "));
            switch (opcion) {

                case 1:Metodos.twitear("Hola");
                    break;
                case 2:Metodos.timeLine();
                    break;
                case 3:Metodos.buscarTt("Spotify");
                    break;
                case 4:Metodos.enviarMP(JOptionPane.showInputDialog("Introduce destinatario"),JOptionPane.showInputDialog("Introduce a mensaxe"));
                    break;
                
            }

        } while (opcion != 0);
    }
    
}
    

