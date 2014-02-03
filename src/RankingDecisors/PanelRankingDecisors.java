/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RankingDecisors;

import Data.StructursDecisors;



public class PanelRankingDecisors extends javax.swing.JPanel {
   public PanelRankingDecisors(){
        initComponents();
        rkDecisors= new RankingDecisors();
        rkDecisors.CargaFichasCtaCte(jTable1, StructursDecisors.weightsDecisors, StructursDecisors.names);
        isCalculated=false;
        weightsFinal=new Double[StructursDecisors.weightsDecisors.size()];
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalPanelSaatyElements = new javax.swing.JPanel();
        btnCalculateNewWeights = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbFunctions = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(254, 254, 254));
        setMaximumSize(new java.awt.Dimension(902, 448));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(902, 488));

        internalPanelSaatyElements.setBackground(new java.awt.Color(254, 254, 254));
        internalPanelSaatyElements.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ranking pesos"));

        btnCalculateNewWeights.setBackground(new java.awt.Color(254, 254, 254));
        btnCalculateNewWeights.setText("Calcular nuevos Pesos");
        btnCalculateNewWeights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateNewWeightsActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);

        cmbFunctions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "y=x", "y=0.5*x+50", "y=(x^2)/100", "y=sqrt(100*x)" }));

        javax.swing.GroupLayout internalPanelSaatyElementsLayout = new javax.swing.GroupLayout(internalPanelSaatyElements);
        internalPanelSaatyElements.setLayout(internalPanelSaatyElementsLayout);
        internalPanelSaatyElementsLayout.setHorizontalGroup(
            internalPanelSaatyElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalPanelSaatyElementsLayout.createSequentialGroup()
                .addGroup(internalPanelSaatyElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, internalPanelSaatyElementsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(internalPanelSaatyElementsLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(internalPanelSaatyElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFunctions, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(internalPanelSaatyElementsLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnCalculateNewWeights)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        internalPanelSaatyElementsLayout.setVerticalGroup(
            internalPanelSaatyElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalPanelSaatyElementsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cmbFunctions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnCalculateNewWeights)
                .addGap(41, 41, 41))
        );

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Grafica de Funciones"));
        jPanel1.setMaximumSize(new java.awt.Dimension(630, 414));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 414));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 414));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(internalPanelSaatyElements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(internalPanelSaatyElements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateNewWeightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateNewWeightsActionPerformed
        double weights[][]=(rkDecisors.calculateNewWeights(StructursDecisors.weightsDecisors.size(), cmbFunctions.getSelectedIndex()));
        rkDecisors.loadNewWeights(jTable1, StructursDecisors.weightsDecisors, StructursDecisors.names, weights);
        jPanel1.removeAll();
        jPanel1.repaint();
        for(int i=0; i<weights[0].length; i++){
            System.out.println("Weihgts[0]["+i+"]="+weights[0][i]+"\nWeights[1]["+i+"]="+weights[1][i]);
        }
        JFreeChartRanking jf=new JFreeChartRanking();
        jf.getPanel(cmbFunctions.getSelectedItem().toString(), weights, jPanel1);
        for(int i=0; i<StructursDecisors.weightsDecisors.size();i++){
            weightsFinal[i]=weights[1][i];
        }
        isCalculated=true;
    }//GEN-LAST:event_btnCalculateNewWeightsActionPerformed
    RankingDecisors rkDecisors;
    public static Double []weightsFinal;
    public static boolean isCalculated;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateNewWeights;
    private javax.swing.JComboBox cmbFunctions;
    private javax.swing.JPanel internalPanelSaatyElements;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
