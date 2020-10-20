package com.bonnysid.structure;

import java.util.Arrays;
import java.util.Random;

public class Secret {
    private final Value value;
    private String valueStr = "";
    private final String keeper;
    private final int place;

    public Secret(String value, String keeper) {
        this.value = new Value(value);
        valueStr = value;
        this.keeper = keeper;
        place = 0;
        this.value.putKeeper(keeper);
    }

    public Secret(Secret secret, String keeper) {
        this(secret.value, keeper);
        System.out.println(secret.keeper + " tells the secret: " + secret.value);
    }

    private Secret(Value value, String keeper) {
        this.value = value;
        this.valueStr = this.value.transform(valueStr);
        this.keeper = keeper;
        place = value.changes;
        this.value.putKeeper(keeper);
    }

    public int howManyPeopleKnows() {
        return value.getChanges();
    }

    public int howManyPeopleKnowsAfterThis() {
        return value.getChanges() - place;
    }

    public String getOtherKeeper(int index) { return value.getKeeper(index + place); }

    public String getValue() {
        return valueStr;
    }

    public String getKeeper() {
        return keeper;
    }

    public int getDifference(int index) {
        System.out.println(value.getSecretLength(index + place));
        return Math.abs(value.getSecretLength(index + place) - valueStr.length());
    }

    public int numOfKeeperPlace() {
        return place;
    }

    @Override
    public String toString() {
        return keeper + ": it is a secret!";
    }

    public static class Value {
        private final String value;
        private int changes;
        private int nowRadix;
        private Random random;
        private HashTable<String, Integer> keepers = new HashTable<>();

        public Value(String value) { this(value, 0); }

        public Value(String value, int changes) {
            this.value = value;
            this.changes = changes;
        }

        public String transform(String value) {
            char[] res = value.toCharArray();
            nowRadix = (int) (value.length() * 0.1);
            for (int i = 0; i < nowRadix; i++) {
                int changeableChar = random.nextInt(nowRadix) + 1;
                res[changeableChar] = Character.forDigit(random.nextInt(nowRadix) + 1, nowRadix);
            }
            changes++;
            System.out.println(nowRadix);
            return Arrays.toString(res);
        }

        private String getValue() { return value; }

        public int getChanges() { return changes; }

        private void putKeeper(String keeper) {
            keepers.set(keeper, nowRadix + value.length());
        }

        private String getKeeper(int i) { return keepers.getKey(i); }

        private int getSecretLength(int index) { return keepers.get(keepers.getKey(index)); }

        @Override
        public String toString() { return value; }
    }
}
