package fpoly.cp17302_3.duan1.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "CUAHANGBANVE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbTheLoai = "create table THELOAI (maloai integer primary key autoincrement, tenloai text)";
        db.execSQL(dbTheLoai);

        String dbPhim = "create table PHIM(maphim integer primary key autoincrement, tenphim text, hinhanh integer, maloai integer references THELOAI(maloai))";
        db.execSQL(dbPhim);

        String dbXuatChieu = "create table XUATCHIEU(maxuatchieu integer primary key autoincrement, ngaychieu text, thoigianchieu text, maphim integer references PHIM(maphim))";
        db.execSQL(dbXuatChieu);

        String dbThanhVien = "create table THANHVIEN(matv text primary key, tentv text, matkhau text, loaitaikhoan text)";
        db.execSQL(dbThanhVien);

        String  dbVe = "create table VE(mave integer primary key autoincrement, thoigiandat text, soghe text, giave integer, maxuatchieu integer references XUATCHIEU(maxuatchieu), matv text references THANHVIEN(matv))";
        db.execSQL(dbVe);

        db.execSQL("INSERT INTO THANHVIEN VALUES ('tv01', 'DAI', '123', 'admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS THELOAI");
        db.execSQL("DROP TABLE IF EXISTS PHIM");
        db.execSQL("DROP TABLE IF EXISTS XUATCHIEU");
        db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
        db.execSQL("DROP TABLE IF EXISTS VE");
    }
}
