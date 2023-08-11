package engine;

import engine.impl.EngineImpl;
import schema.generated.PRDWorld;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TemporaryInterface {
    private static final String JAXB_XML_PACKAGE_NAME = "schema.generated";
    private static final String XML_FILE_PATH = "resources/master-ex1.xml";
    public static void main(String[] args) {
        EngineImpl currEngine = new EngineImpl();
        currEngine.readWorldFromXml(XML_FILE_PATH, JAXB_XML_PACKAGE_NAME);
        System.out.println(currEngine.toString());
        //showSimulationData(currEngine.createNewSimulation());
    }

    private static void showSimulationData(SimulationOutcome newSimulation) {

    }

}
