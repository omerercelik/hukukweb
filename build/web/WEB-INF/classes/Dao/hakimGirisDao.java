/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bağlantı.Sql;
import entity.CelseSahit;
import entity.DavaCelse;
import entity.davaAvukat;
import entity.davaKanıt;
import entity.davaMusteri;
import entity.hakim;
import entity.hakimDava;
import entity.hakimDavaMahkeme;
import entity.hakimMahkeme;
import entity.mahkemeAdliye;
import entity.sahitSoru;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muhammed
 */
@ManagedBean (name="hakimGirisDao")
@RequestScoped
public class hakimGirisDao {
    Connection con = new Sql().connect();  
    private String hakim_ad,hakim_soyad;
    private static String hakim_tcNo;

      public void setHakim_tcNo(String hakim_tcNo) {
        this.hakim_tcNo = hakim_tcNo;
    }

      public void setHakim_ad(String hakim_ad) {
        this.hakim_ad = hakim_ad;
    }

      public void setHakim_soyad(String hakim_soyad) {
        this.hakim_soyad = hakim_soyad;
    }
    
    public String getHakim_tcNo() {
        return hakim_tcNo;
    }

    public String getHakim_ad() {
        return hakim_ad;
    }

    public String getHakim_soyad() {
        return hakim_soyad;
    }

   
      public String hakimGiris() throws ClassNotFoundException, SQLException{

        String sayfa ="";
    
    
        String query ="SELECT tcno FROM hakim WHERE tcno='" + hakim_tcNo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        String tc= "";
        while(rs.next())
          tc=rs.getString("tcNo");
  
           
                if(this.hakim_tcNo.equals(tc))
                    sayfa="hakimSayfasi";
                else
                    sayfa ="index";
    
                
                    return sayfa;
}


public List<hakimDava> selectdava() throws ClassNotFoundException, SQLException{
        
    
 
    String query ="SELECT hakim.ad,hakim.soyad,dava.dosyaNo ,dava.konu,dava.türü FROM hakim,dava WHERE hakim.idhakim=dava.hakim_idhakim and hakim.tcno='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<hakimDava> hakimDava = new ArrayList<hakimDava>() ;
    
    while(rs.next()){
    hakimDava adam=new hakimDava();
    
    adam.setHakim_ad(rs.getString("ad"));
    adam.setHakim_soyad(rs.getString("soyad"));
    adam.setDava_dosyaNo(Integer.parseInt(rs.getString("dosyaNo")));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_türü(rs.getString("türü"));
    hakimDava.add(adam);
    }
    
    return hakimDava;
 
    }       

public String selectad() throws ClassNotFoundException, SQLException{
        
    
 
    String query ="SELECT hakim.ad,hakim.soyad FROM hakim  where  hakim.tcno='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    String ad="";
     String soyad="";
    
    while(rs.next()){
   ad=rs.getString("ad");
   soyad=rs.getString("soyad");
    
    }
    return ad+" " +soyad;
 
    }       
public List<davaKanıt> selectdavakanıt() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,kanit.ad,kanit.tanım FROM hakim,dava,kanit WHERE hakim.idhakim=dava.hakim_idhakim and dava.hakim_idhakim=kanit.dava_hakim_idhakim and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<davaKanıt> kanıt = new ArrayList<davaKanıt>() ;
    
