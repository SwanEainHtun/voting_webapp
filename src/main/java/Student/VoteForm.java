/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Student;


import javax.swing.JOptionPane;
import Connections.ConnectionToDB;
import Forms.Login;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
/**
 *
 * @author wintwinthtae
 */
public class VoteForm extends javax.swing.JFrame {

Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String itemSelected;
String selected;
DefaultListModel dlm = new DefaultListModel();
int  kingVote , queenVote,smartVote,styleVote;

    /**
     * Creates new form VoteForm
     */
    public VoteForm() {
        initComponents();
        conn = ConnectionToDB.ConnectToDB();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        populateKing();
        populateQueen();
        populateSmart();
        populateStyle();
    }

     public void close(){
        WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
     
     public void populateKing(){
        try{
            String sql = "SELECT firstname,middlename,lastname FROM candidates_info WHERE position='KING'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                kingCombo.addItem(rs.getString("firstname")+" "+rs.getString("middlename")+" "+rs.getString("lastname"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
      public void populateQueen(){
        try{
            String sql = "SELECT firstname,middlename,lastname FROM candidates_info WHERE position='QUEEN'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                queenCombo.addItem(rs.getString("firstname")+" "+rs.getString("middlename")+" "+rs.getString("lastname"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
       public void populateSmart(){
        try{
            String sql = "SELECT firstname,middlename,lastname FROM candidates_info WHERE position='SMART'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                smartCombo.addItem(rs.getString("firstname")+" "+rs.getString("middlename")+" "+rs.getString("lastname"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
       
        public void populateStyle(){
        try{
            String sql = "SELECT firstname,middlename,lastname FROM candidates_info WHERE position='STYLE'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                styleCombo.addItem(rs.getString("firstname")+" "+rs.getString("middlename")+" "+rs.getString("lastname"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        public void selectVoteCountForKing(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+kingCombo.getSelectedItem()+"' AND position='KING'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               kingVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
         public void selectVoteCountForQueen(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+queenCombo.getSelectedItem()+"' AND position='QUEEN'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               queenVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
          public void selectVoteCountForSmart(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+smartCombo.getSelectedItem()+"' AND position='SMART'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               smartVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
           public void selectVoteCountForStyle(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+styleCombo.getSelectedItem()+"' AND position='STYLE'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               styleVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
           
          public void updateForKing(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ kingVote +"' WHERE fullname='"+kingCombo.getSelectedItem()+"' AND position='KING'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

          public void updateForQueen(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ queenVote +"' WHERE fullname='"+queenCombo.getSelectedItem()+"' AND position='QUEEN'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
          public void updateForSmart(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ smartVote +"' WHERE fullname='"+smartCombo.getSelectedItem()+"' AND position='SMART'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
          public void updateForStyle(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ styleVote +"' WHERE fullname='"+styleCombo.getSelectedItem()+"' AND position='STYLE'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        nameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yearLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kingCombo = new javax.swing.JComboBox<>();
        queenCombo = new javax.swing.JComboBox<>();
        smartCombo = new javax.swing.JComboBox<>();
        styleCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        voteCombo = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, null, null));

        jLabel1.setText("Name");

        nameLbl.setForeground(new java.awt.Color(102, 0, 0));
        nameLbl.setText("Name");

        jLabel2.setText("Gender");

        genderLbl.setForeground(new java.awt.Color(102, 0, 0));
        genderLbl.setText("Gender");

        jLabel4.setText("Year");

        yearLbl.setForeground(new java.awt.Color(102, 0, 0));
        yearLbl.setText("Year");

        jLabel6.setText("Status");

        statusLbl.setForeground(new java.awt.Color(102, 0, 0));
        statusLbl.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nameLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genderLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearLbl)
                    .addComponent(statusLbl))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameLbl)
                    .addComponent(jLabel4)
                    .addComponent(yearLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(genderLbl)
                    .addComponent(jLabel6)
                    .addComponent(statusLbl))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, null, null));

        jLabel3.setText("King");

        jLabel5.setText("Queen");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Smart");

        jLabel8.setText("Style");

        jLabel11.setText("Style");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(kingCombo, 0, 129, Short.MAX_VALUE)
                        .addComponent(smartCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(styleCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(queenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(queenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(smartCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(styleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(48, 48, 48)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        voteCombo.setBackground(java.awt.Color.lightGray);
        voteCombo.setText("Vote");
        voteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteComboActionPerformed(evt);
            }
        });

        exitBtn.setBackground(java.awt.Color.lightGray);
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Please Vote Wisely!");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Student/rsz_logo2.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Pick Your Favourite");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voteCombo)
                .addGap(65, 65, 65)
                .addComponent(exitBtn)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voteCombo)
                    .addComponent(exitBtn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteComboActionPerformed
        // TODO add your handling code here:
        if(kingCombo.getSelectedIndex()==0 || queenCombo.getSelectedIndex()==0 || smartCombo.getSelectedIndex()==0 || styleCombo.getSelectedIndex()==0){
               JOptionPane.showMessageDialog(null, "Please fill up all the required fields");
           }else{
                int des = JOptionPane.showConfirmDialog(null, "Finish Voting?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(des==0){
               selectVoteCountForKing();
               selectVoteCountForQueen();
               selectVoteCountForSmart();
               selectVoteCountForStyle();
               
               
                updateForKing();
                updateForQueen();
                updateForSmart();
                updateForStyle();
                
                JOptionPane.showMessageDialog(null, "Voted Successfully!");
                }
               
           }
    }//GEN-LAST:event_voteComboActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        Login l = new Login();
        //close();
        l.setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    public javax.swing.JLabel genderLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> kingCombo;
    public javax.swing.JLabel nameLbl;
    private javax.swing.JComboBox<String> queenCombo;
    private javax.swing.JComboBox<String> smartCombo;
    public javax.swing.JLabel statusLbl;
    private javax.swing.JComboBox<String> styleCombo;
    private javax.swing.JButton voteCombo;
    public javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables
}
