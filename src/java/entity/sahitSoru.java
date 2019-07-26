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
public class sahitSoru {
   private String sahit_ad,sahit_soyad,soru,cevap,dava_dosyaNo;

    public void setDava_dosyaNo(String dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public String getDava_dosyaNo() {
        return dava_dosyaNo;
    }
   private Long  sahit_tcNo;

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getSoru() {
        return soru;
    }

    public String getCevap() {
        return cevap;
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

    public void setSahit_ad(String sahit_ad) {
        this.sahit_ad = sahit_ad;
    }

    public void setSahit_soyad(String sahit_soyad) {
        this.sahit_soyad = sahit_soyad;
    }

    public void setSahit_tcNo(Long sahit_tcNo) {
        this.sahit_tcNo = sahit_tcNo;
    }
}
