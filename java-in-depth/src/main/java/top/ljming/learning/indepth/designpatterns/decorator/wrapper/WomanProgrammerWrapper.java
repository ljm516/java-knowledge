package top.ljming.learning.indepth.designpatterns.decorator.wrapper;

import top.ljming.learning.indepth.designpatterns.decorator.Person;

/**
 * 女程序员的包装类，在show()方法的基础上进行可扩展，表示女程序员穿的光鲜亮丽.
 *
 * @author lijm
 */
public class WomanProgrammerWrapper implements Person {

    private Person person;

    public WomanProgrammerWrapper(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
        womanDressWrapper();
    }

    public void womanDressWrapper() {
        System.out.println("woman programmer wear pretty well");
    }
}
