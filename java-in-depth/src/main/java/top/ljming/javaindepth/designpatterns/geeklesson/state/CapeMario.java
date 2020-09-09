package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CapeMario implements IMario {

    private static final CapeMario instance = new CapeMario();
    private CapeMario() {}

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "cape";
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
        stateMachine.setCurrentState(FireFlowerMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
