package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();
    private SuperMario() {}

    public static SuperMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "small";
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        System.out.println("do nothing");

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireFlowerMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
