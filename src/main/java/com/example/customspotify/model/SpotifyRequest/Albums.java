package com.example.customspotify.model.SpotifyRequest;

public class Albums {

    private String href;
    private SimplifiedAlbumObject[] items;
    private String limit;
    private String next;
    private String offset;
    private String previous;
    private String total;

    public Albums(String href, SimplifiedAlbumObject[] items, String limit, String next, String offset, String previous,
            String total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    public Albums() {
    }

    public String getHref() {
        return this.href;
    }

    public SimplifiedAlbumObject[] getItems() {
        return this.items;
    }

    public String getLimit() {
        return this.limit;
    }

    public String getNext() {
        return this.next;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getPrevious() {
        return this.previous;
    }

    public String getTotal() {
        return this.total;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setItems(SimplifiedAlbumObject[] items) {
        this.items = items;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                " href='" + getHref() + "'" +
                ", items='" + getItems() + "'" +
                ", limit='" + getLimit() + "'" +
                ", next='" + getNext() + "'" +
                ", offset='" + getOffset() + "'" +
                ", previous='" + getPrevious() + "'" +
                ", total='" + getTotal() + "'" +
                "}";
    }
}
