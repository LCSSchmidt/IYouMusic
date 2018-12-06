/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic.spotfy;

import com.lumidt.iyourmusic.spotfy.player.SpotfyPlayerAdapter;
import com.lumidt.iyourmusic.spotfy.playlist.SpotfyPlaylistAdapter;
import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.wrapper.spotify.SpotifyApi;

/**
 *
 * @author stit_
 */
public class Spotify {
    public static final String accessToken = "BQDaoJeHs2AYlc35ET77ZUCRg8P57cOsHl9Q69yjI_1n3aTWz0jYN9EWCkqvhsaaBztz8dbmlLUBUrCj4d8JszzgreAVSmqrMBzP8HgXzZLn6aMcXPliPm7ihPjXWw645TzDr_arwHfW95mmy9HHCgYYyjqQFhL_HM_STaohZnTkTbnTHadklDWiuyLWguD9pUxyxFKb1zv2ovTgEhhA9Ramke1qMLF6bOVJ4a1GTKnZa-4YUQNI-g6nTk-rQQee0NZr6p44pzho";
    public static String userId;
    public static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken)
            .build();
    
    public static SpotfyPlayerAdapter player;
    public static SpotfySearchAdapter search;
    public static SpotfyPlaylistAdapter playlist;

    public Spotify(String userId) {
        this.userId = "lusgo";
        this.player = new SpotfyPlayerAdapter();
        this.search = new SpotfySearchAdapter();
        this.playlist = new SpotfyPlaylistAdapter();
    }
}
