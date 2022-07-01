/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bioskop;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fajar
 */
public class Menu extends javax.swing.JFrame {
    public static String bawaData;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn;
    String filename=null;
    byte[] person_image;
    
    public Menu(){
        this.cn = Koneksi.Koneksi();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namafilm1LB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        namafilm4LB = new javax.swing.JLabel();
        gambarfilmLB3 = new javax.swing.JLabel();
        gambarfilmLB1 = new javax.swing.JLabel();
        namaTF3 = new javax.swing.JLabel();
        namafilm2LB = new javax.swing.JLabel();
        gambarfilmLB2 = new javax.swing.JLabel();
        namafilm3LB = new javax.swing.JLabel();
        gambarfilm4LB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel1.setText("DAFTAR FILM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        jLabel2.setText(" ");

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jLabel3.setText("-----------------------------------------------------SEDANG TAYANG-----------------------------------------------------");
        jLabel3.setAlignmentY(0.0F);

        namafilm1LB.setText("Film1");

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jLabel9.setText("-----------------------------------------------------Coming Soon-----------------------------------------------------");
        jLabel9.setAlignmentY(0.0F);

        namafilm4LB.setText("film4");

        gambarfilmLB3.setText(" ");
        gambarfilmLB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gambarfilmLB3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gambarfilmLB3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gambarfilmLB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gambarfilmLB3MouseClicked(evt);
            }
        });

        gambarfilmLB1.setBackground(new java.awt.Color(255, 255, 255));
        gambarfilmLB1.setText(" ");
        gambarfilmLB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gambarfilmLB1.setPreferredSize(new java.awt.Dimension(5, 16));
        gambarfilmLB1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gambarfilmLB1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gambarfilmLB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gambarfilmLB1MouseClicked(evt);
            }
        });

        namaTF3.setText(" ");

        namafilm2LB.setText("film2");

        gambarfilmLB2.setText(" ");
        gambarfilmLB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gambarfilmLB2.setPreferredSize(new java.awt.Dimension(5, 16));
        gambarfilmLB2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gambarfilmLB2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gambarfilmLB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gambarfilmLB2MouseClicked(evt);
            }
        });

        namafilm3LB.setText("film3");

        gambarfilm4LB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gambarfilm4LBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(317, 317, 317)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(222, 222, 222)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(namafilm2LB, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(gambarfilmLB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gambarfilmLB3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(namafilm3LB, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel3))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(561, 561, 561)
                        .addComponent(namaTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namafilm4LB, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(gambarfilm4LB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gambarfilmLB1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namafilm1LB, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gambarfilmLB3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gambarfilmLB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namafilm1LB)
                            .addComponent(namafilm2LB)
                            .addComponent(namafilm3LB))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gambarfilm4LB, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namafilm4LB)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel10))
                            .addComponent(namaTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(gambarfilmLB1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void gambar1(String where){
    try{
        st=cn.createStatement();
        byte[]image=null;
        rs=st.executeQuery("SELECT poster from film where id_film='"+where+"'");
        while(rs.next()){
            image=rs.getBytes("poster");
        }
        Image img=Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);
        gambarfilmLB1.setIcon(icon);
    }
    catch(Exception e){
        
    }
}
    public void gambar2(String where){
    try{
        st=cn.createStatement();
        byte[]image=null;
        rs=st.executeQuery("SELECT poster from film where id_film='"+where+"'");
        while(rs.next()){
            image=rs.getBytes("poster");
        }
        Image img=Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);

        gambarfilmLB2.setIcon(icon);
    }
    catch(Exception e){
        
    }
}
public void gambar3(String where){
    try{
        st=cn.createStatement();
        byte[]image=null;
        rs=st.executeQuery("SELECT poster from film where id_film='"+where+"'");
        while(rs.next()){
            image=rs.getBytes("poster");
        }
        Image img=Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);
        gambarfilmLB3.setIcon(icon);
    }
    catch(Exception e){
        
    }
}
public void gambar4(String where){
    try{
        st=cn.createStatement();
        byte[]image=null;
        rs=st.executeQuery("SELECT poster from film where id_film='"+where+"'");
        while(rs.next()){
            image=rs.getBytes("poster");
        }
        Image img=Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);
        gambarfilm4LB.setIcon(icon);
    }
    catch(Exception e){
        
    }
}
    private void gambarfilmLB3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gambarfilmLB3AncestorAdded
        gambar3("3333");
        data3("3333");
    }//GEN-LAST:event_gambarfilmLB3AncestorAdded

    private void gambarfilmLB1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gambarfilmLB1AncestorAdded
       gambar1("1111");
       data1("1111");
    }//GEN-LAST:event_gambarfilmLB1AncestorAdded

    private void gambarfilmLB2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gambarfilmLB2AncestorAdded
       gambar2("2222");
       data2("2222");
    }//GEN-LAST:event_gambarfilmLB2AncestorAdded

    private void gambarfilm4LBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gambarfilm4LBAncestorAdded
       gambar4("4444");
       data4("4444");
    }//GEN-LAST:event_gambarfilm4LBAncestorAdded
    
    private void gambarfilmLB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gambarfilmLB2MouseClicked
        // TODO add your handling code here:
        setBawaData(namafilm2LB.getText());
        new JadwalJframe().setVisible(true);  
        dispose();

    }//GEN-LAST:event_gambarfilmLB2MouseClicked

    private void gambarfilmLB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gambarfilmLB1MouseClicked
        // TODO add your handling code here:
        setBawaData(namafilm1LB.getText());
        new JadwalJframe().setVisible(true);  
        dispose();
    }//GEN-LAST:event_gambarfilmLB1MouseClicked

    private void gambarfilmLB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gambarfilmLB3MouseClicked
        // TODO add your handling code here:
        setBawaData(namafilm3LB.getText());
        new JadwalJframe().setVisible(true);  
        dispose();
    }//GEN-LAST:event_gambarfilmLB3MouseClicked
public void data1(String Where){
   try {
                String sql="select*  from film where id_film='"+Where+"'";
                st=cn.createStatement();
                rs=st.executeQuery(sql);

                while(rs.next())
                {
                    namafilm1LB.setText(rs.getString("judul"));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"GAGAL");
            }         
}
public void data2(String Where){
   try {
                String sql="select*  from film where id_film='"+Where+"'";
                st=cn.createStatement();
                rs=st.executeQuery(sql);

                while(rs.next())
                {
                    namafilm2LB.setText(rs.getString("judul"));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"GAGAL");
            }         
}
public void data3(String Where){
   try {
                String sql="select*  from film where id_film='"+Where+"'";
                st=cn.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next())
                {
                    namafilm3LB.setText(rs.getString("judul"));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"GAGAL");
            }         
}
public void data4(String Where){
   try {
                String sql="select*  from film where id_film='"+Where+"'";
                st=cn.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next())
                {
                    namafilm4LB.setText(rs.getString("judul"));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"GAGAL");
            }         
}
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                
            }
            
        });
    }
    
    public void setBawaData(String bawaData){
        this.bawaData = bawaData;
    }
    
    public String getBawaData(){
        return bawaData;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gambarfilm4LB;
    private javax.swing.JLabel gambarfilmLB1;
    private javax.swing.JLabel gambarfilmLB2;
    private javax.swing.JLabel gambarfilmLB3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel namaTF3;
    private javax.swing.JLabel namafilm1LB;
    private javax.swing.JLabel namafilm2LB;
    private javax.swing.JLabel namafilm3LB;
    private javax.swing.JLabel namafilm4LB;
    // End of variables declaration//GEN-END:variables
}
