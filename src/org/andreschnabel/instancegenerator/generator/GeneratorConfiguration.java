package org.andreschnabel.instancegenerator.generator;

import org.andreschnabel.instancegenerator.utils.MinMaxPair;

public class GeneratorConfiguration {
    public MinMaxPair<Integer> numClasses, capacity;

    public GeneratorConfiguration() {
        numClasses = new MinMaxPair<>(3);
        capacity = new MinMaxPair<>(9);
    }
}
