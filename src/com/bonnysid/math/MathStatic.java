package com.bonnysid.math;

public final class MathStatic {
    public static double sum(Number ...nums) {
        double sum = 0;
        for (Number n : nums) { sum += n.doubleValue(); }
        return sum;
    }

    public static double pow(String ...nums) {
        return Math.pow(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
    }

}
