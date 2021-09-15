package ghareeb.gatewaymanager.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ghareeb.gatewaymanager.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "devices", path = "devices")
public interface DeviceRepository extends JpaRepository<Device, Short> {

    Page<Device> findAllDevicesByGatewaysId(@RequestParam("id") Long id, Pageable pageable);
}