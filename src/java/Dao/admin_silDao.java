/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Lenovo
 */
@ManagedBean(name="admin_silDao")
@RequestScoped
public class admin_silDao {
    Connection con = new Sql().connect();  
    private int idadmin;

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

  public void delete() throws ClassNotFoundException, SQLException{

    
    
    String query ="delete from admin where idadmin=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, this.idadmin);
   
    
    
    ps.executeUpdate();
    }
}