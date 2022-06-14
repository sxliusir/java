package algorithm;

public class Insertion {
    public static void main(String[] args) {
        int[] arr={9, 8, 3, 5, 2};
        for (int i = 1; i<arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
            }
        }
        print(arr);
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void print(int[] arr) {
        for (int i = 0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
