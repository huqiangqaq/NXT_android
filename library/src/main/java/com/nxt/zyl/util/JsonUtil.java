package com.nxt.zyl.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by huqiang on 2016/10/10.
 */

public class JsonUtil {
    public static boolean PareJson(String string){
        try {
            JSONObject jsonObject = new JSONObject(string);
            return jsonObject.getBoolean("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> parseJson_spnner(String String,String tag){
        List<String> list = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(String);

            for (int i=0;i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
                list.add(object.getString(tag));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String parseJson_zha(String json,String tag){
        try {
            JSONObject object = new JSONObject(json);
            return object.getString(tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
