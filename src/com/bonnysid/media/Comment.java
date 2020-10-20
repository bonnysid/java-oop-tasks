package com.bonnysid.media;

public class Comment {
    public String value = "";
    private int rating;

    public Comment(String value, int rating) {
        this.value = value;
        setRating(rating);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 10) this.rating = rating;
        else throw new IllegalArgumentException("You must input rating from 0 to 10!");
    }

    @Override
    public Comment clone() {
        return new Comment(value, rating);
    }

    @Override
    public String toString() {
        return "(" + rating + ") " + value + "\n\t";
    }
}
