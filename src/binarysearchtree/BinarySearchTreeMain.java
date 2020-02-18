/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Random;

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

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            tree.insert(rnd.nextInt(100));
        }

        tree.inOrder();
    }

}
