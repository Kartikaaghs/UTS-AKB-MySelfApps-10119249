package com.example.myselfapps;

//<!--Nama : Kartika Aghni Safitri | NIM : 10119249 | Kelas : IF-6 | Tanggal Pengerjaan : 18/5/2022-->

public class MediaModel {
    int image;
    String title;
    String penyanyi;

    public MediaModel(int image, String title, String penyanyi) {
        this.image = image;
        this.title = title;
        this.penyanyi = penyanyi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }
}

