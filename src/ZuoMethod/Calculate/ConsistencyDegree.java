
package ZuoMethod.Calculate;
import Data.ZuoMethodData;

/**
 *
 * @author faka
 */
public class ConsistencyDegree extends Similarity{

    public Double[] ConsistencyDegree(Double[] WeightsDecisors)
    {
        for(int k=0;k<WeightsDecisors.length;k++)
        {   
            ZuoMethodData.ConsistencyDegreeDecisors[k] = 0.0;
            for(int i=0;i<ZuoMethodData.SimilarityDegree.length;i++)
            {
                ZuoMethodData.ConsistencyDegreeDecisors[k] = ZuoMethodData.ConsistencyDegreeDecisors[k] + (ZuoMethodData.SimilarityDegree[i] * WeightsDecisors[k]);
            }
        }
        return ZuoMethodData.ConsistencyDegreeDecisors;
    }   
}
