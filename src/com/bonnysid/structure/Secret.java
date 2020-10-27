package com.bonnysid.structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
        this(secret.value, secret.valueStr, keeper);
        System.out.println(secret.keeper + " tells the secret to " + keeper + ": " + secret.value);
    }

    private Secret(Value value, String valueStr, String keeper) {
        this.value = value;
        this.valueStr = this.value.transform(valueStr);
        place = value.changes;
        this.keeper = keeper;
        this.value.putKeeper(keeper);
    }

    public int amountKeepers() {
        return value.getChanges() + 1;
    }

    public int amountKeepersAfter() {
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
        return Math.abs(value.getSecretLength(index + place) - valueStr.length());
    }

    public int keeperPlace() {
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
        private final Random random = new Random();
        private HashTable<String, Integer> keepers = new HashTable<>();

        public Value(String value) { this(value, 0); }

        public Value(String value, int changes) {
            this.value = value;
            this.changes = changes;
        }

        public String transform(String value) {
            List<String> res = Arrays.asList(value.split(""));
            nowRadix = (int) (value.length() * 0.1);
            for (int i = 0; i < nowRadix; i++) {
                int changeableSym = random.nextInt(nowRadix) + 1;
                res.add(changeableSym, String.valueOf(Character.forDigit(random.nextInt(nowRadix) + 1, nowRadix)));
            }
            changes++;
            return res.stream().reduce("",(symbol, symbol2) -> symbol + symbol2);
        }

        private String getValue() { return value; }

        public int getChanges() { return changes; }

        private void putKeeper(String keeper) {
            keepers.set(keeper, nowRadix + value.length());
        }

        private String getKeeper(int i) {
            if (i < 0 || i >= keepers.size()) throw new IllegalArgumentException("This index doesn't have a keeper");
            return keepers.getKey(i);
        }

        private int getSecretLength(int index) { return keepers.get(keepers.getKey(index)); }

        @Override
        public String toString() { return value; }
    }
}
