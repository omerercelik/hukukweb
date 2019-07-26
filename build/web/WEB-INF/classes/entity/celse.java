/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

public class celse {
    
    private Date tarih;
    private String salon;
    private int iddava,idcelse;

    public int getIdcelse() {
        return idcelse;
    }

    public void setIdcelse(int idcelse) {
        this.idcelse = idcelse;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getIddava() {
        return iddava;
    }

    public void setIddava(int iddava) {
        this.iddava = iddava;
    }
    
}
