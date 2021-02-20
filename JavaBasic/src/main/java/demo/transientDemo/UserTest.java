package demo.transientDemo;

import java.io.*;

/**
 * Created by zhoupanchn on 2020/2/20.
 */
public class UserTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeUser();
        DeSerializeUser();

    }

    private static void DeSerializeUser() throws IOException, ClassNotFoundException {
        File              file              = new File("E://test");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        User              o                 = (User) objectInputStream.readObject();
        System.out.println("反序列化后：age=" + o.getAge());
        System.out.println("反序列化后：name=" + o.getUserName());
    }

    private static void SerializeUser() throws IOException {
        User user = new User();
        user.setUserName("Transient测试");
        user.setAge(16);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://test"));
        oos.writeObject(user);
        oos.close();
        System.out.println("序列化前：age=" + user.getAge());
        System.out.println("序列化前：name=" + user.getUserName());
    }
}
