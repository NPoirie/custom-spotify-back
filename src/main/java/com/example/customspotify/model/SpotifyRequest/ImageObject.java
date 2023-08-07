package com.example.customspotify.model.SpotifyRequest;

public class ImageObject {

    private String url;
    private int height;
    private int width;

    public ImageObject(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public ImageObject() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
