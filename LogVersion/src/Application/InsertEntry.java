package Application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.HashSet;

public class InsertEntry extends javax.swing.JFrame {

    public InsertEntry(MainScreen mainScreen) {
        MONTH_31.add(1);
        MONTH_31.add(3);
        MONTH_31.add(5);
        MONTH_31.add(7);
        MONTH_31.add(8);
        MONTH_31.add(10);
        MONTH_31.add(12);
        initComponents();
        
        CancelAdapter cancelAction = new CancelAdapter();
        
        this.addKeyListener(cancelAction);
        bCreate.addKeyListener(cancelAction);
        spDate.addKeyListener(cancelAction);
        spMonth.addKeyListener(cancelAction);
        spYear.addKeyListener(cancelAction);
        tfTitle.addKeyListener(cancelAction);

        Calendar now = Calendar.getInstance();
        spDate.setValue(now.get(Calendar.DATE));
        spMonth.setValue(now.get(Calendar.MONTH) + 1);
        spYear.setValue(now.get(Calendar.YEAR));
        setMainScreen(mainScreen);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spDate = new javax.swing.JSpinner();
        spMonth = new javax.swing.JSpinner();
        spYear = new javax.swing.JSpinner();
        lInfo = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Date");

        jLabel2.setText("Month");

        jLabel3.setText("Year");

        spDate.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        spMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spYear.setModel(new javax.swing.SpinnerNumberModel(2013, 2013, 9999, 1));

        lInfo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lInfo.setText("Insert New Entry");

        jLabel5.setText("Title");

        bCreate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bCreate.setText("Create");
        bCreate.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(spDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addComponent(spMonth, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfTitle))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(bCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateActionPerformed

        if (tfTitle.getText().equals("")) {
            lInfo.setText("Empty Title!");
            return;
        } else if (!isValidDate()) {
            lInfo.setText("Invalid Date!");
            return;
        }

        Calendar toBeAdded = Calendar.getInstance();
        toBeAdded.set(Calendar.DATE, Integer.parseInt(spDate.getValue().toString()));
        toBeAdded.set(Calendar.MONTH, Integer.parseInt(spMonth.getValue().toString()) - 1);
        toBeAdded.set(Calendar.YEAR, Integer.parseInt(spYear.getValue().toString()));
        mainScreen.addEntry(new Entry(toBeAdded, tfTitle.getText()));
        InsertEntry.this.setVisible(false);

        tfTitle.setText("");
    }//GEN-LAST:event_bCreateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lInfo;
    private javax.swing.JSpinner spDate;
    private javax.swing.JSpinner spMonth;
    private javax.swing.JSpinner spYear;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables
    private MainScreen mainScreen;
    private static HashSet<Integer> MONTH_31 = new HashSet<Integer>();

    private void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    private boolean isValidDate() {
        int date = Integer.parseInt(spDate.getValue().toString());
        int month = Integer.parseInt(spMonth.getValue().toString());

        if (month != 2) {
            if (!MONTH_31.contains(month)) {
                if (date > 30) {
                    return false;
                }
            }
        } else {
            if (!leapYear(Integer.parseInt(spYear.getValue().toString())))  {
                if (date > 28) {
                    return false;
                }
            } else if (date > 29) {
                return false;
            }
        }

        return true;
    }

    private boolean leapYear(int year) {
        return true;
    }
    
    private class CancelAdapter extends KeyAdapter {
    	@Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                InsertEntry.this.setVisible(false);
            }
        }
    }
}