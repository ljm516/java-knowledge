package top.ljming.javaindepth.designpatterns.geeklesson.combination;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class File extends FileSystemNode {
    public File(String path) {
        super(path);
    }

    @Override
    int countNumOfFiles() {
        return 1;
    }

    @Override
    long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }
}
