package Dao;

import bağlantı.Sql;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

@ManagedBean(name = "TcNoSorgulaDao")
@RequestScoped
public class TcNoSorgulaDao {
    Connection con = new Sql().connect();  

    private String musteriTcNo;
    private boolean guncellemizin= false;

    public String getMusteriTcNo() {
        return musteriTcNo;
    }

    public void setMusteriTcNo(String musteriTcNo) {
        this.musteriTcNo = musteriTcNo;
    }

    public boolean isGuncellemizin() {
        return guncellemizin;
    }

    public void setGuncellemizin(boolean guncellemizin) {
        this.guncellemizin = guncellemizin;
    }
    
    public String sayfa(){
    String sayfa="";
        
        try {
           
            PreparedStatement ps = (PreparedStatement)con.prepareStatement("SELECT tcNo FROM musteri WHERE tcNo='" + musteriTcNo + "'");
            
            ResultSet rs = ps.executeQuery();
            String tcNo="";
                
            
            while(rs.next()){
            tcNo = rs.getString("tcNo");
            }
            if(musteriTcNo.equals(tcNo)){
            sayfa = "davaBilgileriniGoster";
            }
            else sayfa = "";
            
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
          return sayfa;
    }
}
