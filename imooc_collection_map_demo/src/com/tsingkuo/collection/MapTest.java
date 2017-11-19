package com.tsingkuo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by johnnykuo on 2017/10/21.
 */
public class MapTest {
    private Map<String, Students> students;

    public void setStudents(Map<String, Students> students) {
        this.students = students;
    }

    public Map<String, Students> getStudents() {

        return students;
    }

    public MapTest() {
        this.students = new HashMap<String, Students>();
    }

    /**
     * 测试如何往map中添加键值对
     */
    public void testPut() {
        Scanner scanner = new Scanner(System.in);
        for (int i =0; i<3; i++) {
            System.out.println("请输入学生的编号：");
            String stuId = scanner.next();
            Students student = students.get(stuId);
            if (student == null) {
                System.out.println("请输入此学生的姓名：");
                String studentName = scanner.next();
                Students newStudent = new Students(stuId, studentName);
                students.put(stuId, newStudent);
            } else {
                System.out.println("您输入的学生编号已经存在！");
            }
        }
        System.out.println("成功录入学生信息");
    }

    /**
     * 测试循环遍历map中key值的集合
     */
    public void testKeySet() {
        System.out.println("现在已经有" + students.size() + "个学生信息");
        for (String stuId : students.keySet()) {
            Students student = students.get(stuId);
            if (student != null) {
                System.out.println(student.getId() + ":" + student.getName());
            }
        }
    }

    /**
     * 测试删除Map中的映射
     */
    public void testRemove() {
        if (students.size() == 0) {
            System.out.println("系统中没有学生，您无法进行删除操作，请相关部门先录入相关学生信息");
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入您要删除的学生ID：");
                String stuId = scanner.next();
                if (students.get(stuId) == null) {
                    System.out.println("此学生不存在");
                    continue;
                } else {
                    Students removedStu = students.remove(stuId);
                    System.out.println("您已经删除了" + removedStu.getName());
                    break;
                }
            }
        }
    }

    /**
     * 测试entrySet() 方法
     */
    public void testEntrySet() {
        if (students.size() == 0) {
            System.out.println("系统中已经没有学生，全都被删除了");
        } else {
            System.out.println("还剩下" + students.size() + "个学生");
            Set<Map.Entry<String, Students>> lastStudents = students.entrySet();
            for (Map.Entry<String, Students> entry : lastStudents) {
//                Students student = (Students) entry.getValue();
                System.out.println(entry.getKey() + ":" + entry.getValue().getName());
            }
        }
    }

    /**
     * 测试map中通过put()方法来修改键值对
     */
    public void testPutModify() {
        if (students.size() == 0) {
            System.out.println("系统中已经没有学生了，您无法进行修改操作");
        } else {
            System.out.println("请输入你需要修改的学生的Id：");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String studentId = scanner.next();
                if (students.get(studentId) == null) {
                    System.out.println("此学生不存在，请重新输入您要修改的学生Id:");
                    continue;
                } else {
                    Students firstStudent = students.get(studentId);
                    System.out.println("之前学生名字：" + firstStudent.getName());
                    System.out.println("请输入学生的新名字：");
                    Scanner scanner1 = new Scanner(System.in);
                    Students secondStudent = new Students(studentId, scanner1.next());
                    students.put(studentId, secondStudent);
                    System.out.println("修改后的学生名字：" + students.get(studentId).getName());
                    break;
                }
            }
        }
    }

    /**
     * 测试containsKey()跟containsValue()方法
     */
    public void testContainsKeyAndValue() {
        System.out.println("请输入你要查看学生的编号：");
        Scanner scanner = new Scanner(System.in);
        String stuId = scanner.next();
        System.out.println(stuId + "学生是否存在：" + students.containsKey(stuId));
        System.out.println("请输入想要查看学生的名字：");
        String stuName = scanner.next();
        Students student = new Students();
        student.setName(stuName);
        System.out.println(student.getName() + "是否存在：" + students.containsValue(student));
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
//        mt.testKeySet();
////        mt.testRemove();
//        mt.testPutModify();
//        mt.testEntrySet();
        mt.testContainsKeyAndValue();
    }
}
