/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import bağlantı.Sql;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;


@ManagedBean(name = "adminKontrol")
@RequestScoped
public class adminKontrol {
Connection conn = new Sql().connect();  
Connection conn2 = new Sql().connect();  

    private String isim ,sifre;

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

   
    public String sayfa(){
    String sayfa="";
      
        try {
         
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement("SELECT isim FROM admin WHERE isim='" + isim + "'");
            com.mysql.jdbc.PreparedStatement ps2 = (com.mysql.jdbc.PreparedStatement)conn2.prepareStatement("SELECT sifre FROM admin WHERE sifre='" + sifre + "'");
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            
            String ad="" , pass ="";
            
            while(rs.next()){
            ad = rs.getString("isim");
            }
           while(rs2.next()){
            pass = rs2.getString("sifre");
            }
            if(isim.equals(ad)  &&   sifre.equals(pass)){
            sayfa = "AdminSayfasi";
            }
            else sayfa = "index";
            
            ps.close();
            ps2.close();
            conn.close();
            conn2.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
          return sayfa;
    }
   
    }
    

