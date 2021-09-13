package ghareeb.gatewaymanager.controller;

import ghareeb.gatewaymanager.dto.JsonBody;
import ghareeb.gatewaymanager.dto.ResponseMessage;
import ghareeb.gatewaymanager.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class GatewayRest {

    private EntityService entityService;

    @Autowired
    public GatewayRest(EntityService entityService) {
        this.entityService = entityService;
    }

    // get Json and call add entity from entity service
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseMessage addEntity(@RequestBody JsonBody jsonBody) {
        return entityService.addEntity(jsonBody);
    }
}
