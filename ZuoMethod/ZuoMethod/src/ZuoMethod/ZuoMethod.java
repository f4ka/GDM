
package zuomethod;
import ZuoMethod.Calculate.ConsistencyDegree;
import ZuoMethod.Calculate.Similarity;
import ZuoMethod.Calculate.WeightOfAggregationDecisor;
/**
 *
 * @author faka
 */
public class ZuoMethod {
    public static Double[] SimilarityDegree,ConsistencyDegreeDecisors,WeightAgregationsDecisors,AgregationTotal;
    
    public static void main(String[] args) {
        
        Double[][] Trapezes = {{8.0,8.5,9.5,10.0,1.0},{1.2,2.15,4.05,5.0,1.0},{5.0,5.25,5.75,6.0,1.0},{5.0,6.25,8.75,10.0,1.0}};
        Double[] GravityCenters = {9.0,3.1,5.5,7.5};
        Double[] WeightsDecisors = {0.260,0.202,0.217,0.321};
        
        SimilarityDegree = new Double[GravityCenters.length-1];
        ConsistencyDegreeDecisors = new Double[WeightsDecisors.length];
        WeightAgregationsDecisors = new Double[WeightsDecisors.length];
        AgregationTotal = new Double[4];
        
        Similarity s = new Similarity();
        SimilarityDegree = s.Similarity(Trapezes,GravityCenters,WeightsDecisors.length);//el 4 es el numero de trapecios
        
        if(s.CheckWeights(WeightsDecisors))
            WeightsDecisors = s.NormalizationWeights(WeightsDecisors);
        
        ConsistencyDegree c = new ConsistencyDegree();
        ConsistencyDegreeDecisors = c.ConsistencyDegree(WeightsDecisors);
       
        WeightOfAggregationDecisor w = new WeightOfAggregationDecisor();
        WeightAgregationsDecisors = w.WeightOfAggregationDecisor(ConsistencyDegreeDecisors);
        
        AgregationTotal = w.AgregationTotal(WeightAgregationsDecisors, Trapezes);
                for(int sx=0;sx<AgregationTotal.length;sx++)
                {
                    System.out.println(AgregationTotal[sx]);
                }
    }
    
}
