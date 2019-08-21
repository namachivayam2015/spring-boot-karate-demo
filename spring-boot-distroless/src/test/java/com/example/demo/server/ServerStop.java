package com.example.demo.server;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerStop {

    public void stopServer(int port) {
        try {
            Socket s = new Socket(InetAddress.getByName("127.0.0.1"), port);
            OutputStream out = s.getOutputStream();
            System.out.println("sending stop request to monitor thread on port: "+ port);
            out.write(("\r\n").getBytes());
            out.flush();
            s.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}