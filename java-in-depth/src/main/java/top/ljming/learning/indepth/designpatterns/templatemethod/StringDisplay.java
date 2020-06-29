package top.ljming.learning.indepth.designpatterns.templatemethod;

/**
 * StringDisplay.
 *
 * @author ljming
 */
public class StringDisplay extends AbstractDisplay {

    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    void open() {
        System.out.print("《");
    }

    @Override
    void print() {
        System.out.print("|" + str + "|");
    }

    @Override
    void close() {
        System.out.print("》");
    }
}
