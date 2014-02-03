/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SaatyDecisors.GUI;

import Data.Structurs;
import Data.StructursDecisors;
import java.util.ArrayList;


public class RollBack {
    public void showEigenvector(){
        for(int i=0; i<StructursDecisors.eigenvector.size();i++)
            System.out.println("Eigenvector ["+i+"]="+StructursDecisors.eigenvector.get(i));
    }
    public void deleteLastsRecordsAddedEigenvector(){
        int sizeEig=StructursDecisors.eigenvector.size();
        for(int i=sizeEig-1; i>=(sizeEig-Structurs.A.length-1); i--){
            StructursDecisors.eigenvector.remove(i);
        }
    }
    
    public int contElements(){
        int cont=1;
        for (int i=0; i < StructursDecisors.names.size(); i++)
                for (int j = (i + 1); j < StructursDecisors.names.size(); j++) 
                    cont=cont++;
        return cont;
    }
}
