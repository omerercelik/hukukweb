/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.dava;
import entity.hakim;
import entity.mahkeme;
import entity.musteri;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "musteriDao")
@RequestScoped
public class musteriDao {
Connection con = new Sql().connect();  
    private int tcNo,idmusteri;
    private String ad,soyad,durum,mail;

    public int getIdmusteri() {
        return idmusteri;
    }

    public void setIdmusteri(int idmusteri) {
        this.idmusteri = idmusteri;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

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

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public void insert() throws ClassNotFoundException, SQLException{

    
    String query ="insert into musteri ( tcNo , ad , soyad , durum , mail ) values (?,?,?,?,?);";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, this.tcNo);
    ps.setString(2, this.ad);
    ps.setString(3, this.soyad);
    ps.setString(4, this.durum);
    ps.setString(5, this.mail);
    ps.executeUpdate();
    }
    
    public List<musteri> select() throws ClassNotFoundException, SQLException{
        
       
    String query ="Select * From musteri;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<musteri> musteriler = new ArrayList<musteri>() ;
    
    while(rs.next()){
    musteri adam = new musteri();
    adam.setIdmusteri(rs.getInt("idmusteri"));
    adam.setTcNo(rs.getInt("tcNo"));
    adam.setAd(rs.getString("ad"));
    adam.setSoyad(rs.getString("soyad"));
    adam.setDurum(rs.getString("durum"));
    adam.setMail(rs.getString("mail"));
    musteriler.add(adam);
    }
    
    return musteriler;
    
    }
    public void update() throws ClassNotFoundException, SQLException{

   
    
    
    String query2 ="update musteri set musteri.tcNo=?,musteri.ad=?,musteri.soyad=?,musteri.durum=?,musteri.mail=? where musteri.idMusteri=?;";
    PreparedStatement ps2 = con.prepareStatement(query2);
   
    
    ps2.setInt(1, this.tcNo);
    ps2.setString(2, this.ad);
    ps2.setString(3, this.soyad);
    ps2.setString(4, this.durum);
    ps2.setString(5, this.mail);
    ps2.setInt(6, this.idmusteri);
    
    ps2.executeUpdate();
    
    }
}
