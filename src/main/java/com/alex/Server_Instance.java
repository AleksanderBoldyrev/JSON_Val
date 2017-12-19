package com.alex;

import java.io.IOException;
import java.net.Socket;
import java.io.*;

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
        _userId = -1;
        try {
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            _out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[] cleanString(char[] in)
    {
        char[] res;
        int newSize = 0;
        for (int i=0; i<in.length; i++)
            if (!Settings.NOT_VALID_CHARS.contains(in[i]))
                newSize++;
        res = new char[newSize];
        newSize = 0;
        for (int i=0; i<in.length; i++)
            if (!Settings.NOT_VALID_CHARS.contains(in[i]))
            {
                res[newSize] = in[i];
                newSize++;
            }
        return res;
    }

      /**
     * Reader of the socket.
     */
    @Override
    public void run() {
        try {
            String str = new String();
            String resp = new String();
            String buf = new String();
            int conLen = 0;
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
            if (conLen>0) {
                char[] arr = new char[conLen];
                _in.read(arr, 0, conLen);
                buf = new String(cleanString(arr));
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