    while(rs.next()){
    davaKanıt adam=new davaKanıt();
    
    adam.setDava_dosyaNo(Integer.parseInt(rs.getString("dosyaNo")));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_türü(rs.getString("türü"));
    adam.setKanit_ad(rs.getString("ad"));
    adam.setKanit_tanım("tanım");
    kanıt.add(adam);
    }
    ps.close();
    con.close();
    return kanıt;
 
    }       
    public List<davaAvukat> selectavukatdava() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,avukat.tcNo,avukat.ad,avukat.soyad,avukat.mail,avukat.sgkNo,avukat.diplomaNo FROM hakim,dava,avukatdava,avukat WHERE hakim.idhakim=dava.hakim_idhakim  and dava.iddava=avukatdava.iddava and avukatdava.idAvukat=avukat.idAvukat  and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<davaAvukat> avukat = new ArrayList<davaAvukat>() ;
    
    while(rs.next()){
    davaAvukat adam=new davaAvukat();
    
    adam.setDava_dosyaNo((rs.getInt("dosyaNo")));
    adam.setAvukat_tcNo(rs.getString("tcNo"));
    adam.setAvukat_ad(rs.getString("ad"));
    adam.setAvukat_soyad(rs.getString("soyad"));
    adam.setAvukat_mail("mail");
    adam.setAvukat_sgkNo(rs.getInt("sgkNo"));
    adam.setAvukat_diplomaNo(rs.getInt("diplomaNo"));
   
    avukat.add(adam);
    }
    ps.close();
    con.close();
    return avukat;
 
    }       
     public List<davaMusteri> selectdavamusteri() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,musteri.tcNo,musteri.ad,musteri.soyad,musteri.mail,musteri.durum FROM hakim,dava,avukatdava,avukat,avukatmusteri,musteri WHERE hakim.idhakim=dava.hakim_idhakim  and dava.iddava=avukatdava.iddava and avukatdava.idAvukat=avukat.idAvukat and avukat.idavukat=avukatmusteri.idavukat and avukatmusteri.idmusteri=musteri.idmusteri  and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<davaMusteri> musteri = new ArrayList<davaMusteri>() ;
    
    while(rs.next()){
    davaMusteri adam=new davaMusteri();
    
    adam.setDava_dosyaNo((rs.getLong("dosyaNo")));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_türü(rs.getString("türü"));
    adam.setMusteri_tcNo(rs.getLong("tcNo"));
    adam.setMusteri_ad(rs.getString("ad"));
    adam.setMusteri_soyad(rs.getString("soyad"));
    adam.setMusteri_durum("durum");
    adam.setMusteri_mail(rs.getString("mail"));
    
   
    musteri.add(adam);
    }
    ps.close();
    con.close();
    return musteri;
 
    }       
      

public List<hakimMahkeme> selectmahkeme() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT hakim.ad,hakim.soyad,mahkeme.mahkemeNo ,mahkeme.turu FROM hakim,mahkeme WHERE hakim.idhakim=mahkeme.idhakim and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<hakimMahkeme> hakimMahkemeGoster = new ArrayList<hakimMahkeme>() ;
    
    while(rs.next()){
   hakimMahkeme adam=new hakimMahkeme();
    
    adam.setHakim_ad(rs.getString("ad"));
    adam.setHakim_soyad(rs.getString("soyad"));
    adam.setMahkemeNo(Integer.parseInt(rs.getString("mahkemeNo")));
    adam.setMahkeme_turu(rs.getString("turu"));
   
    hakimMahkemeGoster.add(adam);
    }
    ps.close();
    con.close();
    return hakimMahkemeGoster;
 
    }  
public List<mahkemeAdliye> selectmahkemeAdliye() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo,mahkeme.mahkemeNo ,mahkeme.turu FROM hakim,mahkeme WHERE hakim.idhakim=dava.hakim_idhakim and dava.hakim_idhakim="
                   + "mahkeme.idhakim and mahkeme.idadliye=adliye.idadliye and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<mahkemeAdliye> adliye = new ArrayList<mahkemeAdliye>() ;
    
    while(rs.next()){
   mahkemeAdliye adam=new mahkemeAdliye();
    
    adam.setDava_dosyaNo(rs.getLong("dosyaNo"));
    adam.setMahkeme_mahkemeNo(rs.getLong("mahkemeNo"));
    adam.setMahkeme_türü(rs.getString("turu"));
    adam.setAdliye_ad((rs.getString("mahkemeNo")));
    adam.setAdliye_il(rs.getString("il"));
    adam.setAdliye_ilçe(rs.getString("ilçe"));
    adam.setAdliye_adliyeno(rs.getLong("adliyeno"));
   
    adliye.add(adam);
    }
    ps.close();
    con.close();
    return adliye;
 
    }       

