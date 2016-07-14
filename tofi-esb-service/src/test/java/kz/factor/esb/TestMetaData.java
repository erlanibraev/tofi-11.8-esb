package kz.factor.esb;

import kz.factor.resources.tofischema.MetadataType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Erlan.Ibraev on 14.07.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class TestMetaData {
    @Value("${local.server.port}")
    private int port = 0;

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();


    @Before
    public void createClient() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(MetadataType.class));
        marshaller.afterPropertiesSet();
    }


    @Test
    public void testReadMetaData() {
        MetadataType metadata = getMetadata();
        System.out.println(metadata.getOwners().getOwner().get(0).getCode());
    }

    @Test
    public void testWS() throws InterruptedException {
        MetadataType request = getMetadata();
        assertNotNull(new WebServiceTemplate(marshaller).marshalSendAndReceive("http://localhost:" + port + "/ws", request));

    }

    private MetadataType getMetadata() {
        Source source = new StreamSource(this.getClass().getClassLoader().getResourceAsStream("testMetaData.xml"));
        JAXBElement<MetadataType> jaxbElement = (JAXBElement<MetadataType>) marshaller.unmarshal(source);
        MetadataType metadata = jaxbElement.getValue();
        return metadata;
    }

}
