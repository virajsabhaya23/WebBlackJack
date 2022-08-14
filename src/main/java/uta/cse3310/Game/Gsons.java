package uta.cse3310.Game;
import com.google.gson.*;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

public class Gsons {

    public static String makejson(Player player, String object){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        object = gson.toJson(player);
        System.out.println(object);
        return object;
    }
}

