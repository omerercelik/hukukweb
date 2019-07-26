/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.hakim;
import entity.mahkeme;
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
@ManagedBean(name = "davaGuncelleDao")
@RequestScoped
public class davaGuncelleDao {
Connection con = new Sql().connect();  
    private String dava_konu,dava_turu;
    private int dava_dosyaNo,mahkeme_no,hakim_tcno,iddava;

    public String getDava_konu() {
        return dava_konu;
    }

    public void setDava_konu(String dava_konu) {
        this.dava_konu = dava_konu;
    }

    public String getDava_turu() {
        return dava_turu;
    }

    public void setDava_turu(String dava_turu) {
        this.dava_turu = dava_turu;
    }

    public int getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public void setDava_dosyaNo(int dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public int getMahkeme_no() {
        return mahkeme_no;
    }

    public void setMahkeme_no(int mahkeme_no) {
        this.mahkeme_no = mahkeme_no;
    }

    public int getHakim_tcno() {
        return hakim_tcno;
    }

    public void setHakim_tcno(int hakim_tcno) {
        this.hakim_tcno = hakim_tcno;
    }

    public int getIddava() {
        return iddava;
    }

    public void setIddava(int iddava) {
        this.iddava = iddava;
    }
     public void update() throws ClassNotFoundException, SQLException{

   
    String query="Select mahkeme.idmahkeme From mahkeme Where mahkeme.mahkemeNo=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, mahkeme_no);
    ResultSet rs = ps.executeQuery();
    mahkeme m = new mahkeme();
    while(rs.next()){
        m.setIdmahkeme(rs.getInt("idmahkeme"));
    }
    String query2="Select hakim.idhakim From hakim Where hakim.tcno=?";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setInt(1, hakim_tcno);
    ResultSet rs2 = ps2.executeQuery();
    hakim h = new hakim();
    while(rs2.next()){
        h.setHakimId(rs2.getInt("idhakim"));
    }
    String query3 ="update dava set dava.dosyaNo=? , dava.konu=? , dava.türü=? , dava.idmahkeme=? ,dava.idhakim=? where dava.iddava=?;";
    PreparedStatement ps3 = con.prepareStatement(query3);
   
    ps3.setInt(1,this.dava_dosyaNo );
    ps3.setString(2, this.dava_konu);
    ps3.setString(3, this.dava_turu);
    ps3.setInt(4, m.getIdmahkeme());
    ps3.setInt(5, h.getHakimId());
    ps3.setInt(6,this.iddava );
    
    ps3.executeUpdate();
    }
}
