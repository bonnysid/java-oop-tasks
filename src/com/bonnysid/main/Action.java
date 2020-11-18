package com.bonnysid.main;

public interface Action<T, R> {
    R act(T obj);
}
