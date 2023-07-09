package com.example.c53;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_fashion";
    private static final String TABLE_HISTORY = "history";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_ADDRESS = "address";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HISTORY_TABLE = "CREATE TABLE " + TABLE_HISTORY + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_NAME + " TEXT, "  + KEY_IMAGE + " INTEGER, " + KEY_ADDRESS + " TEXT, " + KEY_QUANTITY + " INTEGER)";
        db.execSQL(CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);

        onCreate(db);
    }

    long addHistory(HistoryItem history) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, history.getName());
        values.put(KEY_IMAGE, history.getImage());
        values.put(KEY_ADDRESS, history.getAddress());
        values.put(KEY_QUANTITY, history.getQuantity());

        long result = db.insert(TABLE_HISTORY, null, values);
        db.close();
        return result;
    }

    public List<HistoryItem> getHistoryList() {
        List<HistoryItem> listHistory = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_HISTORY;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                HistoryItem history = new HistoryItem(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4)
                );
                listHistory.add(history);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listHistory;
    }
}
