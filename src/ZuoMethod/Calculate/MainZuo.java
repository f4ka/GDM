/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ZuoMethod.Calculate;
import Data.StructursDecisors;
import Data.Trap;
import Data.ZuoMethodData;
import Graphics.Trapecio;
import java.util.ArrayList;
/**
 *
 * @author agustin
 */
public class MainZuo {
        Double [][] Trapezes;
        Double [] GravityCenters;
        Double [] WeightsDecisors;  
        
       public Trapecio main(){
        //Trapezes = {{8.0,8.5,9.5,10.0,1.0},{1.2,2.15,4.05,5.0,1.0},{5.0,5.25,5.75,6.0,1.0},{5.0,6.25,8.75,10.0,1.0}};
        //GravityCenters = {9.0,3.1,5.5,7.5};
        //WeightsDecisors = {0.260,0.202,0.217,0.321};
        
        Trapecio trapecioAux;
        double auxA[]=new double[2];
        double auxB[]=new double[2];
        double auxC[]=new double[2];
        double auxD[]=new double[2];    
        
        ordenarTrapecios();
        ZuoMethodData.SimilarityDegree = new Double[GravityCenters.length-1];
        ZuoMethodData.ConsistencyDegreeDecisors = new Double[WeightsDecisors.length];
        ZuoMethodData.WeightAgregationsDecisors = new Double[WeightsDecisors.length];
        ZuoMethodData.AgregationTotal = new Double[4];
        
        Similarity s = new Similarity();
        
        ZuoMethodData.SimilarityDegree = s.Similarity(Trapezes,GravityCenters,WeightsDecisors.length);//el 4 es el numero de trapecios
        

        
        ConsistencyDegree c = new ConsistencyDegree();
        ZuoMethodData.ConsistencyDegreeDecisors = c.ConsistencyDegree(WeightsDecisors);
       
        WeightOfAggregationDecisor w = new WeightOfAggregationDecisor();
        ZuoMethodData.WeightAgregationsDecisors = w.WeightOfAggregationDecisor(ZuoMethodData.ConsistencyDegreeDecisors);
        
        ZuoMethodData.AgregationTotal = w.AgregationTotal(ZuoMethodData.WeightAgregationsDecisors, Trapezes);
                /*for(int sx=0;sx<ZuoMethodData.AgregationTotal.length;sx++)
                {
                    System.out.println(ZuoMethodData.AgregationTotal[sx]);
                }*/
        auxA[0]=ZuoMethodData.AgregationTotal[0];
        auxA[1]=0.0;
        auxB[0]=ZuoMethodData.AgregationTotal[1];
        auxB[1]=1.0;
        auxC[0]=ZuoMethodData.AgregationTotal[2];
        auxC[1]=1.0;
        auxD[0]=ZuoMethodData.AgregationTotal[3];
        auxD[1]=0.0;
        trapecioAux=new Trapecio(auxA, auxB, auxC, auxD);
        return trapecioAux;
            
       }
       
       
       /**
     *
     * @param Trapecios
     * @return
     */
    public double encontrarMax(ArrayList<Trapecio> Trapecios){
          double max=0;
           for(int i=0; i<Trapecios.size(); i++){
              if(max<Trapecios.get(i).getPtoD()[0])
                  max= Trapecios.get(i).getPtoD()[0];
          }
            return max;
       }
       
       public  void ordenarTrapecios(){
           int n=Trap.trapecios.size();
           double max=1.0;
           Trapezes = new Double[n][5];
           for(int i=0 ; i<n; i++)
           {
               Trapezes[i][0]=Trap.trapecios.get(i).getPtoA()[0];
               Trapezes[i][1]=Trap.trapecios.get(i).getPtoB()[0];
               Trapezes[i][2]=Trap.trapecios.get(i).getPtoC()[0];
               Trapezes[i][3]=Trap.trapecios.get(i).getPtoD()[0];
               Trapezes[i][4]=1.00;
            }
           max=encontrarMax(Trap.trapecios);
           
          for(int i=0; i<n; i++)
          {
              Trap.trapecios.get(i).setPtoA((Trap.trapecios.get(i).getPtoA()[0]/max), 0.0);
              Trap.trapecios.get(i).setPtoB((Trap.trapecios.get(i).getPtoB()[0]/max), 1.0);
              Trap.trapecios.get(i).setPtoC((Trap.trapecios.get(i).getPtoC()[0]/max), 1.0);
              Trap.trapecios.get(i).setPtoD((Trap.trapecios.get(i).getPtoD()[0]/max), 0.0);
              System.out.println(Trap.trapecios.get(i).getPtoA()[0]/max);
              System.out.println(Trap.trapecios.get(i).getPtoB()[0]/max);
              System.out.println(Trap.trapecios.get(i).getPtoC()[0]/max);
              System.out.println(Trap.trapecios.get(i).getPtoD()[0]/max);
          }
           
           GravityCenters = new Double[Trap.cgs.size()];
           for(int i=0; i<Trap.cgs.size(); i++)
               GravityCenters[i]=(Double) Trap.cgs.get(i);
           WeightsDecisors= new Double[StructursDecisors.weightsDecisors.size()];
           for(int i=0; i<StructursDecisors.weightsDecisors.size();i++)
               WeightsDecisors[i]=(Double) StructursDecisors.weightsDecisors.get(i);
           
        }
       
}

