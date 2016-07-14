package kz.factor.esb.service.impl;

import kz.factor.esb.service.IMetaDataService;
import kz.factor.resources.tofischema.MetadataType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Erlan.Ibraev on 14.07.2016.
 */
@Endpoint
public class MetaDataService implements IMetaDataService{

    @PayloadRoot(namespace = "http://www.factor.kz/resources/TOFISchema", localPart = "Metadata")
    @ResponsePayload
    @Override
    public String send(MetadataType metadata) {

        return "sended";
    }
}
