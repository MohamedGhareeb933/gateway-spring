package ghareeb.gatewaymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ServiceConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    ServiceConfig(EntityManager entityManager) {this.entityManager = entityManager;}

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        ExposeId(config);
    }

    // Expose the Entity ID
    private void ExposeId(RepositoryRestConfiguration config) {

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClass = new ArrayList<>();

        // get the Java Type of entity and push into List
        for(EntityType entity : entities) {
            entityClass.add(entity.getJavaType());
        }

        // Map the Collection into array and Expose the id
        Class[] domainType = entityClass.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}
