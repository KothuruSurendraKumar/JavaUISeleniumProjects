package com;

import java.util.*;

public class PhoneNumberLetterCombinations {

    // Mapping from digits to letters
    private static final String[] phoneMap = {
        "",     // 0
        "",     // 1
        "abc",   // 2
        "def",   // 3
        "ghi",   // 4
        "jkl",   // 5
        "mno",   // 6
        "pqrs",  // 7
        "tuv",   // 8
        "wxyz"   // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // If the input is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        // Initialize the list with an empty string
        result.add("");
        
        // Iterate through each digit in the input string
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            String letters = phoneMap[digit];
            
            // Temporary list to hold the new combinations
            List<String> temp = new ArrayList<>();
            
            // For each string in the result list, add each letter corresponding to the current digit
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            
            // Update the result list with the new combinations
            result = temp;
        }
        
        return result;
    }

    public static void main(String[] args) {
        String digits = "23"; // Example input
        List<String> combinations = letterCombinations(digits);
        System.out.println(combinations); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}

