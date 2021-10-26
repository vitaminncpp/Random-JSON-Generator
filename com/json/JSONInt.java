package com.json;

import java.util.Random;

public class JSONInt implements JSONObject,JSONKey{
    private int value;

    public JSONInt(int value){
        this.value=value;
    }

    @Override
    public String toString(){
        return "\""+this.value+"\"";
    }

    /**
     * @return int return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }


    public static JSONInt generate(){
        return new JSONInt(Math.abs(new Random().nextInt())+1);
    }

}
