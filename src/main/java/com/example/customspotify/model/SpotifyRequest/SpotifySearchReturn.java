package com.example.customspotify.model.SpotifyRequest;

public class SpotifySearchReturn {

    private Albums albums;

    public SpotifySearchReturn(Albums albums) {
        this.albums = albums;
    }

    public SpotifySearchReturn() {
    }

    public Albums getAlbums() {
        return this.albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public SpotifySearchReturn albums(Albums albums) {
        setAlbums(albums);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " albums='" + getAlbums() + "'" + "}";
    }
}
