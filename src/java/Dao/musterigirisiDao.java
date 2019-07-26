/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Class2
 */

@ManagedBean (name="musterigirisDao")
@RequestScoped
public class musterigirisiDao {
     Connection con = new Sql().connect();  
    private String musteri_ad,musteri_soyad;
    private static String musteri_tcNo;

    public String getMusteri_ad() {
        return musteri_ad;
    }

    public String getMusteri_soyad() {
        return musteri_soyad;
    }

    public String getMusteri_tcNo() {
        return musteri_tcNo;
    }

    public void setMusteri_ad(String musteri_ad) {
        this.musteri_ad = musteri_ad;
    }

    public void setMusteri_soyad(String musteri_soyad) {
        this.musteri_soyad = musteri_soyad;
    }

    public void setMusteri_tcNo(String musteri_tcNo) {
        this.musteri_tcNo = musteri_tcNo;
    }
   
    
      public String musteriGiris() throws ClassNotFoundException, SQLException{

        String sayfa ="";
    
    
        String query ="SELECT tcno FROM musteri WHERE tcno='" + musteri_tcNo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        String tc= "";
        while(rs.next())
          tc=rs.getString("tcNo");
  
        
                if(this.musteri_tcNo.equals(tc))
                    sayfa="musteriSayfasi";
                else
                    sayfa ="index";
    
                    return sayfa;
}
public String selectmusteri_ad() throws ClassNotFoundException, SQLException{

        
    
    
        String query ="SELECT ad,soyad FROM musteri WHERE tcno='" + musteri_tcNo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        String ad= "";
        String soyad="";
        while(rs.next()){
          ad=rs.getString("ad");
          soyad=rs.getString("soyad");
        }
        
    
                    return ad+" "+soyad;
}
      
      public  List<avukat> selectAvukat() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT avukat.ad,avukat.soyad,avukat.mail FROM avukat,avukatMusteri,musteri WHERE musteri.idMusteri=avukatMusteri.idMusteri and  avukatMusteri.idAvukat=avukat.idAvukat and   musteri.tcNo='"+musteri_tcNo+"'";   
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukat> avukat = new ArrayList<avukat>() ;
    
