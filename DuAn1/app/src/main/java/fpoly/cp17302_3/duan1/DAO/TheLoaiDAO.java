package fpoly.cp17302_3.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.cp17302_3.duan1.DataBase.DBHelper;
import fpoly.cp17302_3.duan1.Model.TheLoai;

public class TheLoaiDAO {
    DBHelper dbHelper;
    public TheLoaiDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<TheLoai> getDSTheLoai(){
        ArrayList<TheLoai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THELOAI", null);

        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new TheLoai(cursor.getString(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean themTheLoai(String tenloai){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai",tenloai );
        long check = sqLiteDatabase.insert("THELOAI", null, contentValues);
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean xoaTheLoai(String maloai){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THELOAI WHERE maloai =?", new String[]{maloai});

        long check = sqLiteDatabase.delete("LOAISACH", "maloai = ?", new String[]{maloai});
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean capNhatTheLoai(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai", theLoai.getTenloai());
        long check = sqLiteDatabase.update("THELOAI",contentValues, "maloai = ?", new String[]{theLoai.getMaloai()});
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }
}
