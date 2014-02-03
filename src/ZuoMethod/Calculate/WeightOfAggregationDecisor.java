
package ZuoMethod.Calculate;
import Data.ZuoMethodData;

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
            ZuoMethodData.WeightAgregationsDecisors[i] = ConsistencyDegreeDecisors[i]/SummationConsistencyDegree;
        }
        return ZuoMethodData.WeightAgregationsDecisors;
    }
    
    public Double[] AgregationTotal(Double[] WeightAgregationsDecisors, Double[][] Trapezes)
    {
        for(int i=0;i<WeightAgregationsDecisors.length;i++)
        {
            for(int k=0;k<4;k++)
            {
                Trapezes[i][k] = (WeightAgregationsDecisors[i] * Trapezes[i][k]);
                ZuoMethodData.AgregationTotal[k] = 0.0;            
            }
        }
        for(int i=0;i<WeightAgregationsDecisors.length;i++)
        {
            for(int k=0;k<4;k++)
            {
                //System.out.println(WeightAgregationsDecisors[i]+" "+Trapezes[i][k]);
                ZuoMethodData.AgregationTotal[k] = RoundIt(ZuoMethodData.AgregationTotal[k] + Trapezes[i][k]);
                //System.out.println(ZuoMethod.AgregationTotal[k]);
            }
        }
        return ZuoMethodData.AgregationTotal;
    }
    
    
    public Double RoundIt(Double Number)
{
      return Math.rint(Number*100)/100;
}
}
