package entity;

public class davaBilgileriniGoster {
    
    private int avukatTcNo , davaDosyaNo , avukatDiplomaNo;
    private String avukatAdi , avukatSoyadi , avukatMaili , davaKonusu , davaTuru,musteriTcNo;    

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
}
