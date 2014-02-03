/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SaatyDecisors.GUI;

import Data.StructursDecisors;

/**
 *
 * @author agustin
 */
public class DecisorsMatrix {
   int n;
   public DecisorsMatrix(){
      StructursDecisors.A=new double[StructursDecisors.names.size()][StructursDecisors.names.size()];
      n=StructursDecisors.A.length;
      for(int i=0; i<n; i++)
              StructursDecisors.A[i][i]=1;
   }
   
   public void createMatrix(){
       int k=0;
       for (int i = 0; i < n; i++) {
	 for (int j = (i + 1); j < n; j++) {
                order(StructursDecisors.names.get(i), StructursDecisors.names.get(j), StructursDecisors.values[k]);
                k++;
            }
	}
       for(int i=0; i<n; i++)
           for(int j=0; j<n; j++)
               System.out.println("A["+i+"]["+j+"]="+StructursDecisors.A[i][j]);
   }
  public void order(String name1, String name2, double value){
       int index1=StructursDecisors.names.indexOf(name1);
       int index2=StructursDecisors.names.indexOf(name2);
       StructursDecisors.A[index1][index2] = value;
       StructursDecisors.A[index2][index1] = 1 / value;
   }
   
}
