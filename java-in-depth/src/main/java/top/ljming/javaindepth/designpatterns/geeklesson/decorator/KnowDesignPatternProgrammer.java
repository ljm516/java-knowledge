package top.ljming.javaindepth.designpatterns.geeklesson.decorator;

/**
 * 对普通的程序员能力进行增强， 学习了设计模式的程序员，拥有了设计模式能力。
 *
 * @author ljming
 */
public class KnowDesignPatternProgrammer extends Programmer {

    private Programmer programmer;

    public KnowDesignPatternProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    void ability() {
        System.out.println("learning design pattern");
        programmer.ability();
        System.out.println("know design pattern java programmer");
    }
}
