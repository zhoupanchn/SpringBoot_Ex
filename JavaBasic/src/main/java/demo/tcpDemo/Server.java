package demo.tcpDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhoupanchn on 2020/2/24.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        String       data   = "呵呵";
        ServerSocket socket = new ServerSocket(8888);
        System.out.println("服务端已准备就绪。。。。。");
        Boolean accept = true;
        while (accept) {
            Socket client = socket.accept();
            System.out.println("连接过来的客户端：" + client.getInetAddress());
            InputStream inputStream = client.getInputStream();
            byte[]      bytes       = new byte[1024];
            int         read        = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, read));
            /*PrintStream out = new PrintStream(client.getOutputStream());
            out.println(data);
            out.close();*/
        }
        socket.close();
    }
}
