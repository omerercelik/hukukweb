/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class avukatDava {
 private String avukat_ad,avukat_soyad, dava_türü,dava_konu,dava_dosyaNo;
    private int idAvukat, iddava;

    public String getAvukat_ad() {
        return avukat_ad;
    }

    public String getAvukat_soyad() {
        return avukat_soyad;
    }

    public String getDava_türü() {
        return dava_türü;
    }

    public String getDava_konu() {
        return dava_konu;
    }

    public void setAvukat_ad(String avukat_ad) {
        this.avukat_ad = avukat_ad;
    }

    public void setAvukat_soyad(String avukat_soyad) {
        this.avukat_soyad = avukat_soyad;
    }

    public void setDava_türü(String dava_türü) {
        this.dava_türü = dava_türü;
    }

    public void setDava_konu(String dava_konu) {
        this.dava_konu = dava_konu;
    }
    

    public int getIdAvukat() {
        return idAvukat;
    }

    public void setIdAvukat(int idAvukat) {
        this.idAvukat = idAvukat;
    }

    public int getIddava() {
        return iddava;
    }

    public void setIddava(int iddava) {
        this.iddava = iddava;
    }

    public String getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public void setDava_dosyaNo(String dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }
    
    
}
