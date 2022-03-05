/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author Julian Sarmiento
 */
public class Node {
    //los elementos serán tipo String
    String item;  
        //apuntador al nodo anterior
        Node previous;  
        //apuntador al nodo siguiente
        Node next;  
   
        //constructor de la clase
        public Node( String item) {  
            this.item = item;  
        }
}
