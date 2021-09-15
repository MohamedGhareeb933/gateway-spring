package ghareeb.gatewaymanager.dao;

import ghareeb.gatewaymanager.entity.Gateways;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "gateways", path = "gateways")
public interface GatewaysRepository extends JpaRepository<Gateways, Long> {
    
}