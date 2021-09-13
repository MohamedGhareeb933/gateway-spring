package ghareeb.gatewaymanager.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private short id;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date date;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "gateways_id")
    private Gateways gateways;


    public Device() {
    }

    public Device(String vendor, Date date, boolean status, Gateways gateways) {
        this.vendor = vendor;
        this.date = date;
        this.status = status;
        this.gateways = gateways;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Gateways getGateways() {
        return gateways;
    }

    public void setGateways(Gateways gateways) {
        this.gateways = gateways;
    }
}
