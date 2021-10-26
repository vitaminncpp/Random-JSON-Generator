package com.json;

import java.util.Random;

public class JSONDouble implements JSONObject {
    private double value;

    public JSONDouble(double value){
        this.value=value;
    }

    @Override
    public String toString() {
        return ""+this.value;
    }

    /**
     * @return double return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }


    public static JSONDouble generate(){
        return new JSONDouble(new Random().nextDouble());
    }
}
