package algorithm;

public class selection {
    public static void main(String[] args) {
        int[] arr = {6,1,3,9,8,4,2,5,7};

        for (int i = 0; i < arr.length; i++){
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
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
