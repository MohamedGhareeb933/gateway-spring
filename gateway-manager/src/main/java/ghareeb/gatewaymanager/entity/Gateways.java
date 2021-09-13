package ghareeb.gatewaymanager.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gateways")
public class Gateways {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "name")
    private String name;

    @Column(name = "ipv4_address")
    @Pattern(regexp = "\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b", message = "must be ip address ")
    private String ipAddress;

    @OneToMany(mappedBy = "gateways", cascade = CascadeType.ALL)
    Set<Device> devices = new HashSet<>();

    public Gateways() {
    }

    public Gateways(String serial, String name, String ipAddress, Set<Device> devices) {
        this.serial = serial;
        this.name = name;
        this.ipAddress = ipAddress;
        this.devices = devices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public void add(Device device){
        if (device != null) {
            if (devices == null) {
                devices = new HashSet<>();
            }else {
                devices.add(device);
                device.setGateways(this);
            }
        }
    }

}
