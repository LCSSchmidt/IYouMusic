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
public abstract class  PlaylistContent {
    String name;
    String id;
    String uri;
    String href;

    public PlaylistContent(String name, String id, String uri, String href) {
        this.name = name;
        this.id = id;
        this.uri = uri;
        this.href = href;
    }

    public String getName() {
        return name;
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
