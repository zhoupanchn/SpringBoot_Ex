package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by zhoupanchn on 2020/2/17.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("udp客户端启动连接。。。");
        //不传入端口号， 则表示作为客户端
        DatagramSocket ds    = new DatagramSocket();
        String         str   ="Hello，我是客户端";
        byte[]         bytes =str.getBytes();
        DatagramPacket dp    = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 8080);
        ds.send(dp);
        ds.close();
    }
}
