package com.bgasparotto.datastructures.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbstractPalindromeEvaluatorTest {
    private final PalindromeEvaluator palindromeEvaluator;

    public AbstractPalindromeEvaluatorTest(PalindromeEvaluator palindromeEvaluator) {
        this.palindromeEvaluator = palindromeEvaluator;
    }

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
        assertThat(palindromeEvaluator.isPalindrome("aba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("abba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aabbaa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("112211")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasDifferentCase() {
        assertThat(palindromeEvaluator.isPalindrome("aa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aA")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aBA")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("BB")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aBBa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("AaBbAa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("Aa3Bb3Aa")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpaces() {
        assertThat(palindromeEvaluator.isPalindrome(" aa")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome(" a ba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a bba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("aa bba a")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("1aa bba a 1 ")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpacesAndPunctuations() {
        assertThat(palindromeEvaluator.isPalindrome(" a,a")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome(" a,.ba")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a;b-ba.")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? .aab....baa. !")).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenInputIsPalindromeButHasSpacesAndPunctuationsAndDifferentCase() {
        assertThat(palindromeEvaluator.isPalindrome(" a,A")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome(" a,bA")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("a;B-bA.")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? .AAb....Baa. !")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? 23 .AAb....Baa. 32  !")).isTrue();
        assertThat(palindromeEvaluator.isPalindrome("? 23 .AAb..BBB..Baa. 32  !")).isTrue();
    }
}
