package com.tsingkuo.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by johnnykuo on 2017/10/20.
 */
public class Students implements Comparable<Students> {
    @Override
    public int compareTo(Students o) {
        return this.getId().compareTo(o.getId());
//        return 0;
    }

    private String id;
    private String name;
    private Set<Courses> courses;

    public Students() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;

        Students students = (Students) o;

        return getName() != null ? getName().equals(students.getName()) : students.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public Students(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet<Courses>(); //初始化set
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }
}
