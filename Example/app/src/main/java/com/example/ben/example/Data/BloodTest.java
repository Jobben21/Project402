package com.example.ben.example.Data;

public class BloodTest {

    public int sugar;
    public int sodium;
    public double potassium;
    public int cholesteral;
    public int ldl;
    public int hdl;
    public int trigryceride;

    public BloodTest(int sugar, int sodium, double potassium, int cholesteral, int ldl, int hdl, int trigryceride) {
        this.sugar = sugar;
        this.sodium = sodium;
        this.potassium = potassium;
        this.cholesteral = cholesteral;
        this.ldl = ldl;
        this.hdl = hdl;
        this.trigryceride = trigryceride;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public int getCholesteral() {
        return cholesteral;
    }

    public void setCholesteral(int cholesteral) {
        this.cholesteral = cholesteral;
    }

    public int getLdl() {
        return ldl;
    }

    public void setLdl(int ldl) {
        this.ldl = ldl;
    }

    public int getHdl() {
        return hdl;
    }

    public void setHdl(int hdl) {
        this.hdl = hdl;
    }

    public int getTrigryceride() {
        return trigryceride;
    }

    public void setTrigryceride(int trigryceride) {
        this.trigryceride = trigryceride;
    }
}
