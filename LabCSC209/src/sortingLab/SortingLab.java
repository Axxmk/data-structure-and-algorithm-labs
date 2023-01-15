package sortingLab;

public class SortingLab {
    public static void main(String[] args) {
        int[] a = {34, 9, 7, 41212, 495, 98, 2, 28, 55, 32, 17, 212, 236, 56,
                69, 112, 10, 191, 1668};
        int[] b = a.clone();
        int[] c = a.clone();

        System.out.println("Selection Sort :");
        print(a);
        selectionSort(a);
        print(a);

        System.out.println("Insertion Sort :");
        print(b);
        insertionSort(b);
        print(b);

        System.out.println("Bubble Sort :");
        print(c);
        bubbleSort(c);
        print(c);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  // ith smallest value
            int smallestIndex = i; // assume the item i is the smallest
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            //swap
            if (i != smallestIndex) {
                int temp = arr[i];
                arr[i] = arr[smallestIndex];
                arr[smallestIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int j;
            for(j = i-1; j >= 0 && arr[j] > insertValue; j--) {
                arr[j+1] = arr[j];
            }
            arr[++j] = insertValue;
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = arr.length-1; j > i; j--) {
                if(arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
