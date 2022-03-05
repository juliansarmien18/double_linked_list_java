/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

import java.util.Scanner;

/**
 *
 * @author Julian Sarmiento
 */
public class main {
    
    public static void menu_listas(){
        System.out.println("BIENVENIDO, ESCOJA UNA OPCION");
        System.out.println("1.Lista de frutas");
        System.out.println("2.lista de verduras");
        System.out.println("escoja la lista a editar:");
    }
    
    public static void menu_opciones(){
        System.out.println("1.agregar un elemento a la lista");
        System.out.println("2.imprimir el numero total de elementos de la lista");
        System.out.println("3.buscar un elemento por su posición");
        System.out.println("4.buscar un elemento por su nombre");
        System.out.println("5.imprimir todos los elementos de la lista");
        System.out.println("6.borrar un elemento de la lista por su nombre");
        System.out.println("7.borrar un elemento por su posición");
        System.out.println("8.reemplazar un elemento de la lista");
        System.out.println("9.unir las frutas y verduras en una lista");
        System.out.println("0. salir");
        System.out.println("escoja una opcion:");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        
        DoubleLinkedList frutas = new DoubleLinkedList();
        frutas.add_node("manzana");  
        frutas.add_node("pera");  
        frutas.add_node("mandarina");  
        frutas.add_node("mango");  
        frutas.add_node("kiwi");  
        frutas.add_node("papaya");
        
        DoubleLinkedList verduras = new DoubleLinkedList();
        verduras.add_node("pepino");  
        verduras.add_node("espinacas");  
        verduras.add_node("brocoli");  
        verduras.add_node("remolacha");  
        verduras.add_node("zanahoria");  
        verduras.add_node("coliflor");
        
        DoubleLinkedList lista = new DoubleLinkedList();
        DoubleLinkedList lista2 = new DoubleLinkedList();
        
        menu_listas();
        int op_lists = input.nextInt();

        
        switch (op_lists){
            case 1:{
                lista = frutas;
                lista2 = verduras;
                break;
            }
            case 2:{
                lista = verduras;
                lista2 = frutas;
                break;
            }
            default:{
                System.out.println("opcion incorrecta");
                System.exit(0);
            }  
        }

        int op_actions = 1;
        while(op_actions != 0){
            menu_opciones();
            op_actions = input.nextInt();
            input.nextLine();
            switch (op_actions){
                case 1:{
                    System.out.print("ingrese el nombre del elemento a agregar:");
                    String element = input.nextLine();
                    lista.add_node(element);
                    break;
                }
                case 2:{
                    System.out.println("el numero total de elementos en la lista es: "+lista.elements_of_list());
                    Thread.sleep(3000);
                    break;
                }
                case 3:{
                    System.out.println("ingrese la posición a buscar:");
                    int position = input.nextInt();
                    System.out.println(lista.element_by_position(position));
                    Thread.sleep(3000);
                    break;
                }
                case 4:{
                    System.out.println("ingrese el elemento a buscar:");
                    String element = input.nextLine();
                    System.out.println(lista.is_in_the_list(element));
                    Thread.sleep(3000);
                    break;
                }
                case 5:{
                    lista.print_nodes();
                    Thread.sleep(6000);
                    break;
                }
                case 6:{
                    System.out.println("ingrese el elemento a eliminar de la lista:");
                    String element = input.nextLine();
                    System.out.println(lista.remove_by_name(element));
                    Thread.sleep(3000);
                    break;
                }
                case 7:{
                    System.out.println("ingrese la posición del elemento a borrar:");
                    int position = input.nextInt();
                    System.out.println(lista.remove_by_position(position));
                    Thread.sleep(3000);
                    break;
                }
                case 8:{
                    System.out.println("ingrese el elemento que quiere reemplazar");
                    String element = input.nextLine();
                    System.out.println("ingrese el nuevo elemento");
                    String new_element = input.nextLine();
                    System.out.println(lista.replace_element(element, new_element));
                    Thread.sleep(3000);
                    break;
                }
                case 9:{
                    lista.concatenate_list(lista2);
                    System.out.println("las frutas y verduras se han unido en una sola lista. ");
                    lista.print_nodes();
                    Thread.sleep(6000);
                    break;
                }
                default:{
                    System.out.println("Adios");
                }
                        
            }
        }
        
        
        
    }
    
}
