package com.bgasparotto.datastructures.datastructure.stack.challenge;

public abstract class PalindromeEvaluator {

    public abstract boolean isPalindrome(String input);

    protected boolean isInvalid(String input) {
        return input == null || input.isBlank();
    }
}
