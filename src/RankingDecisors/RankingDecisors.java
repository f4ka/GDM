/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RankingDecisors;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agustin
 */
public class RankingDecisors {
    
      public void CargaFichasCtaCte(JTable Tabla, ArrayList s,ArrayList<String> names) {
        DefaultTableModel Modelo = new DefaultTableModel();
                ordenar(s, names);
                String[] Columnas = {"Nombre","Peso"};
                for (int i = 0; i < Columnas.length; i++) 
                {
                    Modelo.addColumn(Columnas[i]);
                }            
                for (int k=0;k<s.size();k++) 
                {
                    Object[] filas = new Object[Columnas.length];
                    filas[1]=s.get(k);
                    filas[0] = names.get(k);
                    Modelo.addRow(filas);
                }
                Tabla.setModel(Modelo);
  
    }

    public void ordenar(ArrayList s, ArrayList<String> names)
    {
        Object ObjAuxiliar;
        String StrAuxiliar;
        for(int i=0;i<s.size();i++){
            for(int j=0;j<s.size()-1;j++){
                if(Double.parseDouble(s.get(j).toString())<Double.parseDouble(s.get(j+1).toString()))
                {
                    ObjAuxiliar=s.get(j);
                    s.set(j,s.get(j+1));
                    s.set(j+1, ObjAuxiliar);
                    StrAuxiliar=names.get(j);
                    names.set(j, names.get(j+1));
                    names.set(j+1,StrAuxiliar);
                }
            }
        }
    }
    
    public double [][]calculateNewWeights(int weightsLength, int function){
        return(setValues(weightsLength, function));
    }
    
    private double[][] setValues(int weightsLength, int function){
        double interval=100/(weightsLength-1); //se le saca uno a la cantidad de pesos
        double actualValue=100;
        double newWeights[][]=new double[2][weightsLength];
        for(int i=0; i<weightsLength; i++){
            if(actualValue<0) actualValue=0;
            switch(function){
                case 0: newWeights[0][i]=actualValue;
                        newWeights[1][i]=calculateWeightsX(actualValue);
                        break;
                case 1: newWeights[0][i]=actualValue;
                        newWeights[1][i]=calculateWeights05x_50(actualValue);
                        break;
                case 2: newWeights[0][i]=actualValue;
                        newWeights[1][i]=calculateWeightsx2_100(actualValue);
                        break;
                case 3: newWeights[0][i]=actualValue;
                        newWeights[1][i]=calculateWeightssqrt100x(actualValue);
                        break;
                default: JOptionPane.showMessageDialog(null, "Error seleccionando la funcion a usar", "Error", JOptionPane.ERROR_MESSAGE);
                        newWeights[0][i]=0;
                        newWeights[1][i]=0;
                        break;
            }   
            actualValue=actualValue-interval;
        }
        return(newWeights);
    }
    private double calculateWeightsX(double actualValue){
        return(actualValue);
    }

    private double calculateWeightsx2_100(double actualValue) {
        return((Math.pow(actualValue,2)/100));
    }

    private double calculateWeightssqrt100x(double actualValue) {
        return((Math.sqrt(actualValue*100)));
    }

    private double calculateWeights05x_50(double actualValue) {
        return(0.5*actualValue+50);
    }
     
    public void loadNewWeights(JTable Tabla, ArrayList s,ArrayList<String> names, double[][] newWeights) {
        DefaultTableModel Modelo = new DefaultTableModel();
                ordenar(s, names);
                String[] Columnas = {"Nombre","Peso", "Nuevo Peso"};
                for (int i = 0; i < Columnas.length; i++) 
                {
                    Modelo.addColumn(Columnas[i]);
                }            
                for (int k=0;k<s.size();k++) 
                {
                    Object[] filas = new Object[Columnas.length];
                    filas[1] = s.get(k);
                    filas[0] = names.get(k);
                    filas[2] = newWeights[1][k];
                    Modelo.addRow(filas);
                }
                Tabla.setModel(Modelo);  
    }
}
