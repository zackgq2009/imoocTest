package com.tsingkuo.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.List;

/**
 * Created by johnnykuo on 2017/11/4.
 */
public class JDOMTest {

    public void createXML() {
        //创建Document对象，在创建的过程中我们可以直接传根节点对象，也可以不传
        Document document = new Document();
        //创建根节点，并且把它给设置到Document对象中去
        Element rss = new Element("rss");
        rss.setAttribute("version", "2.0");
        document.setRootElement(rss);

        Element bookStore = new Element("bookStore");
        rss.addContent(bookStore);

        Element book = new Element("book");
        book.setAttribute("id", "1");
        bookStore.addContent(book);

        Element name = new Element("name");
        name.setText("<冰与火之歌>");
        book.addContent(name);

        Format format = Format.getPrettyFormat();
//        format.setIgnoreTrAXEscapingPIs(true);
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(document, new FileOutputStream(new File("JDOMBooks.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseXML() {
        //不同于DOM跟SAX，不需要先有工厂模式，我们直接直接new出来SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            //SAXBuilder对象通过.build()方法，直接生成解析了xml文件的Document对象
            Document document = saxBuilder.build(new InputStreamReader(new FileInputStream("books.xml")));
            System.out.println("----------------------------------------------解析开始————————————————————————————----------------------");
            //通过.getRootElement()方法获取根节点
            Element rootElement = document.getRootElement();
            //通过.getChildren()方法获取到根节点的子节点
            List<Element> bookList = rootElement.getChildren();
            for (Element book : bookList
                    ) {
                int bookCount = bookList.indexOf(book) + 1;
                System.out.println("解析第" + bookCount + "本书------------");
                //通过.getAttributes()方法获取到节点的所有属性
                List<Attribute> attributes = book.getAttributes();
                for (Attribute attribute : attributes
                        ) {
                    //通过.getName跟.getValue来获取到属性的属性名跟属性值
                    System.out.println("属性名： " + attribute.getName() + "   属性值： " + attribute.getValue());
                }
                List<Element> elements = book.getChildren();
                for (Element element : elements
                        ) {
                    int elementCount = elements.indexOf(element) + 1;
                    //通过.getName跟.getValue方法，同样可以获取到节点名跟节点中的文本内容
                    System.out.println("第" + elementCount + "子节点，  节点名：" + element.getName() + "   节点值：" + element.getValue().trim());
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------解析结束-----------------------------------------------------");
    }

    public static void main(String[] args) {
        new JDOMTest().createXML();
    }
}
