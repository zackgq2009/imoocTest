package com.tsingkuo.io;

import java.io.Serializable;

/**
 * Created by johnnykuo on 2017/10/28.
 */
public class TestStudent implements Serializable{
    private String stuNo;
    private String stuName;
    private transient int stuAge;

    public TestStudent() {
    }

    public TestStudent(String stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }


}
