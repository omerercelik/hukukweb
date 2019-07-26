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
public class davaMusteri {
     private String  dava_türü,dava_konu,musteri_ad,musteri_soyad,musteri_mail,musteri_durum;
    private Long dava_dosyaNo,musteri_tcNo;

    public void setDava_türü(String dava_türü) {
        this.dava_türü = dava_türü;
    }

    public void setDava_konu(String dava_konu) {
        this.dava_konu = dava_konu;
    }

    public void setMusteri_ad(String musteri_ad) {
        this.musteri_ad = musteri_ad;
    }

    public void setMusteri_soyad(String musteri_soyad) {
        this.musteri_soyad = musteri_soyad;
    }

    public void setMusteri_mail(String musteri_mail) {
        this.musteri_mail = musteri_mail;
    }

    public void setMusteri_durum(String musteri_durum) {
        this.musteri_durum = musteri_durum;
    }

    public void setDava_dosyaNo(Long dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public void setMusteri_tcNo(Long musteri_tcNo) {
        this.musteri_tcNo = musteri_tcNo;
    }

    public String getDava_türü() {
        return dava_türü;
    }

    public String getDava_konu() {
        return dava_konu;
    }

    public String getMusteri_ad() {
        return musteri_ad;
    }

    public String getMusteri_soyad() {
        return musteri_soyad;
    }

    public String getMusteri_mail() {
        return musteri_mail;
    }

    public String getMusteri_durum() {
        return musteri_durum;
    }

    public Long getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public Long getMusteri_tcNo() {
        return musteri_tcNo;
    }

   
}
