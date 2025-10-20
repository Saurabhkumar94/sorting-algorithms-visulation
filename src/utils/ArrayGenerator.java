package utils;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generate(int size, int maxVal) {
        Random r = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = 10 + r.nextInt(maxVal);
        return a;
    }
}
