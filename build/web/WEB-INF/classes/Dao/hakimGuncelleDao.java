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
@ManagedBean (name="hakimGuncelleDao")
@RequestScoped
public class hakimGuncelleDao {
Connection con = new Sql().connect();  
    private String hakim_adi,hakim_soyadi;
    private int hakim_tcNo,idhakim;

    public String getHakim_adi() {
        return hakim_adi;
    }

    public void setHakim_adi(String hakim_adi) {
        this.hakim_adi = hakim_adi;
    }

    public String getHakim_soyadi() {
        return hakim_soyadi;
    }

    public void setHakim_soyadi(String hakim_soyadi) {
        this.hakim_soyadi = hakim_soyadi;
    }

    public int getHakim_tcNo() {
        return hakim_tcNo;
    }

    public void setHakim_tcNo(int hakim_tcNo) {
        this.hakim_tcNo = hakim_tcNo;
    }

    public int getIdhakim() {
        return idhakim;
    }

    public void setIdhakim(int idhakim) {
        this.idhakim = idhakim;
    }
      public void update() throws ClassNotFoundException, SQLException{

   
    
    
    String query ="update hakim set hakim.tcno=? , hakim.ad=? , hakim.soyad=? where idhakim=?;";
    PreparedStatement ps = con.prepareStatement(query);
   
    ps.setInt(1,this.hakim_tcNo );
    ps.setString(2, this.hakim_adi);
    ps.setString(3, this.hakim_soyadi);
    ps.setInt(4, this.idhakim );
    
    ps.executeUpdate();
    }
}
