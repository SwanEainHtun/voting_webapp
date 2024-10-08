/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;
import Connections.ConnectionToDB;
import Student.VoteForm;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author wintwinthtae
 */
public class ViewVotesPanel extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;
    /**
     * Creates new form ViewVotesPanel
     */
    public ViewVotesPanel() {
        initComponents();
        conn = ConnectionToDB.ConnectToDB();
        setup();
    }
    
    
    public void setup(){
        
        try{
            
             
            //int king=1;
            String kg="SELECT * FROM candidates_info where position='KING' order by -vote_count limit 1";
            pst =conn.prepareStatement(kg);
            rs1= pst.executeQuery();
            
                    
            //int queen=2;
            String qn="SELECT * FROM candidates_info where position='QUEEN' order by -vote_count limit 1";
            pst =conn.prepareStatement(qn);
            rs2= pst.executeQuery();
            
            //int smart=3;
            String st="SELECT * FROM candidates_info where position='SMART' order by -vote_count limit 1";
            pst =conn.prepareStatement(st);
            rs3= pst.executeQuery();
            
            //int style=4;
            String sty="SELECT * FROM candidates_info WHERE position='STYLE' ORDER BY -vote_count limit 1";
            pst =conn.prepareStatement(sty);
            rs4= pst.executeQuery();
            
            if(rs1.next()  && rs2.next() &&rs3.next() && rs4.next() )  {
                kingVote.setText(rs1.getString("vote_count"));
                kingName.setText(rs1.getString("fullname"));
                
                queenVote.setText(rs2.getString("vote_count"));
                queenName.setText(rs2.getString("fullname"));
                
                smartVote.setText(rs3.getString("vote_count"));
                smartName.setText(rs3.getString("fullname"));
                
                styleVote.setText(rs4.getString("vote_count"));
                styleName.setText(rs4.getString("fullname"));
                                              
            }           
        }      
        catch(Exception e){          
        }
    }
    public void close(){
    WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kingName = new javax.swing.JTextField();
        queenName = new javax.swing.JTextField();
        smartName = new javax.swing.JTextField();
        styleName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kingVote = new javax.swing.JLabel();
        queenVote = new javax.swing.JLabel();
        smartVote = new javax.swing.JLabel();
        styleVote = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WINNERS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 47, 123, 27));

        jLabel2.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("POSITION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 123, 85, 26));

        jLabel3.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 14)); // NOI18N
        jLabel3.setText("CANDIDATE NAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 116, -1, -1));

        jLabel4.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 14)); // NOI18N
        jLabel4.setText("WINNING VOTES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 114, -1, 26));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 155, 492, 10));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KING");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 171, 93, 29));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("QUEEN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 243, 93, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SMART");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 316, 93, 28));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("STYLE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 383, 93, 29));

        kingName.setEditable(false);
        jPanel1.add(kingName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 174, 154, -1));

        queenName.setEditable(false);
        jPanel1.add(queenName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 247, 154, -1));

        smartName.setEditable(false);
        jPanel1.add(smartName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 316, 154, -1));

        styleName.setEditable(false);
        jPanel1.add(styleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 386, 154, -1));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 171, -1, 23));

        kingVote.setText("10");
        jPanel1.add(kingVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 171, -1, 23));

        queenVote.setText("10");
        jPanel1.add(queenVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 238, -1, -1));

        smartVote.setText("10");
        jPanel1.add(smartVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 319, -1, -1));

        styleVote.setText("10");
        jPanel1.add(styleVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 389, -1, -1));

        closeBtn.setBackground(new java.awt.Color(153, 204, 255));
        closeBtn.setText("CLOSE");
        closeBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 492, 102, 36));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/BG2.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2, 620, 580));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_closeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewVotesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVotesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVotesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVotesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVotesPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kingName;
    private javax.swing.JLabel kingVote;
    private javax.swing.JTextField queenName;
    private javax.swing.JLabel queenVote;
    private javax.swing.JTextField smartName;
    private javax.swing.JLabel smartVote;
    private javax.swing.JTextField styleName;
    private javax.swing.JLabel styleVote;
    // End of variables declaration//GEN-END:variables
}
