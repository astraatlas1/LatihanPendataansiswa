package com.example.latihan5;

public class DataModel {
    private  String nisn;
    private  String nama;
    private  String alamat;

    public DataModel(String nisn, String nama, String alamat) {
        this.nisn = nisn;
        this.nama = nama;
        this.alamat = alamat;
    }

    public  String getNisn(){
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public  String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
