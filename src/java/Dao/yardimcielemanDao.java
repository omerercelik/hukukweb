/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.avukat;
import entity.dava;
import entity.yardimcieleman;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean(name="yardimcielemanDao")
@RequestScoped
public class yardimcielemanDao {
Connection con = new Sql().connect();  
   private String ad,soyad,vasif;
    private int sgkNo,maas,AvukattcNo;

    public int getAvukattcNo() {
        return AvukattcNo;
    }

    public void setAvukattcNo(int AvukattcNo) {
        this.AvukattcNo = AvukattcNo;
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

    public String getVasif() {
        return vasif;
    }

    public void setVasif(String vasif) {
        this.vasif = vasif;
    }

   
 public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }
    public int getSgkNo() {
        return sgkNo;
    }

    public void setSgkNo(int sgkNo) {
        this.sgkNo = sgkNo;
    }

public void insert() throws ClassNotFoundException, SQLException{

   
    String query="Select avukat.idavukat From avukat Where avukat.tcNo=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, AvukattcNo);
    ResultSet rs = ps.executeQuery();
    avukat a = new avukat();
    while(rs.next()){
        a.setIdavukat(rs.getInt("idavukat"));
    }
    
    String query2 ="insert into yardimcieleman (ad , soyad , vasif , sgkNo , maas , idavukat) values (?,?,?,?,?,?);";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setString(1, this.ad);
    ps2.setString(2,this.soyad);
    ps2.setString(3, this.vasif);
    ps2.setInt(4, this.sgkNo);
    ps2.setInt(5,this.maas);
    ps2.setInt(6,a.getIdavukat());
    ps2.executeUpdate();
    con.close();
    }
public List<yardimcieleman> select() throws ClassNotFoundException, SQLException{
        
     
    String query ="Select * From yardimcieleman;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<yardimcieleman> yardimcielemanlar = new ArrayList<yardimcieleman>() ;
    
    while(rs.next()){
    yardimcieleman adam = new yardimcieleman();
    adam.setYardimciElemanId(rs.getInt("yardimcielemanId"));
    adam.setAd(rs.getString("ad"));
    adam.setSoyad(rs.getString("soyad"));
    adam.setSgkNo(rs.getInt("sgkNo"));
    adam.setMaas(rs.getInt("maas"));
    adam.setVasif(rs.getString("vasif"));
    
    yardimcielemanlar.add(adam);
    }
    
    return yardimcielemanlar;
    
    }

    
}
 
    


