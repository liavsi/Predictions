package engine;

import engine.world.World;
import engine.world.entity.Entity;
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
        Engine currEngine = new Engine();
        try {
            InputStream inputStream = new FileInputStream(new File(XML_FILE_PATH));
            PRDWorld generatedWorld = deserializedFrom(inputStream);
            currEngine.loadWorldFromGeneratedWorld(generatedWorld);
            System.out.println(currEngine.getWorld());
        }catch(JAXBException | FileNotFoundException e){
            e.printStackTrace();
        }
        //showSimulationData(currEngine.createNewSimulation());
    }

    private static void showSimulationData(SimulationOutcome newSimulation) {

    }
    private static PRDWorld deserializedFrom(InputStream in)throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (PRDWorld) u.unmarshal(in);
    }
}
