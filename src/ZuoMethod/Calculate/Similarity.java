
package ZuoMethod.Calculate;
import Data.ZuoMethodData;
/**
 *
 * @author faka
 */
public class Similarity {
    Double[] Perimeters,Areas,SumPairs,Exponents;
    public static Double Maximum;
    Double [][] xn;
    public Double[] Similarity(Double[][] Trapezes,Double GravityCenters[], int NumberTrapezes)
    {
        Maximum = FindMaxValue(Trapezes,NumberTrapezes);
        if(CheckTrapecios(Trapezes, NumberTrapezes))
        {
            Trapezes = NormalizatioNumberTrapezeswo(Trapezes, NumberTrapezes, Maximum);
        }        
        if(CheckGravityCenters(GravityCenters))
        {
            GravityCenters = NormalizationGravityCenters(GravityCenters);
        }
            
        SumPairs = SumPairs(Trapezes,NumberTrapezes);
        Exponents =  Exponent(GravityCenters,NumberTrapezes); 
        Perimeters = Perimeter(Trapezes,NumberTrapezes);
        Areas = Area(Trapezes,NumberTrapezes);
        
        for(int i=0;i<NumberTrapezes-1;i++)
        {
        ZuoMethodData.SimilarityDegree[i] = Math.pow((1 - (SumPairs[i]/4)),Exponents[i]);

        Double num =  (Math.min(Perimeters[0], Perimeters[i+1]) + Math.min(Areas[0], Areas[i+1]));
        Double den =  (Math.max(Perimeters[0], Perimeters[i+1]) + Math.max(Areas[0], Areas[i+1]));
        ZuoMethodData.SimilarityDegree[i] = ZuoMethodData.SimilarityDegree[i] * (num/den);
        }
        return ZuoMethodData.SimilarityDegree;
    }
    
    private Double[] SumPairs(Double[][] Trapezes, int NumberTrapezes)
    {
       SumPairs = new Double[NumberTrapezes-1];
       for(int i=0;i<NumberTrapezes-1;i++)
       {
           SumPairs[i] = 0.0;
           for(int k=0;k<4;k++)
           {
               SumPairs[i] = SumPairs[i] + Math.abs(Trapezes[0][k]-Trapezes[i+1][k]);
           }
       }
       return SumPairs;
    }
    
    private Double[] Exponent(Double[] GravityCenters, int NumberTrapezes)
    {
        Exponents = new Double[NumberTrapezes-1];
        for(int i=0;i<NumberTrapezes-1;i++)
        {
            Exponents[i] = Math.abs(GravityCenters[0]-GravityCenters[i+1]);
            Exponents[i] = 1-Exponents[i];
        }
        return Exponents;
    }
    
    private Double[] Perimeter(Double[][] Trapezes, int NumberTrapezes)
    {
        Perimeters = new Double[NumberTrapezes];
        for(int i=0;i<NumberTrapezes;i++)
        {
            Perimeters[i] = Math.sqrt(Math.pow(Trapezes[i][0]-Trapezes[i][1],2) + Math.pow(Trapezes[i][4], 2));
            Perimeters[i] = Perimeters[i] + Math.sqrt(Math.pow(Trapezes[i][2]-Trapezes[i][3],2) + Math.pow(Trapezes[i][4], 2));
            Perimeters[i] = Perimeters[i] + (Trapezes[i][2]-Trapezes[i][1]) + (Trapezes[i][3]-Trapezes[i][0]);
        }
        return Perimeters;
    }
    
    private Double[] Area(Double[][] Trapezes, int NumberTrapezes)
    {
        Double k=0.5;
        Areas = new Double[NumberTrapezes];
        for(int i=0;i<NumberTrapezes;i++)
        {
            Areas[i] = ((k)*((Trapezes[i][1]-Trapezes[i][0])+(Trapezes[i][3]-Trapezes[i][2]))*Trapezes[i][4]) + (Trapezes[i][2]-Trapezes[i][1])*Trapezes[i][4];
        }
        return Areas;
    }
    
    private Double[][] Normalization(Double[][] Trapezes,int index)
    {
        xn = new Double[2][4];
        for(int i=0;i<4;i++)
        {
        xn[0][i] = (Trapezes[0][i] - Math.min(Trapezes[0][0],Trapezes[index][0]))/(Math.max(Trapezes[0][3], Trapezes[index][3]) - Math.min(Trapezes[0][0], Trapezes[index][0]));
        xn[1][i] = (Trapezes[index][i] - Math.min(Trapezes[0][0],Trapezes[index][0]))/(Math.max(Trapezes[0][3], Trapezes[index][3]) - Math.min(Trapezes[0][0], Trapezes[index][0]));
        }
        return xn;
    }
    
    private boolean CheckTrapecios(Double[][] Trapezes, int NumberTrapezes)
    {
        boolean x=false;
        for(int i=0;i<NumberTrapezes;i++)
        {
            for(int k=0;k<4;k++)
            {
                if(Trapezes[i][k]>1)
                    x=true;
            }
        }
        return x;
    }
    
    private Double FindMaxValue(Double[][] Trapezes, int NumberTrapezes)
    {
        Double x = 0.0;
        for(int i=0;i<NumberTrapezes;i++)
        {
            for(int k=0;k<3;k++)
            {
                Double max = Math.max(Trapezes[i][k],Trapezes[i][k+1]);
                if(x<max)
                {
                    x = max;
                }
            }
        }
        return x;
    }
    
    private Double[][] NormalizatioNumberTrapezeswo(Double[][] Trapezes, int NumberTrapezes, Double Max)
    {
        for(int i=0;i<NumberTrapezes;i++)
        {
            for(int k=0;k<4;k++)
            {
                    Trapezes[i][k] = Trapezes[i][k]/Max;
            }
        }
        return Trapezes;
    }
    
    public boolean CheckGravityCenters(Double[] GravityCenters)
    {
        boolean x=false;
        for(int i=0;i<GravityCenters.length;i++)
        {
            if(GravityCenters[i]>1)
                x=true;
        }
        return x;
    }
    
    public Double[] NormalizationGravityCenters(Double[] GravityCenters)
    {
        for(int i=0;i<GravityCenters.length;i++)
        {
            GravityCenters[i] = GravityCenters[i]/Maximum;
        }
        return GravityCenters;
    }    
}
