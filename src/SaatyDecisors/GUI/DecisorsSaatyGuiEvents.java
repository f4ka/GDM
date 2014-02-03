/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SaatyDecisors.GUI;


import Data.StructursDecisors;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DecisorsSaatyGuiEvents { 
   
   public void addListElement(JTextField txtElement, DefaultListModel listModel, JList listElements, ArrayList elements){
        if(!txtElement.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            listModel.addElement(txtElement.getText());
            StructursDecisors.names.add(txtElement.getText());
            elements.add(txtElement.getText());
            txtElement.requestFocus();
            txtElement.setText("");
            listElements = new JList(listModel);
             elements.size();
        }
    }
    
    public void  addNewVersionJSlidersElement(JPanel panel,int panelNo){
        sliders=new ArrayList<JSlider>();
        if(StructursDecisors.names.size()>0){
               for (int i=0; i < StructursDecisors.names.size(); i++) {
                   for (int j = (i + 1); j < StructursDecisors.names.size(); j++) {
                       createPanel(panel, StructursDecisors.names.get(i).toString(), StructursDecisors.names.get(j).toString(),  panelNo);
                   } 
                 }
               StructursDecisors.elements[panelNo]=new JSlider[sliders.size()];
               for(int i=0; i<sliders.size(); i++)
                    StructursDecisors.elements[panelNo][i]=sliders.get(i);
         }
    }
       
        public void createPanel(JPanel panel, String label1, String label2, int panelNo){
            addJPanel(panel, label1, label2,  panelNo);
        }
        
        public void addJPanel(JPanel panel, String label1, String label2, int panelNo){
            JPanel aux =new JPanel();
            JPanel superior=new JPanel();
            JPanel inferior=new JPanel();
            superior.setBounds(0, 0, 500, 20);
            superior.setBackground(new java.awt.Color(254, 254, 254));
            inferior.setBounds(0, 20, 500, 30);
            inferior.setBackground(new java.awt.Color(254, 254, 254));
            aux.setBounds(100, 100, 500, 60);
            aux.setBackground(new java.awt.Color(254, 254, 254));
            superior.setVisible(true);
            inferior.setVisible(true);
            aux.setVisible(true);
            superior.setLayout(new FlowLayout());
            inferior.setLayout(new FlowLayout());
            aux.setLayout(null);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            //StructursDecisors.elements.get(panelNo).add(addComponents(label1, label2, panel, inferior, superior, aux));
             sliders.add(addComponents(label1, label2, panel, inferior, superior, aux));
          //  StructursDecisors.elements.size();
   }
        
        public JSlider addComponents(String label1, String label2, JPanel panel, JPanel inferior, JPanel superior, JPanel aux){
            JLabel lbl1=new JLabel(label1);
            JLabel lbl2=new JLabel(label2);
            final JLabel lblSlider=new JLabel("1.00");
            final JSlider sld =new JSlider();
            lbl1.setSize(100, 30);
            ///sliders 
            sld.setSize(150,30);
            sld.setMaximum(16);
            sld.setValue(8);
            sld.setBackground(new java.awt.Color(254, 254, 254));
            sld.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e) {
                    lblSlider.setText(Integer.toString(setValueSliders(sld.getValue())));
                }
            });
            //labels instance
            lbl2.setSize(100,30);
            lblSlider.setSize(50, 20);
            inferior.add(lbl1);
            inferior.add(sld);
            inferior.add(lbl2);
            superior.add(lblSlider);
            aux.add(superior);
            aux.add(inferior);
            panel.add(aux);
            panel.setVisible(true);
            panel.setBounds(0,0, 537, 200);   
            return sld;
            }
        
        public int setValueSliders(int value){
            int aux=0;
            if(value==8){
                aux=1;
            }
                else{
                    if(value>8){
                        aux=value-7;
                    }
                    else{
                        aux=9-value;
                    }
            }
            return aux;
        }
       public double getValueImportance(int value){
           double aux=0;
           if(value==8)
               aux=1;
           else{
               if(value>8){
                   aux=1.0/(value-7);
               }
               else{
                   aux=9-value;
               }
           }
           return aux;
       }
       public static ArrayList<JSlider> sliders;
}

  
    

