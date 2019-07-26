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
public class CelseSahit {
    private String celse_salon,celse_tarih,sahit_ad,sahit_soyad;
    private int dava_dosyaNo;
    private Long sahit_tcNo;

    public void setDava_dosyaNo(int dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public int getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public void setCelse_salon(String celse_salon) {
        this.celse_salon = celse_salon;
    }

    public void setCelse_tarih(String celse_tarih) {
        this.celse_tarih = celse_tarih;
    }

    public void setSahit_ad(String sahit_ad) {
        this.sahit_ad = sahit_ad;
    }

    public void setSahit_soyad(String sahit_soyad) {
        this.sahit_soyad = sahit_soyad;
    }

    public void setSahit_tcNo(Long sahit_tcNo) {
        this.sahit_tcNo = sahit_tcNo;
    }

    public String getCelse_salon() {
        return celse_salon;
    }

    public String getCelse_tarih() {
        return celse_tarih;
    }

    public String getSahit_ad() {
        return sahit_ad;
    }

    public String getSahit_soyad() {
        return sahit_soyad;
    }

    public Long getSahit_tcNo() {
        return sahit_tcNo;
    }
   
  

}
