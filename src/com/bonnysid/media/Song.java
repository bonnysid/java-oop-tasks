package com.bonnysid.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song {
    private String title;
    private List<String> authors = new ArrayList<>();
    private Album album;
    private boolean hasAlbum = false;


    public Song(String title, Album album, String ...authors) {
        this.title = title;
        setAuthors(authors);
        setAlbum(album);
    }

    public Song(String title, String ...authors) {
        this(title, null, authors);
    }

    public Song setAuthors(List<String> authors) {
        for(String author : authors) if (author != null) this.authors.add(author);
        return this;
    }

    public Song setAuthors(String ...authors) { return setAuthors(Arrays.asList(authors)); }

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
        return new ArrayList<>(authors);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ", authors: " + authors;
    }
}
