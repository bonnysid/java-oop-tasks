package bonnysid.structurepack;

import java.util.Arrays;
import java.util.Objects;

public class Set<T> {
    private Object[] arr = new Object[100];
    private int size = 0;
    private int realSize = 100;
    private int SIZE_STEP = 50;

    public Set() {}

    public Set(Set hashTable) {
        setHashTable(hashTable);
    }

    public void setHashTable(Set hashTable) {
        if (checkForGrow(hashTable.size())) growUp(hashTable.size());
        for (int i = 0; i < hashTable.size(); i++) this.arr[i] = hashTable.get(i);
        realSize = this.arr.length;
        size = hashTable.size();
    }

    public T get(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Invalid index " + index + ", size of array is " + size);
        return (T)arr[index];
    }

    public Set<T> set(int index, T value) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Invalid index" + index + ", size of array is " + size);
        arr[index] = value;
        return this;
    }

    public boolean add(T item) {
        if (contains(item)) return false;
        if (checkForGrow()) growUp();
        arr[size++] = item;
        return true;
    }

    public boolean add(T ...arr) {
        if (checkForGrow(arr.length)) growUp(arr.length);
        for (int i = 0; i < arr.length; i++) add(arr[i]);
        return true;
    }

    public boolean remove(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("Out bound of array, size of array is " + size);
        Object[] newArr = new Object[realSize];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(this.arr, index + 1, newArr, index, this.arr.length - index - 1);
        this.arr = newArr;
        size--;
        return true;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    public Object[] toArray() {
        Object[] res = new Object[size];
        System.arraycopy(arr, 0, res, 0, size);
        return res;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public int indexOf(T searchItem) {
        for (int i = 0; i < size; i++) { if (searchItem.equals(arr[i])) return i; }
        return -1;
    }

    public boolean contains(T searchItem) {
        for (Object item : arr) { if (searchItem.equals(item)) return true; }
        return false;
    }

    private boolean checkForGrow(int checkSize) {
        if (checkSize > realSize) return true;
        return size == realSize;
    }

    private boolean checkForGrow() { return checkForGrow(0); }

    private void growUp(int checkSize) {
        if (checkSize != 0) {
            SIZE_STEP = checkSize / 2;
            Object[] newArr = new Object[checkSize + SIZE_STEP];
            System.arraycopy(this.arr, 0, newArr, 0, size());
            this.arr = newArr;
        } else {
            SIZE_STEP = size() / 2;
            Object[] newArr = new Object[realSize + SIZE_STEP];
            System.arraycopy(this.arr, 0, newArr, 0, size());
            this.arr = newArr;
        }
    }

    private void growUp() { growUp(0); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set<T> array = (Set<T>) o;
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
