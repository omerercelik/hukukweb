package Dao;

import entity.CelseSahit;
import entity.davaKanıt;
import entity.avukatDava;
import entity.DavaCelse;
import entity.avukatMahkeme;
import entity.davaMusteri;
import entity.sahitSoru;
import entity.mahkemeAdliye;
import bağlantı.Sql;
import entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author muhammed
 */
@ManagedBean (name="avukatGirisDao")
@RequestScoped
public class avukatGirisDao {
    Connection con = new Sql().connect();  
    private String avukat_ad,avukat_soyad;
    private static String avukat_tcNo;

      public void setAvukat_tcNo(String hakim_tcNo) {
        this.avukat_tcNo = hakim_tcNo;
    }

      public void setAvukat_ad(String hakim_ad) {
        this.avukat_ad = hakim_ad;
    }

      public void setAvukat_soyad(String hakim_soyad) {
        this.avukat_soyad = hakim_soyad;
    }
    
    public String getAvukat_tcNo() {
        return avukat_tcNo;
    }

    public String getAvukat_ad() {
        return avukat_ad;
    }

    public String getAvukat_soyad() {
        return avukat_soyad;
    }
      public String avukatGiris() throws ClassNotFoundException, SQLException{

        String sayfa ="";
    
    
        String query ="SELECT tcno FROM avukat WHERE tcno='" + avukat_tcNo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        String tc= "";
        while(rs.next())
          tc=rs.getString("tcNo");
  
        
                if(this.avukat_tcNo.equals(tc))
                    sayfa="avukatSayfasi";
                else
                    sayfa ="index";
    
                    return sayfa;
}
      public String avukatisim() throws ClassNotFoundException, SQLException{

      
    
    
        String query ="SELECT ad,soyad FROM avukat WHERE tcno='" + avukat_tcNo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        String ad="";
        String soyad="";
        while(rs.next()){
        ad= rs.getString("ad");
        soyad= rs.getString("soyad");
        }
                    return ad+" "+soyad;
}

      
      public List<avukatDava> selectdava() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT avukat.ad,avukat.soyad,dava.dosyaNo ,dava.konu,dava.türü FROM avukat,dava,avukatDava WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava  and avukat.tcNo='"+avukat_tcNo+"'";   
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukatDava> Dava = new ArrayList<avukatDava>() ;
    
