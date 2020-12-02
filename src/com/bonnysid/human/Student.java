package com.bonnysid.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student<T> extends Human{
    private List<T> marks = new ArrayList<>();
    private boolean isExcellent = false;
//    private final static List<Integer> badMarks = new ArrayList<>(Arrays.asList(2, 3, 4));
    private MarkChecker<T> ch;

    public Student(Name fullName, int height) {
        this(fullName, height, null);
    }

    public Student(Name fullName) {
        this(fullName, 170, null);
    }

    public Student(Name fullName, int height, MarkChecker<T> ch, T ...marks) {
        super(fullName, height);
        this.ch = ch;
        addMarks(marks);
    }

    public List<T> getMarks() {
        return new ArrayList<T>(marks);
    }

    public Student<T> addMarks(T ...marks) {
        for (T mark : marks) {
            if (ch.check(mark)) this.marks.add(mark);
        }
        checkForExcellent();
        return this;
    }

    public Student<T> addMarks(List<T> marks) {
        for (T mark : marks) ch.check(mark);
        this.marks.addAll(marks);
        checkForExcellent();
        return this;
    }

    public Student<T> changeMark(int index, T mark) {
        ch.check(mark);
        marks.set(index, mark);
        checkForExcellent();
        return this;
    }

    public double getAvgMarks() {
        if (marks.isEmpty()) return 0;
        double res = 0;
        for (T mark : marks) res += ch.getValue(mark);
        return res / marks.size();
    }

    private void checkForExcellent() {
        if (!marks.isEmpty()) {
            for( T mark : marks) {
                if (!ch.checkForExcellent(mark)) {
                    isExcellent = false;
                    return;
                }
            }
            isExcellent = true;
        } else isExcellent = false;
    }

    private void checkMark(int mark) { if (!(mark >= 2 && mark <= 5)) throw new IllegalArgumentException("Mark cannot be < 2 and > 5"); }

    @Override
    public String toString() {
        return getFullName() + (isExcellent ? "(Excellent)" : "") + ": " + marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj.getClass() != this.getClass()) return false;
        Student student = (Student)obj;
        if (!Objects.equals(this, obj)) return false;
        return this.marks.equals(student.getMarks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), marks);
    }
}
