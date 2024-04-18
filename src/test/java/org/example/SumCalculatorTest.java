package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    void beforeEach() {
        //given
        sumCalculator = new SumCalculator();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("validInputParam")
    void testThatSumMethodWorksCorrect(String name, int input, int expected) {
        //when
        int actual = sumCalculator.sum(input);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testThatSumMethodThrowsException() {
        //given
        int input = 0;

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> sumCalculator.sum(input));
    }

    private static Stream<Arguments> validInputParam() {
        return Stream.of(
                Arguments.of("with input 1", 1, 1),
                Arguments.of("with input 3", 3, 6));
    }

}