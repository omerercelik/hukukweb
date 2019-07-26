package Dao;

import bağlantı.Sql;
import entity.rapor_maas;
import entity.yardimcieleman;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;


@ManagedBean (name = "rapor_yardimcielemanDao")
@RequestScoped
public class rapor_yardimcielemanDao {
 
   Connection con = new Sql().connect();  

    public List<rapor_maas> select() throws ClassNotFoundException, SQLException{
        
   
    String query ="select min(yardimcieleman.maas) , yardimcieleman.ad , yardimcieleman.soyad , avukat.tcNo , avukat.ad, avukat.soyad from yardimcieleman , avukat where yardimcieleman.idAvukat=avukat.idAvukat;";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<rapor_maas> yardimcielemanlar = new ArrayList<rapor_maas>() ;
    
    while(rs.next()){
    rapor_maas adam = new rapor_maas();
    adam.setEndüşük_maas(rs.getInt("min(yardimcieleman.maas)"));
    adam.setYardimcieleman_ad(rs.getString("ad"));
    adam.setYardimcieleman_soyad(rs.getString("soyad"));
    adam.setAvukat_tcNo(rs.getInt("avukat.tcNo"));
    adam.setAvukat_ad(rs.getString("avukat.ad"));
    adam.setAvukat_soyad(rs.getString("avukat.soyad"));
    
    yardimcielemanlar.add(adam);
    }
    
    return yardimcielemanlar;
    
    
    }
}

