package com.example.test.convertor.impl;

import com.example.test.convertor.Converter;
import com.example.test.file.FileSelector;
import com.example.test.model.Food;
import com.example.test.model.Menu;
import com.example.test.model.enums.XsdSource;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class XmlConverter implements Converter {

    public List<Food> getBreakfastFoodFrom(File file) {
        JAXBContext jaxbContext;
        Menu root = null;
        final List<Food> foods = new ArrayList<>();
        try {
            jaxbContext = JAXBContext.newInstance(Menu.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema menuXsd = sf.newSchema(FileSelector.getFile(getXsdSource(file)));
            jaxbUnmarshaller.setSchema(menuXsd);

            root = (Menu) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException | SAXException e) {
            log.error(e.getMessage(), e);
        }

        if (root != null) {
            Optional.ofNullable(root.getFood()).ifPresent(foods::addAll);
        }
        return foods;
    }

    private String getXsdSource(File file) {
        String filename = file.getName();
        switch (filename) {
            case "menu.xml":
                return XsdSource.MENU.toString();
            default:
                return XsdSource.UNKNOWN.toString();
        }

    }
}
