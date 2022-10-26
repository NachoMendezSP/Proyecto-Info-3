import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

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
                    System.out.println("Has seleccionado la opcion 1");
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion 4");
                    break;
                case 5:
                    System.out.println("Has seleccionado la opcion 5");
                    break;
                case 6:
                    System.out.println("Has seleccionado la opcion 6");
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
