/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Main.FramePpal;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author agustin
 */
public class MainTrapecio {
    public static ArrayList<Trapecio> trapecios= new ArrayList<>();
    public static Ventana ventana;

    
    public MainTrapecio(JFrame frame){
        ventana=new Ventana();
        ventana.setBounds(0, 0, 1000, 520);
        ventana.setVisible(false);

        frame.add(ventana);
    }
    public static void agregarTrapecio(Trapecio trap){
		
		trapecios.add(trap);
		
		ventana.graficarChart(Trapecio.graficarTrapecios(trapecios));
    }
}
