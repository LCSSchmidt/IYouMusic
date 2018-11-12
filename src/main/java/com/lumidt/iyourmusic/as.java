/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic;

import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.lumidt.iyourmusic.spotfy.playlist.SpotfyPlaylistAdapter;
import com.lumidt.iyourmusic.youtube.YoutubeSearchAdapter;

/**
 *
 * @author stit_
 */
public class as {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpotfyPlaylistAdapter playlistAdapter = new SpotfyPlaylistAdapter();
        playlistAdapter.createPlaylist("amendoim");
        playlistAdapter.addTracksToPlayList("amendoim", "Run Veorra");
//        YoutubeSearchAdapter youtubeSearchAdapter = new YoutubeSearchAdapter();
//        youtubeSearchAdapter.searchTrack("17");
//        SpotfyPlaylistAdapter creator = new SpotfyPlaylistAdapter("ANEBDIUN");
//        creator.createPlaylist_Sync();
//        SpotfySearchAdapter x = new SpotfySearchAdapter();
//        x.SearchTracksSync();
    }

}
