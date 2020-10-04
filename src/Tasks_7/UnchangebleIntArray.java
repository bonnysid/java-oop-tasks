package Tasks_7;

public class UnchangebleIntArray {
    private int[] arr = new int[100];
    private int size = 0;
    private int realSize = 100;

    public UnchangebleIntArray(int realSize) {
        this.arr = new int[realSize];
        this.realSize = realSize;
    }

    public UnchangebleIntArray(int ...arr) {
        setArr(arr);
    }

    private void setArr(int ...arr) {
        this.arr = arr;
        realSize = arr.length;
        size = arr.length;
    }

    public int get(int index) {
        if (index > realSize) throw new IndexOutOfBoundsException("Invalid index " + index + ", size of array is " + size);
        return arr[index];
    }

    public UnchangebleIntArray set(int index, int value) {
        if (index > realSize) throw new IndexOutOfBoundsException("Invalid index" + index + ", size of array is " + realSize);
        arr[index] = value;
        return this;
    }

    public UnchangebleIntArray add(int num) {
        if (size == realSize) throw new IndexOutOfBoundsException("Out bound of array, size of array is " + size);
        arr[size++] = num;
        return this;
    }

    public UnchangebleIntArray add(int ...arr) {
        if (size + arr.length == realSize) throw new IndexOutOfBoundsException("Out bound of array, size of array is " + size);
        System.arraycopy(arr, 0, this.arr, size, arr.length);
        return this;
    }

    public UnchangebleIntArray remove(int index) {
        if (index > realSize) throw new IndexOutOfBoundsException("Out bound of array, size of array is " + realSize);
        int[] newArr = new int[realSize];
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
