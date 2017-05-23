package org.andreschnabel.instancegenerator.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.distribution.UniformRealDistribution;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    public static String slurp(String filename) throws IOException {
        return FileUtils.readFileToString(new File(filename));
    }

    public static void spit(String filename, String contents) throws IOException {
        FileUtils.writeStringToFile(new File(filename), contents);
    }

    private static Random rand = new Random();

    public static int randIntInRange(int lb, int ub) {
        return rand.nextInt((ub - lb) + 1) + lb;
    }

    public static int randIntInRange(MinMaxPair<Integer> bounds) {
        return randIntInRange(bounds.min, bounds.max);
    }

    public static double randDoubleInRange(double lb, double ub) {
        return lb + rand.nextDouble() * (ub - lb);
    }

    public static double randDoubleInRange(MinMaxPair<Double> bounds) {
        return randDoubleInRange(bounds.min, bounds.max);
    }

    public static double uniformRealInRange(MinMaxPair<Double> pair) {
        return new UniformRealDistribution(pair.min, pair.max).sample();
    }

    public static <T> List<T> initializeListWithLambda(int count, Function<Integer, T> f) {
        return IntStream.range(0, count).mapToObj(f::apply).collect(Collectors.toList());
    }

    public static boolean randBool() {
        return rand.nextBoolean();
    }
}
