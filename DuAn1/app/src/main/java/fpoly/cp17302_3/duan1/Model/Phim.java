package fpoly.cp17302_3.duan1.Model;

public class Phim {
    private String maphim;
    private String tenphim;
    private int hinhanh;

    public Phim(String maphim, String tenphim, int hinhanh) {
        this.maphim = maphim;
        this.tenphim = tenphim;
        this.hinhanh = hinhanh;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
