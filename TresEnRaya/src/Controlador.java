
import java.awt.Color;
import static java.awt.Color.red;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAVINCI
 */
public class Controlador {
     private static Principal vista;
     private static boolean turno = true;
     private static boolean partidaTerminada;
     private static int contador = 0;

    public Controlador(Principal vista) {
        this.vista = vista;
    }
    
    public static void pintarBoton(JButton botonPresionado, JButton[] botones){
        if(partidaTerminada){
            return;
        }
     if (botonPresionado.getBackground().equals(Color.red) || botonPresionado.getBackground().equals(Color.blue)) {
        return;
    }
        if (turno){
            botonPresionado.setBackground(Color.red);
            contador++;
            turno = false;
        }else{
             botonPresionado.setBackground(Color.blue);
             contador++;
             turno = true;
        }
          comprobarGanador(botones);
    }
    
    public static void comprobarGanador(JButton[] botones){
    int[][] combinaciones = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };
    boolean ganador = false;
    for (int i = 0; i < combinaciones.length; i++) {

        int a = combinaciones[i][0];
        int b = combinaciones[i][1];
        int c = combinaciones[i][2];

        if (botones[a].getBackground().equals(Color.red)
                && botones[b].getBackground().equals(Color.red)
                && botones[c].getBackground().equals(Color.red))
        {
                ganador = true;
                partidaTerminada = true;
            JOptionPane.showMessageDialog(null, "¡Gana el rojo!");
        }else if (botones[a].getBackground().equals(Color.blue)
                && botones[b].getBackground().equals(Color.blue)
                && botones[c].getBackground().equals(Color.blue))
        {
         ganador = true;
         partidaTerminada = true;
         JOptionPane.showMessageDialog(null, "¡Gana el azul!");  
        }
    }
    if(ganador == false && contador == 9){
        JOptionPane.showMessageDialog(null, "¡EMPATE!");
         for (int i = 0; i < botones.length; i++) {
             botones[i].setBackground(null);
         }
         turno = false;
         ganador = false;
         partidaTerminada = false;
         
    }
   
    }
}
