package com.bonnysid.media;

import com.bonnysid.structure.Array;

import java.util.*;

public class SubComment extends Comment {
    private List<SubComment> subComments = new ArrayList<>();

    public SubComment(String value, int rating) {
        super(value, rating);
    }

    public SubComment(String value, int rating, SubComment... subComments) { this(value, rating, Arrays.asList(subComments)); }

    public SubComment(String value, int rating, List<SubComment> subComments) {
        this(value, rating);
        this.subComments = new ArrayList<>(subComments);
    }

    public SubComment addSubComments(List<SubComment> subComments) {
        for (SubComment sc : subComments) this.subComments.add(sc.clone());
        return this;
    }

    public SubComment addSubComments(SubComment ...subComments) { return addSubComments(Arrays.asList(subComments)); }

    public SubComment addSubComment(String value, int rating) {
        this.subComments.add(new SubComment(value, rating));
        return this;
    }

    public List<SubComment> getSubComments() {
        return new ArrayList<>(subComments);
    }

    @Override
    public SubComment clone() {
        return new SubComment(value, getRating(), subComments);
    }

    @Override
    public String toString() { return toString(0); }

    private String toString(int spaces) {
        String subCommentsStr = "";
        for (int i = 0; i < subComments.size(); i++) {
            int space = i + spaces + 1;
            subCommentsStr += "\t".repeat(space) + subComments.get(i).toString(space);
        }
        return super.toString() + subCommentsStr;
    }

}
