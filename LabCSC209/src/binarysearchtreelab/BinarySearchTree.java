package binarysearchtreelab;

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int newInfo) {
        BSTNode n = new BSTNode(newInfo);
        if (this.root == null) {
            this.root = n;
        }
        else {
            BSTNode p = this.root;
            while ((p.left != null && newInfo < p.info) || (p.right != null && newInfo >= p.info)) {
                if (newInfo < p.info) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }

            if(newInfo < p.info) {
                p.left  = n;
            }
            else {
                p.right = n;
            }
        }
    }

    public BSTNode search(int value) {
        BSTNode p = this.root;
        while(p != null) {
            if(p.info == value) {
                System.out.println("Found it!");
                return p;
            }
            else if (value < p.info) {
                p = p.left;
            }
            else {
                p = p.right;
            }
        }
        System.out.println(":( Not found");
        return null;
    }
}
