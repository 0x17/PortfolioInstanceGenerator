package org.andreschnabel.instancegenerator.instance;

import java.util.List;

public class InstanceData {
    public final int capacity;
    public final List<ClientData> clients;

    public InstanceData(int capacity, List<ClientData> clients) {
        this.capacity = capacity;
        this.clients = clients;
    }
}
