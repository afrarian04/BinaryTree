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
