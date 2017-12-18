package com.alex;

        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.util.ArrayList;

/**
 * Created by Alex on 08.10.2015.
 */
public class Netw_Layer extends Thread{
    private ArrayList<com.alex.Server_Instance> _serverThreads;
    private int _port;
    private ServerSocket _ssocket;

    Netw_Layer(int port) {
        _serverThreads = new ArrayList<com.alex.Server_Instance>();
        _serverThreads.clear();
        _port = port;
        try {
            _ssocket = new ServerSocket(_port);
        } catch (IOException e) {
            System.out.println("Couldn't create service.");
        }
    }
     /**
     * Creates the Server instance as a new thread and starts accepting the data through socket.
     */
    public void run()
    {
        Socket s = null;
        while (true) {

            try {
                s = _ssocket.accept();
                com.alex.Server_Instance serv = new com.alex.Server_Instance(s);
                _serverThreads.add(serv);
                Thread t = new Thread(serv);
                t.start();
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Couldn't create a new server thread.");
                break;
            }
        }

        try {
            s.close();
            _ssocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
