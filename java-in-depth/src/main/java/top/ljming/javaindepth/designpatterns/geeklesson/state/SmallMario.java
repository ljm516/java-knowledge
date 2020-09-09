package top.ljming.javaindepth.designpatterns.geeklesson.state;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();
    private SmallMario() {}

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "super";
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
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
        System.out.println("game over");
    }
}
