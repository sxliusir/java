package algorithm;

public class bubble {
    public static void main(String[] args) {
        int[] arr={9, 8, 3, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[i] < arr[j]) {
                    swap(arr,i,j);
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
