/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bioskop;

/**
 *
 * @author fajar
 */
public class UserAdmin {
    private String namafilm;
    private byte[] gambar;
    private String idfilm;
    private String genre;
    private String sipnosis;
    public UserAdmin(String idfilm,String namafilm,String genre,String sipnosis,byte[]image){
        this.idfilm=idfilm;
        this.namafilm=namafilm;
        this.genre=genre;  
        this.sipnosis=sipnosis;  
        this.gambar=image;  
    }

   
    /**
     * @return the idfilm
     */
    public String getIdfilm() {
        return idfilm;
    }

    /**
     * @param idfilm the idfilm to set
     */
    public void setIdfilm(String idfilm) {
        this.idfilm = idfilm;
    }

    /**
     * @return the namafilm
     */
    public String getNamafilm() {
        return namafilm;
    }

    /**
     * @param namafilm the namafilm to set
     */
    public void setNamafilm(String namafilm) {
        this.namafilm = namafilm;
    }

    /**
     * @return the gambar
     */
    public byte[] getGambar() {
        return gambar;
    }

    /**
     * @param image the gambar to set
     */
    public void setGambar(byte[] image) {
        this.gambar = image;
    }

    /**
     * @return the no
     */
    
    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getSipnosis() {
        return sipnosis;
    }

    /**
     * @param sipnosis the sipnosis to set
     */
    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

   
    
}

