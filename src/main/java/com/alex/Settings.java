package com.alex;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;

/**
 * Created by Alex on 06.11.2017.
 */
public final class Settings {
    public static final int PORT = 80;
    public static final String HOST = "localhost";
    public static final int SLEEP_TIME = 50;
    public static final int RETRIES_COUNT = 200;
    public static final String REQ_CONT_LEN = "Content-Length: ";

    public static final String ERR_CODE = "errorCode";
    public static final String ERR_MES = "errorMessage";
    public static final String ERR_PL = "errorPlace";

    public static final ArrayList<Character> NOT_VALID_CHARS = new ArrayList<Character>() {{
        add('\u0000');
        add('\uFEFF');
    }};
}
