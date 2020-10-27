package com.bonnysid.main;


import com.bonnysid.math.geometry.Point;
import com.bonnysid.media.Comment;
import com.bonnysid.media.Post;
import com.bonnysid.media.SubComment;
import com.bonnysid.structure.Secret;

import java.awt.geom.Point2D;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        Post p = new Post("Cat", "Text about cats:)", 10);
        p.addComments(new SubComment("Lol!", 6).addSubComments(new SubComment("wow!", 10).addSubComment("Third comment!", 4)), new SubComment("Fourth", 10)).addTags("cats", "cute");
        System.out.println(p);
    }
}
