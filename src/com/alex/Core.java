package com.alex;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Created by Alex on 06.11.2017.
 */
public class Core {
    Core() {

    }

    public String validate(String in) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(in);
            System.out.println(object.isEmpty());
        } catch (ParseException ex) {
            System.out.println("Json error: "+ ex.toString());
        }
        return in;
    }
}