    while(rs.next()){
   avukat adam=new avukat();
    
    adam.setAd(rs.getString("ad"));
    adam.setSoyad(rs.getString("soyad"));
    adam.setMail("mail");
    
   avukat.add(adam);
    }
    ps.close();
    con.close();
    return avukat;
 
    }
      public List<dava> selectdava() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT   dava.konu,dava.türü FROM musteri,avukatMusteri,avukat,avukatDava,dava WHERE musteri.idMusteri=avukatMusteri.idMusteri and  avukatMusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and   musteri.tcNo ='"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<dava> dava = new ArrayList<dava>() ;
    
    while(rs.next()){
    dava adam=new dava();
    
    
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_turu(rs.getString("türü"));
  
    dava.add(adam);
    }
    ps.close();
    con.close();
    return dava;
 
    }
     
      public List<mahkemeAdliye> selectmahkeme() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT mahkeme.mahkemeNo,mahkeme.turu,adliye.adliyeno,adliye.ad,adliye.il,adliye.ilçe  FROM musteri,avukatmusteri,avukat,avukatdava,dava,mahkeme,adliye WHERE musteri.idMusteri=avukatmusteri.idMusteri and  avukatmusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatdava.idAvukat and avukatdava.iddava=dava.iddava and dava.idmahkeme=mahkeme.idmahkeme and mahkeme.idadliye=adliye.idadliye and musteri.tcNo='"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<mahkemeAdliye> adliye_ve_mahkeme_goster = new ArrayList<mahkemeAdliye>() ;
    
    while(rs.next()){
  mahkemeAdliye adam=new mahkemeAdliye();
    
    adam.setMahkeme_mahkemeNo(rs.getLong("mahkemeNo"));
    adam.setMahkeme_türü(rs.getString("turu"));
    adam.setAdliye_adliyeno(rs.getLong("adliyeno"));
    adam.setAdliye_ad("ad");
   adam.setAdliye_il("il");
   adam.setAdliye_ilçe("ilce");
   
    adliye_ve_mahkeme_goster.add(adam);
    }
    ps.close();
    con.close();
    return adliye_ve_mahkeme_goster;
 
    }  
      
     
      public List<DavaCelse> selectdavacelse() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,celse.salon,celse.tarih FROM musteri,avukatMusteri,avukat,avukatDava,dava,celse  WHERE musteri.idMusteri=avukatMusteri.idMusteri and  avukatMusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.iddava=celse.iddava and  musteri.tcNo='"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<DavaCelse> celse = new ArrayList<DavaCelse>() ;
    
    while(rs.next()){
    DavaCelse adam=new DavaCelse();
    
    
    adam.setDava_dosyaNo((rs.getInt("dosyaNo")));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_türü(rs.getString("türü"));
    adam.setCelse_salon(rs.getString("salon"));
    adam.setCelse_tarih(rs.getString("tarih"));
    celse.add(adam);
    }
    ps.close();
    con.close();
    return celse;
 
    }       
      public List<hakim> selecthakim() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT hakim.ad,hakim.soyad  FROM musteri,avukatMusteri,avukat,avukatDava,dava,hakim WHERE musteri.idMusteri=avukatmusteri.idMusteri and  avukatMusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatdava.idAvukat and avukatdava.iddava=dava.iddava  and dava.hakim_idhakim=hakim.idhakim and  musteri.tcNo='"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<hakim> hakimGoster = new ArrayList<hakim>() ;
    
    
    while(rs.next()){
    hakim adam=new hakim();
    
    
  
    adam.setHakim_adi(rs.getString("ad"));
    adam.setHakim_soyadi(rs.getString("soyad"));
    
   hakimGoster.add(adam);
    }
    ps.close();
    con.close();
    return hakimGoster;
 
    }       
      public List<musteriDavaAdliye> selectDavaAdliye() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo,dava.konu,dava.türü,adliye.adliyeno,adliye.il,adliye.ilçe FROM musteri,avukatmusteri,avukat,avukatdava,dava, mahkeme,adliye WHERE musteri.idMusteri=avukatmusteri.idMusteri and  avukatmusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatdava.idAvukat and avukatdava.iddava=dava.iddava and dava.idmahkeme=mahkeme.idmahkeme and mahkeme.idadliye=adliye.idadliye and   musteri.tcNo='"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<musteriDavaAdliye> adliye = new ArrayList<musteriDavaAdliye>() ;
    
    
    while(rs.next()){
    musteriDavaAdliye adliye_object=new musteriDavaAdliye();
    
    
  
    adliye_object.setAdliyeNo(rs.getString("adliyeno"));
    adliye_object.setAdliye_il(rs.getString("il"));
    adliye_object.setAdliye_ilce(rs.getString("ilçe"));
    adliye_object.setDosyaNo(rs.getString("dosyaNo"));
    adliye_object.setDava_konu(rs.getString("konu"));
    adliye_object.setDava_türü(rs.getString("türü"));
    adliye_object.setDava_konu(rs.getString("konu"));
    
   adliye.add(adliye_object);
    }
    ps.close();
    con.close();
    return adliye;
 
    }       
   public List<hakimDavaMahkeme> selectHakimDava() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo,dava.konu,dava.türü,adliye.adliyeno,adliye.il,adliye.ilçe FROM musteri,avukatMusteri,avukat,avukatDava,dava, mahkeme,adliye WHERE musteri.idMusteri=avukatMusteri.idMusteri and  avukatMusteri.idAvukat=avukat.idAvukat and avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.idmahkeme=mahkeme.idmahkeme and mahkeme.idadliye=adliye.idadliye and   musteri.tcNo'"+musteri_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<hakimDavaMahkeme> hakimDava = new ArrayList<hakimDavaMahkeme>() ;
    
    
    while(rs.next()){
    hakimDavaMahkeme hakimDava_object=new hakimDavaMahkeme();
    
    
  
    hakimDava_object.setDava_dosyaNo(rs.getInt("dosyaNo"));
    hakimDava_object.setDava_konu(rs.getString("konu"));
    hakimDava_object.setDava_türü(rs.getString("türü"));
    hakimDava_object.setHakim_ad(rs.getString("ad"));
    hakimDava_object.setHakim_soyad(rs.getString("soyad"));
    
   hakimDava.add(hakimDava_object);
    }
    ps.close();
    con.close();
    return hakimDava;
 
    }                       
                   

    
}
