package com.alex;

import java.io.IOException;
//import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
//import java.util.ArrayList;

/**
 * Created by Alex on 06.11.2017.
 */
public class Server_Instance extends Thread {
    private Socket _socket;
    private BufferedReader _in;
    private PrintWriter _out;
    private Core _core;
    private int _userId;

    Server_Instance(Socket s) {
        _socket = s;
        _core = new Core();
        //_parser.SetUserId(-1);
        _userId = -1;
        try {
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            _out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String str = new String();
            String resp = new String();
            String buf = new String();
            int conLen = 0;
            //System.out.println("<HEAD>");
            while ((str = _in.readLine()) != null) {
                if (str.equals("")) {
                    break;
                }
                System.out.println(str);
                // read head
                if (str.contains(Settings.REQ_CONT_LEN)) {
                    conLen = Integer.parseInt(str.replace(Settings.REQ_CONT_LEN, ""));
                }
                // wait for some msecs
                try {
                    this.sleep(Settings.SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("<BODY>");
            if (conLen>0) {
                char[] arr = new char[conLen];
                _in.read(arr, 0, conLen);
                buf = new String(arr);
                System.out.println(buf);
                if (buf.length() > 0) {
                    Core cc = new Core();
                    resp = cc.validate(buf);
                    _out.println(resp);
                    _socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("End of validating...");
            try {
                _socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}