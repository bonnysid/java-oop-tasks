package com.bonnysid.human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StudentBook {
    private long number;
    private String nameOfStudent;
    private List<String[]> examRes = new ArrayList<>();

    public StudentBook(long number, String nameOfStudent) {
        this.number = number;
        this.nameOfStudent = nameOfStudent;
    }

    public StudentBook(long number, String nameOfStudent, List<String[]> examRes) {
        this(number, nameOfStudent);
        addExamRes(examRes);;
    }

    public StudentBook(long number, String nameOfStudent, String[] ...examRes) {
        this(number, nameOfStudent);
        addExamRes(examRes);
    }

    public long getNumber() {
        return number;
    }

    public StudentBook setNumber(long number) {
        if (number < 0) throw new IllegalArgumentException("Index of student book cannot be less than zero");
        this.number = number;
        return this;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public StudentBook setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
        return this;
    }

    public List<String[]> getExamRes() {
        return new ArrayList<String[]>(examRes);
    }

    public StudentBook addExamRes(List<String[]> examRes) {
        this.examRes = examRes;
        return this;
    }

    public StudentBook addExamRes(String[] ...examRes) {
        this.examRes.addAll(Arrays.asList(examRes));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBook that = (StudentBook) o;
        return number == that.number &&
                Objects.equals(nameOfStudent, that.nameOfStudent) &&
                Objects.equals(examRes, that.examRes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, nameOfStudent, examRes);
    }

    @Override
    public String toString() {
        String exams = "";
        for (String[] exam : examRes) exams += "\n\t" + Arrays.toString(exam);
        return nameOfStudent + ", " + number + ":" + exams;
    }
}
