package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class Example  extends AppCompatActivity {

    private int age;
    private  int weight;
    private  int height;
    private  float BMI;
    private float BMR;
    private int man;
    private  int woman;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Example(){

    }
    public Example(int age, int weight, int height, float BMI, float BMR, int man, int woman) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.BMI = BMI;
        this.BMR = BMR;
        this.man = man;
        this.woman = woman;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public void setMan(int man) {
        this.man = man;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
    public void setBMI(float BMI) {
        this.BMI = BMI;
    }

    public float getBMI() {
        return BMI;
    }

    public float getBMR() {
        return BMR;
    }

    public void setBMR(float BMR) {
        this.BMR = BMR;

    }


    public int getMan() {
        return man;
    }

    public int getWoman() {
        return woman;
    }
}