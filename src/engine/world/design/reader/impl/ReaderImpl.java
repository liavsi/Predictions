package engine.world.design.reader.impl;

import engine.world.design.api.World;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.definition.entity.impl.EntityDefinitionImpl;
import engine.world.design.definition.environment.api.EnvVariablesManager;
import engine.world.design.definition.environment.impl.EnvVariablesManagerImpl;
import engine.world.design.definition.property.api.PropertyDefinition;
import engine.world.design.definition.property.api.PropertyType;
import engine.world.design.definition.property.impl.BooleanPropertyDefinition;
import engine.world.design.definition.property.impl.FloatPropertyDefinition;
import engine.world.design.definition.property.impl.IntegerPropertyDefinition;
import engine.world.design.definition.property.impl.StringPropertyDefinition;
import engine.world.design.definition.value.generator.api.ValueGeneratorFactory;
import engine.world.design.execution.entity.Entity;
import engine.world.design.impl.WorldImpl;
import engine.world.design.reader.api.Reader;
import engine.world.property.EnvironmentProperty;
import engine.world.property.Property;
import schema.generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderImpl implements Reader {

    World createdWorld;
    PRDWorld prdWorld;

    public ReaderImpl() {
        createdWorld = new WorldImpl();
    }
    @Override
    public void readWorldFromXml(String XML_PATH, String JAXB_XML_PACKAGE_NAME) {
        try {
            InputStream inputStream = new FileInputStream(new File(XML_PATH));
            prdWorld = deserializedFrom( JAXB_XML_PACKAGE_NAME, inputStream);
            readPRDWorld();
        }catch(JAXBException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static PRDWorld deserializedFrom(String JAXB_XML_PACKAGE_NAME, InputStream in)throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (PRDWorld) u.unmarshal(in);
    }

    private void readPRDWorld() {

        buildEntitiesFromPRD(prdWorld.getPRDEntities());
        buildEnvironmentFromPRD(prdWorld.getPRDEvironment());
        buildRulesFromPRD(prdWorld.getPRDRules());
        buildTerminationFromPRD(prdWorld.getPRDTermination());
    }

    private void buildTerminationFromPRD(PRDTermination prdTermination) {

    }

    private void buildRulesFromPRD(PRDRules prdRules) {

    }

    /**
     * this code is responsible for creating Property definition from the correct Type
     */
    private void buildEnvironmentFromPRD(PRDEvironment prdEvironment) {
        EnvVariablesManager envVariablesManager = new EnvVariablesManagerImpl();
        for(PRDEnvProperty prdEnvProperty: prdEvironment.getPRDEnvProperty()) {
            switch (prdEnvProperty.getType()) {
                case "decimal":
                    envVariablesManager.addEnvironmentVariable(createDecimalPropertyDefinition(prdEnvProperty));
                    break;
                case "float":
                    envVariablesManager.addEnvironmentVariable(createFloatPropertyDefinition(prdEnvProperty));
                    break;
                case "boolean":
                    envVariablesManager.addEnvironmentVariable(createBooleanPropertyDefinition(prdEnvProperty));
                    break;
                case "string":
                    envVariablesManager.addEnvironmentVariable(createStringPropertyDefinition(prdEnvProperty));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + prdEnvProperty.getType());
            }
        }
        createdWorld.setEnvVariablesManager(envVariablesManager);
    }
    private PropertyDefinition createStringPropertyDefinition(Object i_prdProperty) {
        PropertyDefinition res = null;
        if( i_prdProperty instanceof PRDEnvProperty) {
            PRDEnvProperty prdEnvProperty = (PRDEnvProperty) i_prdProperty;
            String name = prdEnvProperty.getPRDName();
            res = new StringPropertyDefinition(name, ValueGeneratorFactory.createRandomString());
        }
        else {
            if (i_prdProperty instanceof PRDProperty) {
                PRDProperty prdProperty = (PRDProperty) i_prdProperty;
                PRDValue prdValue = prdProperty.getPRDValue();
                String name = prdProperty.getPRDName();
                if(prdValue.isRandomInitialize()) {
                    res = new StringPropertyDefinition(name, ValueGeneratorFactory.createRandomString());
                }
                else {
                    res = new StringPropertyDefinition(name, ValueGeneratorFactory.createFixed(prdValue.getInit()));
                }
            }
        }
        if(res == null) {
            throw new IllegalArgumentException(i_prdProperty.toString() + "is not expected type");
        }
        return res;

    }
    private PropertyDefinition createBooleanPropertyDefinition(Object i_prdProperty) {
        PropertyDefinition res = null;
        if(i_prdProperty instanceof PRDEnvProperty) {
            PRDEnvProperty prdEnvProperty = (PRDEnvProperty) i_prdProperty;
            String name = prdEnvProperty.getPRDName();
            res = new BooleanPropertyDefinition(name, ValueGeneratorFactory.createRandomBoolean());
        }
        else if( i_prdProperty instanceof PRDProperty) {
            PRDProperty prdProperty = (PRDProperty) i_prdProperty;
            PRDValue prdValue = prdProperty.getPRDValue();
            String name = prdProperty.getPRDName();
            if(prdValue.isRandomInitialize()) {
                res = new BooleanPropertyDefinition(name, ValueGeneratorFactory.createRandomBoolean());
            }
            else {
                res = new BooleanPropertyDefinition(name, ValueGeneratorFactory.createFixed(PropertyType.BOOLEAN.convert(prdValue.getInit())));
            }
        }
        if(res == null) {
            throw new IllegalArgumentException(i_prdProperty.toString() + "is not expected type");
        }
        return res;
    }


    private PropertyDefinition createFloatPropertyDefinition(Object i_prdProperty) {
        PropertyDefinition res = null;
        if(i_prdProperty instanceof PRDEnvProperty) {
            PRDEnvProperty prdEnvProperty = (PRDEnvProperty) i_prdProperty;
            Float from = PropertyType.FLOAT.convert(prdEnvProperty.getPRDRange().getFrom());
            Float to = PropertyType.FLOAT.convert(prdEnvProperty.getPRDRange().getTo());
            String name = prdEnvProperty.getPRDName();
            res = new FloatPropertyDefinition(name, ValueGeneratorFactory.createRandomFloat(from, to));
        }
        else if( i_prdProperty instanceof PRDProperty) {
            PRDProperty prdProperty = (PRDProperty) i_prdProperty;
            PRDValue prdValue = prdProperty.getPRDValue();
            String name = prdProperty.getPRDName();
            Float from = PropertyType.FLOAT.convert(prdProperty.getPRDRange().getFrom());
            Float to = PropertyType.FLOAT.convert(prdProperty.getPRDRange().getTo());
            if(prdValue.isRandomInitialize()) {
                res = new FloatPropertyDefinition(name, ValueGeneratorFactory.createRandomFloat(from,to));
            }
            else {
                res = new FloatPropertyDefinition(name, ValueGeneratorFactory.createFixed(PropertyType.FLOAT.convert(prdValue.getInit())));
            }
        }
        if(res == null) {
            throw new IllegalArgumentException(i_prdProperty.toString() + "is not expected type");
        }
        return res;
    }
    private PropertyDefinition createDecimalPropertyDefinition(Object i_prdProperty) {
        PropertyDefinition res = null;
        if(i_prdProperty instanceof PRDEnvProperty) {
            PRDEnvProperty prdEnvProperty = (PRDEnvProperty) i_prdProperty;
            Integer from = PropertyType.DECIMAL.convert(prdEnvProperty.getPRDRange().getFrom());
            Integer to = PropertyType.DECIMAL.convert(prdEnvProperty.getPRDRange().getTo());
            String name = prdEnvProperty.getPRDName();
            res = new IntegerPropertyDefinition(name, ValueGeneratorFactory.createRandomInteger(from, to));
        }
        else if( i_prdProperty instanceof PRDProperty) {
            PRDProperty prdProperty = (PRDProperty) i_prdProperty;
            PRDValue prdValue = prdProperty.getPRDValue();
            String name = prdProperty.getPRDName();
            Integer from = PropertyType.DECIMAL.convert(prdProperty.getPRDRange().getFrom());
            Integer to = PropertyType.DECIMAL.convert(prdProperty.getPRDRange().getTo());
            if(prdValue.isRandomInitialize()) {
                res = new IntegerPropertyDefinition(name, ValueGeneratorFactory.createRandomInteger(from,to));
            }
            else {
                res = new IntegerPropertyDefinition(name, ValueGeneratorFactory.createFixed(PropertyType.DECIMAL.convert(prdValue.getInit())));
            }
        }
        if(res == null) {
            throw new IllegalArgumentException(i_prdProperty.toString() + "is not expected type");
        }
        return res;
    }

    /**
     * this code is responsible for creating the Entities from the PRD files
     */
    private void buildEntitiesFromPRD(PRDEntities prdEntities) {
        Map<String, EntityDefinition> entities = new HashMap<>();
        for (PRDEntity prdEntity: prdEntities.getPRDEntity()){
            EntityDefinition currEntity = new EntityDefinitionImpl(prdEntity.getName(), prdEntity.getPRDPopulation());
            for (PRDProperty prdProperty : prdEntity.getPRDProperties().getPRDProperty()) {
                switch (prdProperty.getType()) {
                    case "decimal":
                        currEntity.getProps().add(createDecimalPropertyDefinition(prdProperty));
                        break;
                    case "float":
                        currEntity.getProps().add(createFloatPropertyDefinition(prdProperty));
                        break;
                    case "boolean":
                        currEntity.getProps().add(createBooleanPropertyDefinition(prdProperty));
                        break;
                    case "string":
                        currEntity.getProps().add(createStringPropertyDefinition(prdProperty));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + prdProperty.getType());
                }
            }
            String entityName = prdEntity.getName();
            entities.put(entityName, currEntity);
        }
        createdWorld.setEntities(entities);
    }

    private void readPRDEntity(PRDEntity prdEntity) {

    }

    private void readPRDRules(PRDRules prdRules) {

    }


    private void readPRDEnv(PRDEnvProperty prdEnvProperty) {

    }
}
