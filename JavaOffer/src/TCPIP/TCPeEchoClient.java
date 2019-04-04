package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TCPeEchoClient{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String server = sc.nextLine();
        int servPort = sc.nextInt();
        sc.nextLine();
        byte[] data = sc.nextLine().getBytes();
        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo String");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);//相当于send

        int totalBytesRcvd = 0;
        int bytesRcvd;

        while (totalBytesRcvd < data.length) {
            if ((bytesRcvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            totalBytesRcvd += bytesRcvd;
        }// data array is full
        System.out.println("Received data length:" + totalBytesRcvd);
        System.out.println("Received: " + new String(data));
        socket.close();

    }
}
