package engine.world.design.reader.api;

import schema.generated.*;

public interface Reader {

    void readWorldFromXml(String XML_PATH, String JAXB_XML_PACKAGE_NAME);

}
