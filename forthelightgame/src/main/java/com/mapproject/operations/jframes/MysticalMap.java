package com.mapproject.operations.jframes;

import javax.swing.JTextField;

import com.mapproject.resources.Map;

public class MysticalMap extends javax.swing.JFrame {

        /**
         * Creates new form MysticalMap
         */
        public MysticalMap() {
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         */
        private void initComponents() {

                jTextField2 = new javax.swing.JTextField();
                filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                                new java.awt.Dimension(0, 32767));
                jtfRoom1 = new javax.swing.JTextField();
                jtfPassage1_5 = new javax.swing.JTextField();
                jtfRoom5 = new javax.swing.JTextField();
                jtfPassage5_9 = new javax.swing.JTextField();
                jtfRoom9 = new javax.swing.JTextField();
                jtfPassage9_13 = new javax.swing.JTextField();
                jtfRoom13 = new javax.swing.JTextField();
                jtfRoom2 = new javax.swing.JTextField();
                jtfPassage2_3 = new javax.swing.JTextField();
                jtfRoom3 = new javax.swing.JTextField();
                jtfPassage3_4 = new javax.swing.JTextField();
                jtfRoom4 = new javax.swing.JTextField();
                jtfRoom6 = new javax.swing.JTextField();
                jtfRoom7 = new javax.swing.JTextField();
                jtfRoom10 = new javax.swing.JTextField();
                jtfRoom14 = new javax.swing.JTextField();
                jtfRoom11 = new javax.swing.JTextField();
                jtfRoom15 = new javax.swing.JTextField();
                jtfRoom8 = new javax.swing.JTextField();
                jtfRoom12 = new javax.swing.JTextField();
                jtfRoom16 = new javax.swing.JTextField();
                jtfPassage5_6 = new javax.swing.JTextField();
                jtfPassage9_10 = new javax.swing.JTextField();
                jtfPassage10_11 = new javax.swing.JTextField();
                jtfPassage6_7 = new javax.swing.JTextField();
                jtfPassage7_8 = new javax.swing.JTextField();
                jtfPassage11_12 = new javax.swing.JTextField();
                jtfPassage2_6 = new javax.swing.JTextField();
                jtfPassage6_10 = new javax.swing.JTextField();
                jtfPassage10_14 = new javax.swing.JTextField();
                jtfPassage11_15 = new javax.swing.JTextField();
                jtfPassage7_11 = new javax.swing.JTextField();
                jtfPassage3_7 = new javax.swing.JTextField();
                jtfPassage4_8 = new javax.swing.JTextField();
                jtfPassage8_12 = new javax.swing.JTextField();
                jtfPassage12_16 = new javax.swing.JTextField();
                jlNorth = new javax.swing.JLabel();
                jlEast = new javax.swing.JLabel();
                jlSouth = new javax.swing.JLabel();
                jlWest = new javax.swing.JLabel();
                jtfPassage1_2 = new javax.swing.JTextField();
                jtfPassage13_14 = new javax.swing.JTextField();
                jtfPassage14_15 = new javax.swing.JTextField();
                jtfPassage15_16 = new javax.swing.JTextField();

                jTextField2.setText("jTextField2");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Mappa Mistica");
                setPreferredSize(new java.awt.Dimension(920, 950));
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowActivated(java.awt.event.WindowEvent evt) {
                                formWindowActivated(evt);
                        }
                });

                jtfRoom1.setEditable(false);
                jtfRoom1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom1.setFocusable(false);
                jtfRoom1.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage1_5.setEditable(false);
                jtfPassage1_5.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage1_5.setFocusable(false);
                jtfPassage1_5.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfRoom5.setEditable(false);
                jtfRoom5.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom5.setFocusable(false);
                jtfRoom5.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage5_9.setEditable(false);
                jtfPassage5_9.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage5_9.setFocusable(false);
                jtfPassage5_9.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfRoom9.setEditable(false);
                jtfRoom9.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom9.setFocusable(false);
                jtfRoom9.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage9_13.setEditable(false);
                jtfPassage9_13.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage9_13.setFocusable(false);
                jtfPassage9_13.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfRoom13.setEditable(false);
                jtfRoom13.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom13.setFocusable(false);
                jtfRoom13.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom2.setEditable(false);
                jtfRoom2.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom2.setFocusable(false);
                jtfRoom2.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage2_3.setEditable(false);
                jtfPassage2_3.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage2_3.setFocusable(false);
                jtfPassage2_3.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfRoom3.setEditable(false);
                jtfRoom3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom3.setFocusable(false);
                jtfRoom3.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage3_4.setEditable(false);
                jtfPassage3_4.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage3_4.setFocusable(false);
                jtfPassage3_4.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfRoom4.setEditable(false);
                jtfRoom4.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom4.setFocusable(false);
                jtfRoom4.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom6.setEditable(false);
                jtfRoom6.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom6.setFocusable(false);
                jtfRoom6.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom7.setEditable(false);
                jtfRoom7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom7.setFocusable(false);
                jtfRoom7.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom10.setEditable(false);
                jtfRoom10.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom10.setFocusable(false);
                jtfRoom10.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom14.setEditable(false);
                jtfRoom14.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom14.setFocusable(false);
                jtfRoom14.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom11.setEditable(false);
                jtfRoom11.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom11.setFocusable(false);
                jtfRoom11.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom15.setEditable(false);
                jtfRoom15.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom15.setFocusable(false);
                jtfRoom15.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom8.setEditable(false);
                jtfRoom8.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom8.setFocusable(false);
                jtfRoom8.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom12.setEditable(false);
                jtfRoom12.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom12.setFocusable(false);
                jtfRoom12.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfRoom16.setEditable(false);
                jtfRoom16.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jtfRoom16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jtfRoom16.setFocusable(false);
                jtfRoom16.setMinimumSize(new java.awt.Dimension(100, 100));

                jtfPassage5_6.setEditable(false);
                jtfPassage5_6.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage5_6.setFocusable(false);
                jtfPassage5_6.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage9_10.setEditable(false);
                jtfPassage9_10.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage9_10.setFocusable(false);
                jtfPassage9_10.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage10_11.setEditable(false);
                jtfPassage10_11.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage10_11.setFocusable(false);
                jtfPassage10_11.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage6_7.setEditable(false);
                jtfPassage6_7.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage6_7.setFocusable(false);
                jtfPassage6_7.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage7_8.setEditable(false);
                jtfPassage7_8.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage7_8.setFocusable(false);
                jtfPassage7_8.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage11_12.setEditable(false);
                jtfPassage11_12.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage11_12.setFocusable(false);
                jtfPassage11_12.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage2_6.setEditable(false);
                jtfPassage2_6.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage2_6.setFocusable(false);
                jtfPassage2_6.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage6_10.setEditable(false);
                jtfPassage6_10.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage6_10.setFocusable(false);
                jtfPassage6_10.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage10_14.setEditable(false);
                jtfPassage10_14.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage10_14.setFocusable(false);
                jtfPassage10_14.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage11_15.setEditable(false);
                jtfPassage11_15.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage11_15.setFocusable(false);
                jtfPassage11_15.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage7_11.setEditable(false);
                jtfPassage7_11.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage7_11.setFocusable(false);
                jtfPassage7_11.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage3_7.setEditable(false);
                jtfPassage3_7.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage3_7.setFocusable(false);
                jtfPassage3_7.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage4_8.setEditable(false);
                jtfPassage4_8.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage4_8.setFocusable(false);
                jtfPassage4_8.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage8_12.setEditable(false);
                jtfPassage8_12.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage8_12.setFocusable(false);
                jtfPassage8_12.setPreferredSize(new java.awt.Dimension(10, 50));

                jtfPassage12_16.setEditable(false);
                jtfPassage12_16.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage12_16.setFocusable(false);
                jtfPassage12_16.setPreferredSize(new java.awt.Dimension(10, 50));

                jlNorth.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
                jlNorth.setText("N");

                jlEast.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
                jlEast.setText("E");

                jlSouth.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
                jlSouth.setText("S");

                jlWest.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
                jlWest.setText("W");

                jtfPassage1_2.setEditable(false);
                jtfPassage1_2.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage1_2.setFocusable(false);
                jtfPassage1_2.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage13_14.setEditable(false);
                jtfPassage13_14.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage13_14.setFocusable(false);
                jtfPassage13_14.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage14_15.setEditable(false);
                jtfPassage14_15.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage14_15.setFocusable(false);
                jtfPassage14_15.setPreferredSize(new java.awt.Dimension(50, 10));

                jtfPassage15_16.setEditable(false);
                jtfPassage15_16.setBackground(new java.awt.Color(0, 0, 0));
                jtfPassage15_16.setFocusable(false);
                jtfPassage15_16.setPreferredSize(new java.awt.Dimension(50, 10));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(151, 151, 151)
                                                                                                .addComponent(filler1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jlWest)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(jtfRoom1,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(jtfPassage1_2,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(jtfRoom5,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(jtfPassage5_6,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(2, 2, 2)
                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                                .addComponent(jtfRoom9,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                100,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jtfRoom13,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                100,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addComponent(jtfPassage9_10,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jtfPassage13_14,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                                .addComponent(jtfRoom6,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                100,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jtfRoom2,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                100,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addComponent(jtfPassage2_3,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jtfPassage6_7,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addGroup(layout
                                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                                .addGap(14, 14, 14)
                                                                                                                                                                                                .addComponent(
                                                                                                                                                                                                                jlNorth))))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(jtfRoom10,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(jtfPassage10_11,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addComponent(jtfRoom14,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(jtfPassage14_15,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(288, 288,
                                                                                                                                                288)
                                                                                                                                .addComponent(jlSouth)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtfRoom3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jtfPassage3_4,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtfRoom7,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jtfPassage7_8,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtfRoom11,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jtfPassage11_12,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jtfRoom15,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jtfPassage15_16,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jtfRoom12,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jtfRoom8,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jtfRoom4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jtfRoom16,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(44, 44, 44)
                                                                                                .addComponent(jtfPassage1_5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(157, 157, 157)
                                                                                                .addComponent(jtfPassage2_6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(148, 148, 148)
                                                                                                .addComponent(jtfPassage3_7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(154, 154, 154)
                                                                                                .addComponent(jtfPassage4_8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(45, 45, 45)
                                                                                                .addComponent(jtfPassage9_13,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(155, 155, 155)
                                                                                                .addComponent(jtfPassage10_14,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(151, 151, 151)
                                                                                                .addComponent(jtfPassage11_15,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(157, 157, 157)
                                                                                                .addComponent(jtfPassage12_16,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(44, 44, 44)
                                                                                                .addComponent(jtfPassage5_9,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(157, 157, 157)
                                                                                                .addComponent(jtfPassage6_10,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(148, 148, 148)
                                                                                                .addComponent(jtfPassage7_11,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(158, 158, 158)
                                                                                                .addComponent(jtfPassage8_12,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(169, 169, 169)
                                                                                                .addComponent(jlEast)))
                                                                .addGap(27, 27, 27)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jlNorth)
                                                                .addGap(36, 36, 36)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(36, 36, 36)
                                                                                                .addComponent(jtfPassage1_2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(37, 37, 37)
                                                                                                .addComponent(jtfPassage2_3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(37, 37, 37)
                                                                                                .addComponent(jtfPassage3_4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jtfRoom1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtfPassage1_5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage2_6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage3_7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage4_8,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(37, 37, 37)
                                                                                                .addComponent(jtfPassage5_6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(jtfPassage6_7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(36, 36, 36)
                                                                                                .addComponent(jtfPassage7_8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jtfRoom5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jtfRoom8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtfPassage5_9,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage6_10,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage7_11,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage8_12,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jlEast)
                                                                                .addComponent(jlWest))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(24, 24, 24)
                                                                                                .addComponent(filler1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(37, 37, 37)
                                                                                                                                .addComponent(jtfPassage9_10,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(36, 36, 36)
                                                                                                                                .addComponent(jtfPassage10_11,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(35, 35, 35)
                                                                                                                                .addComponent(jtfPassage11_12,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jtfRoom9,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jtfRoom10,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jtfRoom11,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jtfRoom12,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jtfPassage9_13,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage10_14,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage11_15,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jtfPassage12_16,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                                                .addComponent(jtfRoom13,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(jtfRoom14,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(jtfRoom15,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(jtfRoom16,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                100,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGap(34, 34, 34))
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                                .addComponent(jtfPassage13_14,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(88, 88, 88)))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                .addComponent(jtfPassage14_15,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(89, 89, 89)))
                                                                                                .addComponent(jlSouth)
                                                                                                .addContainerGap())
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jtfPassage15_16,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(126, 126,
                                                                                                                                126)))));

                pack();
        }// </editor-fold>

        private void formWindowActivated(java.awt.event.WindowEvent evt) {
                if (recognizeRoom(currentRoom) != null) {
                        recognizeRoom(currentRoom).setBackground(new java.awt.Color(0, 204, 204));
                }
                if (recognizeRoom(drawnMap.getStartingRoomId()) != null) {
                        recognizeRoom(drawnMap.getStartingRoomId()).setText("S");
                }
                if (recognizeRoom(drawnMap.getEndRoomId()) != null) {
                        recognizeRoom(drawnMap.getEndRoomId()).setText("E");
                }

                clearPassage();

        }

        private void clearPassage() {
                if (drawnMap.getVisitableRooms().contains(1)) {
                        if (drawnMap.getRoom(1).getSouth() == null) {
                                jtfPassage1_5.setVisible(false);
                        }
                        if (drawnMap.getRoom(1).getEast() == null) {
                                jtfPassage1_2.setVisible(false);
                        }
                } else {
                        jtfPassage1_5.setVisible(false);
                        jtfPassage1_2.setVisible(false);
                        recognizeRoom(1).setVisible(false);
                }
                if (drawnMap.getVisitableRooms().contains(2)) {

                        if (drawnMap.getRoom(2).getSouth() == null) {
                                jtfPassage2_6.setVisible(false);
                        }
                        if (drawnMap.getRoom(2).getEast() == null) {
                                jtfPassage2_3.setVisible(false);
                        }
                } else {
                        jtfPassage2_6.setVisible(false);
                        jtfPassage2_3.setVisible(false);
                        recognizeRoom(2).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(3)) {
                        if (drawnMap.getRoom(3).getSouth() == null) {
                                jtfPassage3_7.setVisible(false);
                        }
                        if (drawnMap.getRoom(3).getEast() == null) {
                                jtfPassage3_4.setVisible(false);
                        }
                } else {
                        jtfPassage3_4.setVisible(false);
                        jtfPassage3_7.setVisible(false);
                        recognizeRoom(3).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(4)) {
                        if (drawnMap.getRoom(4).getSouth() == null) {
                                jtfPassage4_8.setVisible(false);
                        }
                } else {
                        jtfPassage4_8.setVisible(false);
                        recognizeRoom(4).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(5)) {
                        if (drawnMap.getRoom(5).getSouth() == null) {
                                jtfPassage5_9.setVisible(false);
                        }
                        if (drawnMap.getRoom(5).getEast() == null) {
                                jtfPassage5_6.setVisible(false);
                        }
                } else {
                        jtfPassage5_9.setVisible(false);
                        jtfPassage5_6.setVisible(false);
                        recognizeRoom(5).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(6)) {
                        if (drawnMap.getRoom(6).getSouth() == null) {
                                jtfPassage6_10.setVisible(false);
                        }
                        if (drawnMap.getRoom(6).getEast() == null) {
                                jtfPassage6_7.setVisible(false);
                        }
                } else {
                        jtfPassage6_10.setVisible(false);
                        jtfPassage6_7.setVisible(false);
                        recognizeRoom(6).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(7)) {
                        if (drawnMap.getRoom(7).getSouth() == null) {
                                jtfPassage7_11.setVisible(false);
                        }
                        if (drawnMap.getRoom(7).getEast() == null) {
                                jtfPassage7_8.setVisible(false);
                        }
                } else {
                        jtfPassage7_11.setVisible(false);
                        jtfPassage7_8.setVisible(false);
                        recognizeRoom(7).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(8)) {
                        if (drawnMap.getRoom(8).getSouth() == null) {
                                jtfPassage8_12.setVisible(false);
                        }
                } else {
                        jtfPassage8_12.setVisible(false);
                        recognizeRoom(8).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(9)) {
                        if (drawnMap.getRoom(9).getSouth() == null) {
                                jtfPassage9_13.setVisible(false);
                        }
                        if (drawnMap.getRoom(9).getEast() == null) {
                                jtfPassage9_10.setVisible(false);
                        }
                } else {
                        jtfPassage9_13.setVisible(false);
                        jtfPassage9_10.setVisible(false);
                        recognizeRoom(9).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(10)) {
                        if (drawnMap.getRoom(10).getSouth() == null) {
                                jtfPassage10_14.setVisible(false);
                        }
                        if (drawnMap.getRoom(10).getEast() == null) {
                                jtfPassage10_11.setVisible(false);
                        }
                } else {
                        jtfPassage10_11.setVisible(false);
                        jtfPassage10_14.setVisible(false);
                        recognizeRoom(10).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(11)) {
                        if (drawnMap.getRoom(11).getSouth() == null) {
                                jtfPassage11_15.setVisible(false);
                        }
                        if (drawnMap.getRoom(11).getEast() == null) {
                                jtfPassage11_12.setVisible(false);
                        }
                } else {
                        jtfPassage11_15.setVisible(false);
                        jtfPassage11_12.setVisible(false);
                        recognizeRoom(11).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(12)) {
                        if (drawnMap.getRoom(12).getSouth() == null) {
                                jtfPassage12_16.setVisible(false);
                        }
                } else {
                        jtfPassage12_16.setVisible(false);
                        recognizeRoom(12).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(13)) {
                        if (drawnMap.getRoom(13).getEast() == null) {
                                jtfPassage13_14.setVisible(false);
                        }
                } else {
                        jtfPassage13_14.setVisible(false);
                        recognizeRoom(13).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(14)) {
                        if (drawnMap.getRoom(14).getEast() == null) {
                                jtfPassage14_15.setVisible(false);
                        }
                } else {
                        jtfPassage14_15.setVisible(false);
                        recognizeRoom(14).setVisible(false);
                }

                if (drawnMap.getVisitableRooms().contains(15)) {
                        if (drawnMap.getRoom(15).getEast() == null) {
                                jtfPassage15_16.setVisible(false);
                        }
                } else {
                        jtfPassage15_16.setVisible(false);
                        recognizeRoom(15).setVisible(false);
                }

                if (!drawnMap.getVisitableRooms().contains(16)) {
                        recognizeRoom(16).setVisible(false);
                }

        }

        private JTextField recognizeRoom(int i) {
                switch (i) {
                        case 1:
                                return jtfRoom1;
                        case 2:
                                return jtfRoom2;
                        case 3:
                                return jtfRoom3;
                        case 4:
                                return jtfRoom4;
                        case 5:
                                return jtfRoom5;
                        case 6:
                                return jtfRoom6;
                        case 7:
                                return jtfRoom7;
                        case 8:
                                return jtfRoom8;
                        case 9:
                                return jtfRoom9;
                        case 10:
                                return jtfRoom10;
                        case 11:
                                return jtfRoom11;
                        case 12:
                                return jtfRoom12;
                        case 13:
                                return jtfRoom13;
                        case 14:
                                return jtfRoom14;
                        case 15:
                                return jtfRoom15;
                        case 16:
                                return jtfRoom16;
                        default:
                                return null;

                }
        }

        /**
         *
         * @param map
         */
        public static void main(Map map, int room) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(MysticalMap.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MysticalMap.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MysticalMap.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MysticalMap.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                drawnMap = map;
                currentRoom = room;

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new MysticalMap().setVisible(true);
                        }
                });
        }

        private static Map drawnMap = new Map();
        private static int currentRoom;
        // Variables declaration - do not modify
        private javax.swing.Box.Filler filler1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JLabel jlEast;
        private javax.swing.JLabel jlNorth;
        private javax.swing.JLabel jlSouth;
        private javax.swing.JLabel jlWest;
        private javax.swing.JTextField jtfPassage10_11;
        private javax.swing.JTextField jtfPassage10_14;
        private javax.swing.JTextField jtfPassage11_12;
        private javax.swing.JTextField jtfPassage11_15;
        private javax.swing.JTextField jtfPassage12_16;
        private javax.swing.JTextField jtfPassage13_14;
        private javax.swing.JTextField jtfPassage14_15;
        private javax.swing.JTextField jtfPassage15_16;
        private javax.swing.JTextField jtfPassage1_2;
        private javax.swing.JTextField jtfPassage1_5;
        private javax.swing.JTextField jtfPassage2_3;
        private javax.swing.JTextField jtfPassage2_6;
        private javax.swing.JTextField jtfPassage3_4;
        private javax.swing.JTextField jtfPassage3_7;
        private javax.swing.JTextField jtfPassage4_8;
        private javax.swing.JTextField jtfPassage5_6;
        private javax.swing.JTextField jtfPassage5_9;
        private javax.swing.JTextField jtfPassage6_10;
        private javax.swing.JTextField jtfPassage6_7;
        private javax.swing.JTextField jtfPassage7_11;
        private javax.swing.JTextField jtfPassage7_8;
        private javax.swing.JTextField jtfPassage8_12;
        private javax.swing.JTextField jtfPassage9_10;
        private javax.swing.JTextField jtfPassage9_13;
        private javax.swing.JTextField jtfRoom1;
        private javax.swing.JTextField jtfRoom10;
        private javax.swing.JTextField jtfRoom11;
        private javax.swing.JTextField jtfRoom12;
        private javax.swing.JTextField jtfRoom13;
        private javax.swing.JTextField jtfRoom14;
        private javax.swing.JTextField jtfRoom15;
        private javax.swing.JTextField jtfRoom16;
        private javax.swing.JTextField jtfRoom2;
        private javax.swing.JTextField jtfRoom3;
        private javax.swing.JTextField jtfRoom4;
        private javax.swing.JTextField jtfRoom5;
        private javax.swing.JTextField jtfRoom6;
        private javax.swing.JTextField jtfRoom7;
        private javax.swing.JTextField jtfRoom8;
        private javax.swing.JTextField jtfRoom9;
        // End of variables declaration
}
