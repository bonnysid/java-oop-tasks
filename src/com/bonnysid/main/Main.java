package com.bonnysid.main;


<<<<<<< HEAD
import com.bonnysid.math.geometry.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Karate k1 = new Karate("Nikita");
        Combo c = new Combo("kick", "kick", "hithand", "hitinAir");
        k1.hit(c);
=======

import com.bonnysid.human.MarkChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        MarkChecker<String> ch = new MarkChecker<String>() {
            @Override
            public boolean check(String mark) {
                return mark != null && (mark.trim().toLowerCase().equals("зачтено") || mark.trim().toLowerCase().equals("не зачтено"));
            }

            @Override
            public double getValue(String mark) {
                return mark != null && mark.trim().toLowerCase().equals("зачтено") ? 1 : 0;
            }

            @Override
            public boolean checkForExcellent(String mark) {
                return mark != null && mark.trim().toLowerCase().equals("зачтено");
            }
        };

        Action<String, Integer> act = (String::length);

        System.out.println(convert(Arrays.asList("dshhs", "dsf"), act));
    }

    public static <T, R> List<R> convert(List<T> list, Action<T, R> act) {
        List<R> res = new ArrayList<>();
        for(T obj : list) res.add(act.act(obj));
        return res;
>>>>>>> 14465bb9392e7cb106cd8bcee163ae8853d29aba
    }
}
