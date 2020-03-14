package top.ljming.learning.indepth.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ExtendApp {

    static class Parent {

        void greet() {
            System.out.println("p");
        }
    }

    static class Son extends Parent {
        void greet() {
            System.out.println("S");
        }
    }

    public static void main(String[] args) {
        List<Parent> list = new ArrayList<>();
        Parent p = new Son();
        list.add(p);
        list.get(0).greet();
    }
}
