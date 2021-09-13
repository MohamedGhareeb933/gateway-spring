package ghareeb.gatewaymanager.service;

import ghareeb.gatewaymanager.dao.DeviceRepository;
import ghareeb.gatewaymanager.dao.GatewaysRepository;
import ghareeb.gatewaymanager.dto.JsonBody;
import ghareeb.gatewaymanager.dto.ResponseMessage;
import ghareeb.gatewaymanager.entity.Device;
import ghareeb.gatewaymanager.entity.Gateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class EntityServiceImple implements EntityService {

    // get DAO object for device and gateway
    private DeviceRepository deviceRepository;
    private GatewaysRepository gatewaysRepository;

    // global gateway object used in lambda
    private Gateways gateways;

    @Autowired
    public EntityServiceImple(DeviceRepository deviceRepository, GatewaysRepository gatewaysRepository) {
        this.deviceRepository = deviceRepository;
        this.gatewaysRepository = gatewaysRepository;
    }

    @Override
    public ResponseMessage addEntity(JsonBody jsonBody) {

        // generate uuid
        String serial = GenerateUUID();

        // save gateway and device object
        saveGateways(jsonBody, serial);

        return new ResponseMessage(serial);
    }

    public void saveGateways(JsonBody jsonBody, String serial) {

        // if the requested json has Gateway object
        // set gateway object from json - set serial - and save gateway
        if (jsonBody.getGateways() != null) {

            gateways = getGateway(jsonBody);

            gateways.setSerial(serial);

            gatewaysRepository.save(gateways);
        }

        // get device from json
        Set<Device> devices = getDevices(jsonBody);

        // iterate through the device list
        if (devices.size() > 0) {
            devices.forEach(

                    device -> {
                        // if the device from json has gateway object then find that gateway object otherwise
                        // add the devices to the existing gateway in json object
                        if (device.getGateways() != null) {
                            gateways = findGateway(device);
                        }else {
                            gateways = getGateway(jsonBody);
                        }

                        // add device to gateway
                        gateways.add(device);

                        // if gateway is exist save gateway , otherwise save device
                        if (getGateway(jsonBody) != null) {
                            gatewaysRepository.save(gateways);
                        }else {
                            deviceRepository.save(device);
                        }
                    });
        }

    }

    // get gateway from json body
    public Gateways getGateway(JsonBody jsonBody) {
        return jsonBody.getGateways();
    }

    // find gateway that exist in device object
    public Gateways findGateway(Device device) {
        return gatewaysRepository.getById(device.getGateways().getId());
    }

    // get device from json
    public Set<Device> getDevices(JsonBody jsonBody) {
        return jsonBody.getDevices();
    }

    // generate uuid
    private String GenerateUUID() {
        return UUID.randomUUID().toString();
    }
}
