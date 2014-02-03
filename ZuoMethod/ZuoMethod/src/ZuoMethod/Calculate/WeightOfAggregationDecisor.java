
package ZuoMethod.Calculate;
import zuomethod.ZuoMethod;

/**
 *
 * @author faka
 */
public class WeightOfAggregationDecisor {
    public Double[] WeightOfAggregationDecisor(Double[] ConsistencyDegreeDecisors)
    {
        Double SummationConsistencyDegree =0.0;
        for(int i=0;i<ConsistencyDegreeDecisors.length;i++)
        {
            SummationConsistencyDegree = SummationConsistencyDegree + ConsistencyDegreeDecisors[i];
        }
        for(int i=0;i<ConsistencyDegreeDecisors.length;i++)
        {
            ZuoMethod.WeightAgregationsDecisors[i] = ConsistencyDegreeDecisors[i]/SummationConsistencyDegree;
        }
        return ZuoMethod.WeightAgregationsDecisors;
    }
    
    public Double[] AgregationTotal(Double[] WeightAgregationsDecisors, Double[][] Trapezes)
    {
        for(int i=0;i<WeightAgregationsDecisors.length;i++)
        {
            for(int k=0;k<4;k++)
            {
                ZuoMethod.AgregationTotal[k] = 0.0;
                ZuoMethod.AgregationTotal[k]= RoundIt(ZuoMethod.AgregationTotal[k] + (WeightAgregationsDecisors[i] * Trapezes[i][k]));
            }
        }
        return ZuoMethod.AgregationTotal;
    }
    
    
    public Double RoundIt(Double Number)
{
      return Math.rint(Number*100)/100;
}
}
