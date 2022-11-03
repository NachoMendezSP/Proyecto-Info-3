package utils;

import model.*;
import java.util.Random;
import java.util.Scanner;

public class Operations {
    public static BinTree<Integer> randomBinaryTree() throws Exception {
        int cant;
        BinTree<Integer> binTree = new BinTree<>();
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("------------------------------");
        System.out.println("Arbol binario aleatorio");
        System.out.println("Ingrese la cantidad de elementos del arbol binario.");
        System.out.print("Cantidad: ");
        cant = sc.nextInt();

        for (int i = 0; i < cant; i++) {
            binTree.add(ran.nextInt(100));
        }

        if (!binTree.isEmpty()) System.out.println("Arbol binario aleatorio creado.");
        else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");
        return binTree;
    }

    public static BinTree<Integer> manualBinaryTree() throws Exception {
        int num;
        BinTree<Integer> binTree = new BinTree<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Arbol binario manual");
        System.out.println("Ingrese el elemento a ingresar. Ingrese -1 para salir.");

        do {
            System.out.print("Elemento: ");
            num = sc.nextInt();
            if (num >= 0) binTree.add(num);
        } while (num != -1);

        if (!binTree.isEmpty()) System.out.println("Arbol binario manual creado.");
        else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");
        return binTree;

    }

    public static AVLTree<Integer> randomAVLTree() throws Exception {
        int cantidad;
        AVLTree<Integer> avlTree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("------------------------------");
        System.out.println("Arbol AVL aleatorio");
        System.out.println("Ingrese la cantidad de elementos del arbol AVL");
        System.out.print("Cantidad: ");
        cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            avlTree.add(ran.nextInt(100));
        }

        if (!avlTree.isEmpty()) System.out.println("Arbol binario AVL aleatorio creado.");
        else throw new Exception("No pudo crearse el arbol binario AVL o se creo vacio.");
        return avlTree;
    }

    public static AVLTree<Integer> manualAVLTree() throws Exception {
        int num;
        AVLTree<Integer> avlTree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Arbol AVL manual");
        System.out.println("Ingrese el elemento a ingresar. Ingrese -1 para salir.");

        do {
            System.out.print("Elemento: ");
            num = sc.nextInt();
            if (num >= 0) avlTree.add(num);
        } while (num != -1);

        if (!avlTree.isEmpty()) System.out.println("Arbol binario AVL manual creado");
        else throw new Exception("No pudo crearse el arbol binario AVL o se creo vacio");
        return avlTree;
    }

    public static void printTreesInOrder(BinTree<Integer> binTree, AVLTree<Integer> avlTree) throws Exception {
        int tmp;
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Seleccione un tipo de arbol.");
        System.out.println("1- Arbol binario de busqueda");
        System.out.println("2- Arbol AVL");
        tmp = sc.nextInt();

        if (tmp == 1) {
            if (binTree == null) {
                throw new Exception("\nEl arbol es nulo");
            }
            binTree.printInOrder();
        } else if (tmp == 2) {
            if (avlTree == null) {
                throw new Exception("\nArbol nulo");
            }
            avlTree.printInOrder();
        } else System.out.println("Opcion invalida");
    }

    public static void printTreeDiagram(BinTree<Integer> binTree, AVLTree<Integer> avlTree) throws Exception {
        int tmp;
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Seleccione un tipo de arbol.");
        System.out.println("1- Arbol binario de busqueda");
        System.out.println("2- Arbol AVL");

        tmp = sc.nextInt();

        if (tmp == 1) {
            if (binTree == null) {
                throw new Exception("\nArbol nulo");
            }

            System.out.println(binTree.printTree(binTree.getRoot()));
        } else if (tmp == 2) {
            if (avlTree == null) {
                throw new Exception("\nArbol nulo");
            }
            System.out.println(avlTree.printTree(avlTree.getRoot()));
        } else System.out.println("Opcion invalida");
    }
}
