/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic;

import java.util.List;

/**
 *
 * @author stit_
 */
public interface SearchManager {
    public void searchAlbum(String albumName);
    public void searchArtist(String artistName);
    public void searchPlaylist(String playlistName);
    public List<TrackContent>  searchTrack(String trackName);
}
