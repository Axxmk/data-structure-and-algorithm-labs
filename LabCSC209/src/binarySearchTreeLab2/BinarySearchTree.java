package binarySearchTreeLab2;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void preorderTraversal(Node p) {
        if(p != null) {
            System.out.print(p.info + " "); // visit that p first
            preorderTraversal(p.left); // then go to left
            preorderTraversal(p.right); // go to right for the last
        }
    }

    public void inorderTraversal(Node p) {
        if(p != null) {
            inorderTraversal(p.left);  // go to left node first
            System.out.print(p.info + " ");  // then visit that p
            inorderTraversal(p.right);  // go to the right node in the last
        }
    }

    public void postorderTraversal(Node p) {
        if(p != null) {
            postorderTraversal(p.left);  // go to left node first
            postorderTraversal(p.right); // then go to right node
            System.out.print(p.info + " ");  // visit that p
        }
    }

    public void breadthFirstTraversal() {  // เป็นการ visit node ไปทีละ level from left to right
        Node p = this.root;
        Queue<Node> q = new LinkedList<>();

        if(p != null) {
            q.add(p); // enqueue the first one (root)

            while(!q.isEmpty()) {
                p = q.remove();  // dequeue
                System.out.print(p.info + " ");  // visit that p

                if(p.left != null) {
                    q.add(p.left);  // enqueue
                }
                if(p.right != null) {
                    q.add(p.right); // enqueue
                }
            }
        }
    }

    public void deleteByMerging(int deleteValue) {
        //merge the right subtree of the deleted node to be
        //under (right child) of the left subtree of he deleted node

        // searching
        Node p = this.root, prev = null;
        while (p != null && p.info != deleteValue) {
            prev = p;
            if(deleteValue < p.info) {
                p = p.left;
            }
            else {
                p = p.right;
            }
        }

        // deleting
        Node parentOfDeletedNode = prev;
        Node deletedNode = p;
        Node parentToPointTo = null;

        if(p != null && p.info == deleteValue) {
            if(deletedNode.right == null) {
                // has single left child
                if(deletedNode.right == null) {
                    parentToPointTo = deletedNode.left;
                }
                // has single right child
                else if (deletedNode.left == null) {
                    parentToPointTo = deletedNode.right;
                }
                // delete node has two children
                else {
                    //search for the rightmost node of the left subtree
                    Node rightmost = deletedNode.left;

                    while (rightmost.right != null) {
                        rightmost = rightmost.right;
                    }
                    rightmost.right = deletedNode.right;
                    parentToPointTo = deletedNode.left;
                }

                if(deletedNode == this.root) {
                    this.root = parentToPointTo;
                }
                else if(deletedNode == parentOfDeletedNode.left) {
                    parentOfDeletedNode.left = parentToPointTo;
                }
                else {
                    parentOfDeletedNode.right = parentToPointTo;
                }
            }

        }
    }

    public void insert(int newInfo) {
        // an empty tree
        if(root == null) {
            root = new Node(newInfo);
            return;
        }

        // not empty tree
        Node p = root;
        while(p != null){
            if(newInfo < p.info ) {
                if (p.left != null) {
                    p=p.left;
                }
                else {
                    p.left = new Node(newInfo);
                    return;
                }
            }
            else {
                if(p.right != null){
                    p=p.right;
                }
                else {
                    p.right = new Node(newInfo);
                    return;
                }
            }
        }
    }
}
