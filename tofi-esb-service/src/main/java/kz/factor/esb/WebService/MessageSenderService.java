package kz.factor.esb.WebService;

import kz.factor.resources.tofischema.MessageDataType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Erlan.Ibraev on 09.07.2016.
 */
@Endpoint
public class MessageSenderService {
    public static final String NAMESPACE_URI = "http://www.factor.kz/resources/TOFISchema";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart="MessageData")
    @ResponsePayload
    public MessageDataType sendMessage(@RequestPayload MessageDataType message) {
        MessageDataType result = new MessageDataType();
        return result;
    }
}
