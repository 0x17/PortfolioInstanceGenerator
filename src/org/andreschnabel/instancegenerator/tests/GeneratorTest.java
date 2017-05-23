package org.andreschnabel.instancegenerator.tests;

import org.andreschnabel.instancegenerator.generator.Generator;
import org.andreschnabel.instancegenerator.generator.GeneratorConfiguration;
import org.andreschnabel.instancegenerator.instance.ClientData;
import org.andreschnabel.instancegenerator.instance.InstanceData;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GeneratorTest {

    private GeneratorConfiguration config = new GeneratorConfiguration();

    @Test
    public void generateInstances() {
        List<InstanceData> instances = Generator.generateInstances(config, 10);
        assertEquals(10, instances.size());
    }

    @Test
    public void generateRevenueCostRatios() {
        Double[] ratios = Generator.generateRevenueCostRatios(5);
        for(int i=1; i<ratios.length; i++)
            assertTrue(ratios[i-1] > ratios[i]);
    }

    @Test
    public void generateInstance() {
        InstanceData instance = Generator.generateInstance(config);
        assertTrue(instance.capacity > 0);
        assertFalse(instance.clients.isEmpty());
    }

    @Test
    public void generateClient() {
        int capacity = 100;
        ClientData client = Generator.generateClient(0, 5, capacity, 0.5);
        assertTrue(client.consumptionPerReq < capacity);
    }

}