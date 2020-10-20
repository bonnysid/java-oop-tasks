package com.bonnysid.human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student extends Human{
    private List<Integer> marks = new ArrayList<>();
    private boolean isExcellent = false;
    private final static List<Integer> badMarks = new ArrayList<>(Arrays.asList(2, 3, 4));

    public Student(Name fullName, int height) {
        this(fullName, height, null);
    }

    public Student(Name fullName) {
        this(fullName, 170, null);
    }

    public Student(Name fullName, int height, int ...marks) {
        super(fullName, height);
        addMarks(marks);
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public Student addMarks(int ...marks) {
        for (int mark : marks) {
            checkMark(mark);
            this.marks.add(mark);
        }
        checkForExcellent();
        return this;
    }

    public Student addMarks(List<Integer> marks) {
        for (int mark : marks) checkMark(mark);
        this.marks.addAll(marks);
        checkForExcellent();
        return this;
    }

    public Student changeMark(int index, int mark) {
        checkMark(mark);
        marks.set(index, mark);
        checkForExcellent();
        return this;
    }

    public double getAvgMarks() {
        if (marks.isEmpty()) return 0;
        int res = 0;
        for (int mark : marks) res += mark;
        return res / marks.size();
    }

    private void checkForExcellent() {
        if (!marks.isEmpty()) {
            for( int mark : marks) {
                if (badMarks.contains(mark)) {
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
