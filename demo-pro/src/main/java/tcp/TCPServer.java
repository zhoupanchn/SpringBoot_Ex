package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhoupanchn on 2020/2/17.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("TCP协议服务器启动。。。。");
        //创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        //接受客户端请求 阻塞功能

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = socket.getInputStream();

                            byte[] bytes  = new byte[1024];
                            int    len    = inputStream.read(bytes);
                            String result = new String(bytes, 0, len);
                            System.out.println("服务器端接受的内容:" + result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
