package com.bgasparotto.datastructures.challenge;

import com.bgasparotto.datastructures.datastructure.queue.SimpleCircularArrayQueue;
import com.bgasparotto.datastructures.datastructure.queue.SimpleQueue;
import com.bgasparotto.datastructures.datastructure.stack.SimpleLinkedListStack;
import com.bgasparotto.datastructures.datastructure.stack.SimpleStack;

public class StackQueuePalindromeEvaluator extends PalindromeEvaluator {

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
        SimpleStack<Character> stack = new SimpleLinkedListStack<>();
        SimpleQueue<Character> queue = new SimpleCircularArrayQueue<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        for (int i = 0; i < input.length(); i++) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }
}
