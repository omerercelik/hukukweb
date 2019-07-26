package Dao;

import bağlantı.Sql;
import entity.davaBilgileriniGoster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

@ManagedBean(name = "davaBilgileriniGosterDao")
@RequestScoped
public class davaBilgileriniGosterDao {
    Connection con = new Sql().connect();  

    private int avukatTcNo , davaDosyaNo , avukatDiplomaNo;
    private String avukatAdi , avukatSoyadi , avukatMaili , davaKonusu , davaTuru, musteriTcNo;

    public String getMusteriTcNo() {
        return musteriTcNo;
    }

    public void setMusteriTcNo(String musteriTcNo) {
        this.musteriTcNo = musteriTcNo;
    }

    public int getAvukatTcNo() {
        return avukatTcNo;
    }

    public void setAvukatTcNo(int avukatTcNo) {
        this.avukatTcNo = avukatTcNo;
    }

    public int getDavaDosyaNo() {
        return davaDosyaNo;
    }

    public void setDavaDosyaNo(int davaDosyaNo) {
        this.davaDosyaNo = davaDosyaNo;
    }

    public int getAvukatDiplomaNo() {
        return avukatDiplomaNo;
    }

    public void setAvukatDiplomaNo(int avukatDiplomaNo) {
        this.avukatDiplomaNo = avukatDiplomaNo;
    }

    public String getAvukatAdi() {
        return avukatAdi;
    }

    public void setAvukatAdi(String avukatAdi) {
        this.avukatAdi = avukatAdi;
    }

    public String getAvukatSoyadi() {
        return avukatSoyadi;
    }

    public void setAvukatSoyadi(String avukatSoyadi) {
        this.avukatSoyadi = avukatSoyadi;
    }

    public String getAvukatMaili() {
        return avukatMaili;
    }

    public void setAvukatMaili(String avukatMaili) {
        this.avukatMaili = avukatMaili;
    }

    public String getDavaKonusu() {
        return davaKonusu;
    }

    public void setDavaKonusu(String davaKonusu) {
        this.davaKonusu = davaKonusu;
    }

    public String getDavaTuru() {
        return davaTuru;
    }

    public void setDavaTuru(String davaTuru) {
        this.davaTuru = davaTuru;
    }
    
    public String sayfa(){
    String sayfa="";
        Connection conn=null;
        try {
            
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement)conn.prepareStatement("SELECT tcNo FROM musteri WHERE tcNo='" + musteriTcNo + "'");
            
            ResultSet rs = ps.executeQuery();
            String tcNom="";
                
            
            while(rs.next()){
            tcNom = rs.getString("tcNo");
            }
            if(musteriTcNo.equals(tcNom)){
            sayfa = "davaBilgileriniGoster";
            }
            else sayfa = "";
            
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
          return sayfa;
    }
    
    public List<davaBilgileriniGoster> select() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT avukat.ad,avukat.soyad,avukat.mail,avukat.tcNo FROM avukat,musteri,avukatMusteri WHERE avukatMusteri.idMusteri = musteri.idMusteri and avukatMusteri.idAvukat=avukat.idAvukat and musteri.tcNo='"+musteriTcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<davaBilgileriniGoster> avukatlar = new ArrayList<davaBilgileriniGoster>() ;
    
    while(rs.next()){
    davaBilgileriniGoster adam = new davaBilgileriniGoster();
    
    adam.setAvukatAdi(rs.getString("ad"));
    adam.setAvukatSoyadi(rs.getString("soyad"));
    adam.setAvukatMaili(rs.getString("mail"));
    adam.setAvukatTcNo(rs.getInt("tcNo"));
    avukatlar.add(adam);
    }
    con.close();
    return avukatlar;
 
    }       
    
    
}
