package Tasks_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();
    private boolean isExcellent = false;

    public Student(String name, int ...marks) {
        this.name = name;
        addMarks(marks);
        checkForExcellent();
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
        for (int mark : marks)
            if (mark >= 2 && mark <= 5) this.marks.add(mark);
            else throw new IllegalArgumentException("Mark cannot be < 2 and > 5");
        checkForExcellent();
        return this;
    }

    public Student addMarks(List<Integer> marks) {
        for (int mark : marks)
            if (!(mark >= 2 && mark <= 5)) throw new IllegalArgumentException("Mark cannot be < 2 and > 5");
        this.marks.addAll(marks);
        checkForExcellent();
        return this;
    }

    public Student changeMark(int index, int mark) {
        if (!(mark >= 2 && mark <= 5)) throw new IllegalArgumentException("Mark cannot be < 2 and > 5");
        marks.set(index, mark);
        checkForExcellent();
        return this;
    }

    private void checkForExcellent() {
        if (marks.size() > 0) {
            int [] badMarks = {2, 3, 4};
            for( int mark : badMarks) {
                if (marks.contains(mark)) {
                    isExcellent = false;
                    return;
                }
            }
            isExcellent = true;
        } else isExcellent = false;
    }

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
