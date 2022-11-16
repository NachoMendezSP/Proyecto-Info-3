import utils.Operations;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws Exception {

        Scanner sn = new Scanner(System.in);
        boolean salir;
        int option;
        int mode;
        int option2;

        while(true){
            salir = false;

            do {
                System.out.println("---------------------------------------");
                System.out.println("¿Qué tipo de estructura desea utilizar?");
                System.out.println("---------------------------------------");
                System.out.println("1. Árbol Binario de Búsqueda.");
                System.out.println("2. Árbol Binario AVL.");
                System.out.println("3. Montículo Binario.");
                System.out.println("4. Cerrar programa.");
                System.out.println("---------------------------------------");
                System.out.println("Ingrese una de las opciones.");
                System.out.print("Opción: ");
                option = sn.nextInt();

                if (option == 4)
                    System.exit(0);

                if (option < 1 || option > 4)
                    System.out.println("Opción inválida. Solo números entre 1 y 4.");

            } while (option < 1 || option > 4);

            do {
                System.out.println("---------------------------------------");
                System.out.println("¿Cómo desea ingresar los datos?");
                System.out.println("1. Insertar datos manualmente.");
                System.out.println("2. Insertar datos aleatorios.");
                System.out.println("---------------------------------------");
                System.out.println("Ingrese una de las opciones.");
                System.out.print("Opción: ");
                mode = sn.nextInt();

                if (mode < 1 || mode > 2)
                    System.out.println("Opción inválida. Solo números entre 1 y 2.");

                if (mode == 1)
                    Operations.manualGeneration(option);
                if (mode == 2)
                    Operations.randomGeneration(option);

            } while (mode < 1 || mode > 2);

            while(!salir) {
                System.out.println("---------------------------------------");
                System.out.println("¿Qué operación desea realizar?");
                System.out.println("---------------------------------------");
                System.out.println("1. Buscar un dato.");
                System.out.println("2. Eliminar un dato.");
                System.out.println("3. Ingresar un dato.");
                System.out.println("4. Mostrar árbol ordenado.");
                System.out.println("5. Mostrar diagrama del árbol.");
                System.out.println("6. Volver al menú principal.");
                System.out.println("---------------------------------------");
                System.out.print("Opción: ");
                option2 = sn.nextInt();

                switch (option2) {
                    case 1:
                        Operations.search(option);
                        break;
                    case 2:
                        Operations.delete(option);
                        break;
                    case 3:
                        Operations.insert(option);
                        break;
                    case 4:
                        Operations.print(option);
                        break;
                    case 5:
                        Operations.printTree(option);
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Solo números entre 1 y 6.");
                }
            }
        }
    }
}
