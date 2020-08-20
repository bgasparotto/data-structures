package com.bgasparotto.datastructures.challenge;

import com.bgasparotto.datastructures.datastructure.stack.SimpleLinkedListStack;
import com.bgasparotto.datastructures.datastructure.stack.SimpleStack;

public class ReverseStringPalindromeEvaluator extends PalindromeEvaluator {
    private static final String ALPHANUMERIC_ONLY_REGEX = "[^a-zA-Z0-9]";

    @Override
    public boolean isPalindrome(String input) {
        if (isInvalid(input)) {
            return false;
        }

        String cleanInput = alphanumericOnly(input);
        return inputIsPalindrome(cleanInput);
    }

    private String alphanumericOnly(String input) {
        return input.replaceAll(ALPHANUMERIC_ONLY_REGEX, "");
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
