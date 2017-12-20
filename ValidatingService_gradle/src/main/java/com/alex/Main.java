package com.alex;

public class Main {

    public static void main(String[] args) {
        System.out.println("Creating server");
        Netw_Layer servDaemon = new Netw_Layer(Settings.PORT);
        System.out.println("Creating server thread");
        Thread serverThread = new Thread(servDaemon);
        System.out.println("Trying to run server thread");
        serverThread.run();
        System.out.println("Server stopped");
    }
}
