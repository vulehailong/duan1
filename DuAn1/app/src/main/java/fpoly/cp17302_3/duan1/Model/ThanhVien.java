package fpoly.cp17302_3.duan1.Model;

public class ThanhVien {
    private String matv;
    private String tentv;
    private String matkhau;
    private String loaitaikhoan;

    public ThanhVien(String matv, String tentv, String matkhau, String loaitaikhoan) {
        this.matv = matv;
        this.tentv = tentv;
        this.matkhau = matkhau;
        this.loaitaikhoan = loaitaikhoan;
    }

    public String getMatv() {
        return matv;
    }

    public void setMatv(String matv) {
        this.matv = matv;
    }

    public String getTentv() {
        return tentv;
    }

    public void setTentv(String tentv) {
        this.tentv = tentv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }
}
