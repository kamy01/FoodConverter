package com.menu.converter.converter.impl;

import com.menu.converter.converter.Converter;
import com.menu.converter.file.InputStreamSelector;
import com.menu.converter.model.Food;
import com.menu.converter.model.Menu;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class XmlConverter implements Converter {

    public List<Food> getBreakfastFoodFrom(InputStream inputStream) {
        JAXBContext jaxbContext;
        Menu root = null;
        final List<Food> foods = new ArrayList<>();
        try {
            jaxbContext = JAXBContext.newInstance(Menu.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema menuXsd = sf.newSchema(new StreamSource(InputStreamSelector.getInputStreamFrom("menu.xsd")));
            jaxbUnmarshaller.setSchema(menuXsd);

            root = (Menu) jaxbUnmarshaller.unmarshal(inputStream);

        } catch (JAXBException | SAXException e) {
            log.error(e.getMessage(), e);
        }

        if (root != null) {
            Optional.ofNullable(root.getFood()).ifPresent(foods::addAll);
        }
        return foods;
    }
}
