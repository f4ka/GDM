/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RankingDecisors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author agustin
 */
public class JFreeChartRanking {
    public void getPanel(String nameFunction, double [][]parElements, JPanel panel){
        XYDataset data=generateData(nameFunction, parElements);
        JFreeChart diagram=createDiagram(data);
        ChartPanel chartPanel=new ChartPanel(diagram);
        chartPanel.setPreferredSize(new Dimension(500,400));
        chartPanel.setBounds(25, 25, 600, 420);
        chartPanel.setVisible(true);
        panel.add(chartPanel);
    } 
    private XYDataset generateData(String nameFunction, double [][]parElements){
        XYSeries data=new XYSeries(nameFunction);
        for(int i=0; i<parElements[0].length; i++){ //parElements es una matriz donde en la fila 0 tiene los x, y en la fila 1 tiene los ys
            data.add(parElements[0][i], parElements[1][i]);
        }
        XYSeriesCollection dataCollection = new XYSeriesCollection();
        dataCollection.addSeries(data);
        return dataCollection;
    }
    private JFreeChart createDiagram(XYDataset dataCollection){
                JFreeChart diag=ChartFactory.createXYLineChart("", //titulo
                                                        "Elementos",//leyenda del eje x
                                                        "Importancia",//leyenda del eje y
                                                        dataCollection, //DATOS
                                                        PlotOrientation.VERTICAL,
                                                        true, //VER TITULO DE LINEA
                                                        true, //tooltip
                                                        false); //URL
                XYPlot plot = diag.getXYPlot();
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
                renderer.setSeriesPaint(0, Color.WHITE);
                renderer.setSeriesStroke(0, new BasicStroke(6.0f));
                plot.setRenderer(renderer);
                plot.setBackgroundPaint(Color.DARK_GRAY);
                plot.setRangeGridlinesVisible(true);
                plot.setRangeGridlinePaint(Color.BLACK); 
                plot.setDomainGridlinesVisible(true);
                plot.setDomainGridlinePaint(Color.BLACK);
        return diag;
    }
}
