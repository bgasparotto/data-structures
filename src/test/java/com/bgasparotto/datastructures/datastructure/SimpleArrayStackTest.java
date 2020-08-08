package com.bgasparotto.datastructures.datastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.bgasparotto.datastructures.datastructure.stack.SimpleArrayStack;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleArrayStackTest {

    private SimpleArrayStack<String> stack;
    private final String rick = "Rick";
    private final String james = "James";
    private final String lucy = "Lucy";

    @BeforeEach
    public void setUp() {
        stack = new SimpleArrayStack<>();
    }

    @Test
    public void shouldPushAndPeekElementsAtTheTop() {
        stack.push(rick);
        assertThat(stack.peek()).isEqualTo(rick);

        stack.push(james);
        assertThat(stack.peek()).isEqualTo(james);
    }

    @Test
    public void shouldPopElementsFromTheTop() {
        stack.push(rick);
        stack.push(james);
        stack.push(lucy);

        assertThat(stack.pop()).isEqualTo(lucy);
        assertThat(stack.pop()).isEqualTo(james);
        assertThat(stack.pop()).isEqualTo(rick);
    }

    @Test
    public void shouldThrowExceptionIfPopAnEmptyStack() {
        assertThatThrownBy(() -> stack.pop()).isInstanceOf(EmptyStackException.class);
    }

    @Test
    public void shouldThrowExceptionIfPeekAnEmptyStack() {
        assertThatThrownBy(() -> stack.peek()).isInstanceOf(EmptyStackException.class);
    }

    @Test
    public void sizeShouldReturnZeroWhenStackIsEmpty() {
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void sizeShouldReturnTheAppropriateValueAsTheStackGrows() {
        stack.push(rick);
        assertThat(stack.size()).isEqualTo(1);

        stack.push(james);
        assertThat(stack.size()).isEqualTo(2);

        stack.push(lucy);
        assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    public void sizeShouldReturnTheAppropriateValueAsTheStackShrinks() {
        stack.push(rick);
        stack.push(james);
        stack.push(lucy);

        assertThat(stack.size()).isEqualTo(3);

        stack.pop();
        assertThat(stack.size()).isEqualTo(2);

        stack.pop();
        assertThat(stack.size()).isEqualTo(1);

        stack.pop();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenStackHasNoElements() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyShouldReturnFalseWhenStackHasOneOrMoreElements() {
        stack.push(rick);
        assertThat(stack.isEmpty()).isFalse();

        stack.push(james);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void isEmptyShouldReturnAccordingToWhetherTheStackHasElements() {
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();

        stack.push(rick);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.isEmpty()).isFalse();

        stack.pop();
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void equivalentElementsShouldBePushedAsManyTimesAsInvoked() {
        addRepeatedly(rick, 10);

        assertThat(stack.size()).isEqualTo(10);
    }

    private void addRepeatedly(String element, int times) {
        for (int i = 0; i < times; i++) {
            stack.push(element);
        }
    }

    @Test
    public void shouldAccommodateLargeNumberOfElements() {
        addRepeatedly(james, 1000);
        addRepeatedly(lucy, 1000);

        assertThat(stack.size()).isEqualTo(2000);
    }
}
