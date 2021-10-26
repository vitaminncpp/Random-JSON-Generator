package com.json;

import java.util.Random;

public class JSONBool implements JSONObject {
    private boolean value;

    

    public JSONBool(boolean value) {
        this.value = value;
    }

    /**
     * @return boolean return the value
     */
    public boolean isValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(boolean value) {
        this.value = value;
    }   

    @Override
    public String toString() {
        return ""+this.value;
    }

    public static JSONBool generate(){
        Random r=new Random();
        return new JSONBool(r.nextBoolean());
    }
}
