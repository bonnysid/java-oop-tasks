package bonnysid.mediapack;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private String title;
    private List<String> authors = new ArrayList<>();
    private Album album;
    private boolean hasAlbum = false;


    public Song(String title, Album album, String ...authors) {
        this.title = title;
        setAuthors(authors);
        this.album = album;
    }

    public Song(String title, String ...authors) {
        this(title, null, authors);
    }

    public Song setAuthors(String ...authors) {
        for(String author : authors) if (author != null) this.authors.add(author);
        return this;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    public Album getAlbum() {
        return album;
    }

    public Song setAlbum(Album album) {
        if (hasAlbum) throw new IllegalArgumentException("This song already has the album");
        hasAlbum = true;
        this.album = album;
        if (!album.getSongs().contains(this)) album.addSongs(this);
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ", authors: " + authors;
    }
}