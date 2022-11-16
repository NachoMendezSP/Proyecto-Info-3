package model;

public class BinHeap {
    private static final int MAX_SIZE = 100;
    private int [] heap;
    private int size;

    public BinHeap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    // Devuelve el indice del nodo padre
    public static int parent(int i) {
        return (i - 1) / 2;
    }

    // Devuelve el indice del nodo hijo izquierdo
    public static int leftChild(int i) {
        return 2*i + 1;
    }

    // Devuelve el indice del nodo hijo derecho
    public static int rightChild(int i) {
        return 2*i + 2;
    }

    // Inserta un item en la posicion apropiada
    public void insert(int data) {
        if (size >= MAX_SIZE) {
            System.out.println("El monticulo esta lleno. No se puede insertar");
            return;
        }

        // Primero inserta en la ultima posicion del arreglo
        // y lo mueve hacia arriba
        heap[size] = data;
        size = size + 1;


        // Mueve hacia arriba del monticulo satisfaciendo la propiedad de orden
        int i = size - 1;
        while (i != 0 && heap[BinHeap.parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = BinHeap.parent(i);
        }
    }

    // Mueve el item en la posicion i del arreglo
    // en la posicion que le corresponde (condicion de orden)
    public void maxHeapify(int i){
        // Busca el nodo hijo de la izquierda
        int left = BinHeap.leftChild(i);

        // Busca el nodo hijo de la derecha
        int right = BinHeap.rightChild(i);

        // Busca el mas grande entre 3 nodos
        int largest = i;

        // Verifica si el nodo izquierdo es mas grande que el nodo actual
        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        // Verifica si el nodo derecho es mas grande que el nodo actual
        // y el nodo izquierdo
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        // Intercambia el nodo mas grande con el nodo actual
        // y repite el proceso hasta que el nodo actual sea mayor
        // que el nodo de la derecha y el nodo de la izquierda
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }

    }

    // Devuelve el maximo item del monticulo
    public int getMax() {
        return heap[0];
    }

    // Elimina y devuelve el maximo item del monticulo
    public int extractMax() {
        int maxItem = heap[0];

        // Reemplaza el primer item por el ultimo item
        heap[0] = heap[size - 1];
        size = size - 1;

        // Mantiene la propiedad de monticulo, monticulizando el
        // primer item
        maxHeapify(0);
        return maxItem;
    }

    // Imprime el monticulo
    public void printHeap() {
        System.out.println("Elementos del montículo (mayor elemento primero):");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public boolean find(int x, BinHeap mont){
        for (int i = 0; i < mont.size; i++) {
           if(x == mont.heap[i])
               return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }
}
