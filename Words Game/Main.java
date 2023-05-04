package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        int totalRemovedLettersCount = 0;
        int removedLettersCountFromFirstWord = 0;
        int removedLettersCountFromSecondWord = 0;

        StringBuilder sameLetters = new StringBuilder();

        boolean haveSameLetters = false;

        while (!haveSameLetters) {
            //if first word has bigger size, we compare the symbols from second word to first word
            if (haveSameLettersInBothWords(firstWord, secondWord)) {
                sameLetters.append(extractSameLetters(firstWord, secondWord));
                totalRemovedLettersCount = removedLettersCount(firstWord, secondWord);
                haveSameLetters = true;
            }

            if (!haveSameLettersInBothWords(firstWord, secondWord)) {
                //if there isn't same letters in both words, we take another two, until we got same letters
                System.out.println("No matched letters in the both words, please insert new two words!");
                firstWord = scanner.nextLine();
                secondWord = scanner.nextLine();
            }
        }
        removedLettersCountFromFirstWord = firstWord.length() - sameLetters.length();
        removedLettersCountFromSecondWord = secondWord.length() - sameLetters.length();
        totalRemovedLettersCount = removedLettersCountFromFirstWord + removedLettersCountFromSecondWord;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The first entered word is: %s%n", firstWord));
        sb.append(String.format("The second entered word is: %s%n", secondWord));
        sb.append(String.format("The same letters in the both words are: %s%n", sameLetters));
        sb.append(String.format("Removed symbols count from first word is: %d%n", removedLettersCountFromFirstWord));
        sb.append(String.format("Removed symbols count from second word is: %d%n", removedLettersCountFromSecondWord));
        sb.append(String.format("Total removed symbols count is: %d%n", totalRemovedLettersCount));
        System.out.println(sb.toString());

    }

    public static boolean haveSameLettersInBothWords(String firstWord, String secondWord) {
        for (int i = 0; i < secondWord.length(); i++) {
            String currentSymbol = String.valueOf(secondWord.charAt(i));
            if (firstWord.contains(currentSymbol)) {
                return true;
            }
        }
        return false;
    }
    public static String extractSameLetters(String firstWord, String secondWord) {
        StringBuilder sameLetters = new StringBuilder();
        if (firstWord.length() > secondWord.length()) {
            for (int i = 0; i < secondWord.length(); i++) {
                String currentSymbol = String.valueOf(secondWord.charAt(i));
                if (firstWord.contains(currentSymbol)) {
                    sameLetters.append(currentSymbol);
                }
            }
        } else if (secondWord.length() > firstWord.length()) {

            for (int i = 0; i < firstWord.length(); i++) {
                String currentSymbol = String.valueOf(firstWord.charAt(i));
                if (secondWord.contains(currentSymbol)) {
                    sameLetters.append(currentSymbol);
                }
            }
        } else {
            for (int i = 0; i < secondWord.length(); i++) {
                String currentSymbol = String.valueOf(secondWord.charAt(i));
                if (firstWord.contains(currentSymbol)) {
                    sameLetters.append(currentSymbol);
                }
            }

        }

        return sameLetters.toString();
    }
    public static int removedLettersCount(String firstWord, String secondWord) {
        int removedLettersCount = 0;
        if (firstWord.length() > secondWord.length()) {
            for (int i = 0; i < secondWord.length(); i++) {
                String currentSymbol = String.valueOf(secondWord.charAt(i));
                if (!firstWord.contains(currentSymbol)) {
                    removedLettersCount++;
                }
            }
        } else if (secondWord.length() > firstWord.length()) {

            for (int i = 0; i < firstWord.length(); i++) {
                String currentSymbol = String.valueOf(firstWord.charAt(i));
                if (!secondWord.contains(currentSymbol)) {
                    removedLettersCount++;
                }
            }
        } else {
            for (int i = 0; i < secondWord.length(); i++) {
                String currentSymbol = String.valueOf(secondWord.charAt(i));
                if (!firstWord.contains(currentSymbol)) {
                    removedLettersCount++;
                }
            }

        }
        return removedLettersCount;
    }
}
