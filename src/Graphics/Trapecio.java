/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author agustin
 */
public class Trapecio {

	private static int m=5;
	private double[] ptoA = new double[2];
	private double[] ptoB = new double[2];
	private double[] ptoC = new double[2];
	private double[] ptoD = new double[2];
	
	
	public Trapecio(double[] ptoA, double[] ptoB, double[] ptoC, double[] ptoD) {
	
		this.ptoA = ptoA;
		this.ptoB = ptoB;
		this.ptoC = ptoC;
		this.ptoD = ptoD;
	}


	public double[] getPtoA() {
		return ptoA;
	}

        public void setPtoA(double ptoA0, double ptoA1) {
		this.ptoA[0]=ptoA0;
                this.ptoA[1]=ptoA1;
	}
        public void setPtoB(double ptoB0, double ptoB1) {
		this.ptoB[0]=ptoB0;
                this.ptoB[1]=ptoB1;
	}
        public void setPtoC(double ptoC0, double ptoC1) {
		this.ptoC[0]=ptoC0;
                this.ptoC[1]=ptoC1;
	}
        public void setPtoD(double ptoD0, double ptoD1) {
		this.ptoD[0]=ptoD0;
                this.ptoD[1]=ptoD1;
	}
	public void setPtoA(double[] ptoA) {
		this.ptoA = ptoA;
	}


	public double[] getPtoB() {
		return ptoB;
	}


	public void setPtoB(double[] ptoB) {
		this.ptoB = ptoB;
	}


	public double[] getPtoC() {
		return ptoC;
	}


	public void setPtoC(double[] ptoC) {
		this.ptoC = ptoC;
	}


	public double[] getPtoD() {
		return ptoD;
	}


	public void setPtoD(double[] ptoD) {
		this.ptoD = ptoD;
	}
	
	public static Trapecio crearTrapecioCentroGravedad(double centroGravedad) throws Exception{
		
		if(centroGravedad>2*m || centroGravedad<0){
			throw new Exception("centro de gravedad mayor a m, o menor a 0");
		}

		double valores[] = new double[4];
		valores = obtenerDistanciaCercana(centroGravedad,valores);
		double[] ptoA = {valores[0],0};
		double[] ptoD = {valores[3],0};
		double[] ptoB = {valores[1],1};
		double[] ptoC = {valores[2],1};
		return(new Trapecio(ptoA,ptoB,ptoC,ptoD));
		
	}


	private static double[] obtenerDistanciaCercana(double centroGravedad, double[] valores) {
				
		if(centroGravedad-m>0){
			double bMayor= 2*Math.min(Math.abs(centroGravedad-m),Math.abs(2*m-centroGravedad));
			valores[0] = centroGravedad - bMayor/2;
			valores[3] = centroGravedad + bMayor/2;
			double bMenor= Math.min(Math.abs(centroGravedad-m),Math.abs(2*m-centroGravedad));
			valores[1] = centroGravedad - bMenor/2;
			valores[2] = centroGravedad + bMenor/2;
			return(valores);
		}else{
			double bMayor= 2*Math.min(Math.abs(m-centroGravedad),Math.abs(centroGravedad-0));
			valores[0] = centroGravedad - bMayor/2;
			valores[3] = centroGravedad + bMayor/2;
			double bMenor= Math.min(Math.abs(m-centroGravedad),Math.abs(centroGravedad-0));
			valores[1] = centroGravedad - bMenor/2;
			valores[2] = centroGravedad + bMenor/2;
			return(valores);
			
		}
	}
	
    public static JFreeChart graficarTrapecios(ArrayList<Trapecio> trapecios) {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		for(int i=0; i<trapecios.size(); i++){

		XYSeries series = new XYSeries("Trapecio "+ (i+1), false, true);
		
		series.add(trapecios.get(i).getPtoA()[0], trapecios.get(i).getPtoA()[1]);
		series.add(trapecios.get(i).getPtoB()[0], trapecios.get(i).getPtoB()[1]);
		series.add(trapecios.get(i).getPtoC()[0], trapecios.get(i).getPtoC()[1]);
		series.add(trapecios.get(i).getPtoD()[0], trapecios.get(i).getPtoD()[1]);
		series.add(trapecios.get(i).getPtoA()[0], trapecios.get(i).getPtoA()[1]);

		
		dataset.addSeries(series);
		
		}
		JFreeChart chart = ChartFactory.createXYLineChart("",
				"x", "y", dataset, PlotOrientation.VERTICAL, true,
				true, false);

                XYPlot plot = chart.getXYPlot();
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
                renderer.setSeriesPaint(trapecios.size()-1, Color.WHITE);
                renderer.setSeriesStroke(trapecios.size()-1, new BasicStroke(6.0f));
                plot.setRenderer(renderer);
                plot.setBackgroundPaint(Color.DARK_GRAY);
                plot.setRangeGridlinesVisible(true);
                plot.setRangeGridlinePaint(Color.BLACK); 
                plot.setDomainGridlinesVisible(true);
                plot.setDomainGridlinePaint(Color.BLACK);
		/*
		 * ChartFrame frame = new ChartFrame("prueba", chart);
		 * frame.setVisible(true); frame.setSize(300,300);
		 */

		return (chart);
	}
}
    

