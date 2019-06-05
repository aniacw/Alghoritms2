package Alg;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Functions {

    // Napisz funckję, która dostaje argumenty: int min, int max, int dzielnik, int niedzielnik
    // i wypisuje wszystkie liczby od min do max, które są podzielne przez 'dzielnik' ale nie są podzielne przez 'niedzielnik'

    public static void printDivisible(int min, int max, int divisor, int nonDivisor) {
        for (int i = min; i <= max; i++) {
            if (i % divisor == 0 && i % nonDivisor != 0)
                System.out.println(i + ", ");
        }
    }


    //Napisz funckję, która zwraca sumę cyfr liczby całkowitej podanej jako argument.

    public static int returnSum(int number) {
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }

        return sum;
    }


    //Napisz funckję, która odpowiada na pytanie czy w podanym zakresie min, max liczb całkowitych istnieje liczba, której suma cyfr
    //równa się liczbie podanej jako 3 argument tej funkcji. Funkcja powinna zwracać wartość boolean, a NIE wypisywać do konsoli odpowiedź.
    //Użyj funkcji z poprzedniego zadania.

    public static boolean equalsNumber(int min, int max, int number) {
        for (int i = min; i <= max; i++)
            if (returnSum(i) == number)
                return true;

        return false;
    }


    //Napisz funkcję, która dostanie tablicę stringów i zwróci najdłuższy z nich

    public static String findLongestString(String[] words) {
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return longest;
    }


    //Napisz funckję, która dostanie 2 tablice z intami i zwróci informację ile liczb z tablicy 1 występuje również w tablicy 2.

    //{1,3,2,1,4}
    //{9,9,1}

    public static int countDuplicates(int[] arr1, int[] arr2) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    counter++;
            }
        }
        return counter;
    }


    //Napisz funckję, która dostanie 2 tablice z intami i zwróci informację ile elementów z 1 tablicy spełnia nastepujący warunek:
    //dla liczby n (z 1 tab) istnieje co najwyżej n liczb w 2 tablicy, które są mniejsze od n


    public static int findUpToN(int[] arr1, int[] arr2) {
        int counter = 0;

        for (int j = arr2.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr2[i] > arr2[i + 1]) {
                    int temp = arr2[i];
                    arr2[i] = arr2[i + 1];
                    arr2[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < arr1.length; i++) {
            int n = arr1[i];
            int idx = runBinarySearch(arr2, 0, arr2.length - 1, n);
            if (idx <= n)
                counter++;
        }

        return counter;
    }

    private static int runBinarySearch(int[] array, int min, int max, int key) {
        int index = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (array[mid] < key)
                min = mid + 1;
            else if (array[mid] > key)
                max = mid - 1;
            else if (array[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }


    //Napisz funkcję, ktora dostanie tablicę 2-wymiarową z intami i zwróci informację ile jest rzędów,
    // w których ilość liczb ujemnych jest większa niż ilośc liczb dodatnich.

    public static int countRows(int[][] array) {
        int counter = 0;
        int perRow = 0;

        for (int i = 0; i < array.length; i++) {//row
            for (int j = 0; j < array[i].length; j++) {//col
                if (array[i][j] < 0) {
                    perRow++;
                    if (perRow > array[i].length / 2) {
                        counter++;
                        break;
                    }
                }
            }
            perRow = 0;
        }
        return counter;
    }


    //Napisz funckję, która dla podanej liczby n wyświetli w konsoli horyzontalnie n kwadratów nxn.
    //np dla n=3:
    //
    //### ### ###
    //### ### ###
    //### ### ###

    public static void drawRectangle(int n) {

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    System.out.print("#");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    //Napisz funckję, która dla podanej liczby n zwróci wartość sumy:
    //1/1 + 1/2 + 1/3 + ... + 1/n

    public static double computeSum(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    //Napisz funckję, która dla podanej liczby n zwróci wartość sumy:
    //1/1 + 1/4 + 1/9 + ... + 1/n^2

    public static double computeSumExp(int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += 1.0 / (i * i);
        }

        return sum;
    }


    //Napisz funckję, która dla podanej liczby n zwróci wartość sumy:
    //1/1 - 1/2 + 1/4 - 1/8 + 1/16 - 1/32 + ... (+/-)1/2^n

    public static double computeSumExpPlusMinus(int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0)
                sum += 1.0 / Math.pow(2, i);
            else
                sum -= 1.0 / Math.pow(2, i);
        }
        return sum;
    }

    //Napisz funckję, która dla podanych liczb a, n zwróci wartość sumy:
    //(a)/(n) + (a+1)/(n+1) + (a+2)/(n+2) + ... + (a+n)/(n+n)

    public static double computeSum2(int a, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += ((double) a + i) / ((double) n + i);
        }
        return sum;
    }


}
