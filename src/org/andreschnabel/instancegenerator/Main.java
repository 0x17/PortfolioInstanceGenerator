package org.andreschnabel.instancegenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.andreschnabel.instancegenerator.generator.Generator;
import org.andreschnabel.instancegenerator.generator.GeneratorConfiguration;
import org.andreschnabel.instancegenerator.instance.InstanceData;
import org.andreschnabel.instancegenerator.instance.SetPersistor;
import org.andreschnabel.instancegenerator.utils.Utils;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        GeneratorConfiguration config = gson.fromJson(Utils.slurp("data/default_config.json"), GeneratorConfiguration.class);

        /*NormalDistribution nd = new NormalDistribution(10, 1);
        System.out.println(nd.sample());*/

        InstanceData data = gson.fromJson(Utils.slurp("data/multi_data.json"), InstanceData.class);

        List<InstanceData> instances = Generator.generateInstances(config, 1);

        System.out.println(gson.toJson(instances));

        SetPersistor sp = new SetPersistor(gson);
        sp.persistInstances(instances, new File("output"), "pinstance", ".json");
    }

}
