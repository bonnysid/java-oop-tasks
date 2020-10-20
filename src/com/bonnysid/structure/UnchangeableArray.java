package com.bonnysid.structure;

public class UnchangeableArray<T> {
    private Object[] arr = new Object[100];
    private int size = 0;
    private int realSize = 100;

    public UnchangeableArray(int realSize) {
        this.arr = new Object[realSize];
        this.realSize = realSize;
    }

    public UnchangeableArray(T ...arr) {
        setArr(arr);
    }

    private void setArr(T ...arr) {
        this.arr = arr;
        realSize = arr.length;
        size = arr.length;
    }

    public T get(int index) {
        if (index > realSize) throw new ArrayIndexOutOfBoundsException("Invalid index " + index + ", size of array is " + size);
        return (T)arr[index];
    }

    public UnchangeableArray set(int index, T value) {
        if (index > realSize) throw new ArrayIndexOutOfBoundsException("Invalid index" + index + ", size of array is " + realSize);
        arr[index] = value;
        return this;
    }

    public UnchangeableArray add(T num) {
        if (size == realSize) throw new ArrayIndexOutOfBoundsException("Out bound of array, size of array is " + size);
        arr[size++] = num;
        return this;
    }

    public UnchangeableArray add(T ...arr) {
        if (size + arr.length == realSize) throw new ArrayIndexOutOfBoundsException("Out bound of array, size of array is " + size);
        System.arraycopy(arr, 0, this.arr, size, arr.length);
        return this;
    }

    public UnchangeableArray remove(int index) {
        if (index > realSize) throw new ArrayIndexOutOfBoundsException("Out bound of array, size of array is " + realSize);
        Object[] newArr = new Object[realSize];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(this.arr, index + 1, newArr, index, this.arr.length - index - 1);
        this.arr = newArr;
        size--;
        return this;
    }

    public boolean canAdd() {
        return !(size == realSize);
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i] + (i == size - 1 ? "" : ", "));
        }
        sb.append(" ]");
        return sb.toString();
    }
}
