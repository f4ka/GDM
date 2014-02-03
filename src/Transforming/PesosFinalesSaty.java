/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transforming;

import Data.Structurs;
import Data.StructursDecisors;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class PesosFinalesSaty {
    public void calcularPesos(){
       /* for(int i=0; i<StructursDecisors.eigenvector.size(); i++)
            System.out.println("Eigenvector["+i+"]="+StructursDecisors.eigenvector.get(i));
        for(int i=0; i<Structurs.eigenvector.size(); i++)
            System.out.println("EigenvectorCriterio["+i+"]="+Structurs.eigenvector.get(i));*/
        StructursDecisors.weightsDecisors=new ArrayList();
        double [][] matrizEigenvectors=createMatriz();
        for(int i=0; i<Structurs.names.size();i++)
            for(int j=0; j<StructursDecisors.names.size(); j++)
                System.out.println("MatrizEigenvector["+i+"]["+j+"]"+"="+matrizEigenvectors[i][j]);
        double eigenvectorCriterios[]=new double[Structurs.eigenvector.size()];
        for(int i=0; i<Structurs.eigenvector.size(); i++)
            eigenvectorCriterios[i]=(double) Structurs.eigenvector.get(i);
        double []vectorPesos=createArrayPesos(matrizEigenvectors, eigenvectorCriterios);
        
    }
    public double[][] createMatriz(){
        int cadencia=StructursDecisors.names.size();
        double matriz[][]=new double[Structurs.names.size()][StructursDecisors.names.size()];
        int aux=cadencia;
        int i=0;
        int k=0; 
            for(int j=0; j<StructursDecisors.eigenvector.size(); j++){
                matriz[i][k]=(double) StructursDecisors.eigenvector.get(j);
                k++;
                if(j==aux-1){
                  i=i+1;
                  k=0;
                  aux=aux+cadencia;
                }
            }
        return matriz;
    }
    
    public double[] createArrayPesos(double [][]matrizDecisores, double[] eigenvectorCriterios){
        double pesos[]=new double[StructursDecisors.names.size()];
        for(int j=0; j<StructursDecisors.names.size(); j++)
            for(int i=0; i<Structurs.names.size(); i++){
                pesos[j]=pesos[j]+matrizDecisores[i][j]*eigenvectorCriterios[i];
            }
        for(int i=0 ; i<StructursDecisors.names.size(); i++)
            StructursDecisors.weightsDecisors.add(pesos[i]);
        return pesos;
    }
}
