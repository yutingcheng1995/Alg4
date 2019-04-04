package TCPIP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class TCPEchoServer {
    private static final int BUFSIZE = 32;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int servPort = sc.nextInt();

        //为端口servPort创建一个监听socket，监听客户端socket发送过来的连接请求
        //对应TCP/IP的建立连接
        ServerSocket servSock = new ServerSocket(servPort);
        //测试ServerSocket类中的三个获取属性方法
        System.out.println(servSock.getInetAddress());
        System.out.println(servSock.getLocalPort());
        System.out.println(servSock.getLocalSocketAddress());

        int recvMsgSize;

        byte[] receiveBuf = new byte[BUFSIZE];

        while(true) {
            //当有客户端的请求时，该方法由阻塞变为运行，创建一个新的socket，用于和该客户端通信
            Socket clntSock = servSock.accept();

            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);

            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }
            clntSock.close();
        }
    }
}