public List<mahkemeAdliye> selectmahkemedava() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT mahkeme.mahkemeNo, mahkeme.turu,adliye.adliyeno,adliye.ad,adliye.il,adliye.ilçe, dava.dosyaNo  FROM hakim,dava,mahkeme,adliye WHERE hakim.idhakim=mahkeme.idhakim and mahkeme.idhakim=dava.hakim_idhakim and mahkeme.idadliye=adliye.idadliye and hakim.tcno='"+hakim_tcNo+"'";
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<mahkemeAdliye> adliye = new ArrayList<mahkemeAdliye>() ;
    
    while(rs.next()){
   
    mahkemeAdliye adam=new mahkemeAdliye();
    
    adam.setDava_dosyaNo(rs.getInt("dosyaNo"));
    adam.setMahkeme_mahkemeNo((rs.getInt("mahkemeNo")));
    adam.setMahkeme_türü(rs.getString("turu"));
    adam.setAdliye_adliyeno(rs.getInt("adliyeno"));
    adam.setAdliye_ad(rs.getString("ad"));
    adam.setAdliye_il(rs.getString("il"));
    adam.setAdliye_ilçe(rs.getString("ilçe"));
   
    adliye.add(adam);
    }
    ps.close();
    con.close();
    return adliye;
 
    }       
public List<DavaCelse> selectdavacelse() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,celse.salon,celse.tarih FROM hakim,dava,celse WHERE hakim.idhakim=dava.hakim_idhakim and dava.iddava=celse.iddava and hakim.tcno='"+hakim_tcNo+"'";    
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
    public List<CelseSahit> selectcelsesahit() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT sahit.tcNo,sahit.ad,sahit.soyad,celse.salon,celse.tarih  FROM hakim,dava, celse,sahit WHERE hakim.idhakim=dava.hakim_idhakim and dava.iddava=celse.iddava and celse.idcelse=sahit.idcelse and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<CelseSahit> sahit = new ArrayList<CelseSahit>() ;
    
    while(rs.next()){
    CelseSahit adam=new CelseSahit();
    
    adam.setSahit_tcNo(rs.getLong("tcNo"));
    adam.setSahit_ad((rs.getString("ad")));
    adam.setSahit_soyad(rs.getString("soyad"));
    adam.setCelse_salon(rs.getString("salon"));
    adam.setCelse_tarih(rs.getString("tarih"));
    sahit.add(adam);
    }
    ps.close();
    con.close();
    return sahit;
 
    }       
     public List<sahitSoru> selectsahitsoru() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT sahit.tcNo,sahit.ad,sahit.soyad,soru.soru,soru.cevap ,dava.dosyaNo FROM hakim,dava, celse,sahit,soru WHERE hakim.idhakim=dava.hakim_idhakim and dava.iddava=celse.iddava and celse.idcelse=sahit.idcelse and sahit.idsahit=soru.idsahit and hakim.tcNo='"+hakim_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<sahitSoru> soru = new ArrayList<sahitSoru>() ;
    
    while(rs.next()){
    sahitSoru adam=new sahitSoru();
    
    adam.setDava_dosyaNo(rs.getString("dosyaNo"));
    adam.setSahit_tcNo(rs.getLong("tcNo"));
    adam.setSahit_ad(rs.getString("ad"));
    adam.setSahit_soyad(rs.getString("soyad"));
    adam.setSoru(rs.getString("soru"));
    adam.setCevap(rs.getString("cevap"));
    soru.add(adam);
    }
    ps.close();
    con.close();
    return soru;
 
    }       
    


}
