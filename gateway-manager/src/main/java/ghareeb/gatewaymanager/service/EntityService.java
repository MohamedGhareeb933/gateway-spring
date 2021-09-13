package ghareeb.gatewaymanager.service;

import ghareeb.gatewaymanager.dto.JsonBody;
import ghareeb.gatewaymanager.dto.ResponseMessage;

public interface EntityService {

    public ResponseMessage addEntity(JsonBody jsonBody);
}
