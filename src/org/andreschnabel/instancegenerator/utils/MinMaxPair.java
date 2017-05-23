package org.andreschnabel.instancegenerator.utils;

public class MinMaxPair<T> {

    public T min, max;

    public MinMaxPair(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public MinMaxPair(T minAndMax) {
        this.min = this.max = minAndMax;
    }

}
