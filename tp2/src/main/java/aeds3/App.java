package aeds3;

/**
 * Willian de Souza Soares - 2014.1.08.034 
 */
public class App {
    public static void main(String[] args) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Un-ordered array: ");
        printArray(array);

        bubbleSort(array);
        System.out.println("Ordered array: ");
        printArray(array);
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1)
                System.out.print(", ");
            else
                System.out.println("]");
        }
    }
}
