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
public class hakimDavaMahkeme {
    
    private String hakim_ad,hakim_soyad,mahkeme_turu,dava_türü,dava_konu;
     int mahkemeNo,dava_dosyaNo;;

    public void setDava_türü(String dava_türü) {
        this.dava_türü = dava_türü;
    }

    public void setDava_konu(String dava_konu) {
        this.dava_konu = dava_konu;
    }

    public void setDava_dosyaNo(int dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public String getHakim_ad() {
        return hakim_ad;
    }

    public String getHakim_soyad() {
        return hakim_soyad;
    }

    public String getDava_türü() {
        return dava_türü;
    }

    public String getDava_konu() {
        return dava_konu;
    }

    public int getDava_dosyaNo() {
        return dava_dosyaNo;
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

    public String getMahkeme_turu() {
        return mahkeme_turu;
    }

    public int getMahkemeNo() {
        return mahkemeNo;
    }
   
}
