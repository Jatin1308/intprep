package JavaSocketExample;

import java.net.*;
import java.io.*;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }


    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
//        String resp4 = client.sendMessage(".");


        System.out.println(resp1);
        System.out.println(resp2);
        System.out.println(resp3);
//        System.out.println(resp4);

    }



}

