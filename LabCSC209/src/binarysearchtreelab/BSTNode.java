package binarysearchtreelab;

public class BSTNode {
    int info;
    BSTNode left;
    BSTNode right;

    public BSTNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public BSTNode(int info, BSTNode left, BSTNode right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
