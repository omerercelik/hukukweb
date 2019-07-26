/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.avukat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ali haydaar
 */
@ManagedBean (name ="avukatDao")
@RequestScoped
public class avukatDao {
Connection con = new Sql().connect();  
    private String ad,soyad,mail;
    private int diplomaNo,sgkNo,tcNo;

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
    
    public void insert() throws ClassNotFoundException, SQLException{

   
    
    
    String query ="insert into avukat ( ad , soyad , mail , diplomaNo , sgkNo,tcNo ) values (?,?,?,?,?,?);";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, this.ad);
    ps.setString(2, this.soyad);
    ps.setString(3, this.mail);
    ps.setInt(4, this.diplomaNo);
    ps.setInt(5, this.sgkNo);
    ps.setInt(6, this.tcNo);
    ps.executeUpdate();
    }
    
    public List<avukat> select() throws ClassNotFoundException, SQLException{
        
   
   
    String query ="Select * From avukat;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukat> avukatlar = new ArrayList<avukat>() ;
    
    while(rs.next()){
    avukat adam = new avukat();
   
    adam.setAd(rs.getString("ad"));
    adam.setSoyad(rs.getString("soyad"));
    adam.setMail(rs.getString("mail"));
    avukatlar.add(adam);
    }
    
    return avukatlar;
    
    }
}
