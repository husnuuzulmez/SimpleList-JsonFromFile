package com.example.uzulmez.simplelist;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uzulmez on 2/10/2018.
 */

public class recipe {

    public String p1;
    public String p2;




    public static ArrayList<recipe> getlistfromfile(String s , Context contex) {
        ArrayList<recipe> rlist = new ArrayList<>();
        try {
        String jsonString =  loadJsonFromAsset(s,contex);
        JSONObject json = new JSONObject(jsonString);
        JSONArray recipes = json.getJSONArray("recipes");

        for (int i=0; i<recipes.length(); i++){
            recipe r = new recipe();
            r.p1 = recipes.getJSONObject(i).getString("title");
            r.p2 = recipes.getJSONObject(i).getString("image");
            rlist.add(r);
        }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rlist;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
