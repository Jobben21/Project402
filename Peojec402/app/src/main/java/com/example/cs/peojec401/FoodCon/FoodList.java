package com.example.cs.peojec401.FoodCon;

import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class FoodList  {

    private  String name,method,ingred,food_di;
    private  String food_img,foodtype,typeingred;
    private  int energy,fat,carbo,protein,sugar;
    public static   int m=0;
    public static   int m1=0;
    public static   int m2=0;
    public static   int m3=0;




    public FoodList(String name, String img, int energy, int fat, int carbo, int protein, int sugar, String method, String ingred, String typeingred, String foodtype, String food_di){

        this.setName(name);
        this.setFoodpic(img);
        this.setEnergy(energy);
        this.setFat(fat);
        this.setProtein(protein);
        this.setCarbo(carbo);
        this.setSugar(sugar);
        this.setMethod(method);
        this.setIngred(ingred);
        this.setFood_di(food_di);
        this.setTypeingred(typeingred);
        this.setFoodtype(foodtype);

    }
    public String getFood_di() {
        return food_di;
    }

    public void setFood_di(String food_di) {
        this.food_di = food_di;
    }
    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {




        this.foodtype = foodtype;
    }

    public String getTypeingred() {
        return typeingred;
    }

    public void setTypeingred(String typeingred) {
        this.typeingred = typeingred;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIngred() {
        return ingred;
    }

    public void setIngred(String ingred) {
        this.ingred = ingred;
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
