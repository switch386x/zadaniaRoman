package zadaniaDodatkowe;

import java.util.Arrays;

public class ArraysAndStrings {
    // <1.1
    /*
     * implement an algorithm to determine if a string has all unique characters.
     */
    public boolean uniqueCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; i < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public void displayUniqueCharacters(String input) {
        ArraysAndStrings test = new ArraysAndStrings();
        if (test.uniqueCharacters(input))
            System.out.println("unique character containing string");
        else {
            System.out.println("duplicate character containing string");
        }
    }
    // 1.1/>

    // <1.2
    /*
     * given the two strings, write a method to decide if one is a permutation of the other.
     */

    public boolean arePermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            System.out.println("different amount of characters");
            return false;
        }
        else {
            char c1[] = s1.toCharArray();
            char c2[] = s2.toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);

            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    System.out.println("not a permutation");
                    return false;
                }
            }
            System.out.println("permutation");
            return true;
        }
    }
    // 1.2/>

    // <1.3
    /*
     * write a method to replace all spaces in a string with "%20". You may assume that the string has sufficient space at the end
     * to hold the additional characters, and that You are given the "true" length of the string.
     */

    public String URLifyString(String s) {

        char array[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 32)
                sb.append("%20");
            else {
                sb.append(array[i]);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    // 1.3/>

    // <1.5
    /*
     * there are three types of edits that can be performed on strings : insert a character, remove a character or replace a
     * character. Given two strings write a function to check if they are one edit or zero edits away I DONT UNDERSTAND THIS TASK
     */
    // 1.5/>

    public boolean isEditDistanceOne(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        else {
            int counter = 0;
            int i = 0;
            int j = 0;
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    if (counter == 1)
                        return false;
                    if (s1.length() > s2.length()) {
                        i++;
                    }
                    else if (s1.length() < s2.length()) {
                        j++;
                    }
                    else {
                        i++;
                        j++;
                    }
                    counter++;
                }
                else {
                    i++;
                    j++;
                    return true;
                }
            }
            if (i < s1.length() || j < s2.length()) {
                counter++;
                return counter == 1;
            }
            return false;
        }
    }
    // <1.6
    /*
     * implement a method to perform basic string compression using the counts of repeated characters. For example, the string
     * aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original string, your method
     * should return the original string. You can assume the string has only uppercase and lowercase letters (a-z),
     */

    public String stringCompression(String s) {

        int initialLength = s.length();
        if (s.length() < 3) {
            System.out.println(s);
            return s;
        }
        else {
            String compressedString = "";
            char lastChar = s.charAt(0);
            int charCount = 1;
            for (int i = 1; i < initialLength; i++) {
                if (s.charAt(i) == lastChar)
                    charCount++;
                else {
                    compressedString += Character.toString(lastChar) + Integer.toString(charCount);
                    lastChar = s.charAt(i);
                    charCount = 1;
                }
            }
            compressedString += Character.toString(lastChar) + Integer.toString(charCount);
            if (compressedString.length() < initialLength)
                System.out.println(compressedString);
            return compressedString;
        }
    }
    // 1.6/>

    // <1.7
    /*
     * Given an image represented by an NxN matrix, where each pixel in the image is n = 4 bytes, write a method to rotate the
     * image by 90 degrees. Can you do this in place? each pixel in the image is 4 bytes. n - that is matrix size
     */

    public int[][] rotateMatrix90Degree(int matrix[][], int n) {

        printMatrix(matrix);

        for (int layer = 0; layer < (n / 2); layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int j = last - offset;
                int top = matrix[first][i]; // save top values

                matrix[first][i] = matrix[j][first];
                matrix[j][first] = matrix[last][j];
                matrix[last][j] = matrix[i][last];
                matrix[i][last] = top; //retrieve top values
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    public static void printMatrix(int matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 1.7/>

    // <1.8
    /*
     * Write an algorithm such that if an element in an MxN matrix is 0 its entire row and column are set to 0
     */

    public int[][] setMatrixValuesToZero(int[][] matrix, int a, int b) {

        int row[] = new int[a];
        int column[] = new int[b];

        // fory musza tutaj byc poniewaz populuja macierz ktora uzywamy do zerowania danymi - macierz pomocnicza. Sprawdzenie
        // wykonane przy uzyciu Debuggera.
        for (int i = 0; i < a; i++) {
            row[i] = 1;
        }

        for (int j = 0; j < b; j++) {
            column[j] = 1;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    column[j] = 0;
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (row[i] == 0 || column[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    // 1.8/>

    // <1.9
    /*
     * Assume you have a method isSubstring which checks if one word is a substring of the other one. Given two strings s1 and s2
     * write code to check if s2 is a rotation of s1 using only one call to isSubstring.
     */

    public boolean isRotation(String s1, String s2) {
        int s1len = s1.length();
        if (s1len == s2.length()) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        else {
            return false;
        }
    }

    private static boolean isSubstring(String s1, String s2) {
        if (s1.contains(s2)) {
            System.out.println("substring noticed");
            return true;
        }
        else {
            System.out.println("substring unnnoticed");
            return false;
        }
    }

    // 1.9/>
    public static void main(String args[]) {

    }
}