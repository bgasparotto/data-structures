package com.bgasparotto.datastructures.challenge;

public abstract class PalindromeEvaluator {

    public abstract boolean isPalindrome(String input);

    protected boolean isInvalid(String input) {
        return input == null || input.isBlank();
    }
}
