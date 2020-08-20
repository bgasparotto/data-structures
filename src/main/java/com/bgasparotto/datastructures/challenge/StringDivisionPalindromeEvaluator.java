package com.bgasparotto.datastructures.challenge;

import com.bgasparotto.datastructures.datastructure.stack.SimpleLinkedListStack;
import com.bgasparotto.datastructures.datastructure.stack.SimpleStack;

public class StringDivisionPalindromeEvaluator extends PalindromeEvaluator {
    private static final String LOWER_CASE_ALPHANUMERIC_ONLY_REGEX = "[^a-z0-9]";

    @Override
    public boolean isPalindrome(String input) {
        if (isInvalid(input)) {
            return false;
        }

        String cleanLowerCaseInput = lowerCaseAlphanumericOnly(input);
        return inputIsPalindrome(cleanLowerCaseInput);
    }

    private String lowerCaseAlphanumericOnly(String input) {
        return input
                .toLowerCase()
                .replaceAll(LOWER_CASE_ALPHANUMERIC_ONLY_REGEX, "");
    }

    private boolean inputIsPalindrome(String input) {
        int middleEndIndex = input.length() / 2;
        SimpleStack<Character> stack = new SimpleLinkedListStack<>();

        for (int i = 0; i < middleEndIndex; i++) {
            char c = input.charAt(i);
            stack.push(c);
        }

        int singleMiddleElementLeap = input.length() % 2;
        int middleStartIndex = middleEndIndex + singleMiddleElementLeap;

        for (int i = middleStartIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
