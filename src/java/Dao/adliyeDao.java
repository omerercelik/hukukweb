/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import bağlantı.Sql;
import entity.dava;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muhammed
 */
@ManagedBean (name = "adliyeDao")
@RequestScoped
public class adliyeDao {
Connection con = new Sql().connect();  
        
    
    private String ad,il,ilce;
    private int adliyeNo;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public int getAdliyeNo() {
        return adliyeNo;
    }

    public void setAdliyeNo(int adliyeNo) {
        this.adliyeNo = adliyeNo;
    }
  
    public void insert() throws ClassNotFoundException, SQLException{

  
    String query2 ="insert into adliye ( adliyeNo ,ad , il , ilçe) values (?,?,?,?);";
    PreparedStatement ps = con.prepareStatement(query2);
    ps.setInt(1,this.adliyeNo );
    ps.setString(2, this.ad);
    ps.setString(3, this.il);
    ps.setString(4, this.ilce);
    ps.executeUpdate();
    }
}
