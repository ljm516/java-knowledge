package top.ljming.javaindepth.designpatterns.geeklesson.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class Directory extends FileSystemNode {

    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            numOfFiles += subNode.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    long countSizeOfFiles() {
        long sizeOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            sizeOfFiles += subNode.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public void addSubNode(FileSystemNode subNode) {
        subNodes.add(subNode);
    }
}
