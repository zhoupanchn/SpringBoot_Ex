package demo.tcpDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhoupanchn on 2020/2/24.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);
       /* Scanner scanner = new Scanner(client.getInputStream());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();*/
        /*String str="你猜猜我是谁";
        OutputStream outputStream = client.getOutputStream();
        outputStream.write(str.getBytes());*/
        String  str     = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            System.out.println(str);
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(str.getBytes());
        }
        client.close();
    }
}
