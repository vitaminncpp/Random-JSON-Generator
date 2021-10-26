package com.json;

import java.util.Random;

/**
 * JSONStr
 */
public class JSONStr implements JSONObject,JSONKey{

    private String value;
    public JSONStr(String value){
        this.value=value;
    }

    

    @Override
    public String toString() {
        return "\"" +this.value + "\"";
    }

    /**
     * @return String return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }



    public static JSONStr generate(int size){
        String str="";
        Random r=new Random();
        size= r.nextInt(size);
        int temp=0;
        for(int i=0;i<size;i++){
            temp=r.nextInt(26);
            str+=((char)(temp+97));
        }
        return new JSONStr(str);
    }
}