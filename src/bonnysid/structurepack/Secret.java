package bonnysid.structurepack;

import java.util.Arrays;
import java.util.Random;

public class Secret {
    private Value value;
    private String valueStr = "";
    private String keeper;
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

    public String getValue() {
        return value.getValue();
    }

    public String getKeeper() {
        return keeper;
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
        private Random random;
        private Array<String> keepers;

        public Value(String value) { this(value, 0); }

        public Value(String value, int changes) {
            this.value = value;
            this.changes = changes;
        }

        public String transform(String value) {
            char[] res = value.toCharArray();
            int radix = (int) (value.length() * 0.1);
            for (int i = 0; i < radix; i++) {
                int changeableChar = random.nextInt(radix) + 1;
                res[changeableChar] = Character.forDigit(random.nextInt(radix) + 1, radix);
            }
            changes++;
            return Arrays.toString(res);
        }

        private String getValue() { return value; }

        public int getChanges() { return changes; }

        private void putKeeper(String keeper) {
            keepers.add(keeper);
        }

        @Override
        public String toString() { return value; }
    }
}
