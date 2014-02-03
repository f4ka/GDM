/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Saaty.Criteria;

import Data.Structurs;

/**
 *
 * @author agustin
 */
public class Matrix {
   int n;
   int length;
   public Matrix(){
      Structurs.A=new double[Structurs.names.size()][Structurs.names.size()];
      n=Structurs.A.length;
      length=Structurs.elements.size();
      for(int i=0; i<n; i++)
              Structurs.A[i][i]=1;
   }
   
   public void createMatrix(){
       int k=0;
       for (int i = 0; i < n; i++) {
	 for (int j = (i + 1); j < n; j++) {
                order(Structurs.names.get(i), Structurs.names.get(j), Structurs.values[k]);
                k++;
            }
	}
     //  for(int i=0; i<n; i++)
     //      for(int j=0; j<n; j++)
           //    System.out.println("A["+i+"]["+j+"]="+Structurs.A[i][j]);
   }
  public void order(String name1, String name2, double value){
       int index1=Structurs.names.indexOf(name1);
       int index2=Structurs.names.indexOf(name2);
       Structurs.A[index1][index2] = value;
       Structurs.A[index2][index1] = 1 / value;
   }
   
}
