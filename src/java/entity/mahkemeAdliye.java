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
public class mahkemeAdliye {
    private String mahkeme_türü,adliye_ad,adliye_il,adliye_ilçe;
     private long  dava_dosyaNo,mahkeme_mahkemeNo,adliye_adliyeno;

   

    public void setMahkeme_türü(String mahkeme_türü) {
        this.mahkeme_türü = mahkeme_türü;
    }

    public void setAdliye_ad(String adliye_ad) {
        this.adliye_ad = adliye_ad;
    }

    public void setAdliye_il(String adliye_il) {
        this.adliye_il = adliye_il;
    }

    public void setAdliye_ilçe(String adliye_ilçe) {
        this.adliye_ilçe = adliye_ilçe;
    }

    public long getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public void setDava_dosyaNo(long dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public void setMahkeme_mahkemeNo(long mahkeme_mahkemeNo) {
        this.mahkeme_mahkemeNo = mahkeme_mahkemeNo;
    }

    public void setAdliye_adliyeno(long adliye_adliyeno) {
        this.adliye_adliyeno = adliye_adliyeno;
    }

   
    

    public String getMahkeme_türü() {
        return mahkeme_türü;
    }

    public String getAdliye_ad() {
        return adliye_ad;
    }

    public String getAdliye_il() {
        return adliye_il;
    }

    public String getAdliye_ilçe() {
        return adliye_ilçe;
    }

    public long getMahkeme_mahkemeNo() {
        return mahkeme_mahkemeNo;
    }

    public long getAdliye_adliyeno() {
        return adliye_adliyeno;
    }
}
