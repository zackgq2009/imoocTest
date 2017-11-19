package com.tsingkuo.collection;

import java.util.Comparator;

/**
 * Created by johnnykuo on 2017/10/25.
 */
public class StudentsComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.getName().compareTo(o2.getName()); //此处的compareTo()方法，是对字符串进行比较
    }
}
