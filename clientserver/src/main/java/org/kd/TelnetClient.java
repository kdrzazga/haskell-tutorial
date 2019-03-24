package org.kd;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TelnetClient {

    private final static int PORT = 4242;
    private String host;

    private PrintWriter s_out = null;
    private final PrintStream output = System.out;
    private BufferedReader s_in = null;

    public TelnetClient(String host) {
        this.host = host;
    }

    public void sendData() {
        var s = new Socket();

        try {
            s.connect(new InetSocketAddress("localhost", PORT));
            System.out.println("Connected");

            //writer for socket
            s_out = new PrintWriter(s.getOutputStream(), true);
            //reader for socket
            s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }

        //Host not found
        catch (UnknownHostException e) {
            System.err.println("Don't know about host : " + host);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Send message to server
        send("Yanush");
        send("quit");
    }

    private void send(String message) {
        s_out.println(message);

        System.out.println("Message send");

        String response;
        try {
            while ((response = s_in.readLine()) != null
                    || !response.startsWith("Bye")) {
                output.print(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TelnetClient("localhost").sendData();
    }
}
