package Tasks_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();
    private boolean isExcellent = false;
    private final List<Integer> badMarks = new ArrayList<>(Arrays.asList(2, 3, 4));

    public Student(String name, int ...marks) {
        this.name = name;
        addMarks(marks);
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
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

    private void checkForExcellent() {
        if (marks.size() > 0) {
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
        return name + (isExcellent ? "(Excellent)" : "") + ": " + marks;
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
        return Objects.hash(name, marks);
    }
}
