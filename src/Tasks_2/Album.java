package Tasks_2;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private List<String> authors = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

    public Album(String title, String ...authors) {
        this.title = title;
        addAuthors(authors);
    }

    public Album(String title) {
        this(title, "");
    }

    public Album addAuthors(String ...authors) {
        for(String author : authors) if (author != null) this.authors.add(author);
        return this;
    }
    public Album addSongs(Song ...songs) {
        for(Song s : songs) {
            if (s != null) {
                this.songs.add(s);
                s.setAuthors(authors.toArray(String[]::new));
            }
        }
        return this;
    }

    public Album setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthor() {
        return authors;
    }
}
