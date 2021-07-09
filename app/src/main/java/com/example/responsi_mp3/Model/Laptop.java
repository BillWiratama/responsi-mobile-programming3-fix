package com.example.responsi_mp3.Model;

public class Laptop {

    private String rating;
    private String laptop_name;
    private String type;
    private String price;
    private int image;

    public Laptop() {
        this.rating = rating;
        this.laptop_name = laptop_name;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
