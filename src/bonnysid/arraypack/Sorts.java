package bonnysid.arraypack;

public class Sorts {
    public static void sortArrayByLength(String[] arr) {
        String temp;
        boolean wasChange;
        for (int i = 0; i < arr.length - 1; i++) {
            wasChange = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    wasChange = true;
                }
            }
            if (!wasChange) break;
        }
    }

    public static void sortArrayByLength(String[][] arr) {
        for (String[] strings : arr) sortArrayByLength(strings);
    }
}
