/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 */
public class AjedrezApp extends javax.swing.JFrame {

    Timer TB = new Timer();
    Timer TN = new Timer();
    Timer Tturno = new Timer();

    int tb = 0;
    int tn = 0;
    Rey blanco, negro;
    boolean turno = true;
    int pasosreyblanco = 0, pasosreynegro = 0;
    int ganan = -1;

    int Contador_comido = 0;

    JugadorVirtual jugadorVirtualnegro = null;
    JugadorVirtual jugadorVirtualblanco = null;
    Jugadores DialogJ;

    public AjedrezApp() {
        initComponents();
        Jugadores DialogJ = new Jugadores(this, true);
        DialogJ.setLocationRelativeTo(null);
        DialogJ.setVisible(true);

        //*************************************************
        //**********************************************
        blanco = new Rey(1, 3, 0, "", null, this);
        blanco.rey = blanco;
        negro = new Rey(2, 3, 7, "", null, this);
        negro.rey = negro;
        if (DialogJ.negras.isSelected()) {
            jugadorVirtualnegro = new JugadorVirtual(negro, this);
        }
        if (DialogJ.blancas.isSelected()) {
            jugadorVirtualblanco = new JugadorVirtual(blanco, this);
        }

        this.setLocationRelativeTo(null);

        jblanco.setBackground(Color.GREEN);
        jnegro.setBackground(Color.red);
        texto.setText(">Es el turno de las blancas\n");
        for (int x = 0; x < 8; x++) {
            for (int y = 2; y < 6; y++) {
                new NULA(0, x, y, "", blanco, this);
            }
        }

        ///////
        /* for (int x = 0; x < 8; x++) {
               new NULA(0,x,0,"",blanco,this);
           }
           for (int x = 0; x < 8; x++) {
               new NULA(0,x,7,"",blanco,this);
           }*/
        new NULA(0, 0, 0, "", blanco, this);
        new NULA(0, 1, 0, "", blanco, this);
        new NULA(0, 3, 0, "", blanco, this);
        new NULA(0, 4, 0, "", blanco, this);
        new NULA(0, 6, 0, "", blanco, this);
        new NULA(0, 7, 0, "", blanco, this);

        new NULA(0, 0, 7, "", blanco, this);
        new NULA(0, 1, 7, "", blanco, this);
        new NULA(0, 3, 7, "", blanco, this);
        new NULA(0, 4, 7, "", blanco, this);
        new NULA(0, 6, 7, "", blanco, this);
        new NULA(0, 7, 7, "", blanco, this);

        ///////////
        /* new Torre(1,0,0,"",blanco,this);
       new Torre(1,7,0,"",blanco,this);
       new Alfil(1,1,0,"",blanco,this);
       new Alfil(1,6,0,"",blanco,this); 
       new Caballo(1,2,0,"",blanco,this);*/
        new Caballo(1, 2, 0, "Caballo_blanco", blanco, this);
        /* new Caballo(1,5,0,"",blanco,this); */
        new Caballo(1, 5, 0, "Caballo_blanco", blanco, this);
        //new Reina(1,4,0,"",blanco,this);

        new Peon(1, 0, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 1, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 2, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 3, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 4, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 5, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 6, 1, "Peon_Blanco", blanco, this);
        new Peon(1, 7, 1, "Peon_Blanco", blanco, this);

        /*new Torre(2,0,7,"",negro,this);
       new Torre(2,7,7,"",negro,this);
       new Alfil(2,1,7,"",negro,this);
       new Alfil(2,6,7,"",negro,this); */
        new Caballo(2, 2, 7, "Caballo_Negro", negro, this);
        //new Caballo(2,2,7,"",negro,this);
        new Caballo(2, 5, 7, "Caballo_Negro", negro, this);
        /*new Caballo(2,5,7,"",negro,this); 
       new Reina(2,4,7,"",negro,this);*/

        new Peon(2, 0, 6, "Peon_Negro", negro, this);
        new Peon(2, 1, 6, "Peon_Negro", negro, this);
        new Peon(2, 2, 6, "Peon_Negro", negro, this);
        new Peon(2, 3, 6, "Peon_Negro", negro, this);
        new Peon(2, 4, 6, "Peon_Negro", negro, this);
        new Peon(2, 5, 6, "Peon_Negro", negro, this);
        new Peon(2, 6, 6, "Peon_Negro", negro, this);
        new Peon(2, 7, 6, "Peon_Negro", negro, this);

        //this.setSize(700,500);//1200,830
        //tablero.setSize(8*90,8*90);
        this.validate();
        this.repaint();

        TimerTask tkb = new TimerTask() {
            public void run() {
                tb++;
                tiempoB.setText(tb + " seg");
            }
        };
        TB.scheduleAtFixedRate(tkb, 0, 1000);

        TimerTask task = new TimerTask() {
            public void run() {

                if (ganan != -1) {
                    Tturno.cancel();
                }
                try {
                    if (!turno && jugadorVirtualnegro != null) {
                        if(DialogJ.facil_check.isSelected()){/////////
                            jugadorVirtualnegro.juega2();
                        }else{
                            jugadorVirtualnegro.juega();
                        }
                    } else if (turno && jugadorVirtualblanco != null) {
                        if(DialogJ.facil_check.isSelected()){
                            jugadorVirtualblanco.juega2();
                        }else{
                            jugadorVirtualblanco.juega();
                        }
                        
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("ESTOY EN EL ERROR");
                }
                jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
                jScrollPane1.repaint();
            }
        };

        Tturno.scheduleAtFixedRate(task, 0, 2000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tablero = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JEditorPane();
        tiempoB = new javax.swing.JLabel();
        jblanco = new javax.swing.JButton();
        tiempoN = new javax.swing.JLabel();
        jnegro = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setSize(new java.awt.Dimension(950, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 53, 53));
        jPanel1.setLayout(new java.awt.GridLayout(8, 1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1");
        jPanel1.add(jLabel1);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2");
        jPanel1.add(jLabel2);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("3");
        jPanel1.add(jLabel3);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("4");
        jPanel1.add(jLabel4);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("5");
        jPanel1.add(jLabel5);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("6");
        jPanel1.add(jLabel6);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("7");
        jPanel1.add(jLabel7);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("8");
        jPanel1.add(jLabel8);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 20, 490));

        jPanel2.setBackground(new java.awt.Color(56, 53, 53));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 8));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("A");
        jPanel2.add(jLabel10);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("B");
        jPanel2.add(jLabel11);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("C");
        jPanel2.add(jLabel12);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D");
        jPanel2.add(jLabel13);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("E");
        jPanel2.add(jLabel14);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("F");
        jPanel2.add(jLabel9);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("G");
        jPanel2.add(jLabel15);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("H");
        jPanel2.add(jLabel16);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 500, 40));

        jPanel5.setBackground(new java.awt.Color(56, 53, 53));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(45, 42, 42));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_monarch_40px.png"))); // NOI18N
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 40, 50));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 10));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/intermemedio2.2.PNG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 90, 280));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nivel de ");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PEON_BLANCO.png"))); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 40, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PEON_NEGRO.png"))); // NOI18N
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, 50));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("COLOR");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 40, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Blanco");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Negro");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("dificultad");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 140, 560));

        tablero.setBackground(new java.awt.Color(0, 0, 0));
        tablero.setPreferredSize(new java.awt.Dimension(760, 800));
        tablero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 497, 497));

        texto.setBackground(new java.awt.Color(204, 204, 204));
        texto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(texto);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 290, 270));

        tiempoB.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        tiempoB.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tiempoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 80));

        jblanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/rey blanco.png"))); // NOI18N
        jblanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblancoActionPerformed(evt);
            }
        });
        jPanel5.add(jblanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        tiempoN.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        tiempoN.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tiempoN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 90, 80));

        jnegro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jnegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/rey negro.png"))); // NOI18N
        jnegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnegroActionPerformed(evt);
            }
        });
        jPanel5.add(jnegro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jPanel3.setBackground(new java.awt.Color(47, 47, 47));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_monarch_48px.png"))); // NOI18N
        jLabel23.setText(" GUERRA DE PEONES");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 220, 50));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/participantes2.PNG"))); // NOI18N
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, 170, 410));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblancoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jblancoActionPerformed

    private void jnegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnegroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnegroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjedrezApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjedrezApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjedrezApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjedrezApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjedrezApp a = new AjedrezApp();
                a.setVisible(true);
                //a.jugadorVirtualblanco.juega();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JButton jblanco;
    public javax.swing.JButton jnegro;
    public javax.swing.JPanel tablero;
    public javax.swing.JEditorPane texto;
    public javax.swing.JLabel tiempoB;
    public javax.swing.JLabel tiempoN;
    // End of variables declaration//GEN-END:variables

    class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint border
        }
    }
}
