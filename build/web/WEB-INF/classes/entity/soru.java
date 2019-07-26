/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ömer
 */
public class soru {
    
    private String soru,cevap;
    private int idsoru,idsahit;

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public int getIdsoru() {
        return idsoru;
    }

    public void setIdsoru(int idsoru) {
        this.idsoru = idsoru;
    }

    public int getIdsahit() {
        return idsahit;
    }

    public void setIdsahit(int idsahit) {
        this.idsahit = idsahit;
    }
    
}
