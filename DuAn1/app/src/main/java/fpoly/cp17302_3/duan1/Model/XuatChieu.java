package fpoly.cp17302_3.duan1.Model;

public class XuatChieu {
    private String maxuatchieu;
    private String ngaychieu;
    private String thoigianchieu;

    public XuatChieu(String maxuatchieu, String ngaychieu, String thoigianchieu) {
        this.maxuatchieu = maxuatchieu;
        this.ngaychieu = ngaychieu;
        this.thoigianchieu = thoigianchieu;
    }

    public String getMaxuatchieu() {
        return maxuatchieu;
    }

    public void setMaxuatchieu(String maxuatchieu) {
        this.maxuatchieu = maxuatchieu;
    }

    public String getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(String ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public String getThoigianchieu() {
        return thoigianchieu;
    }

    public void setThoigianchieu(String thoigianchieu) {
        this.thoigianchieu = thoigianchieu;
    }
}
