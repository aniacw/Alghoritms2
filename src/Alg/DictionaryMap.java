package Alg;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class DictionaryMap {
    private HashSet<String> words;
    private String dictionaryName;

    public DictionaryMap(String path) throws IOException {
        words = new HashSet<>();
        readFile(path);
    }

    public void readFile(String path) throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }
    }

    public boolean containsWord(String word) {
        long start = System.currentTimeMillis();
        boolean res = words.contains(word);
        long end = System.currentTimeMillis() - start;
        //System.out.println("Word search took: " + end + "ms");
        return res;
    }

    public void readUserFile(String path) throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);

        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = bufferedReader.readLine()) != null){
            String [] arr = line.split("[\\s.,!;:?+\"'/\\[\\]\\\\{}()<>@#$%^&*=|~`]+");
            for(String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
            for(String s : arr) {
                char ch = (words.contains(s) || words.contains(s.substring(0,1).toUpperCase() + s.substring(1))) ? ' ' : '^';
                for (int i=0; i<s.length(); ++i)
                    System.out.print(ch);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void generateDict(String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for(String x : words){
            printWriter.println(x);
        }
        fileOutputStream.close();
    }


}


//Napisz narzędzie, które wczta plik o podanej przez użytkownika nazwie.
//Plik jest traktowany jako słownik, w każdej linijce znajduje się jedno, dowolne słowo.
//Wczytaj plik do własnoręcznie zaimplementowanej struktury danch.
//Powinna ona dawać możliwość błyskawicznego (tzn nieodczywalnego dla użytkownika) wyszukiwania słów, sprawdzania czy należą do słownika.
//Następnie zaimplementuj interakcję z użytkownikiem: powinien podać nazwę słownika, a następnie plik do sprawdzenia poprawności.
//Program powinien zweryfikować poprawność wszystkich słów w pliku za pomoca słownika i skonstruowanej na jego podstawie struktury danych.
//Wyjście powinno zawierać wszystkie linijki w pliku przeplecione linijkami zaznaczającymi niepoprawne słowa.
//Np:
//	ala ma koya a koq ma alę
//	       ^^^^   ^^^
//	stół z powyłamywamyni nogami
//	       ^^^^^^^^^^^^^^