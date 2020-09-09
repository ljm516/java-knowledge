package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class FireFlowerMario implements IMario {

    private static final FireFlowerMario instance = new FireFlowerMario();
    private FireFlowerMario() {}

    public static FireFlowerMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "fireFlower";
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        System.out.println("do nothing");

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        System.out.println("do nothing");
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        System.out.println("do nothing");
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
