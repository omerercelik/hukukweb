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
@ManagedBean (name = "celseGuncelleDao")
@RequestScoped
public class celseGuncelleDao {
Connection con = new Sql().connect();  
    java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
    
    private String salon;
    private int idcelse,dava_dosyaNo;

    public int getDava_dosyaNo() {
        return dava_dosyaNo;
    }

    public void setDava_dosyaNo(int dava_dosyaNo) {
        this.dava_dosyaNo = dava_dosyaNo;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getIdcelse() {
        return idcelse;
    }

    public void setIdcelse(int idcelse) {
        this.idcelse = idcelse;
    }
     public void update() throws ClassNotFoundException, SQLException{

    
    String query2="Select dava.iddava From dava where dava.dosyaNo=?";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setInt(1, dava_dosyaNo);
    ResultSet rs = ps2.executeQuery();
    dava d = new dava();
    while(rs.next()){
        d.setIddava(rs.getInt("iddava"));
    }
    
    
    String query ="update celse set celse.tarih=? , celse.salon=? , celse.iddava=? where idcelse=?;";
    PreparedStatement ps = con.prepareStatement(query);
   
    ps.setString(1,this.currentTime );
    ps.setString(2, this.salon);
    ps.setInt(3, d.getIddava());
    ps.setInt(4, this.idcelse );
    
    ps.executeUpdate();
    }
}
