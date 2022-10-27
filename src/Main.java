import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        Node node = new Node(50); //Raiz inicializada en 50

        while(!salir){

            System.out.println("1. Crear árbol aleatorio.");
            System.out.println("2. Crear árbol manual.");
            System.out.println("3. Crear árbol AVL aleatorio.");
            System.out.println("4. Crear árbol AVL manual.");
            System.out.println("5. Mostrar árbol ordenado..");
            System.out.println("6. Mostrar dibujo árbol");
            System.out.println("7. Cerrar programa");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Crear árbol aleatorio.");
                    System.out.println("Ingresar la cantidad de elementos del árbol: ");
                    Scanner in = new Scanner(System.in);
                    int q = in.nextInt();
                    Random r = new Random();
                    int low = 1;
                    int high = 100;

                    int num;
                    for(num = 0; num < q; ++num) {
                        int result = r.nextInt(high - low) + low;
                        System.out.println("Elemento a insertar: " + result);
                        node.add(result);
                    }

                    break;
                case 2:
                    System.out.println("Crear árbol manual.");
                    System.out.println("Ingresar la cantidad de elementos del árbol: ");
                    Scanner inp = new Scanner(System.in);
                    int t = inp.nextInt();
                    int i;
                    for(i = 0; i < t; ++i) {
                        System.out.println("Ingresar un elemento: ");
                        Scanner a = new Scanner(System.in);
                        int number = a.nextInt();
                        node.add(number);
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion 4");
                    break;
                case 5:
                    System.out.println("-------------------------");
                    System.out.println("Datos ordenados: ");
                    node.printInOrderBinaryTree();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("-------------------------");
                    System.out.println("Imprimir Arbol: ");
                    System.out.println(node.printTree(node));
                    System.out.println("-------------------------");
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
