package com.example.cs.peojec401;

/**
 * Created by นครินทร์ on 5/11/2018.
 */

public class BloodList {
    private String sugar,choles,hdl,ldl,potassium,trigly,sodium;
public BloodList(String sugar,String choles,String hdl,String ldl,String potassium,String trigly,String sodium){

    this.sugar=sugar;
    this.choles=choles;
    this.hdl=hdl;
    this.ldl=ldl;
    this.potassium=potassium;
    this.trigly=trigly;
    this.sodium=sodium;


}



    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getCholes() {
        return choles;
    }

    public void setCholes(String choles) {
        this.choles = choles;
    }

    public String getHdl() {
        return hdl;
    }

    public void setHdl(String hdl) {
        this.hdl = hdl;
    }

    public String getLdl() {
        return ldl;
    }

    public void setLdl(String ldl) {
        this.ldl = ldl;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getTrigly() {
        return trigly;
    }

    public void setTrigly(String trigly) {
        this.trigly = trigly;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }
}
