package com.tsingkuo.collection;

import java.util.*;

/**
 * Created by johnnykuo on 2017/10/25.
 */
public class CollectionsTest {

    /**
     * 通过Collection.sort()方法，对Integer泛型的List进行排序；
     * 创建一个Integer泛型的List，插入是个100以内的不重复随机整数；
     * 调用Collection.sort()方法对其进行排序
     */
    public void testSort() {
        Random random = new Random(); //如果代码中一个变量会重复使用，那么就在方法的最初时间就创建这个对象出来，不要以后重复反复的new一个新的对象
        List<Integer> integerList = new ArrayList<Integer>();
        Integer integer;
        for (int i = 0; i< 10; i++) {
            do {
                integer = random.nextInt(100);
            } while (integerList.contains(integer));
            integerList.add(integer);
        }
        System.out.println("------------------排列前---------------------");
        for (Integer integer1: integerList
             ) {
            System.out.println("数值：" + integer1);
        }
        System.out.println("------------------排列后----------------------");
        Collections.sort(integerList);
        for (Integer integer2: integerList
             ) {
            System.out.println("数值：" + integer2);
        }
    }

    /**
     * 对String泛型的List进行排序；
     * 创建String泛型的List, 添加三个乱序的String元素；
     * 调用sort方法，再次输出排序后的顺序
     */
    public void testStringSort() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("liupl");
        stringList.add("guoqing");
        stringList.add("wulei");
        System.out.println("-----------------------排列前-----------------------");
        for (String string : stringList
                ) {
            System.out.println("内容：" + string);
        }
        System.out.println("-----------------------排列后------------------------");
        Collections.sort(stringList);
        for (String string : stringList
                ) {
            System.out.println("内容：" + string);
        }
    }

    /**
     * 1.创建完List<String>之后，往其中添加十条随机字符串
     * 2.每条字符串的长度为10以内的随机整数
     * 3.每条字符串的每个字符都为随机生成的字符，字符可以重复
     * 4.每条随机字符串不可重复
     */
    public void testRandomStringSort() {
        Random random = new Random();
        String baseString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        List<String> stringList = new ArrayList<>();
        for (int i=0; i< 10; i++) {
            String newString;
            do {
                newString = "";
                for (int j=0; j< random.nextInt(10); j++) {
                    char word = baseString.charAt(random.nextInt(baseString.length()));
                    newString += word;
                }
            } while (stringList.contains(newString));
            stringList.add(newString);
        }
        System.out.println("-----------------------------排列前----------------------------");
        for (String string : stringList
                ) {
            System.out.println(string);
        }
        System.out.println("-----------------------------排列后-----------------------------");
        Collections.sort(stringList);
        for (String string : stringList
                ) {
            System.out.println(string);
        }
    }

    /**
     * 测试针对Students类型的List进行排序
     */
    public void testStudentsSort() {
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("90", "tim"));
        studentsList.add(new Students("2", "tom"));
        studentsList.add(new Students("3", "qing"));
        System.out.println("--------------------------排序前------------------------");
        for (Students student : studentsList
                ) {
            System.out.println(student.getId() + ": " + student.getName());
        }
        Collections.sort(studentsList); //此处的sort()是通过Students类中实现的CompareTo() 方法中的比较逻辑进行的排序，此排序是默认排序
        System.out.println("--------------------------排序后-------------------------");
        for (Students student : studentsList
                ) {
            System.out.println(student.getId() + ": " + student.getName());
        }
        System.out.println("--------------------------按照名字进行排序--------------------");
        Collections.sort(studentsList, new StudentsComparator());   //此处的sort() 则是通过实现了Comparator<Students>类中的compare()方法中的比较逻辑来实现排序的，此排序则是临时排序
        for (Students student : studentsList
                ) {
            System.out.println(student.getId() + ": " + student.getName());
        }
    }

    public static void main(String[] args) {
        CollectionsTest collectionsTest = new CollectionsTest();
        collectionsTest.testSort();
        collectionsTest.testStringSort();
        collectionsTest.testRandomStringSort();
        collectionsTest.testStudentsSort();
    }
}
