/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import ZuoMethod.Calculate.MainZuo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import Data.Trap;
import java.util.ArrayList;
/**
 *
 * @author agustin
 */
public class Ventana extends JPanel{
        private JTextField txtCentroGrav;
	private JTextField txtLongMenor;
	private JTextField txtPtoA;
	private JTextField txtPtoB;
	private JTextField txtPtoC;
	private JTextField txtPtoD;
        private JPanel pnlCalculate;
	private JPanel pnlChart;
        public Ventana() {
		super();
                Trap.cgs=new ArrayList();
                pnlCalculate = new JPanel();
                Trap.trapecios=(ArrayList<Trapecio>) new ArrayList();
                this.setLayout(null);
		setBounds(100, 100, 800, 319);
                setBackground(new java.awt.Color(254, 254, 254));
                pnlCalculate.setBounds(25, 65, 390, 450);
                pnlCalculate.setBackground(new java.awt.Color(254, 254, 254));
                pnlCalculate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Calculo de Similaridad"));
                pnlCalculate.setLayout(null);
		txtCentroGrav = new JTextField();
		txtCentroGrav.setBounds(200, 50, 150, 20);
		pnlCalculate.add(txtCentroGrav);
		txtCentroGrav.setColumns(10);


		JLabel lblCentrog = new JLabel("Centro de Gravedad");
		lblCentrog.setBounds(25, 50, 200, 14);
		pnlCalculate.add(lblCentrog);

		JLabel lblLongmenor = new JLabel("Longitud Menor");
		lblLongmenor.setBounds(25, 100, 200, 14);
		pnlCalculate.add(lblLongmenor);

		txtPtoA = new JTextField();
		txtPtoA.setEditable(false);
		txtPtoA.setBounds(150, 150, 86, 20);
		pnlCalculate.add(txtPtoA);
		txtPtoA.setColumns(10);

		txtPtoB = new JTextField();
		txtPtoB.setEditable(false);
		txtPtoB.setColumns(10);
		txtPtoB.setBounds(150, 190, 86, 20);
		pnlCalculate.add(txtPtoB);

		txtPtoC = new JTextField();
		txtPtoC.setEditable(false);
		txtPtoC.setColumns(10);
		txtPtoC.setBounds(150, 230, 86, 20);
		pnlCalculate.add(txtPtoC);

		txtPtoD = new JTextField();
		txtPtoD.setEditable(false);
		txtPtoD.setColumns(10);
		txtPtoD.setBounds(150, 270, 86, 20);
		pnlCalculate.add(txtPtoD);

		JLabel lblNewLabel = new JLabel("PtoA");
		lblNewLabel.setBounds(250, 150, 46, 14);
		pnlCalculate.add(lblNewLabel);

		JLabel lblPtob = new JLabel("PtoB");
		lblPtob.setBounds(250, 190, 46, 14);
		pnlCalculate.add(lblPtob);

		JLabel lblPtoc = new JLabel("PtoC");
		lblPtoc.setBounds(250, 230, 46, 14);
		pnlCalculate.add(lblPtoc);

		JLabel lblPtod = new JLabel("PtoD");
		lblPtod.setBounds(250, 270, 46, 14);
		pnlCalculate.add(lblPtod);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 100, 150, 20);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Por Defecto", "Personalizado"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == comboBox.getItemCount() - 1) {
					txtLongMenor = new JTextField();
					txtLongMenor.setBounds(211, 249, 86, 20);
					add(txtLongMenor);
					txtLongMenor.setColumns(10);
					txtLongMenor.setVisible(true);
				} else {

					txtLongMenor.setVisible(false);
					
				}
			}
		});
		pnlCalculate.add(comboBox);
		JButton btnCalcular = new JButton("Calcular Trapecio");
                btnCalcular.setBackground(new java.awt.Color(254, 254, 254));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                        eventGraficar();
                        }		
		});
		btnCalcular.setBounds(135, 340, 180, 23);
		pnlCalculate.add(btnCalcular);
		JButton btnLimpiar = new JButton("Limpiar");
                btnLimpiar.setBackground(new java.awt.Color(254, 254, 254));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCentroGrav.setText("");
				txtLongMenor.setText("");
				txtPtoA.setText("");
				txtPtoB.setText("");
				txtPtoC.setText("");
				txtPtoD.setText("");
			}
		});
		btnLimpiar.setBounds(135, 370, 180, 23);
		pnlCalculate.add(btnLimpiar);

		pnlChart = new JPanel();
		pnlChart.setBounds(425, 65, 575, 450);
		pnlChart.setLayout(new BorderLayout());
                pnlChart.setBackground(new java.awt.Color(254, 254, 254));
                pnlChart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Grafica de Trapecios"));
		add(pnlChart);
                JButton btnZuo = new JButton("Calcular Similaridad");
                btnZuo.setBackground(new java.awt.Color(254, 254, 254));
                btnZuo.setBounds(135, 400, 180, 23);
                btnZuo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         eventGraficarUltimoTrapecio();
                    } 
                });
                pnlCalculate.add(btnZuo);
                add(pnlCalculate);
	}

	public void graficarChart(JFreeChart chart) {
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 500));
		chartPanel.setMouseWheelEnabled(true);
		pnlChart.removeAll();
		pnlChart.add(chartPanel, BorderLayout.CENTER);
		pnlChart.validate();
		pnlChart.setVisible(true);
	}
        public void eventGraficar(){
            Trapecio trap;
				try {
                                        Trap.cgs.add(Double.parseDouble(txtCentroGrav.getText()));
					trap = Trapecio.crearTrapecioCentroGravedad(
					Double.parseDouble(txtCentroGrav.getText()));
					txtPtoA.setText(trap.getPtoA()[0] + "; "
							+ trap.getPtoA()[1]);
					txtPtoB.setText(trap.getPtoB()[0] + "; "
							+ trap.getPtoB()[1]);
					txtPtoC.setText(trap.getPtoC()[0] + "; "
							+ trap.getPtoC()[1]);
					txtPtoD.setText(trap.getPtoD()[0] + "; "
							+ trap.getPtoD()[1]);
					MainTrapecio.agregarTrapecio(trap);
                                        Trap.trapecios.add(trap);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Parse Error", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
        
        public void eventGraficarUltimoTrapecio(){
            MainZuo m = new MainZuo();
                         Trapecio trap;
                         try {          
					trap = Trapecio.crearTrapecioCentroGravedad(
					((m.main().getPtoC()[0]+m.main().getPtoB()[0])/2));
                                      //  System.out.println(trap.getPtoB()[0]);
                                      //  System.out.println(trap.getPtoC()[0]);
					txtPtoA.setText(m.main().getPtoA()[0] + "; "
							+ m.main().getPtoA()[1]);
					txtPtoB.setText(m.main().getPtoB()[0] + "; "
							+ m.main().getPtoB()[1]);
					txtPtoC.setText(m.main().getPtoC()[0] + "; "
							+ m.main().getPtoC()[1]);
					txtPtoD.setText(m.main().getPtoD()[0] + "; "
							+ m.main().getPtoD()[1]);
					Trap.trapecios.add(m.main());
                                        MainTrapecio.agregarTrapecio(m.main());
                                        
                                        
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Parse Error", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
                    }
        
}
