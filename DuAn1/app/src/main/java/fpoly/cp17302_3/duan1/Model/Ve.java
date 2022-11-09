package fpoly.cp17302_3.duan1.Model;

public class Ve {
    private String mave;
    private String thoigiandat;
    private String soghe;
    private int giave;

    public Ve(String mave, String thoigiandat, String soghe, int giave) {
        this.mave = mave;
        this.thoigiandat = thoigiandat;
        this.soghe = soghe;
        this.giave = giave;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(String thoigiandat) {
        this.thoigiandat = thoigiandat;
    }

    public String getSoghe() {
        return soghe;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public int getGiave() {
        return giave;
    }

    public void setGiave(int giave) {
        this.giave = giave;
    }
}
