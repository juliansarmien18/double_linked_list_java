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
public class DoubleLinkedList {
    
    //inicializamos la cabeza y la cola en nulo
    Node head, tail = null;
    
    public void add_node(String item) {  
        //Creamos un nuevo nodo 
        Node nodo = new Node(item);  
   
        //si la lista esta vacía se crea el nodo que ser'a tanto la cabeza como la cola  
        if(head == null) {  
            head = tail = nodo;  
            //al ser el primer nodo sus apuntadores serán nulos
            head.previous = null;    
            tail.next = null;  
        } 
        //en caso contrario se agrega un nuevo nodo al final de la lista
        else {  
            tail.next = nodo;  
            //se setea la cola actual como el nodo anterior y el nuevo nodo como la cola actual y finalmente
            //se setea el siguiente nodo de la cola como nulo
            nodo.previous = tail;   
            tail = nodo;    
            tail.next = null;  
        }  
    }
   
    public void print_nodes() {  
        //se seta la cabeza como nodo actual 
        Node current = head; 
        //en caso de no haber cabeza quiere decir que la lista esta vacía y se rompe el metodo
        if(head == null) {  
            System.out.println("la lista esta vacia");  
            return;  
        }  
        System.out.println("Nodos de la lista: ");  
        //mientras el actual sea nulo(es decir, no sea el siguiente de la cola), imprima el nodo actual
        //y pase al siguiente nodo
        while(current != null) {    
            System.out.print(current.item + " ");  
            current = current.next;  
        }
        System.out.println();
    }
    
    public int elements_of_list(){
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return 0;
        }
        //se inicializa contador en 0 y se recorre la lista, por cada elemento el contador aumenta en 1
        else{
            int counter = 0;
            while(current != null){
                counter ++;
                current = current.next;
            }
            //retorna el numero de elementos de la lista
            return counter;
        }
    } 
    
    
    public String element_by_position(int position){
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return "La lista esta vacia";
        }
        //se seta un contador en 0 y se recorre la lista
        else{
            int counter = 0;
            while(current != null){
                //si el contador es igual a la posición solicitada se imprime el elemento
                if(counter == position){
                    return current.item;
                }
                else{
                    counter ++;
                    current = current.next;
                }
            }
            //si acabo el while sin encontrar la posicion solicitada quiere decir que se solicito un numero mas grande que el tamaño de la lista
            return "La lista no tiene esa cantidad de items";
        }
    }
    
    
    public String is_in_the_list(String element){
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return "La lista esta vacia";
        }
        //se recorre la lista y se compara cada elemento con el solicitado, si lo encuentra retorna mensaje exitoso
        else{
            while(current != null){
                if(element.equals(current.item)){
                    return ("El elemento "+element+" se ecuentra en la lista");
                }
                else{
                   current = current.next; 
                } 
            }
            //si acaba el while(llega a la cola) y no encontro el elemento quiere decir que no esta en la lista
            return ("El elemento "+element+" no se ecuentra en la lista");
        }
    }
    
    public String replace_element(String element, String new_element){
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return "La lista esta vacia"; 
        }
        else{
            //se recorre la lista, si el elemento que se quiere reemplazar esta en la lista se realiza el cambio
            while(current != null){
                if(element.equals(current.item)){
                    current.item = new_element;
                    return ("El elemento "+element+" fue reemplazado por "+new_element);
                }
                else{
                    current = current.next;
                }
            }
            //si el while acaba(llega a la cola) y no encontro el elemento a reemplazar se retorna mensaje de no encontrado
            return "el elemento que quiere reemplazar no se encuentra en la lista";
        }
    }
    
    public String remove_by_position(int position) {
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return "La lista esta vacia"; 
        }
        //se crea un contador y se recorre la lista aumentando el contador hasta que sea igual a la posicion
        else{
            int counter = 0;
            while(current != null){
                if(counter == position){
                    //si el previous del nodo actual es nulo(el actual es la cabeza), el siguiente a este se vuelve la cabeza
                    //el anterior de la nueva cabeza se vuelve nulo
                    if (current.previous == null) {
                        head = current.next;
                        head.previous = null;
                        return ("elemento "+current.item+" eliminado");
                        
                    //si el next del nodo es null(estamos en la cola), el anterior se volvera la cola y su next será null
                    } else if (current.next == null) {
                        tail = current.previous;
                        tail.next = null;
                        return ("elemento "+current.item+" eliminado");
                        
                    //si es una posición intermedia, el siguiente nodo del nodo anterior se volvera el siguiente del nodo actual actual
                    //el nodo anterior del siguiente nodo se volvera el anterior del nodo actual
                    } else {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                        return ("elemento "+current.item+" eliminado");
                    }
                }
                counter++;
                current = current.next;
            //si no se encontró la posición es que se escogio una posicion mayor a la del tamaño de la lista
            }
            return "La lista no tiene esa cantidad de items";
        }
    }
    
    
    public String remove_by_name(String element) {
        //se setea el elemento actual como la cabeza y se valida que no sea nulo(lista vacia)
        Node current = head;
        if(head == null){
            return "La lista esta vacia"; 
        }
        //se recorre la lista hasta que el elemento sea el solicitado
        else{
            while(current != null){
                if(current.item.equals(element)){
                    //si el previous del nodo actual es nulo(el actual es la cabeza), el siguiente a este se vuelve la cabeza
                    //el anterior de la nueva cabeza se vuelve nulo
                    if (current.previous == null) {
                        head = current.next;
                        head.previous = null;
                        return ("elemento "+current.item+" eliminado");
                        
                    //si el next del nodo es null(estamos en la cola), el anterior se volvera la cola y su next será null
                    } else if (current.next == null) {
                        tail = current.previous;
                        tail.next = null;
                        return ("elemento "+current.item+" eliminado");
                        
                    //si es una posición intermedia, el siguiente nodo del nodo anterior se volvera el siguiente del nodo actual actual
                    //el nodo anterior del siguiente nodo se volvera el anterior del nodo actual
                    } else {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                        return ("elemento "+current.item+" eliminado");
                    }
                }
                current = current.next;
            //si no se encontró la posición es que se escogio una posicion mayor a la del tamaño de la lista
            }
            return "La lista no tiene el elemento solicitado";
        }
    }
    
    public void concatenate_list(DoubleLinkedList List2){
        Node last = tail;
        Node first = head;
        if(head == null){
            head = List2.head;
        }
        else if (List2.head == null){
            return;
        }
        else{
            last.next = List2.head;
            List2.head.previous = last;
        }
    } 
    
}


