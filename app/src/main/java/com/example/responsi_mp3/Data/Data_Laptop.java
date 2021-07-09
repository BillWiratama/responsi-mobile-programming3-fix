package com.example.responsi_mp3.Data;

import com.example.responsi_mp3.Model.Laptop;
import com.example.responsi_mp3.R;

import java.util.ArrayList;

public class Data_Laptop {
    private  static String [] name = {
            "Dell Alienware",
            "Asus Tuf ",
            "Dell G7",
            "Lenovo Legion",
            "Acer Predator",
            "Asus Rog",
            "Acer Nitro",
            "asus vivobook"
    };
    private static  String [] rating = {
            "5.0",
            "4.5",
            "4.6",
            "4.7",
            "4.4",
            "4.9",
            "4.8",
            "4.3",
    };
    private static String [] price = {
            "Rp. 18.000.000",
            "Rp. 12.000.000",
            "Rp. 15.000.000",
            "Rp. 14.0800.000",
            "Rp. 17.000.000",
            "Rp. 19.00.000",
            "Rp. 13.000.000",
            "Rp. 10.000.000"
    };
    private static String [] type={
            "Intel i7-11050H",
            "Intel i7-9850H",
            "Intel 17-10050H",
            "Intel 17-10050H",
            "Intel 17-8750H",
            "Intel 17-11050H",
            "IIntel 17-7850H",
            "Intel 17-7650U"
    };
    private  static  int [] image = {
            R.drawable.Alienware,
            R.drawable.Asus_Tuf,
            R.drawable.Dell_G7,
            R.drawable.Lenovo_Legion,
            R.drawable.Predator,
            R.drawable.Rog,
            R.drawable.acer_nitro,
            R.drawable.asus_vivobook
    };
    public static ArrayList<Laptop> getListData(){
        ArrayList<Laptop> list = new ArrayList<>();
        for (int position = 0 ; position < name.length; position++){
            Laptop laptop = new Laptop();
            laptop.setRating(rating[position]);
            laptop.setLaptop_name(name[position]);
            laptop.setPrice(price[position]);
            laptop.setType(type[position]);
            laptop.setImage(image[position]);
            list.add(laptop);
        }
        return list;
    }

}
