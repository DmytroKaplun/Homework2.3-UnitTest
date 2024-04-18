package org.example;

public class SumCalculator {
    int sum(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (int i = 1; i <= input; i++) {
            result += i;
        }
        return result;
    }
}
