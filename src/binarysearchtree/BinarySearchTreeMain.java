/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BinarySearchTreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        
        tree.inOrder();
        
        System.out.println("");
        System.out.println("Delete 70");
        tree.deleteImproved(70);
        tree.inOrder();
    }

}
