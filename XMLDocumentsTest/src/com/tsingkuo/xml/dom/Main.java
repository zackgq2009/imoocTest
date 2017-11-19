package com.tsingkuo.xml.dom;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    public void createXML() {
        //创建工厂，并且new出来DocumentBuilder对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            document.setXmlStandalone(true);
            Element bookstore = document.createElement("bookstore");
            Element book = document.createElement("book");
            book.setAttribute("id", "1");
            Element name = document.createElement("name");
            name.setTextContent("冰与火之歌");
            book.appendChild(name);
            bookstore.appendChild(book);
            document.appendChild(bookstore);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    public void parseXML() {
        //创建DocumentBuilderFactory对象，利用newInstance()方法
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        System.out.println("开始解析xml文件内容---------------------------------------------------");
        try {
            //创建DocumentBuilder对象，通过newDocumentBuilder()方法
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //创建Document对象，这个类是在org.w3c.dom包里边，通过parse()方法
            Document document = documentBuilder.parse("books.xml");
            //使用getElementsByXXX()方法
            NodeList bookList = document.getElementsByTagName("book");
            //貌似NodeList对象不好使用foreach跟iterator方法
            for (int i=0; i< bookList.getLength(); i++) {
                Node book = bookList.item(i);
                //获取节点所有的属性值
                NamedNodeMap atts = book.getAttributes();
                for (int j =0 ; j<atts.getLength(); j++) {
                    Node att = atts.item(j);
                    System.out.printf("获取到第" + (i+1)+ "个节点的第" + (j+1) + "个属性，其名称为：" + att.getNodeName());
                    System.out.println("其属性值为：" + att.getNodeValue());
                }
                System.out.println("开始获取所有节点的子节点内容--------------------------------------------------");
                int L = 1;
                //通过getChildNodes()方法来获取到所有的子节点
                NodeList childNodes = book.getChildNodes();
                for (int k=0; k<childNodes.getLength(); k++) {
                    Node childNode = childNodes.item(k);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.printf("获取到第" + (i + 1) + "个节点的第" + (L) + "个子节点：" + childNode.getNodeName());
                        //.getFirstChild().getNodeName()的组合方法只适合叶节点
//                        System.out.println("  其子节点的内容：" + childNode.getFirstChild().getNodeName());
                        System.out.println("  其子节点的内容：" + childNode.getTextContent());
                        L++;
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().createXML();
    }
}
