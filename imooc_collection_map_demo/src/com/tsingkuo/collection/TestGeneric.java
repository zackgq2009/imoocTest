package com.tsingkuo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnykuo on 2017/10/20.
 */
public class TestGeneric {

    private List<Courses> courses;

    public TestGeneric() {
        this.courses = new ArrayList<Courses>();
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public List<Courses> getCourses() {

        return courses;
    }

    public void testAdd() {
        Courses cr1 = new Courses("1", "大学英语");
        courses.add(cr1);
//        courses.add("alskdjfl;as");    泛型集合中，不能添加泛型规定的类型以外的对象，否则会报错！
        Courses cr2 = new Courses("2", "Java基础");
        courses.add(cr2);
    }

    public void testForEach() {
        for (Courses cr : courses) {
            System.out.println(cr.getName());
        }
    }

    public static void main(String[] args) {
        TestGeneric tg = new TestGeneric();
        tg.testAdd();
        tg.testForEach();
    }
}
