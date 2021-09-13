package ghareeb.gatewaymanager.dao;

import ghareeb.gatewaymanager.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "devices", path = "devices")
public interface DeviceRepository extends JpaRepository<Device, Short> {
}