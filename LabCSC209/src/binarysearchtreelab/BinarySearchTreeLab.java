package binarysearchtreelab;

public class BinarySearchTreeLab {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(25);
        tree.insert(2);
        //          50
        //      25
        //   2
        System.out.println(tree.root.left.info);
        System.out.println(tree.root.left.left.info);
        tree.insert(60);
        tree.insert(90);
        tree.insert(19);
        tree.insert(57);
        //            50
        //      25          60
        //   2           57     90
        //      19
        System.out.println(tree.root.left.left.right.info);
        tree.insert(27);
        //            50
        //      25           60
        //   2      27    57     90
        //      19
        System.out.println(tree.root.left.right.info);
        tree.search(19);
        tree.search(99);
    }
}
