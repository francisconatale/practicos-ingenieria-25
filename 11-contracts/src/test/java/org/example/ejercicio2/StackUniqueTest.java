package org.example.ejercicio2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StackUniqueTest {

    static Stream<Arguments> providerOfStacksOne() {
        UniqueStack<String> s1 = new UniqueStack<>(); s1.push("uno");
        UniqueStack<Integer> s2 = new UniqueStack<>(); s2.push(1);
        UniqueStack<Double> s3 = new UniqueStack<>(); s3.push(3.14);

        return Stream.of(
                Arguments.of(s1),
                Arguments.of(s2),
                Arguments.of(s3)
        );
    }

    static Stream<Arguments> providerOfStacksTwo() {
        UniqueStack<String> s1 = new UniqueStack<>();
        UniqueStack<Integer> s2 = new UniqueStack<>();
        UniqueStack<Double> s3 = new UniqueStack<>();

        return Stream.of(
                Arguments.of(s1),
                Arguments.of(s2),
                Arguments.of(s3)
        );
    }

    static Stream<Arguments> providerOfStacksWithObjectExisting() {
        UniqueStack<String> s1 = new UniqueStack<>(); s1.push("uno");
        UniqueStack<Integer> s2 = new UniqueStack<>(); s2.push(1);
        UniqueStack<Double> s3 = new UniqueStack<>(); s3.push(3.14);

        return Stream.of(
                Arguments.of(s1, "uno"),
                Arguments.of(s2, 1),
                Arguments.of(s3, 3.14)
        );
    }


    @ParameterizedTest
    @MethodSource("providerOfStacksOne")
    <E> void testPopWithValidStacks(IUniqueStack<E> stack) {
        Object actual = stack.peek();
        assertEquals(actual, stack.pop());
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksTwo")
    <E> void testPopWithInValidStacks(IUniqueStack<E> stack) {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksWithObjectExisting")
    <E> void testPushWithItemsExisting(IUniqueStack<E> stack, E item) {
        assertThrows(IllegalArgumentException.class, () -> stack.push(item));
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksTwo")
    <E> void testPushWithNullObjects(IUniqueStack<E> stack) {
        assertThrows(NullPointerException.class, () -> stack.push(null));
    }


    @ParameterizedTest
    @MethodSource("providerOfStacksTwo")
    <E> void testPeekWithInvalidStacks(IUniqueStack<E> stack) {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksOne")
    <E> void testPeekWithValidStacks(IUniqueStack<E> stack) {
        E item =  stack.peek();
        assertEquals(item, stack.peek());
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksOne")
    <E> void testEmptyStack(IUniqueStack<E> stack) {
        assertFalse(stack.isEmpty());
    }
    @ParameterizedTest
    @MethodSource("providerOfStacksTwo")
    <E> void testNotEmptyStack(IUniqueStack<E> stack) {
        assertTrue(stack.isEmpty());
    }
    @ParameterizedTest
    @MethodSource("providerOfStacksTwo")
    <E> void sizeOfStacksEmpty(IUniqueStack<E> stack) {
        int sizeOfStack =  stack.size();
        assertEquals(0, sizeOfStack);
    }

    @ParameterizedTest
    @MethodSource("providerOfStacksOne")
    <E> void sizeOfStacksNotEmpty(IUniqueStack<E> stack) {
        int sizeOfStack =  stack.size();
        assertEquals(1, sizeOfStack);
    }
}
