package bonnysid.structurepack;

import java.util.Arrays;
import java.util.Objects;

public class Array<T> {
    private Object[] arr = new Object[100];
    private int size = 0;
    private int realSize = 100;
    private int SIZE_STEP = 50;

    public Array(T ...arr) {
        setArr(arr);
    }

    public void setArr(T ...arr) {
        if (arr.length > realSize) {
            SIZE_STEP = arr.length / 2;
            this.arr = new Object[arr.length + SIZE_STEP];
        }
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        realSize = this.arr.length;
        size = arr.length;
    }

    public T get(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Invalid index " + index + ", size of array is " + size);
        return (T)arr[index];
    }

    public Array set(int index, T value) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Invalid index" + index + ", size of array is " + size);
        arr[index] = value;
        return this;
    }

    public Array add(T num) {
        if (size == realSize) {
            SIZE_STEP = realSize / 2;
            Object[] newArr = new Object[realSize + SIZE_STEP];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[size++] = num;
        return this;
    }

    public Array add(T ...arr) {
        if (size + arr.length == realSize) {
            SIZE_STEP = (realSize + arr.length) / 2;
            Object[] newArr = new Object[realSize + arr.length + SIZE_STEP];
            System.arraycopy(this.arr, 0, newArr, 0, this.arr.length);
            System.arraycopy(arr, 0, newArr, size, arr.length);
            this.arr = newArr;
        } else System.arraycopy(arr, 0, this.arr, size, arr.length);
        size += arr.length;
        return this;
    }

    public Array remove(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Out bound of array, size of array is " + size);
        Object[] newArr = new Object[realSize];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(this.arr, index + 1, newArr, index, this.arr.length - index - 1);
        this.arr = newArr;
        size--;
        return this;
    }

    public Object[] toArray() {
        Object[] res = new Object[size];
        System.arraycopy(arr, 0, res, 0, size);
        return res;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<T> array = (Array<T>) o;
        return size == array.size &&
                realSize == array.realSize &&
                Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, realSize, SIZE_STEP);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

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
