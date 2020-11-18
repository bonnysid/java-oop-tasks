package com.bonnysid.human;

public interface MarkChecker<T> {
    boolean check(T mark);
    double getValue(T mark);
    boolean checkForExcellent(T mark);
}
