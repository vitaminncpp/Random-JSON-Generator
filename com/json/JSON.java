package com.json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author
 */

public class JSON implements JSONObject {

    private static int depth = 0;

    private HashMap<JSONKey, JSONObject> map;

    public JSON() {

        map = new HashMap<JSONKey, JSONObject>();
    }

    public void put(JSONKey key, JSONObject value) {
        this.map.put(key, value);
    }

    @Override
    public String toString() {
        String str = "{";
        Set<JSONKey> keys = map.keySet();
        Iterator<JSONKey> iter = keys.iterator();
        JSONKey key = null;
        for (int i = 0; i < keys.size() - 1; i++) {
            key = iter.next();
            str += key + ":" + map.get(key) + ",";
        }
        key = iter.next();
        str += key + ":" + map.get(key);

        str += "}";
        return str;
    }

    public static JSON generate(int jsonSize, int keySize, int arraySize, int strSize) {

        if (depth > 25) {
            return null;
        }
        depth++;

        JSON json = new JSON();
        Random r = new Random();
        int size = Math.abs(r.nextInt(jsonSize)) + 1;
        int temp = 0;
        JSONKey key;

        JSONObject value = null;
        for (int i = 0; i < size; i++) {
            temp = Math.abs(r.nextInt()) + 1;

            key = JSONStr.generate(keySize);

            switch (temp % 7) {
            case 0:
                value = JSONBool.generate();
                break;
            case 1:
                value = JSONInt.generate();
                break;
            case 2:
                value = JSONArray.generate(Math.abs(r.nextInt(arraySize)) + 1);
                break;
            case 3:
                value = JSONDouble.generate();
                break;
            case 4:
                value = JSONStr.generate(Math.abs(r.nextInt(strSize)) + 1);
                break;
            case 5:
                value = JSON.generate(jsonSize, keySize, arraySize, strSize);
                break;
            case 6:
                value = null;
                break;

            default:
                break;
            }
            json.put(key, value);
        }

        return json;
    }

    /**
     * @return HashMap<JSONKey,JSONObject> return the map
     */
    public HashMap<JSONKey, JSONObject> getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(HashMap<JSONKey, JSONObject> map) {
        this.map = map;
    }

    public static String trim(String json) {

        int len = json.length();
        System.out.print(len);
        String out = "";
        boolean codeState = true;
        char ch = 0;
        for (int i = 0; i < len; i++) {
            ch = json.charAt(i);
            if (codeState) {
                if (ch == ' ' || ch == '\n' || ch == '\t') {
                    continue;
                } else if (ch == '"') {
                    codeState = false;
                    out += ch;

                } else {
                    out += ch;
                }

            } else {
                if (ch == '"') {
                    codeState = true;
                    out += ch;
                } else {
                    out += ch;
                }
            }
        }
        return out;
    }

    public static String formatJSON(String json) {

        return null;
    }
}