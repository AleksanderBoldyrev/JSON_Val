package com.alex;

/**
 * The entry point of the project.
 *
 * Creates a netw_layer and a new server thread.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Creating server");
        com.alex.Netw_Layer servDaemon = new com.alex.Netw_Layer(com.alex.Settings.PORT);
        System.out.println("Creating server thread");
        Thread serverThread = new Thread(servDaemon);
        System.out.println("Trying to run server thread");
        serverThread.run();
        System.out.println("Server stopped");
    }
}
