package com.bonnysid.math;

import com.bonnysid.structure.Array;

import java.util.Arrays;
import java.util.List;

public final class MathStatic {
    public static double sum(Number ...nums) {
        double sum = 0;
        for (Number n : nums) { sum += n.doubleValue(); }
        return sum;
    }

    public static double pow(String ...nums) {
        return Math.pow(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
    }


//    public static List getClones(Cloneable ...objs) {
//        return Arrays.asList(objs).stream().map(obj -> obj.clone());
//    }
}
