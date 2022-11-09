package fpoly.cp17302_3.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.cp17302_3.duan1.DataBase.DBHelper;
import fpoly.cp17302_3.duan1.Model.Phim;

public class PhimDAO {
    DBHelper dbHelper;
    public PhimDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<Phim> getDSPhim(){
        ArrayList<Phim> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PHIM", null);
        if (cursor.getCount() !=0){
            cursor.moveToFirst();
            do {
                list.add(new Phim(cursor.getString(0), cursor.getString(1), cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean themPhim(String tenphim, int hinhanh){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenphim", tenphim);
        contentValues.put("hinhanh", hinhanh);
        long check = sqLiteDatabase.insert("PHIM", null, contentValues);
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean xoaPhim(int maphim){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        long check = sqLiteDatabase.delete("LOAISACH", "maloai = ?", new String[]{String.valueOf(maphim)});
        if (check == -1){
            return false;
            //0: Xóa thất bại
        }else {
            return true;
            //1: Xóa thành công
        }
    }

    public boolean capNhatPhim(Phim phim){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenphim", phim.getTenphim());
        contentValues.put("hinhanh", phim.getHinhanh());
        long check = sqLiteDatabase.update("PHIM", contentValues, "maphim = ?", new String[]{String.valueOf(phim.getMaphim())});
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }
}
