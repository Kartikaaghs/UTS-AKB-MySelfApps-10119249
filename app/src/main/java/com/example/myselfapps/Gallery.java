//Nama : Kartika Aghni Safitri
//NIM : 10119249
//Kelas : IF6
//Tanggal Pengerjaan : 8 Mei 2022

package com.example.myselfapps;

import com.example.myselfapps.Entity.gallery;

import java.util.ArrayList;

public class Gallery {
    private static int[] galleryItems ={

            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4

    };

    public static ArrayList<gallery> getListData(){
        ArrayList<gallery> list = new ArrayList<>();
        for (int position = 0; position < galleryItems.length; position++){
            gallery day = new gallery();
            day.setGalleryItems(galleryItems[position]);
            list.add(day);
        }
        return list;
    }
}
