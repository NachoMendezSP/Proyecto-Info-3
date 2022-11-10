import model.*;
import utils.Operations;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws Exception {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;


        while(!salir){
            System.out.println("------------------------------");
            System.out.println("¿Qué tipo de estructura desea utilizar?");
            System.out.println("------------------------------");
            System.out.println("1. Árbol Binario de Búsqueda.");
            System.out.println("2. Árbol Binario AVL.");
            System.out.println("3. Montículo Binario.");
            System.out.println("4. Cerrar programa.");
            System.out.println("------------------------------");
            System.out.println("Ingrese una de las opciones.");
            System.out.print("Opción: ");
            option = sn.nextInt();

            System.out.println("¿Cómo desea ingresar los datos?");
            System.out.println("1. Insertar datos aleatorios.");
            System.out.println("2. Insertar datos manualmente.");

            System.out.println("¿Qué operación desea realizar?");
            System.out.println("3. Buscar un dato.");
            System.out.println("4. Eliminar un dato.");
            System.out.println("5. Mostrar árbol ordenado.");
            System.out.println("6. Mostrar dibujo árbol.");
            System.out.println("7. Volver al menú principal.");

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
                    salir=true;
                    break;
                default:
                    System.out.println("Opción inválida. Solo números entre 1 y 4");
            }
        }
    }
}
