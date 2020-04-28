import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoupanchn on 2019/4/30.
 */
public class TestA {
    private static final Integer MAX_NUM = 2;

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        User u5 = new User();
        u1.setId(1);
        u2.setId(2);
        u3.setId(3);
        u4.setId(4);
        u5.setId(5);
        List<User> userList = new ArrayList<>();
        userList.add(u4);
        userList.add(u5);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        //List<User> collect = userList.stream().sorted((x, y) -> x.getId().compareTo(y.getId().intValue())).collect(Collectors.toList());
        /*userList.get(0).setId(userList.get(0).getId() + 9);
        for (User user : userList) {
            System.out.println(user.getId());
        }*/
        if (userList != null && userList.size() > 0) {
            Boolean    flag           = true;
            int        start          = 0;
            int        end            = MAX_NUM;
            List<User> batchSaveOrder = userList.subList(start, end);
            do {
                System.out.println("==================");
                batchSaveOrder.clear();
                start = end + 1;
                end += MAX_NUM;
                if (end >= userList.size()) {
                    end = userList.size();
                    flag = false;
                }
            } while (flag);
        }
    }
}
