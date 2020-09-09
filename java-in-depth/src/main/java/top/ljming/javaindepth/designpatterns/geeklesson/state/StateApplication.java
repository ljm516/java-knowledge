package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 状态模式.
 *
 * 状态模式一般用来实现状态机。状态机的实现方式有多种，除了状态模式，比较常用的还有分支逻辑和查表法。
 *
 * @author ljming
 */
public class StateApplication {

    public static void main(String[] args) {
        MarioStateMachine stateMachine = new MarioStateMachine();

        stateMachine.obtainMushRoom();


    }

}
