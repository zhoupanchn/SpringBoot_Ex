package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhoupanchn on 2020/2/17.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp客户端启动。。。。");
        //创建Socket客户端
        Socket       socket       = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是客户端001。。。".getBytes());
        socket.close();
    }
}
