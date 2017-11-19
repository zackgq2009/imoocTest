package com.tsingkuo.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnykuo on 2017/11/3.
 */
public class SAXParserHandler extends DefaultHandler {
    int bookCount = 0;
    int bookChildrenCount;
    String elementValue;
    Book book;
    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始---------------------------------------------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束---------------------------------------------------------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("book")) {
            book = new Book();
            bookList.add(book);
            bookChildrenCount = 0;
            bookCount++;
            System.out.println("解析第" + bookCount + "本书开始--------------");
//            //当用户知道某一个节点下的属性名称的时候，可以直接用.getValue("id")方法
//            String attValue = attributes.getValue("id");
//            System.out.println("第" + bookCount + "本书的id属性值为：" + attValue);
            for (int i = 0; i<attributes.getLength(); i ++) {
                String attValue = attributes.getValue(i);
                String attName = attributes.getQName(i);
                System.out.println("第" + bookCount + "本书的" + attName + "属性值为：" + attValue);
                if (attName.equals("id")) {
                    book.setBookId(attValue);
                }
            }
//            book.setBookId(attValue);
        } else if (!qName.equals("bookstore")) {
            bookChildrenCount++;
            System.out.print("第" + bookCount + "本书的第" + bookChildrenCount + "个子节点的名称为： " + qName + "   ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("name")) {
            book.setBookName(elementValue);
        } else if (qName.equals("author")) {
            book.setBookAuthor(elementValue);
        } else if (qName.equals("year")) {
            book.setBookYear(elementValue);
        } else if (qName.equals("price")) {
            book.setBookprice(elementValue);
        } else if (qName.equals("language")) {
            book.setBookLanguage(elementValue);
        }
        if (qName.equals("book")) {
            System.out.println("解析第" + bookCount + "本书结束--------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String string = new String(ch, start, length);
        if (!string.trim().equals(""))  {
            System.out.println(string.trim());
            elementValue = string.trim();
        }
    }
}