    while(rs.next()){
    avukatDava adam=new avukatDava();
    
    adam.setAvukat_ad(rs.getString("ad"));
    adam.setAvukat_soyad(rs.getString("soyad"));
    adam.setDava_dosyaNo(rs.getString("dosyaNo"));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_türü(rs.getString("türü"));
   Dava.add(adam);
    }
    ps.close();
    con.close();
    return Dava;
 
    }
      public List<davaKanıt> selectdavakanıt() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,kanit.ad,kanit.tanım FROM avukat,dava,kanit,avukatdava WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.iddava=dava_iddava and  avukat.tcNo='"+avukat_tcNo+"'";    
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
      public List<davaMusteri> selectdavamusteri() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.konu,dava.türü,dava.dosyaNo ,musteri.tcNo,musteri.ad,musteri.soyad,musteri.mail,musteri.durum FROM avukat,dava,avukatdava,musteri,avukatmusteri WHERE  avukat.idAvukat=avukatDava.idAvukat and avukat.idAvukat=avukatMusteri.idAvukat and avukatMusteri.idMusteri=musteri.idMusteri and  avukat.tcNo='"+avukat_tcNo+"'" ;    
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
      public List<avukatMahkeme> selectmahkeme() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT avukat.ad,avukat.soyad,mahkeme.mahkemeNo ,mahkeme.turu FROM avukat,mahkeme,avukatdava,dava WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.idmahkeme=mahkeme.idmahkeme and  avukat.tcNo='"+avukat_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukatMahkeme> avukatMahkemeGoster = new ArrayList<avukatMahkeme>() ;
    
    while(rs.next()){
   avukatMahkeme adam=new avukatMahkeme();
    
    adam.setAvukat_ad(rs.getString("ad"));
    adam.setAvukat_soyad(rs.getString("soyad"));
    adam.setMahkemeNo(rs.getString("mahkemeNo"));
    adam.setMahkeme_turu(rs.getString("turu"));
   
    avukatMahkemeGoster.add(adam);
    }
    ps.close();
    con.close();
    return avukatMahkemeGoster;
 
    }  
      
      public List<mahkemeAdliye> selectmahkemeAdliye() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo,mahkeme.mahkemeNo ,mahkeme.turu,adliye.il,adliye.ilçe,adliye.adliyeno FROM avukat,avukatDava,dava,mahkeme,adliye WHERE  avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.idmahkeme=mahkeme.idmahkeme and mahkeme.idadliye=adliye.idadliye   and     avukat.tcNo='"+avukat_tcNo+"'";    
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
      public List<DavaCelse> selectdavacelse() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT dava.dosyaNo ,dava.konu,dava.türü,celse.salon,celse.tarih FROM avukat,dava,celse,avukatDava   WHERE  avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.iddava=celse.iddava  and  avukat.tcNo='"+avukat_tcNo+"'";    
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
        
    
    
    String query ="SELECT dava.dosyaNo, sahit.tcNo,sahit.ad,sahit.soyad,celse.salon,celse.tarih  FROM avukat,dava,celse,sahit,avukatDava WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.iddava=celse.iddava  and celse.idcelse=sahit.idcelse and avukat.tcNo='"+avukat_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<CelseSahit> sahit = new ArrayList<CelseSahit>() ;
    
    while(rs.next()){
    CelseSahit adam=new CelseSahit();
    
    adam.setDava_dosyaNo(rs.getInt("dosyaNo"));
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
        
    
    
    String query ="SELECT sahit.tcNo,sahit.ad,sahit.soyad,soru.soru,soru.cevap  FROM avukat,dava, celse,sahit,soru,avukatDava WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.iddava=celse.iddava  and celse.idcelse=sahit.idcelse and sahit.idsahit=soru.idsahit   and avukat.tcNo='"+avukat_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<sahitSoru> soru = new ArrayList<sahitSoru>() ;
    
    while(rs.next()){
    sahitSoru adam=new sahitSoru();
    
    adam.setSahit_tcNo(rs.getLong("tcNo"));
    adam.setSahit_ad((rs.getString("ad")));
    adam.setSahit_soyad(rs.getString("soyad"));
    adam.setSoru(rs.getString("soru"));
    adam.setCevap(rs.getString("cevap"));
    soru.add(adam);
    }
    ps.close();
    con.close();
    return soru;
 
    }  
      public List<avukathakimDava> selecthakimlerebak() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT hakim.ad,hakim.soyad,dava.dosyaNo,dava.konu,dava.türü  FROM avukat,avukatDava,dava,hakim WHERE avukat.idAvukat=avukatDava.idAvukat and avukatDava.iddava=dava.iddava and dava.hakim_idhakim=hakim.idhakim  and avukat.tcNo='"+avukat_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukathakimDava> soru = new ArrayList<avukathakimDava>() ;
    
    while(rs.next()){
    avukathakimDava adam=new avukathakimDava();
    
    adam.setDosyaNo(rs.getString("dosyaNo"));
    adam.setDava_konu(rs.getString("konu"));
    adam.setDava_turu(rs.getString("türü"));
    adam.setHakim_ad((rs.getString("ad")));
    adam.setHakim_soyad(rs.getString("soyad"));
   
    soru.add(adam);
    }
    ps.close();
    con.close();
    return soru;
 
    }  
      public List<avukat_yardimcieleman> selectyardimcieleman() throws ClassNotFoundException, SQLException{
        
    
    
    String query ="SELECT yardimcieleman.ad,yardimcieleman.soyad,yardimcieleman.sgkNo,yardimcieleman.maas,yardimcieleman.vasif  FROM avukat,yardimcieleman WHERE avukat.idAvukat=yardimcieleman.idAvukat and avukat.tcNo='"+avukat_tcNo+"'";    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    List<avukat_yardimcieleman> eleman = new ArrayList<avukat_yardimcieleman>() ;
    
    while(rs.next()){
    avukat_yardimcieleman adam=new avukat_yardimcieleman();
    
    
    adam.setYardimcieleman_ad((rs.getString("ad")));
    adam.setYardimcieleman_soyad(rs.getString("soyad"));
   
    eleman.add(adam);
    }
    ps.close();
    con.close();
    return eleman;
 
    }  
    
    
    
    
}