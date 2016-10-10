package com.nxt.zyl.util;

import org.json.JSONException;
import org.json.JSONObject;

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
}
