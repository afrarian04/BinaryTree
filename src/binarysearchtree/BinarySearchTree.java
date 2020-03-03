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
    
    public void insert(int key){
        root = insertRec(root, key);
    }
    
    Node insertRec(Node root, int key){
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
    
    public boolean find(int value){
        return findRecursive(root, value);
    }
    
    private boolean findRecursive(Node root, int value){
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
    
    private Node deleteRecursive(Node current, int value){
        if (current == null) {
            return null;
        }
        if (value == current.getKey()) {
            //empty for code to delete
        }
        if (value < current.getKey()) {
            current = deleteRecursive(current.getLeft(), value);
            return current;
        }
        current = deleteRecursive(current.getRight(), value);
        return current;
    }
    
    public void inOrder(){
        inOrderRec(root);
    }
    
    public void inOrderRec(Node root){
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    
    
    
}
