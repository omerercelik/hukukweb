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
@ManagedBean(name="avukat_silDao")
@RequestScoped
public class avukat_silDao {
    Connection con = new Sql().connect();  
    private int idavukat;

  public void update() throws ClassNotFoundException, SQLException{

 
    
    
    String query ="delete from avukat where idAvukat?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, this.idavukat);
   
    
    
    ps.executeUpdate();
    }
}
