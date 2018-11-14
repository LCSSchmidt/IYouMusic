/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic;

/**
 *
 * @author stit_
 */
public abstract class TrackContent {

    String name;
    String album;
    String href;
    String id;
    String uri;
    String artist;

    public TrackContent(String name, String album, String href, String id, String uri, String artist) {
        this.name = name;
        this.album = album;
        this.href = href;
        this.id = id;
        this.uri = uri;
        this.artist = artist;
    }

   

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getHref() {
        return href;
    }
}
