package com;

import java.util.*;

public class StringPermutations {
    
    // Method to print all permutations of a string
    public static void printPermutations(String str) {
        // Convert string to character array to work with individual characters
        char[] chars = str.toCharArray();
        
        // Call the helper function to generate permutations
        generatePermutations(chars, 0);
    }
    
    // Helper method to generate permutations using backtracking
    private static void generatePermutations(char[] chars, int index) {
        // Base case: if index reaches the end of the string, print the permutation
        if (index == chars.length) {
            System.out.println(new String(chars));
            return;
        }
        
        // Recursively swap each character to generate all permutations
        for (int i = index; i < chars.length; i++) {
            // Swap characters at index and i
            swap(chars, index, i);
            
            // Recur for the next index
            generatePermutations(chars, index + 1);
            
            // Backtrack by swapping back
            swap(chars, index, i);
        }
    }
    
    // Utility method to swap two characters in the array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    public static void main(String[] args) {
        // Input string
        String input = "ABC";
        
        // Print all permutations of the input string
        printPermutations(input);
    }
}

