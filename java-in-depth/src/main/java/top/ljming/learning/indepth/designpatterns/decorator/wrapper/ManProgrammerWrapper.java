package top.ljming.learning.indepth.designpatterns.decorator.wrapper;

import top.ljming.learning.indepth.designpatterns.decorator.Person;

/**
 * 男程序员的包装类，在show()方法的基础上进行可扩展，表示男程序员只喜欢穿花寸衫.
 *
 * @author lijm
 */
public class ManProgrammerWrapper implements Person { // 包装类也得实现接口

    private Person person; // 需要持有包装类的原始类

    public ManProgrammerWrapper(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
        manDressWrapper();
    }

    public void manDressWrapper() {
        System.out.println("man programmer like to wear plaid shirts");
    }
}
