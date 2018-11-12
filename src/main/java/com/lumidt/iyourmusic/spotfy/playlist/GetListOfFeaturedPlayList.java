/*
 * The MIT License
 *
 * Copyright 2018 stit_.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.lumidt.iyourmusic.spotfy.playlist;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.FeaturedPlaylists;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.browse.GetListOfFeaturedPlaylistsRequest;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class GetListOfFeaturedPlayList {

    private static final String accessToken = "";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken).setClientId("").setClientSecret("")
            .build();
    private static final GetListOfFeaturedPlaylistsRequest getListOfFeaturedPlaylistsRequest = spotifyApi
            .getListOfFeaturedPlaylists()
            
            .build();

    public static void getListOfFeaturedPlaylists_Sync() {
        try {
            final FeaturedPlaylists featuredPlaylists = getListOfFeaturedPlaylistsRequest.execute();

            System.out.println("Message: " + featuredPlaylists.getMessage());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getListOfFeaturedPlaylists_Async() {
        try {
            final Future<FeaturedPlaylists> featuredPlaylistsFuture = getListOfFeaturedPlaylistsRequest.executeAsync();
            // ...
            final FeaturedPlaylists featuredPlaylists = featuredPlaylistsFuture.get();
            Paging<PlaylistSimplified> playlistSimplified = featuredPlaylists.getPlaylists();
            
            PlaylistSimplified[] playlistSimplified1 = playlistSimplified.getItems();
            for (PlaylistSimplified playlistSimplified2 : playlistSimplified1) {
                System.out.println(playlistSimplified2.getName() );
            }
            
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
    }
}
