/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class musteri {
    
    private int tcNo,idmusteri;
    private String ad,soyad,durum,mail;

    public int getIdmusteri() {
        return idmusteri;
    }

    public void setIdmusteri(int idmusteri) {
        this.idmusteri = idmusteri;
    }
    public String getAd(){
    return ad;
    } 
    public void setAd(String ad){
    this.ad = ad;
    }
    public String getSoyad(){
    return soyad;
    } 
    public void setSoyad(String soyad){
    this.soyad = soyad;
    }
    public String getDurum(){
    return durum;
    } 
    public void setDurum(String durum){
    this.durum = durum;
    }
    public String getMail(){
    return mail;
    } 
    public void setMail(String mail){
    this.mail = mail;
    }
    public int getTcNo(){
    return tcNo;
    } 
    public void setTcNo(int tcNo){
    this.tcNo = tcNo;
    }
    
    
}
