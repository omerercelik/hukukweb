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
public class DavaCelse {
     private String celse_salon,celse_tarih, dava_türü,dava_konu;
        private int dava_dosyaNo;

    public void setCelse_salon(String celse_salon) {
        this.celse_salon = celse_salon;
    }

    public void setCelse_tarih(String celse_tarih) {
        this.celse_tarih = celse_tarih;
    }

    public void setDava_türü(String dava_türü) {
        this.dava_türü = dava_türü;
    }

    public void setDava_konu(String dava_konu) {
        this.dava_konu = dava_konu;
    }

    public void setDava_dosyaNo(int dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public String getCelse_salon() {
        return celse_salon;
    }

    public String getCelse_tarih() {
        return celse_tarih;
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

   

    
}
