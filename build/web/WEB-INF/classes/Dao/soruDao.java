/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.celse;
import entity.sahit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ali haydar
 */
@ManagedBean (name="soruDao")
@RequestScoped
public class soruDao {
Connection con = new Sql().connect();  
  private String soru,cevap;
  private int tcNo;

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }
    
    public void insert() throws ClassNotFoundException, SQLException{

    
    String query="Select sahit.idsahit From sahit where sahit.tcNo=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, tcNo);
    ResultSet rs = ps.executeQuery();
    sahit s = new sahit();
    while(rs.next()){
        s.setIdsahit(rs.getInt("idsahit"));
    }
    
    String query2 ="insert into soru (soru,cevap,idsahit) values (?,?,?);";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setString(1, this.soru);
    ps2.setString(2,this.cevap);
    ps2.setInt(3, s.getIdsahit());
    ps2.executeUpdate();
    con.close();
    }
}
