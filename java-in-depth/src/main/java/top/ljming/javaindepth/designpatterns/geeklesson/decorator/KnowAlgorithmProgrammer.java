package top.ljming.javaindepth.designpatterns.geeklesson.decorator;

/**
 * 对普通的程序员能力进行增强， 学习了算法的程序员，拥有了算法能力。
 *
 * @author ljming
 */
public class KnowAlgorithmProgrammer extends Programmer {

    private Programmer programmer;

    public KnowAlgorithmProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    void ability() {
        System.out.println("learning algorithm");
        programmer.ability();
        System.out.println("know algorithm java programmer");
    }
}
