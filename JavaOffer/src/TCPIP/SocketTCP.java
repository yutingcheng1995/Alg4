package TCPIP;

import java.net.*;
import java.util.Enumeration;

/**
 * 套接字：
 * 1.InetAddress类：表示一个网络目标地址；其有两个子类：Inet4Address和Inet6Address。
 * 2.NetWorkInterface类：
 *     表示本机的接口信息，每个接口对应一个或多个IP地址；
 *     每个接口对应某种类型的网卡；
 *     NetworkInterface.getNetworkInterfaces()：可以获得本机的所有接口实例；
 *     接口实例.getInetAddress()：可以获得接口对应的所有IP地址
 *
 */
public class SocketTCP {
    public static void main(String[] args) {
        //获取与本机的所有IP地址
        try {
            //获取本机所有对外接口：有线网卡、无线网卡、回环地址
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            //没有接口时，输出错误信息
            if(interfaceList == null){
                System.out.println("No interface found!");
            }
            else{
                //有接口
                while(interfaceList.hasMoreElements()){
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface:"+iface.getDisplayName());
                    System.out.println("Interface:"+iface.getName()+":");
                    //获取每个接口的所有IP地址
                    Enumeration<InetAddress> addList = iface.getInetAddresses();
                    if(!addList.hasMoreElements()){
                        System.out.println("\t(No addresses for this interface)");
                    }
                    while(addList.hasMoreElements()){
                        InetAddress add = addList.nextElement();
                        System.out.print("\t Address" + (add instanceof Inet4Address?"(v4)":(add instanceof Inet6Address?"(v6)":"(?)")));
                        System.out.print(":"+add.getHostAddress());
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }catch(SocketException e){
            System.out.println("Error getting network interfaces:" + e.getMessage());
        }

        //获取命令行输入的主机名的地址
        String host= "dell-PC";
        System.out.println("Test getLocalHost:");
        try{
         System.out.println(InetAddress.getLocalHost());
        }catch(UnknownHostException e){
            e.printStackTrace();
        }

        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println(address.toString());
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
        System.out.println(host+":");
        try{
              InetAddress[] addList = InetAddress.getAllByName(host);
              for(InetAddress add:addList){
                  System.out.println("\t" + add.getHostName() + "/"+add.getHostAddress());
                  System.out.println("\t" + add.toString());
              }
        }catch(UnknownHostException e){
                System.out.println("\tUnable to find address for" + host);
        }

    }

}
