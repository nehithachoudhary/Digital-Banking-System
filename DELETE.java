package digitalBankSystem;

import java.awt.event.KeyEvent;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class DELETE extends javax.swing.JFrame {

    /**
     * Creates new form DELETE
     */
    public DELETE() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 220, 40));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 220, 40));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 220, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/digitalBankSystem/wrong.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, 16, 25, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/digitalBankSystem/DELETE_ACCOUN.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new ADMINISTRATOR_MAIN().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try 
        {
            if (jTextField1.getText().equals(""))	
           {
                 javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            } 
            else if (jTextField2.getText().equals("")) 
            {
                javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            }
            else if (jTextField3.getText().equals("")) 
            {
                    javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            }
            else
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
                Long acc = Long.parseLong(jTextField2.getText());
                Long cacc =Long.parseLong(jTextField3.getText());
                if (acc.equals(cacc))
                {
                    String Query = "SELECT USERNAME FROM DBS.ACCOUNTS WHERE ACCOUNTNO=?";
                    java.sql.PreparedStatement ps = con.prepareStatement(Query);
                    ps.setLong(1, Long.parseLong(jTextField2.getText()));
                    java.sql.ResultSet rs = ps.executeQuery();
                    if (rs.next()) 
                    {
                        if (rs.getString("USERNAME").equals(jTextField1.getText())) 
                        {
                            String Query3 = "DELETE FROM DBS.BALANCE WHERE ACCOUNTNO=?";
                            java.sql.PreparedStatement ps2 = con.prepareStatement(Query3);
                            ps2.setLong(1,Long.parseLong(jTextField2.getText()));
                            ps2.executeUpdate();
                            String Query2 = "DELETE FROM DBS.ACCOUNTS WHERE ACCOUNTNO=?";
                            java.sql.PreparedStatement ps1 = con.prepareStatement(Query2);
                            ps1.setLong(1,Long.parseLong(jTextField2.getText()));
                            ps1.executeUpdate();
                            javax.swing.JOptionPane.showMessageDialog(null, "ACCOUNT IS CLOSED SUCESSFULLY");
                            new ADMINISTRATOR_MAIN().setVisible(true);
                            dispose();
                        }
                        else 
                        {
                            javax.swing.JOptionPane.showMessageDialog(null, "NO USER EXISTS");
                        }
                    }
                    else 
                    {
                        javax.swing.JOptionPane.showMessageDialog(null, "CHECK YOUR ACCOUNT NO");
                    }
                } else
                {
                   javax.swing.JOptionPane.showMessageDialog(null, "ACCOUNT NO AND CONFIRM ACCOUNT NO SHOULD SAME");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new WELCOME_TO_CSE_BANK().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
            jTextField2.requestFocus();
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
            jTextField3.requestFocus();
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
             try 
        {
            if (jTextField1.getText().equals(""))	
           {
                 javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            } 
            else if (jTextField2.getText().equals("")) 
            {
                javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            }
            else if (jTextField3.getText().equals("")) 
            {
                    javax.swing.JOptionPane.showMessageDialog(null, "PLEASE FILL CREDENTIALS");
            }
            else
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
                Long acc = Long.parseLong(jTextField2.getText());
                Long cacc =Long.parseLong(jTextField3.getText());
                if (acc.equals(cacc))
                {
                    String Query = "SELECT USERNAME FROM DBS.ACCOUNTS WHERE ACCOUNTNO=?";
                    java.sql.PreparedStatement ps = con.prepareStatement(Query);
                    ps.setLong(1, Long.parseLong(jTextField2.getText()));
                    java.sql.ResultSet rs = ps.executeQuery();
                    if (rs.next()) 
                    {
                        if (rs.getString("USERNAME").equals(jTextField1.getText())) 
                        {
                            String Query2 = "DELETE FROM DBS.ACCOUNTS WHERE ACCOUNTNO=?";
                            java.sql.PreparedStatement ps1 = con.prepareStatement(Query2);
                            ps1.setLong(1,Long.parseLong(jTextField2.getText()));
                            ps1.executeUpdate();
                            javax.swing.JOptionPane.showMessageDialog(null, "ACCOUNT IS CLOSED SUCESSFULLY");
                            new ADMINISTRATOR_MAIN().setVisible(true);
                            dispose();
                        }
                        else 
                        {
                            javax.swing.JOptionPane.showMessageDialog(null, "NO USER EXISTS");
                        }
                    }
                    else 
                    {
                        javax.swing.JOptionPane.showMessageDialog(null, "CHECK YOUR ACCOUNT NO");
                    }
                } else
                {
                   javax.swing.JOptionPane.showMessageDialog(null, "ACCOUNT NO AND CONFIRM ACCOUNT NO SHOULD SAME");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_jTextField3KeyPressed

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
            java.util.logging.Logger.getLogger(DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DELETE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
