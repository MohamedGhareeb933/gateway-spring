package ghareeb.gatewaymanager.dto;

import ghareeb.gatewaymanager.entity.Device;
import ghareeb.gatewaymanager.entity.Gateways;

import java.util.HashSet;
import java.util.Set;

// json class , that has to properties , gateways and device list
public class JsonBody {

    private Gateways gateways;

    private Set<Device> devices = new HashSet<>();

    public JsonBody() {
    }

    public JsonBody(Gateways gateways, Set<Device> devices) {
        this.gateways = gateways;
        this.devices = devices;
    }

    public Gateways getGateways() {
        return gateways;
    }

    public void setGateways(Gateways gateways) {
        this.gateways = gateways;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
