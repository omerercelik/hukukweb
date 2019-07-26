/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.adliye;
import entity.dava;
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
@ManagedBean (name = "mahkemeGuncellemeDao")
@RequestScoped
public class mahkemeGuncelleDao {
Connection con = new Sql().connect();  
     private String turu;
    private int mahkemeNo,hakim_tc,adliye_no,idmahkeme;

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public int getMahkemeNo() {
        return mahkemeNo;
    }

    public void setMahkemeNo(int mahkemeNo) {
        this.mahkemeNo = mahkemeNo;
    }

    public int getHakim_tc() {
        return hakim_tc;
    }

    public void setHakim_tc(int hakim_tc) {
        this.hakim_tc = hakim_tc;
    }

    public int getAdliye_no() {
        return adliye_no;
    }

    public void setAdliye_no(int adliye_no) {
        this.adliye_no = adliye_no;
    }

    public int getIdmahkeme() {
        return idmahkeme;
    }

    public void setIdmahkeme(int idmahkeme) {
        this.idmahkeme = idmahkeme;
    }
    public void update() throws ClassNotFoundException, SQLException{

   
    String query="Select adliye.idadliye,hakim.idhakim From adliye,hakim where hakim.tcNo=? and adliye.adliyeNo=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1,hakim_tc );
    ps.setInt(2,adliye_no );
    ResultSet rs = ps.executeQuery();
    adliye  a = new adliye();
    hakim  h = new hakim();
    while(rs.next()){
        a.setIdadliye(rs.getInt("idadliye"));
        h.setHakimId(rs.getInt("idhakim"));
    }
    
    String query2 ="update mahkeme set mahkeme.mahkemeNo=?,mahkeme.turu=?,mahkeme.idadliye=?,mahkeme.idhakim=? where idmahkeme=?;";
    PreparedStatement ps2 = con.prepareStatement(query2);
   
    ps2.setInt(1,this.mahkemeNo);
    ps2.setString(2, this.turu);
    ps2.setInt(3,a.getIdadliye());
    ps2.setInt(4,h.getHakimId());
    ps2.setInt(5,this.idmahkeme);
    ps2.executeUpdate();
    
    }
}
