package bonnysid.mediapack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubComment extends Comment {
    private List<SubComment> subComment = new ListOfComments<>();

    public SubComment(String value, int rating) {
        super(value, rating);
    }

    public SubComment(String value, int rating, SubComment subComment) {
        this(value, rating);
        this.subComment.add(subComment);
    }

    public SubComment addSubComment(SubComment subComment) {
        this.subComment.add(subComment);
        return this;
    }

    public SubComment addSubComment(String value, int rating) {
        this.subComment.add(new SubComment(value, rating));
        return this;
    }

    public List<SubComment> getSubComment() {
        return subComment;
    }

    @Override
    public String toString() {
        return (subComment == null ? "\t" : "") + super.toString() + (subComment == null ? "" : subComment);
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
