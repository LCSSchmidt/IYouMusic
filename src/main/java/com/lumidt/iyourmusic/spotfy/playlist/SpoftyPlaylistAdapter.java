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

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import java.io.IOException;
import com.lumidt.iyourmusic.PlaylistManager;
import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.wrapper.spotify.model_objects.special.SnapshotResult;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.playlists.AddTracksToPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfUsersPlaylistsRequest;


public class SpoftyPlaylistAdapter implements PlaylistManager {

    private static final String accessToken = "";
    private static final String userId = "";
    private static String name;
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken)
            .build();

    @Override
    public void createPlaylist(String nameOfPlaylist) {
        CreatePlaylistRequest createPlaylistRequest;

        this.name = nameOfPlaylist;
        createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
                .collaborative(false)
                .public_(false)
                .description("Amazing music.")
                .build();

        try {
            final Playlist playlist = createPlaylistRequest.execute();

            System.out.println("Playlist " + playlist.getName() + "criada");
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void getPlayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String getPlaylistId(String plalistName){
        GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequest = spotifyApi
                .getListOfUsersPlaylists(userId).limit(50)
                .build();

        try {
            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequest.execute();

            PlaylistSimplified[] playlistSimplifieds = playlistSimplifiedPaging.getItems();

            for (PlaylistSimplified playlistSimplified : playlistSimplifieds) {
                
                if (playlistSimplified.getName().equals(plalistName)) {
                    return playlistSimplified.getId();
                }
            }
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public void addTracksToPlayList(String playlistName, String trackName) {
        String musicUri = SpotfySearchAdapter.searchTrackUri(trackName);
        String[] uris = new String[]{musicUri};
        String playlistId = getPlaylistId(playlistName);
        
        AddTracksToPlaylistRequest addTracksToPlaylistRequest = spotifyApi
                .addTracksToPlaylist(playlistId, uris)
                .position(0)
                .build();

        try {
            final SnapshotResult snapshotResult = addTracksToPlaylistRequest.execute();

            System.out.println("Snapshot ID: " + snapshotResult.getSnapshotId());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void getListOfUsersPlaylist() {
        GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequest = spotifyApi
                .getListOfUsersPlaylists(userId).limit(50)
                .build();

        try {
            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequest.execute();

            PlaylistSimplified[] playlistSimplifieds = playlistSimplifiedPaging.getItems();

            for (PlaylistSimplified playlistSimplified : playlistSimplifieds) {

                System.out.println(playlistSimplified.getName());
            }

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
