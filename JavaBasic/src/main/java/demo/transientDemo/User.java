package demo.transientDemo;

import java.io.Serializable;

/**
 * Created by zhoupanchn on 2020/2/20.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2153138274140160909L;

    private           String  userName;
    private transient Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
