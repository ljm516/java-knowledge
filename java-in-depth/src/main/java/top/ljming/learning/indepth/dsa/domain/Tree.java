package top.ljming.learning.indepth.dsa.domain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Tree {

    public Tree left;
    public Tree right;
    public int value;

    public Tree(Tree left, Tree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
