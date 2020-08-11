package com.bgasparotto.datastructures.datastructure.stack.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PalindromeEvaluatorTest {
    private final PalindromeEvaluator palindromeEvaluator = new PalindromeEvaluator();

    @Test
    public void shouldReturnFalseForNullInput() {
        assertThat(palindromeEvaluator.isPalindrome(null)).isFalse();
    }

    @Test
    public void shouldReturnFalseForEmptyInput() {
        assertThat(palindromeEvaluator.isPalindrome("")).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenInputIsNotPalindrome() {
        assertThat(palindromeEvaluator.isPalindrome("abbc")).isFalse();
        assertThat(palindromeEvaluator.isPalindrome("a b c")).isFalse();
        assertThat(palindromeEvaluator.isPalindrome("i am not a palindrome am i?")).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindrome() {
        assertThat(palindromeEvaluator.isPalindrome("aa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("abba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aabbaa")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasDifferentCase() {
        assertThat(palindromeEvaluator.isPalindrome("aa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aA")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("BB")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aBBa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("AaBbAa")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpaces() {
        assertThat(palindromeEvaluator.isPalindrome(" aa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a bba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aa bba a")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpacesAndPunctuations() {
        assertThat(palindromeEvaluator.isPalindrome(" a,a")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a;b-ba.")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? .aab....baa. !")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpacesAndPunctuationsAndDifferentCase() {
        assertThat(palindromeEvaluator.isPalindrome(" a,A")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a;B-bA.")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? .AAb....Baa. !")).isTrue();
    }
}
