package main;

import java.util.Arrays;

public class Hash {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sameHash(5)));
    }

    public static String[] sameHash(int n) {
        final int L = 9;
        int skip = Math.max(1, L / 3);
        String[] strings = new String[n];
        String[] characters = new String[] {"A","B","C"};
        int currentCharacter = 0;
        int k = 65;

        for (int i = 0; i < strings.length; i++) {
            strings[i] = "";
        }


        while (currentCharacter < characters.length) {
            for (int i = 0; i < strings.length; i++) {
                strings[i] += characters[currentCharacter];



                for (int j = 0; j < skip; j++) {
                    char c = (char) k;
                    strings[i] += c;
                    k++;
                }
            }
            currentCharacter++;

        }

        return strings;
    }

    public static int hashCode(String s) {
        int hash = 0;
        int skip = Math.max(1, s.length() / 3);

        for (int i = 0; i < s.length(); i += skip) {
            hash = (hash * 37) + s.charAt(i);
        }
        return hash;
    }
}
