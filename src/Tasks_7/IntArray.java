package Tasks_7;

public class IntArray{
    private int[] arr = new int[100];
    private int size = 0;
    private int realSize = 100;
    private int SIZE_STEP = 50;

    public IntArray(int ...arr) {
        setArr(arr);
    }

    public void setArr(int ...arr) {
        if (arr.length > realSize) {
            SIZE_STEP = arr.length / 2;
            this.arr = new int[arr.length + SIZE_STEP];
        }
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        realSize = this.arr.length;
        size = arr.length;
    }

    public int get(int index) {
        if (index > size) throw new IndexOutOfBoundsException("Invalid index " + index + ", size of array is " + size);
        return arr[index];
    }

    public IntArray set(int index, int value) {
        if (index > size) throw new IndexOutOfBoundsException("Invalid index" + index + ", size of array is " + size);
        arr[index] = value;
        return this;
    }

    public IntArray add(int num) {
        if (size == realSize) {
            SIZE_STEP = realSize / 2;
            int[] newArr = new int[realSize + SIZE_STEP];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[size++] = num;
        return this;
    }

    public IntArray add(int ...arr) {
        if (size + arr.length == realSize) {
            SIZE_STEP = (realSize + arr.length) / 2;
            int[] newArr = new int[realSize + arr.length + SIZE_STEP];
            System.arraycopy(this.arr, 0, newArr, 0, this.arr.length);
            System.arraycopy(arr, 0, newArr, size, arr.length);
            arr = newArr;
        } else System.arraycopy(arr, 0, this.arr, size, arr.length);
        return this;
    }

    public IntArray remove(int index) {
        if (index > size) throw new IndexOutOfBoundsException("Out bound of array, size of array is " + size);
        int[] newArr = new int[realSize];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(this.arr, index + 1, newArr, index, this.arr.length - index - 1);
        this.arr = newArr;
        size--;
        return this;
    }

    public int[] toArray() {
        int[] res = new int[size];
        System.arraycopy(arr, 0, res, 0, size);
        return res;
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
