package com.tsingkuo.xml.sax;

import com.sun.tools.doclets.internal.toolkit.util.DocFinder;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by johnnykuo on 2017/11/3.
 */
public class SAXTest {
    public void parseXML() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler saxParserHandler = new SAXParserHandler();
            saxParser.parse("books.xml", saxParserHandler);
            List<Book> books = saxParserHandler.getBookList();
            for (Book book : books
                    ) {
                System.out.println(book.getBookId() + book.getBookName() + book.getBookAuthor() + book.getBookYear() + book.getBookprice() + book.getBookLanguage());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createXML() {
        //先有工厂模式，这里是SAXTransformerFactory工厂
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            //然后再有TransformerHandler对象
            TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
            //再有Transformer对象
            Transformer transformer = transformerHandler.getTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformerHandler.setResult(new StreamResult(new FileOutputStream(new File("SAXbooks.xml"))));
            transformerHandler.startDocument();
            AttributesImpl attributes = new AttributesImpl();
            attributes.clear();
            transformerHandler.startElement("", "", "bookStore", attributes);
            attributes.clear();
            attributes.addAttribute("", "", "id", "", "1");
            transformerHandler.startElement("", "", "book", attributes);
            attributes.clear();
            transformerHandler.startElement("", "", "name", attributes);
            transformerHandler.characters("冰与火之歌".toCharArray(),0,5);
            transformerHandler.endElement("", "", "name");
            attributes.clear();
            transformerHandler.startElement("", "", "author", attributes);
            transformerHandler.characters("乔治马丁".toCharArray(), 0, 4);
            transformerHandler.endElement("","","author");
            transformerHandler.endElement("", "", "book");
            transformerHandler.endElement("","","bookStore");
            transformerHandler.endDocument();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SAXTest().createXML();
    }
}
