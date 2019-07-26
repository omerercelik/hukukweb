
package Dao;

import bağlantı.Sql;
import entity.hakim;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "hakimDao")
@RequestScoped
public class hakimDao {
Connection con = new Sql().connect();  
    private String hakim_adi,hakim_soyadi;
    private int hakim_tcNo;

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
    
     public void insert() throws ClassNotFoundException, SQLException{

    
    String query2 ="insert into hakim(tcNo , ad , soyad) values(?,?,?)";
    PreparedStatement ps2 = con.prepareStatement(query2);
    ps2.setInt(1, hakim_tcNo);
    ps2.setString(2, hakim_adi);
    ps2.setString(3, hakim_soyadi);
    ps2.executeUpdate();

     
     
     }
public List<hakim> select() throws ClassNotFoundException, SQLException{
        
   
   
    String query ="Select * From hakim";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<hakim> hakimler = new ArrayList<hakim>() ;
    
    while(rs.next()){
    hakim adam = new hakim();
    adam.setHakim_adi(rs.getString("ad"));
    adam.setHakim_soyadi(rs.getString("soyad"));
    
    hakimler.add(adam);
    }
    
    return hakimler;
    
    }


}

