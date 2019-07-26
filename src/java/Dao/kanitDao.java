/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.dava;
import entity.hakim;
import entity.kanit;
import entity.mahkeme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "kanitDao")
@RequestScoped
public class kanitDao {
Connection con = new Sql().connect();  
    private String ad,tanim;
    private int dosyaNo,dava_dosya_no,mahkeme_no,hakim_tcNo;

    public int getDava_dosya_no() {
        return dava_dosya_no;
    }

    public void setDava_dosya_no(int dava_dosya_no) {
        this.dava_dosya_no = dava_dosya_no;
    }

    public int getMahkeme_no() {
        return mahkeme_no;
    }

    public void setMahkeme_no(int mahkeme_no) {
        this.mahkeme_no = mahkeme_no;
    }

    public int getHakim_tcNo() {
        return hakim_tcNo;
    }

    public void setHakim_tcNo(int hakim_tcNo) {
        this.hakim_tcNo = hakim_tcNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public int getDosyaNo() {
        return dosyaNo;
    }

    public void setDosyaNo(int dosyaNo) {
        this.dosyaNo = dosyaNo;
    }
    
    public void insert() throws ClassNotFoundException, SQLException{

    
    String query="Select dava.iddava,dava.idmahkeme,dava.idhakim From dava,mahkeme,hakim Where dava.dosyaNo=? and mahkeme.mahkemeNo=? and hakim.tcno=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, dava_dosya_no);
    ps.setInt(2, mahkeme_no);
    ps.setInt(3, hakim_tcNo);
    ResultSet rs = ps.executeQuery();
    dava d = new dava();
    mahkeme m = new mahkeme();
    hakim h = new hakim();
    while(rs.next()){
        m.setIdmahkeme(rs.getInt("idmahkeme"));
        d.setIddava(rs.getInt("iddava"));
        h.setHakimId(rs.getInt("idhakim"));
    }
    String query2 ="insert into kanit(ad , tanım , iddava , idmahkeme , idhakim) values(?,?,?,?,?)";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setString(1, ad);
    ps2.setString(2, tanim);
    ps2.setInt(3, d.getIddava());
    ps2.setInt(4, m.getIdmahkeme());
    ps2.setInt(5, h.getHakimId());
    ps2.executeUpdate();
    
    }
    
    public List<kanit> select() throws ClassNotFoundException, SQLException{
        
    
    String query ="Select * From kanit;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<kanit> kanitlar = new ArrayList<kanit>() ;
    
    while(rs.next()){
    kanit adam = new kanit();
    adam.setIdkanit(rs.getInt("idkanit"));
    adam.setAd(rs.getString("ad"));
    adam.setTanım(rs.getString("tanim"));
    adam.setIdhakim(rs.getInt("idhakim"));
    adam.setIdmahkeme(rs.getInt("idmahkeme"));
    adam.setIdhakim(rs.getInt("idhakim"));
    kanitlar.add(adam);
    }
    
    return kanitlar;
    
    }
}
