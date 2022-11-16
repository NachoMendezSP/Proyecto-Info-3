package utils;

import model.*;
import java.util.Random;
import java.util.Scanner;

public class Operations {

    private static BinTree<Integer> binTree;
    private static AVLTree<Integer> avlTree;
    private static BinHeap binHeap;
    private static final Scanner sc = new Scanner(System.in);

    public static void manualGeneration (int option) throws Exception {
        int number;
        switch (option){
            case 1:
                BinTree<Integer> auxBin = new BinTree<>();

                System.out.println("------------------------------");
                System.out.println("Arbol binario manual.");
                System.out.println("Ingrese el elemento a insertar. Ingrese -1 para salir.");

                do {
                    System.out.print("Elemento: ");
                    number = sc.nextInt();
                    if (number >= 0) auxBin.setRoot(auxBin.insert(auxBin.getRoot(), number));
                } while (number != -1);

                if (!auxBin.isEmpty()) System.out.println("Arbol binario manual creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                binTree = auxBin;
                break;
            case 2:
                AVLTree<Integer> auxAVL = new AVLTree<>();

                System.out.println("------------------------------");
                System.out.println("Arbol binario manual.");
                System.out.println("Ingrese el elemento a insertar. Ingrese -1 para salir.");

                do {
                    System.out.print("Elemento: ");
                    number = sc.nextInt();
                    if (number >= 0) auxAVL.setRoot(auxAVL.insert(auxAVL.getRoot(), number));
                } while (number != -1);

                if (!auxAVL.isEmpty()) System.out.println("Arbol AVL manual creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                avlTree = auxAVL;
                break;
            case 3:
                BinHeap auxHeap = new BinHeap();
                System.out.println("------------------------------");
                System.out.println("Montículo binario manual.");
                System.out.println("Ingrese el elemento a insertar. Ingrese -1 para salir.");

                do {
                    System.out.print("Elemento: ");
                    number = sc.nextInt();
                    if (number >= 0) auxHeap.insert(number);
                } while (number != -1);

                if (!auxHeap.isEmpty()) System.out.println("Montículo binario manual creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                binHeap = auxHeap;
                break;
        }
    }

    public static void randomGeneration (int option) throws Exception{
        int number;
        Random rng = new Random();
        switch (option){
            case 1:
                BinTree<Integer> auxBin = new BinTree<>();

                System.out.println("------------------------------");
                System.out.println("Arbol binario aleatorio.");
                System.out.println("Ingrese la cantidad de elementos del arbol binario.");
                System.out.print("Cantidad: ");
                number = sc.nextInt();

                for (int i = 0; i < number; i++) {
                    auxBin.setRoot(auxBin.insert(auxBin.getRoot(), rng.nextInt(100)));
                }

                if (!auxBin.isEmpty()) System.out.println("Arbol binario aleatorio creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                binTree = auxBin;
                break;
            case 2:
                AVLTree<Integer> auxAVL = new AVLTree<>();

                System.out.println("------------------------------");
                System.out.println("Arbol AVL aleatorio.");
                System.out.println("Ingrese la cantidad de elementos del arbol AVL.");
                System.out.print("Cantidad: ");
                number = sc.nextInt();

                for (int i = 0; i < number; i++) {
                    auxAVL.setRoot(auxAVL.insert(auxAVL.getRoot(), rng.nextInt(100)));
                }

                if (!auxAVL.isEmpty()) System.out.println("Arbol AVL aleatorio creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                avlTree = auxAVL;
                break;
            case 3:
                BinHeap auxHeap = new BinHeap();

                System.out.println("------------------------------");
                System.out.println("Montículo binario aleatorio.");
                System.out.println("Ingrese la cantidad de elementos del montículo binario.");
                System.out.print("Cantidad: ");
                number = sc.nextInt();

                for (int i = 0; i < number; i++) {
                    auxHeap.insert(rng.nextInt(100));
                }

                if (!auxHeap.isEmpty()) System.out.println("Montículo binario manual creado.");
                else throw new Exception("No pudo crearse el arbol binario o se creo vacio.");

                binHeap = auxHeap;
                break;
        }
    }

    public static void search (int option){
        int number;
        System.out.println("------------------------------");
        System.out.print("Ingrese el elemento que desea buscar: ");
        number = sc.nextInt();

        switch (option){
            case 1:
                if(binTree.find(number, binTree.getRoot()))
                    System.out.println("El elemento se encuentra en el árbol.");
                else
                    System.out.println("El elemento no se encuentra en el árbol.");
                break;
            case 2:
                if(avlTree.find(number, avlTree.getRoot()))
                    System.out.println("El elemento se encuentra en el árbol.");
                else
                    System.out.println("El elemento no se encuentra en el árbol.");
                break;
            case 3:
                if(binHeap.find(number, binHeap))
                    System.out.println("El elemento se encuentra en el árbol.");
                else
                    System.out.println("El elemento no se encuentra en el árbol.");
                break;
        }
    }
    public static void delete (int option) throws Exception {
        int number;

        switch (option) {
            case 1:
                System.out.println("------------------------------");
                System.out.print("Ingrese el elemento que desea eliminar: ");
                number = sc.nextInt();
                if (!binTree.find(number, binTree.getRoot()))
                    System.out.println("El elemento no se encuentra en el árbol.");
                else {
                    System.out.println("Antes de eliminar: ");
                    System.out.println(binTree.printTree(binTree.getRoot()));
                    binTree.delete(binTree.getRoot(), number);
                    System.out.println("Luego de eliminar: ");
                    System.out.println(binTree.printTree(binTree.getRoot()));
                }
                break;
            case 2:
                System.out.println("------------------------------");
                System.out.print("Ingrese el elemento que desea eliminar: ");
                number = sc.nextInt();
                if (!avlTree.find(number, avlTree.getRoot()))
                    System.out.println("El elemento no se encuentra en el árbol.");
                else {
                    System.out.println("Antes de eliminar: ");
                    System.out.println(avlTree.printTree(avlTree.getRoot()));
                    avlTree.delete(avlTree.getRoot(), number);
                    System.out.println("Luego de eliminar: ");
                    System.out.println(avlTree.printTree(avlTree.getRoot()));
                }
                break;
            case 3:
                System.out.println("Se eliminará el mayor elemento.");
                System.out.println("Antes de eliminar: ");
                binHeap.printHeap();
                binHeap.extractMax();
                System.out.println("Luego de eliminar: ");
                binHeap.printHeap();
                break;
        }
    }
    public static void insert (int option) throws Exception {
        int number;
        System.out.println("------------------------------");
        System.out.print("Ingrese el elemento que desea ingresar: ");
        number = sc.nextInt();

        switch (option) {
            case 1:
                binTree.setRoot(binTree.insert(binTree.getRoot(), number));
                break;
            case 2:
                avlTree.setRoot(avlTree.insert(avlTree.getRoot(), number));
                break;
            case 3:
                binHeap.insert(number);
                break;
        }

    }
    public static void print (int option){
        if(option == 1)
            binTree.printInOrder();
        else if (option == 2)
            avlTree.printInOrder();
        else if (option == 3)
            binHeap.printHeap();
    }
    public static void printTree (int option){
        switch (option){
            case 1:
                System.out.println(binTree.printTree(binTree.getRoot()));
                break;
            case 2:
                System.out.println(avlTree.printTree(avlTree.getRoot()));
                break;
            case 3:
                System.out.println("Aún no implementado.");
                binHeap.printHeap();
                break;
        }
    }
}
