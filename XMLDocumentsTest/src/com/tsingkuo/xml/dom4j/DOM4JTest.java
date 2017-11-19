package com.tsingkuo.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;

/**
 * Created by johnnykuo on 2017/11/4.
 */
public class DOM4JTest {

    public void createXML() {
        //先生成Document对象用来编辑我们的XML内容
        Document document = DocumentHelper.createDocument();
        Element rss = document.addElement("rss");
        rss.addAttribute("version", "2.0");
        Element bookStore = rss.addElement("bookStore");
        Element book = bookStore.addElement("book");
        book.addAttribute("id", "1");
        Element name = book.addElement("name");
        name.setText("<冰与火之歌>");

        try {
            //通过OutputFormat.createPrettyPrint()静态方法生成一个OutputFormat对象
            OutputFormat format = OutputFormat.createPrettyPrint();
            //OutputFormat对象可以设置编码类型
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(new File("DOM4JRSS.xml")), format);
            //writer对象可以设置是否要进行转义
            writer.setEscapeText(false);
            writer.write(document);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseXML() {
        //同样不需要先有工厂模式，直接new出来一个SAXReader对象
        SAXReader saxReader = new SAXReader();
        try {
            //DOM4J是通过.read()方法来获取到解析出来的Document对象的
            Document document = saxReader.read(new InputStreamReader(new FileInputStream("books.xml")));
            System.out.println("-------------------------------------------开始解析---------------------------------------------");
            //DOM4J中也是通过.getRootElement()方法来获取到根节点的
            Element rootElement = document.getRootElement();
            //DOM4J中最重要的就是获取子节点，不是通过.getChildren，而是通过.elementIterator()方法来获取到
            Iterator<Element> books = rootElement.elementIterator();
            //对书的数量进行计数
            int bookCount = 0;
            //开始迭代
            while (books.hasNext()) {
                Element book = books.next();
                System.out.println("解析第" + (bookCount + 1) + "本书---------");
                bookCount++;
                //生成属性的迭代器
                Iterator<Attribute> bookAttributes = book.attributeIterator();
                int attributeCount = 0;
                while (bookAttributes.hasNext()) {
                    Attribute attribute = bookAttributes.next();
                    //通过.getName()跟.getValue()方法获取到属性名跟属性值
                    System.out.println("第" + (attributeCount + 1) + "属性， 其属性名： " + attribute.getName() + "   属性值：" + attribute.getValue());
                    attributeCount++;
                }
                //生成子节点的迭代器
                Iterator<Element> elementIterator = book.elementIterator();
                //节点数进行计数
                int elementCount = 0;
                while (elementIterator.hasNext()) {
                    Element element = elementIterator.next();
                    System.out.println("第" + (elementCount + 1) + "子节点，  " + "节点名：" + element.getName() + "    节点值：" + element.getStringValue().trim());
                    elementCount++;
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------结束解析--------------------------------------------");
    }



    public static void main(String[] args) {
            new DOM4JTest().createXML();
    }
}
