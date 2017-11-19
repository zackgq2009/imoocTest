package com.tsingkuo.collection;

import java.util.*;

/**
 * Created by johnnykuo on 2017/10/20.
 */
public class SetTest {
    public List<Courses> coursesToSelect;
    public Set<Courses> selectedCourses;

    public SetTest() {
        this.coursesToSelect = new ArrayList<Courses>();
        this.selectedCourses = new HashSet<Courses>();
    }

    public void setAdd(Students student) {
        Courses cr1 = new Courses("1", "数据结构");
        coursesToSelect.add(cr1);
//        Courses temp = coursesToSelect.get(0); //由于list  get出来的是object类型元素，所以我们需要强制把他转换为Courses
//        System.out.println("第一个备选课程：" + temp.getName());

        Courses cr2 = new Courses("2", "C语言");
        coursesToSelect.add(0, cr2);
//        Courses temp2 = coursesToSelect.get(0);
//        System.out.println("第二个备选课程：" + temp2.getName());

        coursesToSelect.add(cr1);
//        Courses temp7 = coursesToSelect.get(2); //由于list  get出来的是object类型元素，所以我们需要强制把他转换为Courses
//        System.out.println("第qi个备选课程：" + temp7.getName());

        Courses[] cr3 = {new Courses("3", "离散数学"), new Courses("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(cr3)); //list中无法直接add数组，我们需要先将数组转化为list才能add进去
//        Courses temp3 = coursesToSelect.get(3);
//        Courses temp4 = coursesToSelect.get(4);
//        System.out.println("第三个跟第四个备选课程：" + temp3.getName() + ";" + temp4.getName());

        Courses[] cr4 = {new Courses("5", "高等数学"), new Courses("6", "大学英语")};
        coursesToSelect.addAll(2, Arrays.asList(cr4));
//        Courses temp5 = coursesToSelect.get(2);
//        Courses temp6 = coursesToSelect.get(3);
//        System.out.println("第五个跟第六个备选课程：" + temp5.getName() + ";" + temp6.getName());

        System.out.println("所有课程在此：");
        for (Courses course : coursesToSelect) {
            System.out.println(course.getId() + ":" + course.getName());
        }
        System.out.println("欢迎" + student.getName() + "; 请选择你的三门课程");

        Scanner scanner = new Scanner(System.in);
        for (int i=0; i < 3; i++) {
            System.out.println("请输入你需要的课程编号");
            String courseId = scanner.next();
            for (Courses course : coursesToSelect) {
                if (courseId.equals(course.getId())) {
                    selectedCourses.add(course);
                }
            }
        }
        student.setCourses(selectedCourses);
    }

    public void setGet(Students student) {
        Set<Courses> courses = student.getCourses();
        System.out.println(student.getName() + "选择了：");
        for (Courses course : courses) {
            System.out.println(course.getId() + ":" + course.getName());
        }
    }

    public void testSetContains(Students student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新课程的名称：");
        String courseName = scanner.next();
        Courses course = new Courses();
        course.setName(courseName);
        System.out.println(student.getName() + "该学生是否选择了" + course.getName() + ": " + student.getCourses().contains(course));
    }

    public static void main(String[] args) {
        Students student = new Students("1", "小明");
        SetTest setTest = new SetTest();
        setTest.setAdd(student);
        setTest.setGet(student);
        setTest.testSetContains(student);
    }
}
