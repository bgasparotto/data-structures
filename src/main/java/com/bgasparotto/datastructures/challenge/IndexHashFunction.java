package com.bgasparotto.datastructures.challenge;

public class IndexHashFunction {
    private final int indexRange;

    public IndexHashFunction(int indexRange) {
        this.indexRange = indexRange;
    }

    public int hash(int value) {
        return Math.abs(value) % indexRange;
    }
}
