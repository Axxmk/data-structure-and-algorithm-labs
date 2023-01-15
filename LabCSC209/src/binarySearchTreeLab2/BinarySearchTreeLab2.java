package binarySearchTreeLab2;

public class BinarySearchTreeLab2 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(100);
        tree.insert(300);
        tree.insert(40);
        tree.insert(45);
        tree.insert(150);
        tree.insert(30);
        tree.insert(80);
        tree.insert(48);

        //                      50
        //            40                 100
        //      30          45      80          300
        //          48                      150

        System.out.println(tree.root.left.left.info);
        System.out.println(tree.root.left.right.info);

        System.out.print(" preorder Traversal : ");
        tree.preorderTraversal(tree.root);
        System.out.print("\n Inorder Traversal : ");
        tree.inorderTraversal(tree.root);

        System.out.print("\n Breadth First Traversal : ");
        tree.breadthFirstTraversal();

        tree.insert(70);
        tree.insert(90);
        tree.insert(60);
        tree.insert(75);
        tree.insert(85);
        tree.insert(95);
        System.out.print("\n Inorder Traversal : ");
        tree.inorderTraversal(tree.root);

        tree.deleteByMerging(5000);
        System.out.print("\n Inorder Traversal : ");
        tree.inorderTraversal(tree.root);
    }
}
