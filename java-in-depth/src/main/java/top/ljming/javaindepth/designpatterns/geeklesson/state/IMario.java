package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IMario {

    String getName();

    void obtainMushRoom(MarioStateMachine stateMachine);
    void obtainCape(MarioStateMachine stateMachine);
    void obtainFireFlower(MarioStateMachine stateMachine);
    void meetMonster(MarioStateMachine stateMachine);
}
