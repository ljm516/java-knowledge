package top.ljming.learning.indepth.designpatterns.templatemethod;

/**
 * CharDisplay，继承AbstractDisplay，具体的类.
 *
 * @author ljming
 */
public class CharDisplay extends AbstractDisplay {

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.print(ch);
    }

    @Override
    void close() {
        System.out.print(">>");
    }
}
