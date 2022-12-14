package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;

public class Dokter implements Parcelable {
    int id = 0;
    String nama_pasien;
    String nama_dokter;
    String spesialis;
    String keluhan;
    String tanggal;
    String waktu;
    String status;

    public Dokter(int id, String nama_pasien, String nama_dokter,
                  String spesialis, String keluhan, String tanggal,
                  String waktu, String status) {
        this.id = id;
        this.nama_pasien = nama_pasien;
        this.nama_dokter = nama_dokter;
        this.spesialis = spesialis;
        this.keluhan = keluhan;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
    }

    public Dokter(){}
    public Dokter(Parcel in){
        nama_pasien = in.readString();
        nama_dokter = in.readString();
        spesialis = in.readString();
        keluhan = in.readString();
        tanggal = in.readString();
        waktu = in.readString();
        status = in.readString();

    }

    public static final Creator<Dokter> CREATOR = new Creator<Dokter>() {
        @Override
        public Dokter createFromParcel(Parcel parcel) {
            return new Dokter(parcel);

        }

        @Override
        public Dokter[] newArray(int i) {
            return new Dokter[i];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama_pasien);
        parcel.writeString(this.nama_dokter);
        parcel.writeString(this.keluhan);
        parcel.writeString(this.spesialis);
        parcel.writeSerializable(this.tanggal);
        parcel.writeSerializable(this.waktu);
    }
}
