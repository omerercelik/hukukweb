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
public class davaKanıt {
     private String kanit_ad,kanit_tanım, dava_türü,dava_konu;
    private int dava_dosyaNo;

    public void setKanit_ad(String kanit_ad) {
        this.kanit_ad = kanit_ad;
    }

    public void setKanit_tanım(String kanit_tanım) {
        this.kanit_tanım = kanit_tanım;
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

    public String getKanit_ad() {
        return kanit_ad;
    }

    public String getKanit_tanım() {
        return kanit_tanım;
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
