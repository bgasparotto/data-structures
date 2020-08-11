package com.bgasparotto.datastructures.datastructure.stack.challenge;

import com.bgasparotto.datastructures.datastructure.stack.SimpleLinkedListStack;
import com.bgasparotto.datastructures.datastructure.stack.SimpleStack;

public class PalindromeEvaluator {
    private static final String LOWER_CASE_ALPHANUMERIC_ONLY_REGEX = "[^a-z0-9]";

    public boolean isPalindrome(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }

        String cleanInput = lowerCaseAlphanumericOnly(input);
        if (hasOddNumberOfChars(cleanInput)) {
            return false;
        }

        return inputIsPalindrome(cleanInput);
    }

    private boolean hasOddNumberOfChars(String input) {
        return input.length() % 2 != 0;
    }

    private boolean inputIsPalindrome(String input) {
        int middle = input.length() / 2;
        SimpleStack<Character> stack = new SimpleLinkedListStack<>();

        char[] leftHalf = input.substring(0, middle).toCharArray();
        for (char c : leftHalf) {
            stack.push(c);
        }

        char[] rightHalf = input.substring(middle).toCharArray();
        for (char c : rightHalf) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    private String lowerCaseAlphanumericOnly(String input) {
        return input
                .toLowerCase()
                .replaceAll(LOWER_CASE_ALPHANUMERIC_ONLY_REGEX, "");
    }
}
