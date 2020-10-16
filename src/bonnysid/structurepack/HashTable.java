package bonnysid.structurepack;

public class HashTable<T, K> {
    private Object [] keys = new Object[100];
    private Object [] values = new Object[100];
    private int size = 0;
    private int realSize = 100;
    private int SIZE_STEP = 50;

    public HashTable() { }
    public HashTable(int realSize) {
        setRealSize(realSize);
    }

    public HashTable(HashTable hashTable) {
        if (hashTable == null) throw new IllegalArgumentException("Argument cannot be equals null");
        addTableObjects(hashTable);
    }

    public HashTable set(T key, K value) {
        if (checkSize(null)) growUp(null);
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return this;
            }
        }
        keys[size] = key;
        values[size++] = value;
        return this;
    }

    public HashTable remove(T key) {
        int index = indexOf(key);
        if (index != -1) {
            Object [] tempKeys = new Object[realSize];
            Object [] tempValues = new Object[realSize];
            System.arraycopy(keys, 0, tempKeys, 0, index);
            System.arraycopy(keys, index + 1, tempKeys, index, keys.length - index - 1);
            System.arraycopy(values, 0, tempValues, 0, index);
            System.arraycopy(values, index + 1, tempValues, index, values.length - index - 1);
            keys = tempKeys;
            values = tempValues;
            size--;
        }
        return this;
    }

    public HashTable addTableObjects(HashTable<T, K> hashTable) {
        checkForNull(hashTable);
        if (checkSize(hashTable)) growUp(hashTable);
        System.arraycopy(hashTable.getKeys(), 0, keys, size, hashTable.size);
        System.arraycopy(hashTable.getValues(), 0, values, size, hashTable.size);
        size += hashTable.size;
        return this;
    }

    public int size() {
        return size;
    }

    public boolean contains(T searchKey) {
        for (Object key : keys) { if (searchKey.equals(key)) return true; }
        return false;
    }

    public int indexOf(T key) {
        for (int i = 0; i < size; i++) if (key.equals(keys[i])) return i;
        return -1;
    }

    public K get(T key) {
        int index = indexOf(key);
        if (index == -1) return null;
        return (K) values[index];
    }

    public Node getItem(int index) {
        return new Node(keys[index], values[index]);
    }

    public T getKey(int index) {
        return (T) keys[index];
    }

    public Object[] getKeys() {
        Object[] returned = new Object[size];
        System.arraycopy(keys, 0, returned, 0, size);
        return returned;
    }

    public Object[] getValues() {
        Object[] returned = new Object[size];
        System.arraycopy(values, 0, returned, 0, size);
        return returned;
    }

    private boolean checkSize(HashTable hashTable) {
        if (size == realSize) return true;
        if (hashTable == null) return true;
        return hashTable.size + size > realSize;
    }

    private void growUp(HashTable hashTable) {
        if (hashTable != null) SIZE_STEP = hashTable.size + size > realSize ? (hashTable.realSize + realSize) / 2 : realSize / 2;
        else SIZE_STEP = realSize / 2;
        Object [] tempKeys = new Object[realSize + SIZE_STEP];
        Object [] tempValues = new Object[realSize + SIZE_STEP];
        System.arraycopy(keys, 0, tempKeys, 0, realSize);
        System.arraycopy(values, 0, tempValues, 0, realSize);
        realSize = tempKeys.length;
        keys = tempKeys;
        values = tempValues;
    }

    private void setRealSize(int realSize) {
        if (realSize < 0) throw new IllegalArgumentException("Size of array cannot be less than zero");
        this.realSize = realSize;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[ \n\t");
        for (int i = 0; i < size; i++) {
            sb.append(keys[i] + ": " + values[i] + (i == size - 1 ? "\n" : ", \n\t"));
        }
        sb.append("]");
        return sb.toString();
    }

    public static class Node<T, K> {
        private T key;
        private K value;

        public Node(T key, K value) {
            this.key = key;
            this.value = value;
        }

        public K getValue() {
            return value;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "[" +
                    "key = " + key +
                    ", value = " + value +
                    ']';
        }
    }

    private void checkForNull(Object obj) { if (obj == null) throw new IllegalArgumentException("Argument cannot be equals null!");}
}
