package com.mapproject.operations.jframes;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * Based on: Puzzle 33333! from the game "Professor Layton and the Curious Village"
 */

/**
 *
 * @author gmrut
 */
public class Puzzle33333 extends javax.swing.JFrame {

        /**
         * Creates new form Puzzle33333
         */
        public Puzzle33333() {
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         */
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jlMinusSign = new javax.swing.JLabel();
                jtfMinueU = new javax.swing.JTextField();
                jtfMinueDa = new javax.swing.JTextField();
                jtfMinueDaK = new javax.swing.JTextField();
                jtfMinueUK = new javax.swing.JTextField();
                jtfMinueH = new javax.swing.JTextField();
                jtfSubtraU = new javax.swing.JTextField();
                jtfSubtraDa = new javax.swing.JTextField();
                jtfSubtraH = new javax.swing.JTextField();
                jtfSubtraUK = new javax.swing.JTextField();
                jbEqualButton = new javax.swing.JButton();
                jtfResultDaK = new javax.swing.JTextField();
                jtfResultUK = new javax.swing.JTextField();
                jtfResultH = new javax.swing.JTextField();
                jtfResultDa = new javax.swing.JTextField();
                jtfResultU = new javax.swing.JTextField();
                jbResa = new javax.swing.JButton();

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane1.setViewportView(jTextArea1);

                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                setTitle("33333");
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                jlMinusSign.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jlMinusSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jlMinusSign.setText("-");
                jlMinusSign.setToolTipText("");

                jtfMinueU.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfMinueU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfMinueU.setMinimumSize(new java.awt.Dimension(60, 60));
                jtfMinueU.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfMinueU.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfMinueUKeyPressed(evt);
                        }
                });

                jtfMinueDa.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfMinueDa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfMinueDa.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfMinueDa.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfMinueDaKeyPressed(evt);
                        }
                });

                jtfMinueDaK.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfMinueDaK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfMinueDaK.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfMinueDaK.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfMinueDaKKeyPressed(evt);
                        }
                });

                jtfMinueUK.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfMinueUK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfMinueUK.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfMinueUK.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfMinueUKKeyPressed(evt);
                        }
                });

                jtfMinueH.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfMinueH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfMinueH.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfMinueH.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfMinueHKeyPressed(evt);
                        }
                });

                jtfSubtraU.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfSubtraU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfSubtraU.setMinimumSize(new java.awt.Dimension(60, 60));
                jtfSubtraU.setPreferredSize(new java.awt.Dimension(60, 60));
                jtfSubtraU.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfSubtraUKeyPressed(evt);
                        }
                });

                jtfSubtraDa.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfSubtraDa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfSubtraDa.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfSubtraDaKeyPressed(evt);
                        }
                });

                jtfSubtraH.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfSubtraH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfSubtraH.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfSubtraHKeyPressed(evt);
                        }
                });

                jtfSubtraUK.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfSubtraUK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfSubtraUK.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jtfSubtraUKKeyPressed(evt);
                        }
                });

                jbEqualButton.setFont(new java.awt.Font("Serif", 1, 30)); // NOI18N
                jbEqualButton.setText("=");
                jbEqualButton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jbEqualButtonMouseClicked(evt);
                        }
                });

                jtfResultDaK.setEditable(false);
                jtfResultDaK.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfResultDaK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfResultDaK.setText("3");

                jtfResultUK.setEditable(false);
                jtfResultUK.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfResultUK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfResultUK.setText("3");

                jtfResultH.setEditable(false);
                jtfResultH.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfResultH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfResultH.setText("3");

                jtfResultDa.setEditable(false);
                jtfResultDa.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfResultDa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfResultDa.setText("3");

                jtfResultU.setEditable(false);
                jtfResultU.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
                jtfResultU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfResultU.setText("3");

                jbResa.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
                jbResa.setText("RESA");
                jbResa.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                jbResaMousePressed(evt);
                        }
                });
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jtfMinueDaK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultDaK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(68, 68, 68)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jtfSubtraUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(60, 60, 60)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jtfSubtraH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(74, 74, 74)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jtfResultDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfSubtraDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(86, 86, 86)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jtfSubtraU,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jtfMinueU,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(92, 92, 92)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jlMinusSign,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jbEqualButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jtfResultU,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(83, 83, 83)
                                                                                                .addComponent(jbResa,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                108,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(92, 92, 92)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(34, 34, 34)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlMinusSign,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueU,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueDaK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfMinueH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(109, 109, 109)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtfSubtraUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfSubtraH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfSubtraDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfSubtraU,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jbEqualButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(109, 109, 109)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jbResa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                73,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultU,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultDa,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultH,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultUK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfResultDaK,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(56, 56, 56)));

                pack();
        }

        private void jbEqualButtonMouseClicked(java.awt.event.MouseEvent evt) {
                if (answer.get(1) != null &&
                                answer.get(2) != null &&
                                answer.get(3) != null &&
                                answer.get(4) != null &&
                                answer.get(5) != null &&
                                answer.get(6) != null &&
                                answer.get(7) != null &&
                                answer.get(8) != null &&
                                answer.get(9) != null) {

                        if (answer.get(1).equals("4") &&
                                        answer.get(2).equals("1") &&
                                        answer.get(3).equals("2") &&
                                        answer.get(6).equals("7") &&
                                        answer.get(7).equals("9") &&
                                        ((answer.get(4).equals("6") && answer.get(5).equals("8")
                                                        && answer.get(8).equals("3") && answer.get(9).equals("5"))
                                                        ||
                                                        (answer.get(4).equals("8") && answer.get(5).equals("6")
                                                                        && answer.get(8).equals("5")
                                                                        && answer.get(9).equals("3")))) {

                                solved = 1;
                                JComponent comp = (JComponent) evt.getSource();
                                Window win = SwingUtilities.getWindowAncestor(comp);
                                win.dispose();
                        } else {
                                System.out.println("Provi ad aprire la porta, ma non da segni di cedimento.");
                        }
                } else {
                        System.out.println("Provi ad aprire la porta, ma non da segni di cedimento.");
                }
        }

        private void jtfMinueDaKKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 1, jtfMinueDaK);
        }

        private void jtfMinueUKKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 2, jtfMinueUK);
        }

        private void jtfMinueHKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 3, jtfMinueH);
        }

        private void jtfMinueDaKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 4, jtfMinueDa);
        }

        private void jtfMinueUKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 5, jtfMinueU);
        }

        private void jtfSubtraUKKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 6, jtfSubtraUK);
        }

        private void jtfSubtraHKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 7, jtfSubtraH);
        }

        private void jtfSubtraDaKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 8, jtfSubtraDa);
        }

        private void jtfSubtraUKeyPressed(java.awt.event.KeyEvent evt) {
                String input = checkEvent(evt);
                saveInput(input, 9, jtfSubtraU);
        }

        private String checkEvent(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                        case KeyEvent.VK_1:
                                return "1";
                        case KeyEvent.VK_2:
                                return "2";
                        case KeyEvent.VK_3:
                                return "3";
                        case KeyEvent.VK_4:
                                return "4";
                        case KeyEvent.VK_5:
                                return "5";
                        case KeyEvent.VK_6:
                                return "6";
                        case KeyEvent.VK_7:
                                return "7";
                        case KeyEvent.VK_8:
                                return "8";
                        case KeyEvent.VK_9:
                                return "9";
                        default:
                                return "error";
                }
        }

        private void saveInput(String input, int i, JTextField jtf) {
                if (input.equals("error")) {
                } else {
                        answer.put(i, input);
                }
                jtf.setText("");

        }

        private void jbResaMousePressed(java.awt.event.MouseEvent evt) {
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
                        java.util.logging.Logger.getLogger(Puzzle33333.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Puzzle33333.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Puzzle33333.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Puzzle33333.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Puzzle33333().setVisible(true);
                        }
                });
        }

        private final HashMap<Integer, String> answer = new HashMap<>();
        private int solved = -1;

        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JButton jbEqualButton;
        private javax.swing.JButton jbResa;
        private javax.swing.JLabel jlMinusSign;
        private javax.swing.JTextField jtfMinueDa;
        private javax.swing.JTextField jtfMinueDaK;
        private javax.swing.JTextField jtfMinueH;
        private javax.swing.JTextField jtfMinueU;
        private javax.swing.JTextField jtfMinueUK;
        private javax.swing.JTextField jtfResultDa;
        private javax.swing.JTextField jtfResultDaK;
        private javax.swing.JTextField jtfResultH;
        private javax.swing.JTextField jtfResultU;
        private javax.swing.JTextField jtfResultUK;
        private javax.swing.JTextField jtfSubtraDa;
        private javax.swing.JTextField jtfSubtraH;
        private javax.swing.JTextField jtfSubtraU;
        private javax.swing.JTextField jtfSubtraUK;

}
