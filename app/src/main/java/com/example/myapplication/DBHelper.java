package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.model.Dokter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "Daftar Dokter";

    // table name
    private static final String TABLE_DOKTER = "Dokter";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA_PASIEN = "Nama pasien";
    private static final String KEY_NAMA_DOKTER = "Nama dokter";
    private static final String KEY_SPESIALIS = "Spesialis";
    private static final String KEY_KELUHAN = "Keluhan";
    private static final String KEY_TANGGAL = "Tanggal";
    private static final String KEY_WAKTU = "Waktu";
    private static final String KEY_STATUS = "Status";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACS_TABLE = "CREATE TABLE " + TABLE_DOKTER + "("
                + KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAMA_PASIEN + "TEXT,"
                + KEY_NAMA_DOKTER + "TEXT," + KEY_KELUHAN + "TEXT," + KEY_TANGGAL + "TEXT,"
                + KEY_WAKTU + "TEXT," + KEY_STATUS + "TEXT" +")";
        db.execSQL(CREATE_CONTACS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOKTER);
        onCreate(db);
    }

    public void addRecord(Dokter Dokter){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_DOKTER,Dokter.getNama_dokter());
        values.put(KEY_NAMA_PASIEN,Dokter.getNama_pasien());
        values.put(KEY_KELUHAN,Dokter.getKeluhan());
        values.put(KEY_TANGGAL, Dokter.getTanggal());
        values.put(KEY_WAKTU, Dokter.getWaktu());
        values.put(KEY_STATUS,Dokter.getStatus());
        db.insert(TABLE_DOKTER,null,values);
        db.close();
    }

    public Dokter getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DOKTER, new String[]{KEY_NAMA_DOKTER,
                        KEY_NAMA_PASIEN,KEY_KELUHAN,KEY_TANGGAL,
                        KEY_WAKTU,KEY_STATUS},KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }

        Dokter contact = new Dokter(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),
                cursor.getString(6),cursor.getString(7));

        return contact;
    }


    public int updateContact(Dokter contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_DOKTER,contact.getNama_dokter());
        values.put(KEY_NAMA_PASIEN,contact.getNama_pasien());
        values.put(KEY_KELUHAN,contact.getKeluhan());
        values.put(KEY_TANGGAL, contact.getTanggal());
        values.put(KEY_WAKTU, contact.getWaktu());
        values.put(KEY_STATUS,contact.getStatus());

        return db.update(TABLE_DOKTER,values,KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});


    }

    // get All Record
    public List<Dokter> getAllRecord() {
        List<Dokter> contactList = new ArrayList<Dokter>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DOKTER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dokter Dokter = new Dokter();
                Dokter.setId(Integer.parseInt(cursor.getString(0)));
                Dokter.setNama_dokter(cursor.getString(1));
                Dokter.setNama_pasien(cursor.getString(2));
                Dokter.setKeluhan(cursor.getString(4));
                Dokter.setTanggal(cursor.getString(5));
                Dokter.setWaktu(cursor.getString(6));
                Dokter.setStatus(cursor.getString(7));
                contactList.add(Dokter);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public void deleteRecord(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_DOKTER, KEY_ID + " = " + id, null);
    }

}
