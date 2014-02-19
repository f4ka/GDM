/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Data.Structurs;
import Data.StructursDecisors;
import Graphics.MainTrapecio;
import Graphics.Trapecio;
import RankingDecisors.PanelRankingDecisors;
import SaatyDecisors.GUI.*;
import Saaty.Criteria.PanelSaatyMatriz;
import Saaty.Criteria.saatyGuiEvents;
import Transforming.PesosFinalesSaty;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.UIManager;


public class FramePpal extends javax.swing.JFrame {

    public FramePpal() {
        ScreenSplash sc=new ScreenSplash();
        sc.animar();
        saatyEvents=new saatyGuiEvents();
        initComponents();
        this.setBounds(0, 0, 1024, 600);
        panels=new ArrayList();
        panelSaaty= new PanelSaatyMatriz();
        panelSaaty.setBounds(20, 60, 1000, 470);
        consistenceDecisors= new DecisorsConsistence();
        //panels.add(panelSaaty);
        /////////////////////////////////////////////////////////////////
        this.add(panelSaaty);
        this.getContentPane().setLayout(null);
        mainTrap=new MainTrapecio(this);
        datas = new Structurs();
        index=-1; //numero de panel seleccionado
        i=0;
        isPanelsCreated=false; //estan creados los paneles ? falso///////////////////////
        Structurs.elements = new ArrayList();
        Structurs.names=new ArrayList();
        StructursDecisors.names=new ArrayList();
        Structurs.elements = new ArrayList();
        /////////
        eventsDecisors= new DecisorsSaatyGuiEvents();
        /////////////////////////Title
        lblTitle=new JLabel("Asignación de Criterios");
        lblTitle.setFont(new Font("Andele Mono", Font.BOLD, 25));
        lblTitle.setBounds(32, 25, 400, 40);
        this.add(lblTitle);
        ////////////bton Next//////////////////////////////
        btnNext.setBounds(520, 530, 85, 30);
        btnNext.setBackground(new java.awt.Color(254, 254, 254));
        btnNext.setVisible(true);
        this.add(btnNext);
        //////////Boton Previous/////////////////////////7
        btnPrevious.setBounds(420, 530, 85, 30);
        btnPrevious.setBackground(new java.awt.Color(254, 254, 254));
        btnPrevious.setVisible(false);
        this.add(btnPrevious);
        boolConsistenceDecisors=true;
        rollBack=new RollBack();
        isActiveRanking=false;
        isCalculated=false;
        img_unsta2.setVisible(false);
        getContentPane().setBackground(new java.awt.Color(254, 254, 254));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        img_unsta1 = new javax.swing.JLabel();
        img_unsta2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("<<");
        btnPrevious.setPreferredSize(new java.awt.Dimension(35, 27));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        img_unsta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unsta2.png"))); // NOI18N

        img_unsta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Selección_010.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(btnNext)
                        .addGap(0, 0, 0)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(img_unsta2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img_unsta1)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNext)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img_unsta1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_unsta2)))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(saatyEvents.callCalculateConsistence()){
            int n=Structurs.names.size();
            if(i<n){
                if(i==0){
                    UIManager UI=new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    UI.put("Button.background", Color.white);
                    decisorsno=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de decisores:"));
                    StructursDecisors.names=new ArrayList();
                    StructursDecisors.elements=new JSlider[Structurs.names.size()][];
                    for(int j=0; j<decisorsno; j++){
                        String aux=JOptionPane.showInputDialog("Ingrese el decisor "+(j+1)+":");
                        StructursDecisors.names.add(aux);
                    }
                    StructursDecisors.eigenvector=new ArrayList();
                    nextPanel();
                    img_unsta1.setVisible(false);
                    img_unsta2.setVisible(true);
                    btnNext.setLocation(310, 530);
                    btnPrevious.setLocation(210, 530);
                }
                else{
                        panelsDecisorsNoCriteria();
                    }
                }
            else{
                if(i==n){
                    goToPanelRankingDecisors(n);
                    i++;
                }
                else{
                    goToPanelGraphics();
                }
            }
        }
        else{
              JOptionPane.showMessageDialog(null, "La consistencia es mayor a 0.1, por favor reingrese los valores", "Error de Consistencia", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if(i>1)
        {
            if(i<Structurs.names.size()){
                rollBack.deleteLastsRecordsAddedEigenvector();
                rollBack.showEigenvector();
                panels.get(i-1).setVisible(false);
                i--;
                lblTitle.setText(Structurs.names.get(i-1));
                panels.get(i-1).setVisible(true);
            }
            else{
                if(i>Structurs.names.size()){
                    MainTrapecio.ventana.setVisible(false);
                    mainTrap=new MainTrapecio(this);
                    MainTrapecio.trapecios= new ArrayList<>();
                    panelRankingDecisors.setVisible(true);
                }
            }
        }
        }//GEN-LAST:event_btnPreviousActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePpal().setVisible(true);
            }
        });
    }
    private void goToPanelGraphics(){
        isCalculated=PanelRankingDecisors.isCalculated;
        panelRankingDecisors.setVisible(false);
        if(isCalculated==true){
            int selection = JOptionPane.showOptionDialog(
                                       this, // Componente padre
                                       "¿Desea usar los nuevos pesos calculados?", //Mensaje
                                       "Seleccion de pesos", // Título
                                       JOptionPane.YES_NO_CANCEL_OPTION,
                                       JOptionPane.QUESTION_MESSAGE,
                                       null,    // null para icono por defecto.
                                       new Object[] { "Si", "No", "Cancelar"},    // null para YES, NO y CANCEL
                                       "Si");
            if(selection!=-1){
                if((selection+1)==1){
                    weightsFinal=PanelRankingDecisors.weightsFinal;
                    int n=StructursDecisors.weightsDecisors.size();
                    StructursDecisors.weightsDecisors=new ArrayList();
                    for(int j=0; j<n; j++)
                        StructursDecisors.weightsDecisors.add(weightsFinal[j]);
                    MainTrapecio.ventana.setVisible(true);   
                }
                else{
                    MainTrapecio.ventana.setVisible(true);   
                }
            }
        }
        else{
          MainTrapecio.ventana.setVisible(true);   
        }
    }
    private void goToPanelRankingDecisors(int n){
        for(int j=0; j<StructursDecisors.elements[i-1].length; j++)
                    StructursDecisors.values[j]=eventsDecisors.getValueImportance(StructursDecisors.elements[i-1][j].getValue());
                matrixDecisors=new DecisorsMatrix();
                matrixDecisors.createMatrix();
                boolConsistenceDecisors=consistenceDecisors.calculateConsistence();
                PesosFinalesSaty p = new PesosFinalesSaty();
                p.calcularPesos();
                for(int i=0; i<StructursDecisors.weightsDecisors.size(); i++)
                    System.out.println("Peso Decisor ["+i+"]="+StructursDecisors.weightsDecisors.get(i));
                panels.get(n-1).setVisible(false);
                panelRankingDecisors = new PanelRankingDecisors();
                this.add(panelRankingDecisors);
                panelRankingDecisors.setBounds(20, 60, 1000, 500);
                panelRankingDecisors.setVisible(true);
                lblTitle.setVisible(false);
                img_unsta1.setVisible(true);
                img_unsta2.setVisible(false);
                isActiveRanking=true;
    }
    public void nextPanel(){
       
        this.panelSaaty.setVisible(false);    
        //StructursDecisors.elements=new ArrayList();
        StructursDecisors.A=new double[StructursDecisors.names.size()][StructursDecisors.names.size()];
        PanelSaatyDecisorsMatriz m = new PanelSaatyDecisorsMatriz(i);
        this.add(m);
        m.setBounds(20, 50, 902, 470);
        panels.add(m);
        m.setVisible(true);
        lblTitle.setText("Criterio: "+Structurs.names.get(i));
        btnPrevious.setVisible(true);
        this.add(m);
        i++; 
    }
    public void panelsDecisorsNoCriteria(){
                StructursDecisors.values= new double[StructursDecisors.elements[i-1].length];
                for(int j=0; j<StructursDecisors.elements[i-1].length; j++)
                    StructursDecisors.values[j]=eventsDecisors.getValueImportance(StructursDecisors.elements[i-1][j].getValue());
                matrixDecisors=new DecisorsMatrix();
                matrixDecisors.createMatrix();
                boolConsistenceDecisors=consistenceDecisors.calculateConsistence();
             if(boolConsistenceDecisors){
                panels.get(i-1).setVisible(false);
                nextPanel();
              }
             else{
                 JOptionPane.showMessageDialog(null, "La consistencia de los decisores respecto a este criterio es superior a 0.1", "Consistencia>0.1", JOptionPane.ERROR_MESSAGE);
                 rollBack.deleteLastsRecordsAddedEigenvector();                 
                }
    }
    
    Structurs datas;
    MainTrapecio mainTrap;
    ArrayList <PanelSaatyDecisorsMatriz> panels;
    PanelSaatyMatriz panelSaaty;
    int index;
    DecisorsSaatyGuiEvents eventsDecisors;
    JLabel lblTitle;
    boolean isPanelsCreated;
    int i;
    saatyGuiEvents saatyEvents;
    int decisorsno=0;
    private DecisorsMatrix matrixDecisors;
    DecisorsConsistence consistenceDecisors;
    boolean boolConsistenceDecisors;
    RollBack rollBack;
    boolean isActiveRanking;
    boolean isCalculated;
    Double []weightsFinal;
    PanelRankingDecisors panelRankingDecisors;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel img_unsta1;
    private javax.swing.JLabel img_unsta2;
    // End of variables declaration//GEN-END:variables
}
