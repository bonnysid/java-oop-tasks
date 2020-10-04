package Tasks_3;

import Tasks_2.SubComment;

import java.util.*;

public class Post {
    private String title;
    private String text;
    private List<String> tags = new ArrayList<>();
    private List<SubComment> comments = new ListOfComments<>();
    private int rating;

    public Post(String title, String text, int rating) {
        this.title = title;
        this.text = text;
        setRating(rating);
    }

    public Post(String title, String text) {
        this(title, text, 0);
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Post setText(String text) {
        this.text = text;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public Post addTags(List<String> tags) {
        this.tags.addAll(tags);
        return this;
    }

    public Post addTags(String ...tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }

    public List<SubComment> getComments() {
        return comments;
    }

    public Post addComments(List<SubComment> comments) {
        this.comments.addAll(comments);
        return this;
    }

    public Post addComments(SubComment ...comments) {
        this.comments.addAll(Arrays.asList(comments));
        return this;
    }

    public Post addComments(String value, int rating) {
        this.comments.add(new SubComment(value, rating));
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Post setRating(int rating) {
        if (rating < 0 || rating > 10) throw new IllegalArgumentException("Rating can be: from 0 to 10!");
        else this.rating = rating;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return rating == post.rating &&
                Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                Objects.equals(tags, post.tags) &&
                Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, tags, comments, rating);
    }

    @Override
    public String toString() {
        String tagsStr = "";
        for (int i = 0; i < tags.size(); i++) tagsStr += tags.get(i) + (i == this.tags.size() - 1 ? ";" : ", ");
        return "(" + rating + ") " + title + "\n\nтеги: " + tagsStr + "\n\n" + text + "\n\nКомантарии:\n\n" + comments;
    }

    private class ListOfComments<E> extends ArrayList{
        @Override
        public String toString() {
            Iterator<E> it = iterator();
            if (! it.hasNext())
                return "";

            StringBuilder sb = new StringBuilder();
            for (;;) {
                E e = it.next();
                sb.append(e == this ? "(this Collection)" : e);
                if (! it.hasNext())
                    return sb.toString();
                sb.append(' ');
            }
        }
    }

}
