package com.example.customspotify.model;

public class AlbumSearchBody {

    private String search;

    public AlbumSearchBody(String search) {
        this.search = search;
    }

    public AlbumSearchBody() {
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
