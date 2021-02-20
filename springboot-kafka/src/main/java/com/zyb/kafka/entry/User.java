package com.zyb.kafka.entry;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhoupanchn on 2020/4/28.
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -8736294741210005906L;

    private           Long    id;
    private           String  name;
    private           Integer age;
    private           String  email;
    private transient Integer desc;

    @Override
    public String toString() {
        return "User{" + "id:" + id + ",name:" + name + ",age:" + age + ",email:" + email + ",desc:" + desc + "}";
    }
}
