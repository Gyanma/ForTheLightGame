package com.mapproject.operations.jframes;

import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/*
 * Based on: Puzzle A Cryptic Combo from the game "Professor Layton and the Unwound Future"
 */
/**
 *
 * @author gmrut
 */
public class PuzzleCombCrip extends javax.swing.JFrame {

        /**
         * Creates new form PuzzleCombCrip
         */
        public PuzzleCombCrip() {
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         */

        private void initComponents() {

                jtbNumber1 = new javax.swing.JToggleButton();
                jtbNumber2 = new javax.swing.JToggleButton();
                jtbNumber3 = new javax.swing.JToggleButton();
                jtbNumber4 = new javax.swing.JToggleButton();
                jtbNumber5 = new javax.swing.JToggleButton();
                jtbNumber6 = new javax.swing.JToggleButton();
                jtbNumber7 = new javax.swing.JToggleButton();
                jtbNumber8 = new javax.swing.JToggleButton();
                jtbNumber9 = new javax.swing.JToggleButton();
                jtbNumber10 = new javax.swing.JToggleButton();
                jtbNumber11 = new javax.swing.JToggleButton();
                jtbNumber12 = new javax.swing.JToggleButton();
                jtbNumber13 = new javax.swing.JToggleButton();
                jtbNumber14 = new javax.swing.JToggleButton();
                jtbNumber15 = new javax.swing.JToggleButton();
                jbSolution = new javax.swing.JButton();
                jbResa = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                setTitle("Combinazione Criptica");
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                jtbNumber1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber1.setText("1");
                jtbNumber1.setAutoscrolls(true);

                jtbNumber2.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber2.setText("2");
                jtbNumber2.setAutoscrolls(true);

                jtbNumber3.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber3.setText("3");
                jtbNumber3.setAutoscrolls(true);

                jtbNumber4.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber4.setText("4");
                jtbNumber4.setAutoscrolls(true);

                jtbNumber5.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber5.setText("5");
                jtbNumber5.setAutoscrolls(true);

                jtbNumber6.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber6.setText("6");
                jtbNumber6.setAutoscrolls(true);

                jtbNumber7.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber7.setText("7");
                jtbNumber7.setAutoscrolls(true);

                jtbNumber8.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber8.setText("8");
                jtbNumber8.setAutoscrolls(true);

                jtbNumber9.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber9.setText("9");
                jtbNumber9.setAutoscrolls(true);

                jtbNumber10.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber10.setText("10");
                jtbNumber10.setAutoscrolls(true);

                jtbNumber11.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber11.setText("11");
                jtbNumber11.setAutoscrolls(true);

                jtbNumber12.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber12.setText("12");
                jtbNumber12.setAutoscrolls(true);

                jtbNumber13.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber13.setText("13");
                jtbNumber13.setAutoscrolls(true);

                jtbNumber14.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber14.setText("14");
                jtbNumber14.setAutoscrolls(true);

                jtbNumber15.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 30)); // NOI18N
                jtbNumber15.setText("15");
                jtbNumber15.setAutoscrolls(true);

                jbSolution.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
                jbSolution.setText("Apri la porta");
                jbSolution.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jbSolutionMouseClicked(evt);
                        }
                });

                jbResa.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
                jbResa.setText("Resa");
                jbResa.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jbResaMouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jtbNumber4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jtbNumber7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jtbNumber8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jtbNumber9,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jtbNumber10,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jtbNumber11,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jtbNumber12,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jtbNumber5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(jtbNumber6,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtbNumber13,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jtbNumber14,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jtbNumber15,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtbNumber1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jtbNumber2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jtbNumber3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(114, 114, 114)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jbResa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                191,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jbSolution,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                191,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(93, 93, 93)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(39, 39, 39)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtbNumber1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtbNumber4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jbSolution,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtbNumber7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber8,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber9,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtbNumber10,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber11,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber12,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jbResa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                116,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(6, 6, 6)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtbNumber13,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber14,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtbNumber15,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(10, Short.MAX_VALUE)));

                pack();
        }

        private void jbSolutionMouseClicked(java.awt.event.MouseEvent evt) {
                if (jtbNumber1.isSelected() &&
                                jtbNumber2.isSelected() &&
                                jtbNumber3.isSelected() &&
                                jtbNumber6.isSelected() &&
                                jtbNumber7.isSelected() &&
                                jtbNumber8.isSelected() &&
                                jtbNumber9.isSelected() &&
                                jtbNumber10.isSelected() &&
                                jtbNumber13.isSelected() &&
                                jtbNumber14.isSelected() &&
                                jtbNumber15.isSelected()) {

                        solved = 1;
                        JComponent comp = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                } else {
                        System.out.println("Provi ad aprire la porta, ma non da segni di cedimento.");
                }
        }

        private void jbResaMouseClicked(java.awt.event.MouseEvent evt) {
                solved = 0;
                JComponent comp = (JComponent) evt.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
        }

        private void formWindowClosing(java.awt.event.WindowEvent evt) {
                System.out.println("La porta rimane serrata...");
        }

        public int getSolved() {
                return solved;
        }

        public static void main(String[] args) {

                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("CDE/Motif".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(PuzzleCombCrip.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(PuzzleCombCrip.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(PuzzleCombCrip.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(PuzzleCombCrip.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new PuzzleCombCrip().setVisible(true);
                        }
                });
        }

        private int solved = -1;

        // Variables declaration - do not modify
        private javax.swing.JButton jbResa;
        private javax.swing.JButton jbSolution;
        private javax.swing.JToggleButton jtbNumber1;
        private javax.swing.JToggleButton jtbNumber10;
        private javax.swing.JToggleButton jtbNumber11;
        private javax.swing.JToggleButton jtbNumber12;
        private javax.swing.JToggleButton jtbNumber13;
        private javax.swing.JToggleButton jtbNumber14;
        private javax.swing.JToggleButton jtbNumber15;
        private javax.swing.JToggleButton jtbNumber2;
        private javax.swing.JToggleButton jtbNumber3;
        private javax.swing.JToggleButton jtbNumber4;
        private javax.swing.JToggleButton jtbNumber5;
        private javax.swing.JToggleButton jtbNumber6;
        private javax.swing.JToggleButton jtbNumber7;
        private javax.swing.JToggleButton jtbNumber8;
        private javax.swing.JToggleButton jtbNumber9;
        // End of variables declaration
}
