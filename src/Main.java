import model.*;
import utils.Operations;
import java.util.Scanner;

public class Main {
    private static BinTree<Integer> binTree;
    private static AVLTree<Integer> avlTree;

    public static void main(String[] args) throws Exception {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;


        while(!salir){
            System.out.println("------------------------------");
            System.out.println("MENU");
            System.out.println("------------------------------");
            System.out.println("1. Crear árbol aleatorio.");
            System.out.println("2. Crear árbol manual.");
            System.out.println("3. Crear árbol AVL aleatorio.");
            System.out.println("4. Crear árbol AVL manual.");
            System.out.println("5. Mostrar árbol ordenado.");
            System.out.println("6. Mostrar dibujo árbol.");
            System.out.println("7. Cerrar programa.");
            System.out.println("------------------------------");
            System.out.println("Ingrese una de las opciones.");
            System.out.print("Opción: ");
            option = sn.nextInt();

            switch(option){
                case 1:
                    binTree = Operations.randomBinaryTree();
                    break;
                case 2:
                    binTree = Operations.manualBinaryTree();
                    break;
                case 3:
                    avlTree = Operations.randomAVLTree();
                    break;
                case 4:
                    avlTree = Operations.manualAVLTree();
                    break;
                case 5:
                    Operations.printTreesInOrder(binTree, avlTree);
                    break;
                case 6:
                    Operations.printTreeDiagram(binTree, avlTree);
                    break;
                case 7:
                    salir=true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 7");
            }
        }
    }
}
