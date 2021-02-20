package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by zhoupanchn on 2020/2/17.
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //1.ip端口+端口号
        System.out.println("udp服务已经启动...8080");
        //创建服务器端口号 默认使用本机ip
        DatagramSocket ds = new DatagramSocket(8080);
        //服务器接收客户端1024个字节
        byte[] bytes = new byte[1024];
        //定义数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //接受客户端求，将数据封装给数据包，如果客户端不忘服务器发送请求，就一直阻塞
        ds.receive(dp);
        System.out.println("来源ip：" + dp.getAddress() + ",端口号:" + dp.getPort());
        String result = new String(dp.getData(), 0, dp.getLength());
        System.out.println(result);
        ds.close();
    }
}
