package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "Daftar Dokter";

    // table name
    private static final String TABLE_DOKTER = "Dokter";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA_PASIEN = "bahan";
    private static final String KEY_NAMA_DOKTER = "nama dokter";
    private static final String KEY_SPESIALIS = "spesialis";
    private static final String KEY_KELUHAN = "keluhan";
    private static final String KEY_TANGGAL = "tanggal";
    private static final String KEY_WAKTU = "waktu";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACS_TABLE = "CREATE TABLE " + TABLE_DOKTER + "("
                + KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAMA_PASIEN + "TEXT,"
                + KEY_NAMA_DOKTER + "TEXT," + KEY_SPESIALIS + "TEXT,"
                + KEY_KELUHAN + "TEXT," + KEY_TANGGAL + "TEXT,"
                + KEY_WAKTU + "TEXT" +")";
        db.execSQL(CREATE_CONTACS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOKTER);
        onCreate(db);
    }
}
