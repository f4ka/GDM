
package Saaty.Criteria;
import Data.Structurs;

public class Consistence {
    double A1[][], sumCols[], eigenvector[];
    int n, i, j;
     public boolean calculateConsistence(){
        n=Structurs.A.length;
        A1=new double [n][n];
        eigenvector=new double[n]; //vector W
        Matrix matrix = new Matrix();
        RI ri=new RI();
        double consistence;
        matrix.calculateSum();
        matrix.createMatriXA1();
        matrix.createEigenvector();
        consistence=ri.calculateRI();
        System.out.println(consistence);
        if(consistence<=0.1) return true;
        else return false;
    }
    public class Matrix{
    //CALCULAR LA SUMA DE CADA COLUMNA DE LA MATRIZ
    public void calculateSum(){
        sumCols=new double[n];
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                sumCols[j]=sumCols[j]+Structurs.A[i][j];
    }
    //CALCULAR LA DIVISION DE CADA ELEMENTO EN CADA UNO DE LOS ELEMENTOS SUMADOS, CREANDO LA MATRIZ A1
    public void createMatriXA1(){
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                A1[i][j]=Structurs.A[i][j]/sumCols[j];
        
    }
    //CALCULAR EL EIGENVECTOR
    public void createEigenvector(){
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                 eigenvector[i]=eigenvector[i]+A1[i][j];
        for(i=0; i<n; i++)
            eigenvector[i]=eigenvector[i]/n;
        for(i =0 ; i<n; i++)
            Structurs.eigenvector.add(eigenvector[i]);
    }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public class IC{
    //Calcular el indice de consistencia IC=(LANDAMAX-N)/(N-1)
    public double calculateIC(){
        double IC=0;
        double landaMax[]=calculateLandaMax(calculateAW());
        double landaAVG=calculateLandaAVG(landaMax);
        IC=(landaAVG-n)/(n-1);
        return IC;
    }
    //Calucular el producto de la matriz A con el eigenvector, AW  debido a que AW=LANDAMAX*W
    public double[] calculateAW(){
        int k=0;
        double AW[]=new double[n];
        for(i=0; i<n; i++){
            k=0;
            for(j=0; j<n; j++){
                AW[i]=AW[i]+Structurs.A[i][j]*eigenvector[k];
                k++;
            }
        }
        return AW;
    }
    public double[] calculateLandaMax(double AW[]){
        double landaMax[]=new double[n];
        for(i=0; i<n; i++)
            landaMax[i]=AW[i]/eigenvector[i];
        return landaMax;
    }
    //Calcular el promedio de landa max
    public double calculateLandaAVG(double landaMax[]){
        double landaAVG = 0;
        for(i=0; i<n; i++)
            landaAVG=landaAVG+landaMax[i];
        landaAVG=landaAVG/((double)n);
        return landaAVG;
    }
    }
    public class RI{
        public double calculateRI(){
            IC ic=new IC();
            System.out.println("CA:"+Structurs.CA[n-1]);
            double RI=ic.calculateIC()/Structurs.CA[n-1];
            return RI;
        }
    }
    
}

