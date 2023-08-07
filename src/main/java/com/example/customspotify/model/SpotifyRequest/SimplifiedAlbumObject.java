package com.example.customspotify.model.SpotifyRequest;

public class SimplifiedAlbumObject {
    private String name;
    private String release_date;
    private ImageObject[] images;

    public SimplifiedAlbumObject(String name, String release_date, ImageObject[] images) {
        this.name = name;
        this.release_date = release_date;
        this.images = images;
    }

    public SimplifiedAlbumObject() {
    }

    public String getName() {
        return this.name;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public ImageObject[] getImages() {
        return this.images;
    }

    public void setImages(ImageObject[] images) {
        this.images = images;
    }

}
