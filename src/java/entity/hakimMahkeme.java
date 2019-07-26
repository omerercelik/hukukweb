/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ömer
 */
public class hakimMahkeme {
    private String hakim_ad,hakim_soyad,mahkeme_turu;

    public String getHakim_ad() {
        return hakim_ad;
    }

    public void setHakim_ad(String hakim_ad) {
        this.hakim_ad = hakim_ad;
    }

    public void setHakim_soyad(String hakim_soyad) {
        this.hakim_soyad = hakim_soyad;
    }

    public void setMahkeme_turu(String mahkeme_turu) {
        this.mahkeme_turu = mahkeme_turu;
    }

    public void setMahkemeNo(int mahkemeNo) {
        this.mahkemeNo = mahkemeNo;
    }

    public String getHakim_soyad() {
        return hakim_soyad;
    }

    public String getMahkeme_turu() {
        return mahkeme_turu;
    }

    public int getMahkemeNo() {
        return mahkemeNo;
    }
    int mahkemeNo;
}
