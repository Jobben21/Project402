package com.example.cs.peojec401;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class Food_recyc {

    private  String name;
    private  String foodpic;
    private  Double energy;

    public Food_recyc(String name,String foodpic,Double energy){

        this.setName(name);
        this.setFoodpic(foodpic);
        this.setEnergy(energy);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodpic() {
        return foodpic;
    }

    public void setFoodpic(String foodpic) {
        this.foodpic = foodpic;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }
}
