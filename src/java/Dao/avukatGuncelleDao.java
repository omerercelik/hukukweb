/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muhammed
 */
@ManagedBean (name = "avukatGuncelleDao")
@RequestScoped
public class avukatGuncelleDao {
Connection con = new Sql().connect();  
    private String ad,soyad,mail;
    private int diplomaNo,sgkNo,tcNo , idavukat;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getDiplomaNo() {
        return diplomaNo;
    }

    public void setDiplomaNo(int diplomaNo) {
        this.diplomaNo = diplomaNo;
    }

    public int getSgkNo() {
        return sgkNo;
    }

    public void setSgkNo(int sgkNo) {
        this.sgkNo = sgkNo;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public int getIdavukat() {
        return idavukat;
    }

    public void setIdavukat(int idavukat) {
        this.idavukat = idavukat;
    }
     public void update() throws ClassNotFoundException, SQLException{

  
    
    String query2 ="update avukat set avukat.tcNo=? , avukat.ad=? , avukat.soyad=? , avukat.sgkNo=? ,avukat.diplomaNo=? ,avukat.mail=? where idAvukat=?;";
    PreparedStatement ps = con.prepareStatement(query2);
   
    ps.setInt(1,this.tcNo );
    ps.setString(2, this.ad);
    ps.setString(3, this.soyad);
    ps.setInt(4, this.sgkNo);
   ps.setInt(5,this.diplomaNo );
   ps.setString(6, this.mail);
   ps.setInt(7,this.idavukat );
    
    ps.executeUpdate();
    }
}
