package com.example.cs.peojec401;

/**
 * Created by hp on 22/2/2561.
 */
public class Food {


    int Menufood;
    String comment;
    String date;


    String maindish_food;
    int maindish_image;

    public Food(int menufood, String comment, String date, String maindish_food,int maindish_image) {
        Menufood = menufood;
        this.comment = comment;
        this.date = date;
        this.maindish_food = maindish_food;
        this.maindish_image = maindish_image;

    }


    public int getMenufood() {
        return Menufood;
    }

    public void setMenufood(int menufood) {
        Menufood = menufood;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaindish_image() {
        return maindish_image;
    }

    public void setMaindish_image(int maindish_image) {
        this.maindish_image = maindish_image;
    }

    public String getMaindish_food() {
        return maindish_food;
    }

    public void setMaindish_food(String maindish_food) {
        this.maindish_food = maindish_food;
    }
}
