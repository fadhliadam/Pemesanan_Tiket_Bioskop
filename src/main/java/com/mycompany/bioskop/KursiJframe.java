/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bioskop;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author fadhl
 */
public class KursiJframe extends javax.swing.JFrame {
    public static String kursi,total;
    int a;
    long totalHarga;
    String hargaRegular;
    String listKursi = "";
    public Statement st;
    public ResultSet rs;
    Connection cn;

    /**
     * Creates new form KursiJframe
     */
    public KursiJframe() {
        this.cn = Koneksi.Koneksi();
        initComponents();
        editable();
        tampilDataFilm("");
        listener();
    }
    
    public void tampilDataFilm(String where){
        try{
            Menu bawaDatas = new Menu();
            where = bawaDatas.getBawaData();
            st = cn.createStatement();
            byte[] image = null;
            rs = st.executeQuery("SELECT * "
                    + "FROM tayang INNER JOIN film ON tayang.id_film = film.id_film "
                    + "INNER JOIN studio ON tayang.id_studio = studio.id_studio "
                    + "INNER JOIN jadwal ON tayang.id_jadwal = jadwal.id_jadwal where judul ='"+where+"'");
            while(rs.next()){
                image = rs.getBytes("poster");
                JudulFilmTA.setText(rs.getString("judul"));
                KategoriTF.setText(rs.getString("genre"));
                TmpBskpTA.setText("Bioskop: "+rs.getString("lokasi"));
                TglTA.setText("Tanggal: "+rs.getString("tanggal"));
                LyrTA.setText("Layar: "+rs.getString("layar_studio"));
                hargaRegular = rs.getString("harga_regular");
            }
            Image img = Toolkit.getDefaultToolkit().createImage(image);
            ImageIcon icone = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(GambarJL.getWidth(),GambarJL.getHeight(),Image.SCALE_SMOOTH));
            GambarJL.setIcon(icone);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editable(){
        LAYARNOEDIT.setEditable(false);
        TersediaTF.setEditable(false);
        TersimpanTF.setEditable(false);
        SweetTF.setEditable(false);
        TerpilihTF.setEditable(false);
        JudulFilmTA.setEditable(false);
        KategoriTF.setEditable(false);
        RegulalKatTF.setEditable(false);
        TmpBskpTA.setEditable(false);
        ToHrgTA.setEditable(false);
        LyrTA.setEditable(false);
        TglTA.setEditable(false);
        JmlKrsTF.setEditable(false);
        NoKrsTA.setEditable(false);
    }
    public void listener(){
        Component[] comp = {A1TB, A2TB,A3TB,A4TB,A5TB,A6TB,A7TB,A8TB,A9TB,A10TB,
            A11TB,A12TB,A13TB,A14TB,B2TB,B3TB,B4TB,B6TB,B7TB,B8TB,B9TB,B11TB,B12TB,
            B13TB,B14TB,C2TB,C3TB,C4TB,C6TB,C7TB,C8TB,C9TB,C11TB,C12TB,C13TB,C14TB,
            D1TB,D2TB,D3TB,D4TB,D6TB,D7TB,D8TB,D9TB,D11TB,D12TB,E1TB,E2TB,E3TB,E4TB,
            E6TB,E7TB,E8TB,E9TB,E11TB,E12TB,F1TB,F2TB,F3TB,F4TB,F6TB,F7TB,F8TB,F9TB,
            F11TB,F12TB,F13TB,F14TB
        };
        for (Component comp1 : comp) {
            JToggleButton b = (JToggleButton) comp1;
            b.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent ev) {
                    if(ev.getStateChange()==ItemEvent.SELECTED){
                        listKursi += (b.getText()+",");
                        totalHarga += Long.parseLong(hargaRegular);
                        a += 1;
                    }else if(ev.getStateChange()==ItemEvent.DESELECTED){
                        listKursi = listKursi.substring(0, listKursi.length()-1);
                        listKursi = listKursi.replaceAll(b.getText(), "");
                        totalHarga = totalHarga - Long.parseLong(hargaRegular);
                        a = a-1;
                    }
                    NoKrsTA.setText("Kursi No: "+listKursi);
                    ToHrgTA.setText("Total Harga: "+Long.toString(totalHarga));
                    JmlKrsTF.setText("Jumlah Kursi: "+Integer.toString(a));
                    try{
                        setKursi(listKursi.substring(0,listKursi.length()-1));
                        setTotal(Long.toString(totalHarga));
                    }catch(Exception e){
                        
                    }
                }
            });
        }
    }
    
    public void setKursi(String kursi){
        this.kursi = kursi;
    }
    
    public String getKursi(){
        return kursi;
    }
    
    public void setTotal(String total){
        this.total = total;
    }
    
    public String getTotal(){
        return total;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton13 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LAYARNOEDIT = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        A1TB = new ColorToggleButton();
        A2TB = new ColorToggleButton();
        A3TB = new ColorToggleButton();
        A4TB = new ColorToggleButton();
        A5TB = new ColorToggleButton();
        A6TB = new ColorToggleButton();
        A7TB = new ColorToggleButton();
        A8TB = new ColorToggleButton();
        A9TB = new ColorToggleButton();
        A10TB = new ColorToggleButton();
        A11TB = new ColorToggleButton();
        A12TB = new ColorToggleButton();
        A13TB = new ColorToggleButton();
        A14TB = new ColorToggleButton();
        B2TB = new ColorToggleButton();
        B3TB = new ColorToggleButton();
        B4TB = new ColorToggleButton();
        B6TB = new ColorToggleButton();
        B7TB = new ColorToggleButton();
        B8TB = new ColorToggleButton();
        B9TB = new ColorToggleButton();
        B11TB = new ColorToggleButton();
        B12TB = new ColorToggleButton();
        B13TB = new ColorToggleButton();
        B14TB = new ColorToggleButton();
        C2TB = new ColorToggleButton();
        C3TB = new ColorToggleButton();
        C4TB = new ColorToggleButton();
        C6TB = new ColorToggleButton();
        C7TB = new ColorToggleButton();
        C8TB = new ColorToggleButton();
        C9TB = new ColorToggleButton();
        C11TB = new ColorToggleButton();
        C12TB = new ColorToggleButton();
        C13TB = new ColorToggleButton();
        C14TB = new ColorToggleButton();
        D1TB = new ColorToggleButton();
        D2TB = new ColorToggleButton();
        D3TB = new ColorToggleButton();
        D4TB = new ColorToggleButton();
        D6TB = new ColorToggleButton();
        D7TB = new ColorToggleButton();
        D8TB = new ColorToggleButton();
        D9TB = new ColorToggleButton();
        D11TB = new ColorToggleButton();
        D12TB = new ColorToggleButton();
        E1TB = new ColorToggleButton();
        E2TB = new ColorToggleButton();
        E3TB = new ColorToggleButton();
        E4TB = new ColorToggleButton();
        E6TB = new ColorToggleButton();
        E7TB = new ColorToggleButton();
        E8TB = new ColorToggleButton();
        E9TB = new ColorToggleButton();
        E11TB = new ColorToggleButton();
        E12TB = new ColorToggleButton();
        F1TB = new ColorToggleButton();
        F2TB = new ColorToggleButton();
        F3TB = new ColorToggleButton();
        F4TB = new ColorToggleButton();
        F6TB = new ColorToggleButton();
        F7TB = new ColorToggleButton();
        F8TB = new ColorToggleButton();
        F9TB = new ColorToggleButton();
        F11TB = new ColorToggleButton();
        F12TB = new ColorToggleButton();
        F13TB = new ColorToggleButton();
        F14TB = new ColorToggleButton();
        TersediaTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TersimpanTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SweetTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TerpilihTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        SebelumnyaJP = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JudulFilmTA = new javax.swing.JTextArea();
        RegulalKatTF = new javax.swing.JTextField();
        KategoriTF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TmpBskpTA = new javax.swing.JTextArea();
        TglTA = new javax.swing.JTextArea();
        LyrTA = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        JmlKrsTF = new javax.swing.JTextField();
        NoKrsTA = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        ToHrgTA = new javax.swing.JTextArea();
        SelanjutnyaJP = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton79 = new javax.swing.JButton();
        GambarJL = new javax.swing.JLabel();

        jToggleButton13.setBackground(new java.awt.Color(153, 153, 153));
        jToggleButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton13.setForeground(new java.awt.Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("KURSI/ORANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LAYARNOEDIT.setBackground(new java.awt.Color(255, 255, 255));
        LAYARNOEDIT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LAYARNOEDIT.setForeground(new java.awt.Color(0, 0, 0));
        LAYARNOEDIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LAYARNOEDIT.setText("LAYAR");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        A1TB.setBackground(new java.awt.Color(153, 153, 153));
        A1TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A1TB.setForeground(new java.awt.Color(0, 0, 0));
        A1TB.setText("A1");

        A2TB.setBackground(new java.awt.Color(153, 153, 153));
        A2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A2TB.setForeground(new java.awt.Color(0, 0, 0));
        A2TB.setText("A2");

        A3TB.setBackground(new java.awt.Color(153, 153, 153));
        A3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A3TB.setForeground(new java.awt.Color(0, 0, 0));
        A3TB.setText("A3");

        A4TB.setBackground(new java.awt.Color(153, 153, 153));
        A4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A4TB.setForeground(new java.awt.Color(0, 0, 0));
        A4TB.setText("A4");

        A5TB.setBackground(new java.awt.Color(153, 153, 153));
        A5TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A5TB.setForeground(new java.awt.Color(0, 0, 0));
        A5TB.setText("A5");

        A6TB.setBackground(new java.awt.Color(153, 153, 153));
        A6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A6TB.setForeground(new java.awt.Color(0, 0, 0));
        A6TB.setText("A6");

        A7TB.setBackground(new java.awt.Color(153, 153, 153));
        A7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A7TB.setForeground(new java.awt.Color(0, 0, 0));
        A7TB.setText("A7");

        A8TB.setBackground(new java.awt.Color(153, 153, 153));
        A8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A8TB.setForeground(new java.awt.Color(0, 0, 0));
        A8TB.setText("A8");

        A9TB.setBackground(new java.awt.Color(153, 153, 153));
        A9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A9TB.setForeground(new java.awt.Color(0, 0, 0));
        A9TB.setText("A9");

        A10TB.setBackground(new java.awt.Color(153, 153, 153));
        A10TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A10TB.setForeground(new java.awt.Color(0, 0, 0));
        A10TB.setText("A10");

        A11TB.setBackground(new java.awt.Color(153, 153, 153));
        A11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A11TB.setForeground(new java.awt.Color(0, 0, 0));
        A11TB.setText("A11");

        A12TB.setBackground(new java.awt.Color(153, 153, 153));
        A12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A12TB.setForeground(new java.awt.Color(0, 0, 0));
        A12TB.setText("A12");

        A13TB.setBackground(new java.awt.Color(153, 153, 153));
        A13TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A13TB.setForeground(new java.awt.Color(0, 0, 0));
        A13TB.setText("A13");

        A14TB.setBackground(new java.awt.Color(153, 153, 153));
        A14TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        A14TB.setForeground(new java.awt.Color(0, 0, 0));
        A14TB.setText("A14");

        B2TB.setBackground(new java.awt.Color(153, 153, 153));
        B2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B2TB.setForeground(new java.awt.Color(0, 0, 0));
        B2TB.setText("B2");

        B3TB.setBackground(new java.awt.Color(153, 153, 153));
        B3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B3TB.setForeground(new java.awt.Color(0, 0, 0));
        B3TB.setText("B3");

        B4TB.setBackground(new java.awt.Color(153, 153, 153));
        B4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B4TB.setForeground(new java.awt.Color(0, 0, 0));
        B4TB.setText("B4");

        B6TB.setBackground(new java.awt.Color(153, 153, 153));
        B6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B6TB.setForeground(new java.awt.Color(0, 0, 0));
        B6TB.setText("B6");

        B7TB.setBackground(new java.awt.Color(153, 153, 153));
        B7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B7TB.setForeground(new java.awt.Color(0, 0, 0));
        B7TB.setText("B7");

        B8TB.setBackground(new java.awt.Color(153, 153, 153));
        B8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B8TB.setForeground(new java.awt.Color(0, 0, 0));
        B8TB.setText("B8");

        B9TB.setBackground(new java.awt.Color(153, 153, 153));
        B9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B9TB.setForeground(new java.awt.Color(0, 0, 0));
        B9TB.setText("B9");

        B11TB.setBackground(new java.awt.Color(153, 153, 153));
        B11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B11TB.setForeground(new java.awt.Color(0, 0, 0));
        B11TB.setText("B11");

        B12TB.setBackground(new java.awt.Color(153, 153, 153));
        B12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B12TB.setForeground(new java.awt.Color(0, 0, 0));
        B12TB.setText("B12");

        B13TB.setBackground(new java.awt.Color(153, 153, 153));
        B13TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B13TB.setForeground(new java.awt.Color(0, 0, 0));
        B13TB.setText("B13");

        B14TB.setBackground(new java.awt.Color(153, 153, 153));
        B14TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B14TB.setForeground(new java.awt.Color(0, 0, 0));
        B14TB.setText("B14");

        C2TB.setBackground(new java.awt.Color(153, 153, 153));
        C2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C2TB.setForeground(new java.awt.Color(0, 0, 0));
        C2TB.setText("C2");

        C3TB.setBackground(new java.awt.Color(153, 153, 153));
        C3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C3TB.setForeground(new java.awt.Color(0, 0, 0));
        C3TB.setText("C3");

        C4TB.setBackground(new java.awt.Color(153, 153, 153));
        C4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C4TB.setForeground(new java.awt.Color(0, 0, 0));
        C4TB.setText("C4");

        C6TB.setBackground(new java.awt.Color(153, 153, 153));
        C6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C6TB.setForeground(new java.awt.Color(0, 0, 0));
        C6TB.setText("C6");

        C7TB.setBackground(new java.awt.Color(153, 153, 153));
        C7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C7TB.setForeground(new java.awt.Color(0, 0, 0));
        C7TB.setText("C7");

        C8TB.setBackground(new java.awt.Color(153, 153, 153));
        C8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C8TB.setForeground(new java.awt.Color(0, 0, 0));
        C8TB.setText("C8");

        C9TB.setBackground(new java.awt.Color(153, 153, 153));
        C9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C9TB.setForeground(new java.awt.Color(0, 0, 0));
        C9TB.setText("C9");

        C11TB.setBackground(new java.awt.Color(153, 153, 153));
        C11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C11TB.setForeground(new java.awt.Color(0, 0, 0));
        C11TB.setText("C11");

        C12TB.setBackground(new java.awt.Color(153, 153, 153));
        C12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C12TB.setForeground(new java.awt.Color(0, 0, 0));
        C12TB.setText("C12");

        C13TB.setBackground(new java.awt.Color(153, 153, 153));
        C13TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C13TB.setForeground(new java.awt.Color(0, 0, 0));
        C13TB.setText("C13");

        C14TB.setBackground(new java.awt.Color(153, 153, 153));
        C14TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        C14TB.setForeground(new java.awt.Color(0, 0, 0));
        C14TB.setText("C14");

        D1TB.setBackground(new java.awt.Color(153, 153, 153));
        D1TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D1TB.setForeground(new java.awt.Color(0, 0, 0));
        D1TB.setText("D1");

        D2TB.setBackground(new java.awt.Color(153, 153, 153));
        D2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D2TB.setForeground(new java.awt.Color(0, 0, 0));
        D2TB.setText("D2");

        D3TB.setBackground(new java.awt.Color(153, 153, 153));
        D3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D3TB.setForeground(new java.awt.Color(0, 0, 0));
        D3TB.setText("D3");

        D4TB.setBackground(new java.awt.Color(153, 153, 153));
        D4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D4TB.setForeground(new java.awt.Color(0, 0, 0));
        D4TB.setText("D4");

        D6TB.setBackground(new java.awt.Color(153, 153, 153));
        D6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D6TB.setForeground(new java.awt.Color(0, 0, 0));
        D6TB.setText("D6");

        D7TB.setBackground(new java.awt.Color(153, 153, 153));
        D7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D7TB.setForeground(new java.awt.Color(0, 0, 0));
        D7TB.setText("D7");

        D8TB.setBackground(new java.awt.Color(153, 153, 153));
        D8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D8TB.setForeground(new java.awt.Color(0, 0, 0));
        D8TB.setText("D8");

        D9TB.setBackground(new java.awt.Color(153, 153, 153));
        D9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D9TB.setForeground(new java.awt.Color(0, 0, 0));
        D9TB.setText("D9");

        D11TB.setBackground(new java.awt.Color(153, 153, 153));
        D11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D11TB.setForeground(new java.awt.Color(0, 0, 0));
        D11TB.setText("D11");

        D12TB.setBackground(new java.awt.Color(153, 153, 153));
        D12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        D12TB.setForeground(new java.awt.Color(0, 0, 0));
        D12TB.setText("D12");

        E1TB.setBackground(new java.awt.Color(153, 153, 153));
        E1TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E1TB.setForeground(new java.awt.Color(0, 0, 0));
        E1TB.setText("E1");

        E2TB.setBackground(new java.awt.Color(153, 153, 153));
        E2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E2TB.setForeground(new java.awt.Color(0, 0, 0));
        E2TB.setText("E2");

        E3TB.setBackground(new java.awt.Color(153, 153, 153));
        E3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E3TB.setForeground(new java.awt.Color(0, 0, 0));
        E3TB.setText("E3");

        E4TB.setBackground(new java.awt.Color(153, 153, 153));
        E4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E4TB.setForeground(new java.awt.Color(0, 0, 0));
        E4TB.setText("E4");

        E6TB.setBackground(new java.awt.Color(153, 153, 153));
        E6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E6TB.setForeground(new java.awt.Color(0, 0, 0));
        E6TB.setText("E6");

        E7TB.setBackground(new java.awt.Color(153, 153, 153));
        E7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E7TB.setForeground(new java.awt.Color(0, 0, 0));
        E7TB.setText("E7");

        E8TB.setBackground(new java.awt.Color(153, 153, 153));
        E8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E8TB.setForeground(new java.awt.Color(0, 0, 0));
        E8TB.setText("E8");

        E9TB.setBackground(new java.awt.Color(153, 153, 153));
        E9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E9TB.setForeground(new java.awt.Color(0, 0, 0));
        E9TB.setText("E9");

        E11TB.setBackground(new java.awt.Color(153, 153, 153));
        E11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E11TB.setForeground(new java.awt.Color(0, 0, 0));
        E11TB.setText("E11");

        E12TB.setBackground(new java.awt.Color(153, 153, 153));
        E12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E12TB.setForeground(new java.awt.Color(0, 0, 0));
        E12TB.setText("E12");

        F1TB.setBackground(new java.awt.Color(153, 153, 153));
        F1TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F1TB.setForeground(new java.awt.Color(0, 0, 0));
        F1TB.setText("F1");

        F2TB.setBackground(new java.awt.Color(153, 153, 153));
        F2TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F2TB.setForeground(new java.awt.Color(0, 0, 0));
        F2TB.setText("F2");

        F3TB.setBackground(new java.awt.Color(153, 153, 153));
        F3TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F3TB.setForeground(new java.awt.Color(0, 0, 0));
        F3TB.setText("F3");

        F4TB.setBackground(new java.awt.Color(153, 153, 153));
        F4TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F4TB.setForeground(new java.awt.Color(0, 0, 0));
        F4TB.setText("F4");

        F6TB.setBackground(new java.awt.Color(153, 153, 153));
        F6TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F6TB.setForeground(new java.awt.Color(0, 0, 0));
        F6TB.setText("F6");

        F7TB.setBackground(new java.awt.Color(153, 153, 153));
        F7TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F7TB.setForeground(new java.awt.Color(0, 0, 0));
        F7TB.setText("F7");

        F8TB.setBackground(new java.awt.Color(153, 153, 153));
        F8TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F8TB.setForeground(new java.awt.Color(0, 0, 0));
        F8TB.setText("F8");

        F9TB.setBackground(new java.awt.Color(153, 153, 153));
        F9TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F9TB.setForeground(new java.awt.Color(0, 0, 0));
        F9TB.setText("F9");

        F11TB.setBackground(new java.awt.Color(153, 153, 153));
        F11TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F11TB.setForeground(new java.awt.Color(0, 0, 0));
        F11TB.setText("F11");

        F12TB.setBackground(new java.awt.Color(153, 153, 153));
        F12TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F12TB.setForeground(new java.awt.Color(0, 0, 0));
        F12TB.setText("F12");

        F13TB.setBackground(new java.awt.Color(153, 153, 153));
        F13TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F13TB.setForeground(new java.awt.Color(0, 0, 0));
        F13TB.setText("F13");

        F14TB.setBackground(new java.awt.Color(153, 153, 153));
        F14TB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        F14TB.setForeground(new java.awt.Color(0, 0, 0));
        F14TB.setText("F14");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(F2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(B2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(B6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(A2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A5TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(A10TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A13TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(A14TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(B11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B13TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B14TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(C2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(D2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(D3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(128, 128, 128)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(D6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(D7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(D8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(C6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(C7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(C8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(E6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(E7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(E8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(F6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(F7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(F8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(C9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(D9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(E9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(F9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(C11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(C12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(D11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(D12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C13TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C14TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(E11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(E12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(F11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(F12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(F13TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(F14TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addComponent(E1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(E2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(E3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(D4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(F1TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F2TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F4TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F6TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F7TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F9TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F11TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F8TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F12TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F13TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F14TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(E1TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E2TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E3TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E4TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E6TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E7TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E8TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E9TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E11TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E12TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(D1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(D2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(D3TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D6TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D7TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D8TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D9TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D11TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D12TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C2TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C3TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C4TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C6TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C7TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C8TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C9TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C11TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C12TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C13TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C14TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B2TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B7TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B8TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B9TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B11TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B12TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B13TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B14TB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(A1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A2TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A3TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A5TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A6TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A7TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A8TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A9TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A10TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A11TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A12TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A13TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A14TB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        TersediaTF.setBackground(new java.awt.Color(204, 204, 204));
        TersediaTF.setForeground(new java.awt.Color(204, 204, 204));
        TersediaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tersedia");

        TersimpanTF.setBackground(new java.awt.Color(102, 102, 102));
        TersimpanTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tersimpan");

        SweetTF.setBackground(new java.awt.Color(255, 102, 102));
        SweetTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Sweet Box");

        TerpilihTF.setBackground(new java.awt.Color(102, 102, 255));
        TerpilihTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Terpilih");

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        SebelumnyaJP.setBackground(new java.awt.Color(51, 153, 255));
        SebelumnyaJP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        SebelumnyaJP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SebelumnyaJP.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sebelumnya");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 70)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("←");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SebelumnyaJPLayout = new javax.swing.GroupLayout(SebelumnyaJP);
        SebelumnyaJP.setLayout(SebelumnyaJPLayout);
        SebelumnyaJPLayout.setHorizontalGroup(
            SebelumnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SebelumnyaJPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SebelumnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SebelumnyaJPLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SebelumnyaJPLayout.setVerticalGroup(
            SebelumnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SebelumnyaJPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        JudulFilmTA.setBackground(new java.awt.Color(51, 153, 255));
        JudulFilmTA.setColumns(20);
        JudulFilmTA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JudulFilmTA.setForeground(new java.awt.Color(0, 0, 0));
        JudulFilmTA.setLineWrap(true);
        JudulFilmTA.setRows(3);
        JudulFilmTA.setText("JUDUL");
        JudulFilmTA.setWrapStyleWord(true);
        JudulFilmTA.setBorder(null);

        RegulalKatTF.setBackground(new java.awt.Color(51, 153, 255));
        RegulalKatTF.setForeground(new java.awt.Color(0, 0, 0));
        RegulalKatTF.setText("Regular Kategori:");
        RegulalKatTF.setBorder(null);

        KategoriTF.setBackground(new java.awt.Color(51, 153, 255));
        KategoriTF.setForeground(new java.awt.Color(0, 0, 0));
        KategoriTF.setText("Kategori");
        KategoriTF.setBorder(null);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TmpBskpTA.setBackground(new java.awt.Color(51, 153, 255));
        TmpBskpTA.setColumns(20);
        TmpBskpTA.setForeground(new java.awt.Color(0, 0, 0));
        TmpBskpTA.setLineWrap(true);
        TmpBskpTA.setRows(3);
        TmpBskpTA.setText("Bioskop: ");
        TmpBskpTA.setWrapStyleWord(true);
        TmpBskpTA.setBorder(null);

        TglTA.setBackground(new java.awt.Color(51, 153, 255));
        TglTA.setColumns(20);
        TglTA.setForeground(new java.awt.Color(0, 0, 0));
        TglTA.setLineWrap(true);
        TglTA.setRows(3);
        TglTA.setText("Tanggal: ");
        TglTA.setWrapStyleWord(true);
        TglTA.setBorder(null);

        LyrTA.setBackground(new java.awt.Color(51, 153, 255));
        LyrTA.setColumns(20);
        LyrTA.setForeground(new java.awt.Color(0, 0, 0));
        LyrTA.setLineWrap(true);
        LyrTA.setRows(3);
        LyrTA.setText("Layar:  ");
        LyrTA.setBorder(null);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        JmlKrsTF.setBackground(new java.awt.Color(51, 153, 255));
        JmlKrsTF.setForeground(new java.awt.Color(0, 0, 0));
        JmlKrsTF.setText("Jumlah Kursi: ");
        JmlKrsTF.setBorder(null);

        NoKrsTA.setBackground(new java.awt.Color(51, 153, 255));
        NoKrsTA.setColumns(20);
        NoKrsTA.setForeground(new java.awt.Color(0, 0, 0));
        NoKrsTA.setLineWrap(true);
        NoKrsTA.setRows(3);
        NoKrsTA.setText("Kursi No: ");
        NoKrsTA.setBorder(null);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ToHrgTA.setBackground(new java.awt.Color(51, 153, 255));
        ToHrgTA.setColumns(20);
        ToHrgTA.setForeground(new java.awt.Color(0, 0, 0));
        ToHrgTA.setLineWrap(true);
        ToHrgTA.setRows(3);
        ToHrgTA.setText("Total Harga: ");
        ToHrgTA.setBorder(null);

        SelanjutnyaJP.setBackground(new java.awt.Color(51, 153, 255));
        SelanjutnyaJP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        SelanjutnyaJP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelanjutnyaJP.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Selanjutnya");

        jButton79.setBackground(new java.awt.Color(51, 153, 255));
        jButton79.setFont(new java.awt.Font("Segoe UI", 0, 70)); // NOI18N
        jButton79.setForeground(new java.awt.Color(255, 255, 255));
        jButton79.setText("→");
        jButton79.setAlignmentY(0.0F);
        jButton79.setBorder(null);
        jButton79.setBorderPainted(false);
        jButton79.setContentAreaFilled(false);
        jButton79.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton79.setFocusPainted(false);
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelanjutnyaJPLayout = new javax.swing.GroupLayout(SelanjutnyaJP);
        SelanjutnyaJP.setLayout(SelanjutnyaJPLayout);
        SelanjutnyaJPLayout.setHorizontalGroup(
            SelanjutnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelanjutnyaJPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SelanjutnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SelanjutnyaJPLayout.setVerticalGroup(
            SelanjutnyaJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelanjutnyaJPLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        GambarJL.setBackground(new java.awt.Color(255, 255, 255));
        GambarJL.setText("gambar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(SebelumnyaJP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(GambarJL, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegulalKatTF)
                    .addComponent(KategoriTF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JudulFilmTA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TmpBskpTA, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(TglTA, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(LyrTA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JmlKrsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoKrsTA, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ToHrgTA, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SelanjutnyaJP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GambarJL, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelanjutnyaJP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ToHrgTA, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(JmlKrsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoKrsTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(JudulFilmTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RegulalKatTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KategoriTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TmpBskpTA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TglTA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LyrTA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SebelumnyaJP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LAYARNOEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(TersediaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TersimpanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(SweetTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(TerpilihTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LAYARNOEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TersediaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TersimpanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SweetTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TerpilihTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        new PembayaranJframe().setVisible(true);  
        dispose();
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new JadwalJframe().setVisible(true);  
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(KursiJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KursiJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KursiJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KursiJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KursiJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton A10TB;
    private javax.swing.JToggleButton A11TB;
    private javax.swing.JToggleButton A12TB;
    private javax.swing.JToggleButton A13TB;
    private javax.swing.JToggleButton A14TB;
    private javax.swing.JToggleButton A1TB;
    private javax.swing.JToggleButton A2TB;
    private javax.swing.JToggleButton A3TB;
    private javax.swing.JToggleButton A4TB;
    private javax.swing.JToggleButton A5TB;
    private javax.swing.JToggleButton A6TB;
    private javax.swing.JToggleButton A7TB;
    private javax.swing.JToggleButton A8TB;
    private javax.swing.JToggleButton A9TB;
    private javax.swing.JToggleButton B11TB;
    private javax.swing.JToggleButton B12TB;
    private javax.swing.JToggleButton B13TB;
    private javax.swing.JToggleButton B14TB;
    private javax.swing.JToggleButton B2TB;
    private javax.swing.JToggleButton B3TB;
    private javax.swing.JToggleButton B4TB;
    private javax.swing.JToggleButton B6TB;
    private javax.swing.JToggleButton B7TB;
    private javax.swing.JToggleButton B8TB;
    private javax.swing.JToggleButton B9TB;
    private javax.swing.JToggleButton C11TB;
    private javax.swing.JToggleButton C12TB;
    private javax.swing.JToggleButton C13TB;
    private javax.swing.JToggleButton C14TB;
    private javax.swing.JToggleButton C2TB;
    private javax.swing.JToggleButton C3TB;
    private javax.swing.JToggleButton C4TB;
    private javax.swing.JToggleButton C6TB;
    private javax.swing.JToggleButton C7TB;
    private javax.swing.JToggleButton C8TB;
    private javax.swing.JToggleButton C9TB;
    private javax.swing.JToggleButton D11TB;
    private javax.swing.JToggleButton D12TB;
    private javax.swing.JToggleButton D1TB;
    private javax.swing.JToggleButton D2TB;
    private javax.swing.JToggleButton D3TB;
    private javax.swing.JToggleButton D4TB;
    private javax.swing.JToggleButton D6TB;
    private javax.swing.JToggleButton D7TB;
    private javax.swing.JToggleButton D8TB;
    private javax.swing.JToggleButton D9TB;
    private javax.swing.JToggleButton E11TB;
    private javax.swing.JToggleButton E12TB;
    private javax.swing.JToggleButton E1TB;
    private javax.swing.JToggleButton E2TB;
    private javax.swing.JToggleButton E3TB;
    private javax.swing.JToggleButton E4TB;
    private javax.swing.JToggleButton E6TB;
    private javax.swing.JToggleButton E7TB;
    private javax.swing.JToggleButton E8TB;
    private javax.swing.JToggleButton E9TB;
    private javax.swing.JToggleButton F11TB;
    private javax.swing.JToggleButton F12TB;
    private javax.swing.JToggleButton F13TB;
    private javax.swing.JToggleButton F14TB;
    private javax.swing.JToggleButton F1TB;
    private javax.swing.JToggleButton F2TB;
    private javax.swing.JToggleButton F3TB;
    private javax.swing.JToggleButton F4TB;
    private javax.swing.JToggleButton F6TB;
    private javax.swing.JToggleButton F7TB;
    private javax.swing.JToggleButton F8TB;
    private javax.swing.JToggleButton F9TB;
    private javax.swing.JLabel GambarJL;
    private javax.swing.JTextField JmlKrsTF;
    private javax.swing.JTextArea JudulFilmTA;
    private javax.swing.JTextField KategoriTF;
    private javax.swing.JTextField LAYARNOEDIT;
    private javax.swing.JTextArea LyrTA;
    private javax.swing.JTextArea NoKrsTA;
    private javax.swing.JTextField RegulalKatTF;
    private javax.swing.JPanel SebelumnyaJP;
    private javax.swing.JPanel SelanjutnyaJP;
    private javax.swing.JTextField SweetTF;
    private javax.swing.JTextField TerpilihTF;
    private javax.swing.JTextField TersediaTF;
    private javax.swing.JTextField TersimpanTF;
    private javax.swing.JTextArea TglTA;
    private javax.swing.JTextArea TmpBskpTA;
    private javax.swing.JTextArea ToHrgTA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton79;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton13;
    // End of variables declaration//GEN-END:variables
}
