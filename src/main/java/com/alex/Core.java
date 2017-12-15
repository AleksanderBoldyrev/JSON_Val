package com.alex;

import java.io.IOException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Alex on 06.11.2017.
 */

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Crunchify.com
 */

public class Core {

    Core() {
    }

    public String validate(String in) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(in);
            Set keys = object.keySet();
            //for (int i=0; i< keys.size(); i++)
                //System.out.println("KEY: " + keys.toArray()[i].toString());
        } catch (ParseException ex) {
            JSONObject error = new JSONObject();

            error.put(Settings.ERR_CODE,ex.getErrorType());
            error.put(Settings.ERR_MES, ex.toString());
            error.put(Settings.ERR_PL,ex.getPosition());
            //System.out.print(error.toString());

            //System.out.println("Json error: " + ex.toString());

            return error.toString();
        }
        return in;
    }
}