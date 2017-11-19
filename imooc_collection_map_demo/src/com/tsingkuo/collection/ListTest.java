package com.tsingkuo.collection;

import java.util.*;

/**
 * Created by johnnykuo on 2017/10/20.
 */
public class ListTest {
    private List coursesToSelect; //用于存放备选课程的List

    public ListTest() {
        this.coursesToSelect = new ArrayList(); //初始化这个list
    }

    public List getCoursesToSelect() {
        return coursesToSelect;
    }

    public void setCoursesToSelect(List coursesToSelect) {
        this.coursesToSelect = coursesToSelect;
    }

    /**
     * 用于往coursesToSelect中添加备选课程
     */
    public void testAdd() {
        Courses cr1 = new Courses("1", "数据结构");
        coursesToSelect.add(cr1);
        Courses temp = (Courses) coursesToSelect.get(0); //由于list  get出来的是object类型元素，所以我们需要强制把他转换为Courses
        System.out.println("第一个备选课程：" + temp.getName());

        Courses cr2 = new Courses("2", "C语言");
        coursesToSelect.add(0, cr2);
        Courses temp2 = (Courses) coursesToSelect.get(0);
        System.out.println("第二个备选课程：" + temp2.getName());

        coursesToSelect.add(cr1);
        Courses temp7 = (Courses) coursesToSelect.get(2); //由于list  get出来的是object类型元素，所以我们需要强制把他转换为Courses
        System.out.println("第qi个备选课程：" + temp7.getName());

        /**
         * 下边的例子是一个错误示范，我们add的index已经超出了list的长度了，index最大只能是跟集合的长度相等，不能大于集合长度，所以add的index这个时候最大只能是2
         */
//        Courses cr3 = new Courses("3", "test");
//        coursesToSelect.add(4, cr3);

        Courses[] cr3 = {new Courses("3", "离散数学"), new Courses("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(cr3)); //list中无法直接add数组，我们需要先将数组转化为list才能add进去
        Courses temp3 = (Courses) coursesToSelect.get(3);
        Courses temp4 = (Courses) coursesToSelect.get(4);
        System.out.println("第三个跟第四个备选课程：" + temp3.getName() + ";" + temp4.getName());

        Courses[] cr4 = {new Courses("5", "高等数学"), new Courses("6", "大学英语")};
        coursesToSelect.addAll(2, Arrays.asList(cr4));
        Courses temp5 = (Courses) coursesToSelect.get(2);
        Courses temp6 = (Courses) coursesToSelect.get(3);
        System.out.println("第五个跟第六个备选课程：" + temp5.getName() + ";" + temp6.getName());
    }

    /**
     * 取得List中的元素的方法
     * @param
     */
    public void testGet() {
        int size = coursesToSelect.size();
        for (int i=0; i< size; i++) {
            Courses cr = (Courses) coursesToSelect.get(i);
            System.out.println("通过for循环查看所有的元素：" + cr.getName());
        }
    }

    /**
     * 通过迭代器来遍历List， Iterator就是迭代器的意思
     */
    public void testIterator() {
        Iterator iterator = coursesToSelect.iterator();
        while (iterator.hasNext()) {
            Courses cr = (Courses) iterator.next();
            System.out.println("通过Iterator迭代器来查看所有的元素：" + cr.getName());
        }
    }

    /**
     * 通过for each来遍历List，foreach方法其实就是迭代器的简便写法
     */
    public void testForEach() {
        for (Object object : coursesToSelect) {
            Courses cr = (Courses) object;
            System.out.println("通过for each方法来查看所有的元素：" + cr.getName());
        }
    }

    /**
     * 修改list中的元素
     */
    public void testModify() {
        coursesToSelect.set(4, new Courses("8", "毛概"));
    }

    /**
     * 集合的删除有三种模式
     * 第一：remove(index)
     * 第二：remove(object)，集合会删除第一个与这个对象相吻合的元素
     * 第三：removeAll(collection)，集合会删除所有collection提供的对象
     */
    public void testRemove() {
        coursesToSelect.remove(3);
        Courses cr = (Courses) coursesToSelect.get(3);
        System.out.println(cr.getName());
        coursesToSelect.remove(cr);
        Courses[] crs = {(Courses) coursesToSelect.get(3), new Courses("9", "大学语文")};
        coursesToSelect.removeAll(Arrays.asList(crs));
    }

    /**
     * 方法的目的是往这个集合中加入一些其他类型的东西
     */
    public void testType() {
        coursesToSelect.add("加入一个字符串");
        System.out.println(coursesToSelect.get(7));
    }

    public void testListContains() {
        Courses course = (Courses) coursesToSelect.get(1);
        System.out.println(course.getName() + "是否在系统中：" + coursesToSelect.contains(course));
        Courses course2 = new Courses(course.getId(), course.getName());
        System.out.println(course2.getName() + "是否在系统中：" + coursesToSelect.contains(course2));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的课程名称：");
        String name = scanner.next();
        Courses course3 = new Courses();
        course3.setName(name);
        System.out.println(course3.getName() + "是否在系统中：" + coursesToSelect.contains(course3));
    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
//        lt.testType();
//        lt.testGet();
        lt.testListContains();
//        lt.testIterator();
//        lt.testModify();
//        lt.testForEach();
//        lt.testRemove();
//        lt.testForEach();
    }
}
