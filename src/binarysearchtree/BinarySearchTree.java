/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author admin
 */
public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public boolean find(int value) {
        return findRecursive(root, value);
    }

    private boolean findRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.getKey()) {
            return true;
        }
        return value < root.getKey()
                ? findRecursive(root.getLeft(), value)
                : findRecursive(root.getRight(), value);
    }

    public void delete(int key) {
        deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return current;
        }
        if (value < current.getKey()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));;
        } else if (value > current.getKey()) {
            current.setRight(deleteRecursive(current.getRight(), value));
        } else {
            if (current.left == null) {
                return current.getRight();
            } else if (current.right == null) {
                return current.getLeft();
            }
            current.setKey(minValue(current.getRight()));

            current.setRight(deleteRecursive(current.getRight(), current.getKey()));
        }
        return current;
    }

    public void deleteImproved(int key) {
        deleteRecursiveImproved(root, key);
    }

    private Node deleteRecursiveImproved(Node current, int value) {
        if (current == null) {
            return current;
        }
        if (value < current.getKey()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));;
            return current;
        } else if (value > current.getKey()) {
            current.setRight(deleteRecursive(current.getRight(), value));
            return current;
        }
        if (current.getLeft() == null) {
            Node temp = current.getRight();
            return temp;
        } else if (current.getRight() == null) {
            Node temp = current.getLeft();
            return temp;
        } else {
            Node succParent = current.getRight();
            Node succ = current.getRight();
            while (succ.getLeft() != null) {
                succParent = succ;
                succ = succ.getLeft();
            }

            succParent.setLeft(succ.getRight());
            current.setKey(succ.getKey());
            return current;
        }

    }

    private int minValue(Node root) {
        int minV = root.getKey();
        while (root.getLeft() != null) {
            minV = root.getLeft().getKey();
            root = root.getLeft();
        }
        return minV;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.print(root.getKey() + "\t");
            inOrderRec(root.getRight());
        }
    }

}
