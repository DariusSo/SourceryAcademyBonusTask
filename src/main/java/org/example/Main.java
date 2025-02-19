package org.example;

public class Main {
    public static void main(String[] args) {

        String input = "aaabbc";

        String compressedString = BonusTask.compressString(input);
        System.out.println("Compressing | Input: " + input + " -> Output: " + compressedString);

        String decompressedString = BonusTask.decompressString(compressedString);
        System.out.println("Decompressing | Input: " + compressedString + " -> Output: " + decompressedString);
    }
}