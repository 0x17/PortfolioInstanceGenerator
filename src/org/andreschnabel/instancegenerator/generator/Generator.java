package org.andreschnabel.instancegenerator.generator;

import org.andreschnabel.instancegenerator.instance.ClientData;
import org.andreschnabel.instancegenerator.instance.InstanceData;
import org.andreschnabel.instancegenerator.utils.MinMaxPair;
import org.andreschnabel.instancegenerator.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Generator {

    public static List<InstanceData> generateInstances(GeneratorConfiguration config, int numInstances) {
        return Utils.initializeListWithLambda(numInstances, i -> generateInstance(config));
    }

    public static Double[] generateRevenueCostRatios(int numClasses) {
        Double[] revenueCostRatios = new Double[numClasses];
        for(int j=0; j<numClasses; j++) {
            revenueCostRatios[j] = Utils.uniformRealInRange(new MinMaxPair<>(0.0, 10.0));
        }
        Arrays.sort(revenueCostRatios, Collections.reverseOrder());
        return revenueCostRatios;
    }

    public static InstanceData generateInstance(GeneratorConfiguration config) {
        int capacity = Utils.randIntInRange(config.capacity);
        int numClasses = Utils.randIntInRange(config.numClasses);

        InstanceData instance = new InstanceData(capacity, new ArrayList<>(numClasses));

        Double[] revenueCostRatios = generateRevenueCostRatios(numClasses);

        for(int j=0; j<numClasses; j++) {
            ClientData cd = generateClient(j, numClasses, capacity, revenueCostRatios[j]);
            instance.clients.add(cd);
        }

        return instance;
    }

    public static ClientData generateClient(int j, int numClasses, int capacity, double revenueCostRatio) {
        ClientData cd = new ClientData();
        cd.description = "Description for class " + (j+1);
        cd.name = "Class" + (j+1);

        cd.consumptionPerReq = Utils.randIntInRange(1, (int)Math.floor(capacity / numClasses));
        cd.revenuePerReq = revenueCostRatio * cd.consumptionPerReq;
        double x = Utils.randDoubleInRange(0.5, 2.0);
        cd.expD = (capacity / numClasses) / cd.consumptionPerReq * x;
        double varCoeff = Utils.randBool() ? 0.1 : 0.3;
        cd.devD = cd.expD / varCoeff;

        return cd;
    }
}
