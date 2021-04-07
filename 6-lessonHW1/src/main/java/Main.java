import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 3, 1, 7 };
        int [] arr1 = checkArray(arr);
        System.out.println(Arrays.toString(arr1));
        System.out.println(checkArrayOneAndFour(arr)? "There are 1 or 4 in the array": "There aren't 1 or 4 in the array");


    }
// Задание 2
    public static int[] checkArray(int[] arr) throws RuntimeException {
        int k;
        k = -1;
        for(int i=arr.length-1; i >= 0; i--) {

            if (arr[i] == 4) {
                k = i;
                break;
            }
        }

        if (k == -1) throw new RuntimeException("There isn't 4 in array");

        int[] arr1 = new int[arr.length-(k+1)];
        for (int j = k+1; j < arr.length; j++) {
            arr1[j-(k+1)] = arr[j];
        }
        return arr1;
    }
// Задание 3
    public static boolean checkArrayOneAndFour(int[] arr){
        for (int elem:arr) {
            if (elem == 1 || elem == 4 ) {
               return true;
            }
        }
        return false;
    }
}
