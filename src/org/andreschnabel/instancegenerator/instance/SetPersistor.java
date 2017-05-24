package org.andreschnabel.instancegenerator.instance;

import com.google.gson.Gson;
import org.andreschnabel.instancegenerator.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class SetPersistor {

    public static void persistInstances(Gson gson, List<InstanceData> instances, File outPath, String prefix, String suffix) {
        int ctr = 1;
        for(InstanceData instance : instances) {
            try {
                String outFn = outPath + File.separator + prefix + ctr + suffix;
                Utils.spit(outFn, gson.toJson(instance));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ctr++;
        }
    }

}
