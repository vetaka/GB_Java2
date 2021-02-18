package geekbrains.couse2;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class HomeWork5 {
    static final int size = 10000000;
    static final int half = size/2;
    //лямбда выражение
    static BiConsumer<float[], Integer> fillArr = (arr, offset) -> {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i]* Math.sin(0.2f + (i+offset)/5) * Math.cos(0.2f + (i+offset)/5) * Math.cos(0.4f + (i+offset)/2));
        }
    };

    public static void main(String[] args) {
	    float[] arr =new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        firstMethod(arr);
        float[] arr2 = new float[size];
        for (int i = 0; i < size; i++) {
            arr2[i] = 1;
        }
        secondMethod(arr2);
    }
    public static void firstMethod(float[] arr) {
        long a = System.currentTimeMillis();
        fillArr.accept(arr, 0);
        System.out.println("first: " + (System.currentTimeMillis() - a));

    }

    public static void secondMethod(float[] arr) {
        float[] a1 = new float[half];
        float[] a2 = new float[half];
        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);
        long b = System.currentTimeMillis();
        Thread t1 = new Thread(() -> fillArr.accept(a1,0));
        Thread t2 = new Thread(() -> fillArr.accept(a2,half));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.arraycopy(a1, 0, arr, 0, half);
            System.arraycopy(a2, 0, arr, half, half);
            System.out.println("second " + (System.currentTimeMillis() - b));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
