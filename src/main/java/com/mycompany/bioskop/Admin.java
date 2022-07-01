/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bioskop;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author fajar
 */
public class Admin extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    
    Connection cn;
    String filename=null;
    byte[] person_image;

    public Admin() {
        this.person_image = null;
        this.cn = Koneksi.Koneksi();
        initComponents();
        judul();
        tampilData();

    }
    public ArrayList<UserAdmin>adminList(){
        ArrayList<UserAdmin>adminlist=new ArrayList<>();
        try{
            String Query="SELECT*FROM film";
            st=cn.createStatement();
            rs=st.executeQuery(Query);
            UserAdmin admin;
            while(rs.next()){
                admin=new UserAdmin(rs.getString("id_film"),rs.getString("judul"),rs.getString("genre"),
                        rs.getString("sipnosis"),rs.getBytes("poster"));
                adminlist.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adminlist;
    }
    public void judul(){
        Object[] judul={
           "ID","NAMA","Genre"
        };
        tabModel= new DefaultTableModel(null,judul);
        filmTB.setModel(tabModel);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idfilmTF = new javax.swing.JTextField();
        namafilmTF = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        tambahBT = new javax.swing.JButton();
        updateBT = new javax.swing.JButton();
        deleteBT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        browserBT = new javax.swing.JButton();
        gambarLB = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        filmTB = new javax.swing.JTable();
        resetBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        genreTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sipnosisTA = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("ID FILM");

        jLabel3.setText("Nama Film");

        idfilmTF.setText(" ");
        idfilmTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfilmTFActionPerformed(evt);
            }
        });

        namafilmTF.setText(" ");
        namafilmTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namafilmTFActionPerformed(evt);
            }
        });

        tambahBT.setText("Tambah");
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });

        updateBT.setText("Update");
        updateBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTActionPerformed(evt);
            }
        });

        deleteBT.setText("Delete");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        browserBT.setText("Browser");
        browserBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserBTActionPerformed(evt);
            }
        });

        gambarLB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gambarLB.setPreferredSize(new java.awt.Dimension(171, 220));

        filmTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        filmTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filmTBMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(filmTB);

        resetBT.setText("Reset");
        resetBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTActionPerformed(evt);
            }
        });

        jLabel4.setText("Genre");

        sipnosisTA.setColumns(20);
        sipnosisTA.setLineWrap(true);
        sipnosisTA.setRows(5);
        sipnosisTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(sipnosisTA);

        jLabel1.setText("Sipnosis");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namafilmTF, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(idfilmTF)
                                    .addComponent(genreTF)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(gambarLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(tambahBT)
                                .addGap(18, 18, 18)
                                .addComponent(updateBT)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(221, 221, 221)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(deleteBT)
                                        .addGap(18, 18, 18)
                                        .addComponent(resetBT))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(browserBT)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tambahBT)
                                    .addComponent(updateBT)
                                    .addComponent(deleteBT)
                                    .addComponent(resetBT))
                                .addGap(24, 24, 24)))
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idfilmTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namafilmTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(genreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(gambarLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(browserBT)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfilmTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfilmTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfilmTFActionPerformed

    private void namafilmTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namafilmTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namafilmTFActionPerformed

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
   try{
               String Query="INSERT INTO film (id_film, judul, genre, sipnosis, poster) VALUES(?,?,?,?,?)";
               PreparedStatement pst=cn.prepareStatement(Query);
               pst.setString(1,idfilmTF.getText());
               pst.setString(2,namafilmTF.getText());
               pst.setString(3, genreTF.getText());
               pst.setString(4, sipnosisTA.getText());
               pst.setBytes(5,person_image);
               pst.executeUpdate();
               DefaultTableModel model=(DefaultTableModel)filmTB.getModel();
               model.setRowCount(0);
               tampilData();
               JOptionPane.showMessageDialog(null,"Sukses");
   }
   catch(Exception e){
       JOptionPane.showMessageDialog(null,"GAGAL");
   }
    }//GEN-LAST:event_tambahBTActionPerformed

    private void updateBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTActionPerformed
       try{
           int row = filmTB.getSelectedRow();
           String value=(filmTB.getModel().getValueAt(row,0).toString());
           String Query="UPDATE film SET judul=?,genre=?,sipnosis=?,poster=? WHERE id_film="+idfilmTF.getText();
           PreparedStatement pst=cn.prepareStatement(Query); 
           pst.setString(1,namafilmTF.getText());
           pst.setString(2, genreTF.getText());
           pst.setString(3,sipnosisTA.getText());
           pst.setBytes(4,person_image);
           pst.executeUpdate();
           DefaultTableModel model=(DefaultTableModel)filmTB.getModel();
           model.setRowCount(0);
           tampilData();
           JOptionPane.showMessageDialog(null,"Update Sukses");
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Update Gagal");
       }
    }//GEN-LAST:event_updateBTActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
     
      try{
      int row=filmTB.getSelectedRow();
      String rowstr= String.valueOf(row);
      String value=(filmTB.getModel().getValueAt(row,0).toString());
      String Query="DELETE FROM film where id_film="+value;
      PreparedStatement pst=cn.prepareStatement(Query);
      pst.executeUpdate();
      DefaultTableModel model=(DefaultTableModel)filmTB.getModel();
           model.setRowCount(0);
           tampilData();
           JOptionPane.showMessageDialog(null,"Hapus Sukses");
    }
            catch(Exception e){
           JOptionPane.showMessageDialog(null,"Hapus gagal");
            }
    }//GEN-LAST:event_deleteBTActionPerformed

    private void browserBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserBTActionPerformed
    JFileChooser chooser=new JFileChooser();
    chooser.showOpenDialog(null);
    File file=chooser.getSelectedFile();
    filename=file.getAbsolutePath();
    ImageIcon imageicon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(gambarLB.getWidth(),gambarLB.getHeight(),Image.SCALE_SMOOTH));
    gambarLB.setIcon(imageicon);
    try{
    File image= new File(filename);
    FileInputStream fis=new FileInputStream(image);
    ByteArrayOutputStream bos= new ByteArrayOutputStream();
    byte[]buf=new byte[1024];
    for(int readNum;(readNum=fis.read(buf))!=-1;){
        bos.write(buf,0,readNum);
    }
    person_image=bos.toByteArray();
}
catch(Exception e){
    JOptionPane.showMessageDialog(null,e);   
}
// TODO add your handling code here:
    }//GEN-LAST:event_browserBTActionPerformed

    private void filmTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmTBMouseClicked
       int i=filmTB.getSelectedRow();
       TableModel model=filmTB.getModel();
       idfilmTF.setText(model.getValueAt(i,0).toString());
       namafilmTF.setText(model.getValueAt(i,1).toString());
       genreTF.setText(model.getValueAt(i,2).toString());
       sipnosisTA.setText(adminList().get(i).getSipnosis());
       byte[]img=(adminList().get(i).getGambar());
       ImageIcon imageicon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(gambarLB.getWidth(),gambarLB.getHeight(),Image.SCALE_SMOOTH));
       gambarLB.setIcon(imageicon);
       person_image=img;

    }//GEN-LAST:event_filmTBMouseClicked

    private void resetBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTActionPerformed
       idfilmTF.setText("");
       namafilmTF.setText("");
       genreTF.setText("");
       sipnosisTA.setText("");
    }//GEN-LAST:event_resetBTActionPerformed
 public void tampilData(){
      ArrayList<UserAdmin>list = adminList();
      DefaultTableModel model=(DefaultTableModel)filmTB.getModel();
      Object[]row =new Object [3];
      for(int i=0;i<list.size();i++){
          row[0]=list.get(i).getIdfilm();
          row[1]=list.get(i).getNamafilm();
          row[2]=list.get(i).getGenre();
          model.addRow(row);
      }
      
   }
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browserBT;
    private javax.swing.JButton deleteBT;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTable filmTB;
    private javax.swing.JLabel gambarLB;
    private javax.swing.JTextField genreTF;
    private javax.swing.JTextField idfilmTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namafilmTF;
    private javax.swing.JButton resetBT;
    private javax.swing.JTextArea sipnosisTA;
    private javax.swing.JButton tambahBT;
    private javax.swing.JButton updateBT;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the gambar
     */
  


}