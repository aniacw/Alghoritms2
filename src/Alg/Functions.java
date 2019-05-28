package Alg;

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
        Stack<Integer> numbersStack = new Stack<>();
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            numbersStack.push(digit);
            while (!numbersStack.empty())
                sum += numbersStack.pop();
            number = (number - digit) / 10;
        }

        return sum;
    }


    //Napisz funckję, która odpowiada na pytanie czy w podanym zakresie min, max liczb całkowitych istnieje liczba, której suma cyfr
    //równa się liczbie podanej jako 3 argument tej funkcji. Funkcja powinna zwracać wartość boolean, a NIE wypisywać do konsoli odpowiedź.
    //Użyj funkcji z poprzedniego zadania.

    public static boolean equalsNumber(int min, int max, int number) {
        boolean isEqual = false;
        for (int i = min; i <= max; i++)
            if (returnSum(i) == number)
                isEqual = true;

        return isEqual;
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


    //Napisz funckję, która dostanie 2 tablice z intami i zwróci informację ile liczb z 1 tablicy spełnia nastepujący warunek:
    //dla liczby n (z 1 tab) istnieje co najwyżej n liczb w 2 tablicy, które są mniejsze od n


    //Napisz funkcję, ktora dostanie tablicę 2-wymiarową z intami i zwróci informację ile jest rzędów,
    // w których ilość liczb ujemnych jest większa niż ilośc liczb dodatnich.


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
        for(int i = 1; i <= n; i++) {
            sum += ((double)1/i);
        }
        return sum;
    }


}
