package demo.finalDemo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhoupanchn on 2020/2/20.
 */
@Getter
@Setter
public final class Person {
    private       Integer age = 16;
    private final String  name;

    public Person(String name) {
        this.name = "init name";
    }

    public Person(Integer integer) {
        this.name = "after";
    }

}

class Test {
    public static void main(String[] args) {
        Person name = new Person(12);
        System.out.println(name.getName());
    }
}