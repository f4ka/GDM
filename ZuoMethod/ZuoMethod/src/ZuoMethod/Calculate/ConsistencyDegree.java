
package ZuoMethod.Calculate;
import zuomethod.ZuoMethod;

/**
 *
 * @author faka
 */
public class ConsistencyDegree extends Similarity{

    public Double[] ConsistencyDegree(Double[] WeightsDecisors)
    {
        for(int k=0;k<WeightsDecisors.length;k++)
        {   
            ZuoMethod.ConsistencyDegreeDecisors[k] = 0.0;
            for(int i=0;i<ZuoMethod.SimilarityDegree.length;i++)
            {
                ZuoMethod.ConsistencyDegreeDecisors[k] = ZuoMethod.ConsistencyDegreeDecisors[k] + (ZuoMethod.SimilarityDegree[i] * WeightsDecisors[k]);
            }
        }
        return ZuoMethod.ConsistencyDegreeDecisors;
    }   
}
