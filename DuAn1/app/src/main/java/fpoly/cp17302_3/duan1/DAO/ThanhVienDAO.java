package fpoly.cp17302_3.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.cp17302_3.duan1.DataBase.DBHelper;
import fpoly.cp17302_3.duan1.Model.ThanhVien;

public class ThanhVienDAO {
    DBHelper dbHelper;
    SharedPreferences sharedPreferences;
    public ThanhVienDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<ThanhVien> getDSThanhVien(){
        ArrayList<ThanhVien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THANHVIEN", null );
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new ThanhVien(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean checkDangNhap(String matv, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THANHVIEN WHERE matv = ? And matkhau = ?", new String[]{matv, matkhau});
        if (cursor.getCount() !=0) {
            cursor.moveToFirst();

            return true;
        }else{
            return false;
        }
    }

    public boolean themThanhVien(ThanhVien thanhVien){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tentv", thanhVien.getTentv());
        contentValues.put("matkhau", thanhVien.getMatkhau());
        contentValues.put("loaitaikhoan", thanhVien.getLoaitaikhoan());
        long check = sqLiteDatabase.insert("THANHVIEN", null, contentValues );

        if (check == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean xoaThanhVien(String matv){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("THANHVIEN", "matv = ?", new String[]{matv});
        if(check == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean capNhatThanhVien(ThanhVien thanhVien){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("tentv", thanhVien.getTentv());
        contentValues.put("matkhau", thanhVien.getMatkhau());
        contentValues.put("loaitaikhoan", thanhVien.getLoaitaikhoan());

        long check = sqLiteDatabase.update("THANHVIEN", contentValues, "matv = ?", new String[]{thanhVien.getMatv()});
        if (check == -1){
            return false;
        }else {
            return true;
        }

    }
}
