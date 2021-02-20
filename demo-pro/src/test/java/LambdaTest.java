import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaTest {
    @Getter
    @Setter
    class User {
        private String  username;
        private Integer age;

        public User() {
        }

        public User(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void ageSort() {
        User[] users = new User[]{new User("无花果", 6), new User("还还", 8), new User("还给", 5)};
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        System.out.println(Arrays.toString(users));
    }

    @Test
    public void ageSort1() {
        User[] users = new User[]{new User("无花果", 6), new User("还还", 8), new User("还给", 5)};
        Arrays.sort(users, (o1, o2) ->
                Integer.compare(o1.age, o2.age)
        );
        System.out.println(Arrays.toString(users));
    }

    @Test
    public void ageSort2() {
        User[] users = new User[]{new User("无花果", 6), new User("还还", 8), new User("还给", 5)};
        Arrays.sort(users, (o1, o2) ->
                Integer.compare(o1.username.length(), o2.username.length())
        );
        System.out.println(Arrays.toString(users));
    }

    @Test
    public void test() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hello Lambda");
                    }
                }
        ).start();
    }

    @Test
    public void test1() {
        new Thread(() ->
                System.out.println("Hello Lambda")
        ).start();
    }

    @Test
    public void ageSort5() {
        String[] strings = new String[]{"Ahg", "Dhig", "Ckhia", "bksg", "ahg"};
        Collections.sort(Arrays.asList(strings), String.CASE_INSENSITIVE_ORDER);
        /*Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });*/
        System.out.println(Arrays.toString(strings));
    }
}
