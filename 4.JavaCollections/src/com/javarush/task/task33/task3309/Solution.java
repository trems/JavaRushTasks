package com.javarush.task.task33.task3309;

import org.jvnet.staxex.XMLStreamWriterEx;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, stringWriter);

        String tag = "<"+tagName;
        String comm = "<!--"+comment+"-->";
        String result = stringWriter.toString();

        return null;
    }

    public static void main(String[] args) {

    }
}
