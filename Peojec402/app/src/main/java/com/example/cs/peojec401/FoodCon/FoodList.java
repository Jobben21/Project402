package com.example.cs.peojec401.FoodCon;

import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class FoodList  {

    private  String name;
    private  String food_img;
    private  int energy,fat,carbo,protein,sugar;

    public FoodList(String name, String img, int energy,int fat,int carbo,int protein,int sugar){

        this.setName(name);
        this.setFoodpic(img);
        this.setEnergy(energy);
        this.setFat(fat);
        this.setProtein(protein);
        this.setCarbo(carbo);
        this.setSugar(sugar);

    }

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFoodpic() {
        return food_img;
    }

    public void setFoodpic(String foodpic) {

        this.food_img = foodpic;
    }

    public Integer getEnergy()
    {
        return energy;
    }

    public void setEnergy(int energy)
    {
        this.energy = energy;
    }

    public int getFat()
    {
        return fat;
    }

    public void setFat(int fat) {

        this.fat = fat;
    }

    public int getCarbo()
    {
        return carbo;
    }

    public void setCarbo(int carbo)
    {
        this.carbo = carbo;
    }

    public int getProtein() {

        return protein;
    }

    public void setProtein(int protein)
    {
        this.protein = protein;
    }

    public int getSugar()
    {
        return sugar;
    }

    public void setSugar(int sugar)
    {
        this.sugar = sugar;
    }
}
