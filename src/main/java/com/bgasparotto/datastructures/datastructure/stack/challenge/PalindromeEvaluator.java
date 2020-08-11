package com.bgasparotto.datastructures.datastructure.stack.challenge;

import com.bgasparotto.datastructures.datastructure.stack.SimpleLinkedListStack;
import com.bgasparotto.datastructures.datastructure.stack.SimpleStack;

public class PalindromeEvaluator {
    private static final String LOWER_CASE_ALPHANUMERIC_ONLY_REGEX = "[^a-zA-Z0-9]";

    public boolean isPalindrome(String input) {
        if (isInvalid(input)) {
            return false;
        }

        String cleanInput = lowerCaseAlphanumericOnly(input);
        return inputIsPalindrome(cleanInput);
    }

    private boolean isInvalid(String input) {
        return input == null || input.isBlank();
    }

    private String lowerCaseAlphanumericOnly(String input) {
        return input.replaceAll(LOWER_CASE_ALPHANUMERIC_ONLY_REGEX, "");
    }

    private boolean inputIsPalindrome(String input) {
        SimpleStack<Character> stack = new SimpleLinkedListStack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reverseStringBuilder = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            reverseStringBuilder.append(stack.pop());
        }

        String reverseString = reverseStringBuilder.toString();
        return input.equalsIgnoreCase(reverseString);
    }
}
