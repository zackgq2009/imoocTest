package com.tsingkuo.collection;

/**
 * Created by johnnykuo on 2017/10/20.
 */
public class Courses {
    private String id;
    private String name;

    public Courses(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Courses() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courses)) return false;

        Courses courses = (Courses) o;

        return getName() != null ? getName().equals(courses.getName()) : courses.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (obj == null) {
//            return false;
//        } else if (!(obj instanceof Courses)) {
//            return false;
//        }
//        Courses course = (Courses) obj;
//        if (this.getName() == null) {
//            if (course.getName() == null) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            if (this.getName().equals(course.getName())) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
}
