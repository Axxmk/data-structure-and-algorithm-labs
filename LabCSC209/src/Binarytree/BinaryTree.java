package Binarytree;

public class BinaryTree {
    public static void main(String[] args) {
        MyBinaryTree tree1 = new MyBinaryTree();
        tree1.root = new Node("John");
        tree1.root.left = new Node("Kenny");
        tree1.root.right = new Node("Robert");

        Node x = new Node("Mr.X");
        tree1.root.right.right = x;

        System.out.println(tree1.root.name);  // John
        System.out.println(tree1.root.left.name);  // Kenny
        System.out.println(tree1.root.right.right.name);  // Mr.X

        tree1.root.right.left = new Node("Ann");

        //               John
        //      Kenny            Robert
        //                   Ann       Mr.X
        tree1.addToRight("Tony");
        System.out.println(tree1.root.right.right.right.name);
        tree1.addToLeft("Jessy");
        tree1.addToLeft("Lola");
        tree1.addToLeft("Cindy");

        System.out.println(tree1.root.left.left.left.left.name);
    }
}
