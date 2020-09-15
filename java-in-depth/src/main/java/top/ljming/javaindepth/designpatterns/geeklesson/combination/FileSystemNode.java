package top.ljming.javaindepth.designpatterns.geeklesson.combination;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public  abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    abstract int countNumOfFiles();

    abstract long countSizeOfFiles();
}
