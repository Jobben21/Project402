package com.example.cs.peojec401.ConnectData;

/**
 * Created by นครินทร์ on 3/25/2018.
 */

public class Config_food {
    public static final String DATA_URL = "http://192.168.1.40/android/get_food.php?status=0";

    //Tags used in the JSON String
    public static final String ID= "id";
    public static final String FOOD_NAME = "name";
    public static final String FOODPIC = "foodpic";
    public static final String ENERGY= "energy";
    public static final String CARBO="carbohydrate";
    public static final String FAT="fat";
    public static final String PROTEIN="protein";
    public static final String SUGAR="sugar";

    //JSON array name
    public static final String JSON_ARRAY = "result";
}
