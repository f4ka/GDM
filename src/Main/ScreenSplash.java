/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.awt.*;
import java.awt.SplashScreen;
import javax.swing.JOptionPane;


public final class ScreenSplash {
    final SplashScreen splash;
     final String[] texto = {"Tufix Systems" ,"Configuration", "Library",
                          "Files","Forms","Icons","Properties",
                          "JSon Files", "Fuzzy Logic", "Expert Systems",
                          "Database" ,"Done",
                          ""};
    public ScreenSplash(){
        splash = SplashScreen.getSplashScreen();    
    }
  public void animar()
   {
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<texto.length; i++)
            {                       
                //se pinta texto del array
                g.setColor( new Color(4,52,101));//color de fondo
                g.fillRect(100, 483,280,12);//para tapar texto anterior
                g.setColor(Color.white);//color de texto 
                g.drawString("Loading "+texto[i-1]+"...", 100, 493);                
                g.setColor(new Color(0,81,254));//color de barra de progeso
                g.fillRect(100, 466,(i*307/texto.length), 12);//la barra de progreso
                //se pinta una linea segmentada encima de la barra verde
              //  float dash1[] = {2.0f};
                //BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                //g.setStroke(dashed);
                //g.setColor(new Color(0,81,254));//color de barra de progeso
               // g.setColor( new Color(4,52,101));
              //  g.drawLine(100, 452, 500, 314);                
                //se actualiza todo
                splash.update();
  try {
   Thread.sleep(321);
  } catch(InterruptedException e) { }
            }
    splash.close();
    try {
             
         }
 catch (Exception e) {
            System.out.println(e.getMessage());
        }
 }
   }
}
    

