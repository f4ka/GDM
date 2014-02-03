/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Saaty.Criteria;

import Data.Structurs;
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


public class saatyGuiEvents { 
       public saatyGuiEvents(){
   }
       public boolean validationNonRepeatNewElement(String newElement, DefaultListModel listModel){
           boolean result=false;
           for(int i=0; i<listModel.getSize(); i++)
               if(listModel.get(i).toString().equals(newElement))
                    result=true;
           return result;
       }
       public void addNewElement(JTextField txtElement, DefaultListModel listModel, JList listElements, ArrayList elements, JPanel jPanel1){
           if(!validationNonRepeatNewElement(txtElement.getText(), listModel)){
               addListElement(txtElement, listModel, listElements, elements);
               if(elements.size()>=2){
                  jPanel1.removeAll();
                  jPanel1.repaint();
                  panelSliders(elements, jPanel1);
                }
            }
       }
       public void addListElement(JTextField txtElement, DefaultListModel listModel, JList listElements, ArrayList elements){
        if(!txtElement.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            listModel.addElement(txtElement.getText());
            Structurs.names.add(txtElement.getText());
            elements.add(txtElement.getText());
            txtElement.requestFocus();
            txtElement.setText("");
            listElements = new JList(listModel);
        }
    }
       public void removeListElement(DefaultListModel listModel, JList listElements, ArrayList elements, JPanel jPanel1){
               int indexToRemove=listElements.getSelectedIndex();
                elements.remove(indexToRemove);
                listModel.remove(indexToRemove);
                Structurs.names.remove(indexToRemove);
                if(elements.size()>=2){
                   jPanel1.removeAll();
                   jPanel1.repaint();
                   panelSliders(elements, jPanel1);
                }
                else{
                    jPanel1.removeAll();
                    jPanel1.repaint();
                }
       }       
       public void panelSliders(ArrayList elements, JPanel panel){
        Structurs.elements=new ArrayList();
        for (int i=0; i < Structurs.names.size(); i++) {
	  for (int j = (i + 1); j < Structurs.names.size(); j++) {
            createPanel(panel, elements.get(i).toString(), elements.get(j).toString());
 	}
      }
     }   
       public void createPanel(JPanel panel, String label1, String label2){
            addJPanel(panel, label1, label2);
        }
       public void addJPanel(JPanel panel, String label1, String label2){
            JPanel aux =new JPanel();
            JPanel superior=new JPanel();
            JPanel inferior=new JPanel();
            superior.setBounds(95, 0, 500, 20);
            superior.setBackground(new java.awt.Color(254, 254, 254));
            inferior.setBounds(95, 20, 500, 30);
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
            Structurs.elements.add(addComponents(label1, label2, panel, inferior, superior, aux));
         //   sliders.add(addComponents(label1,label2,panel,inferior,superior,aux));
   }    
       public JSlider addComponents(String label1, String label2, JPanel panel, JPanel inferior, JPanel superior, JPanel aux){
            JLabel lbl1=new JLabel(label1);
            JLabel lbl2=new JLabel(label2);
            final JLabel lblSlider=new JLabel("1.00");
            final JSlider sld =new JSlider();
            lbl1.setSize(100, 30);
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
       public  double getValueImportance(int value){
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
       public  boolean callCalculateConsistence(){
            Matrix matrix;
            Consistence consistence = new Consistence();
            boolean boolConsistence=false;
            Structurs.values= new double[Structurs.elements.size()];
            for(int i=0; i<Structurs.elements.size(); i++)
                Structurs.values[i]=getValueImportance(Structurs.elements.get(i).getValue());
            matrix=new Matrix();
            matrix.createMatrix();
            boolConsistence=consistence.calculateConsistence();
            return boolConsistence;
       }
    
}

  
    

