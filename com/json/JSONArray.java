package com.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JSONArray implements JSONObject {

    private static int depth=0;

    private ArrayList <JSONObject> array;

    public JSONArray(){
        this.array=new ArrayList<JSONObject>();
    }
    
    public JSONArray(ArrayList <JSONObject>array){
        this.array=array;
    }
    
    @Override
    public String toString() {
        String str="[";
        for(int i=0;i<array.size()-1;i++){
            str+=array.get(i)+",";
        
        }
        str+=array.get(array.size()-1);
        str+=']';
        return str;

    }

    /**
     * @return List <JSONObject> return the array
     */
    public List <JSONObject> getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(ArrayList <JSONObject> array) {
        this.array = array;
    }


    public static JSONArray generate(int size){

        if(depth>25){
            return null;
        }
        depth++;
        ArrayList<JSONObject> array=new ArrayList<JSONObject>();
try{
        Random r=new Random();
        int newsize=Math.abs(r.nextInt(size))+1;
        int temp;
        for (int i=0;i<newsize;i++){
            temp=Math.abs(r.nextInt(7));
            switch(temp){
                case 0:
                array.add(JSONBool.generate());
                break;
                case 1:
                array.add(JSONInt.generate());
                break;
                case 2:
                array.add(JSONArray.generate(size));
                break;
                case 3:
                array.add(JSONDouble.generate());
                break;
                case 4:
                array.add(JSONStr.generate(size));
                break;
                case 5:
                array.add(JSON.generate(Math.abs(r.nextInt(size))+1,Math.abs(r.nextInt(size))+1,Math.abs(r.nextInt(size))+1,Math.abs(r.nextInt(size))+1));
                break;
                case 6:
                array.add(null);
                break;

                default:
                break;
            }
        }
    }
    catch(ArrayIndexOutOfBoundsException ex){
        System.out.println(depth);
    }

        return new JSONArray(array);

    }

}
