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
public interface PlaylistManager {
    public void createPlaylist(String nameOfPlaylist);
    public void getPlayList();
    public void addTracksToPlayList(String playlistName, String trackName);
    public void getListOfUsersPlaylist();
}
