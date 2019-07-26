/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.avukat;
import entity.celse;
import entity.musteri;
import entity.sahit;
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
 * @author muhammed
 */
@ManagedBean(name = "sahitDao")
@RequestScoped
public class sahitDao {
Connection con = new Sql().connect();  
    private String ad,soyad,salon;
    private int tcNo;

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
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

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }
    public void insert() throws ClassNotFoundException, SQLException{

    
    String query="Select celse.idcelse From celse where celse.salon=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, salon);
    ResultSet rs = ps.executeQuery();
    celse c = new celse();
    while(rs.next()){
        c.setIdcelse(rs.getInt("idcelse"));
    }
    
    String query2 ="insert into sahit (tcNo , ad , soyad , idcelse) values (?,?,?,?);";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setInt(1, this.tcNo);
    ps2.setString(2,this.ad);
    ps2.setString(3, this.soyad);
    ps2.setInt(4,c.getIdcelse());
    ps2.executeUpdate();
    con.close();
    }
    
    public List<sahit> select() throws ClassNotFoundException, SQLException{
        
        
    String query ="Select * From sahit;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<sahit> sahitler = new ArrayList<sahit>() ;
    
    while(rs.next()){
    sahit adam = new sahit();
    adam.setIdsahit(rs.getInt("idsahit"));
    adam.setTcNo(rs.getInt("tcNo"));
    adam.setAd(rs.getString("ad"));
    adam.setSoyad(rs.getString("soyad"));
    adam.setIdcelse(rs.getInt("idcelse"));
    
    sahitler.add(adam);
    }
    
    return sahitler;
    
    }
}
