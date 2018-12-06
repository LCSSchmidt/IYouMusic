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

import com.lumidt.iyourmusic.spotfy.SpotfyTrackContent;
import com.lumidt.iyourmusic.PlaylistContent;
import com.lumidt.iyourmusic.PlaylistListener;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import java.io.IOException;
import com.lumidt.iyourmusic.PlaylistManager;
import com.lumidt.iyourmusic.TrackContent;
import com.lumidt.iyourmusic.spotfy.Spotify;
import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.wrapper.spotify.model_objects.special.SnapshotResult;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.data.playlists.AddTracksToPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsTracksRequest;
import java.util.ArrayList;
import java.util.List;

public class SpotfyPlaylistAdapter implements PlaylistManager {

    private static String userId;
    private static String name;
    private PlaylistListener listener;

    public SpotfyPlaylistAdapter() {
        this.userId = Spotify.userId;
    }

    @Override
    public void addListener(PlaylistListener l) {
        this.listener = l;
    }

    @Override
    public void createPlaylist(String nameOfPlaylist) {
        CreatePlaylistRequest createPlaylistRequest;

        this.name = nameOfPlaylist;
        createPlaylistRequest = Spotify.spotifyApi.createPlaylist(userId, name)
                .collaborative(false)
                .public_(false)
                .description("Amazing music.")
                .build();

        try {
            final Playlist playlist = createPlaylistRequest.execute();

            //System.out.println("Playlist " + playlist.getName() + " criada");

            listener.playlistCreated(nameOfPlaylist);
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void getPlayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getPlaylistId(String plalistName) {
        GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequest = Spotify.spotifyApi
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

        AddTracksToPlaylistRequest addTracksToPlaylistRequest = Spotify.spotifyApi
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
    public List<TrackContent> getPlayListTracks(String playlistId) {
        GetPlaylistsTracksRequest getPlaylistsTracksRequest = Spotify.spotifyApi
                .getPlaylistsTracks(playlistId)
                .build();
        List<TrackContent> trackContents = new ArrayList<>();
        String tracksName;
        String tracksId;
        String tracksUri;
        String tracksHref;
        String tracksAlbum;
        String tracksArtist;
        try {
            final Paging<PlaylistTrack> playlistTrackPaging = getPlaylistsTracksRequest.execute();
            PlaylistTrack[] tracks = playlistTrackPaging.getItems();
            for (PlaylistTrack track : tracks) {
                tracksName = track.getTrack().getName();
                tracksId = track.getTrack().getId();
                tracksAlbum = track.getTrack().getAlbum().getName();
                tracksUri = track.getTrack().getUri();
                tracksHref = track.getTrack().getHref();
                ArtistSimplified[] artists = track.getTrack().getArtists();
                tracksArtist = artists[0].getName();
                trackContents.add(new SpotfyTrackContent(tracksName, tracksAlbum, tracksHref, tracksId, tracksUri, tracksArtist));
            }
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return trackContents;
    }

    @Override
    public List<PlaylistContent> getListOfUsersPlaylist() {
        int index = 0;
        int totalOfPlaylists;
        String playlistsName;
        String playlistsId;
        String playlistUri;
        String playlistHref;
        List<PlaylistContent> playlists = new ArrayList<>();
        GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequest;

        totalOfPlaylists = getListOfCurrentUsersPlaylists();
        
        while(index <= totalOfPlaylists) {
            getListOfUsersPlaylistsRequest = Spotify.spotifyApi
                .getListOfUsersPlaylists(userId).limit(50).offset(index)
                .build();
            try {
                final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequest.execute();

                PlaylistSimplified[] playlistSimplifieds = playlistSimplifiedPaging.getItems();

                for (PlaylistSimplified playlistSimplified : playlistSimplifieds) {
                    playlistsName = playlistSimplified.getName();
                    playlistsId = playlistSimplified.getId();
                    playlistUri = playlistSimplified.getUri();
                    playlistHref = playlistSimplified.getHref();
                    playlists.add(new SpotfyPlaylistContent(playlistsName, playlistsId, playlistUri, playlistHref));
                }

            } catch (IOException | SpotifyWebApiException e) {
                System.out.println("Error: " + e.getMessage());
            }
            index += 50;
        }
        return playlists;
    }

    @Override
    public int getListOfCurrentUsersPlaylists() {
        int index = 0;
        int totalOfPlaylists = 0;
        int total = 0;
        GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylistsRequest = Spotify.spotifyApi
                .getListOfCurrentUsersPlaylists()
                .limit(50)
                .offset(index)
                .build();
        do {
            try {
                final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfCurrentUsersPlaylistsRequest.execute();
                total += playlistSimplifiedPaging.getItems().length;
                totalOfPlaylists = playlistSimplifiedPaging.getItems().length;
            } catch (Exception e) {
                System.out.println("Error on getListOfCurrentUsersPlaylists: " + e.getMessage());
            }

            index += 50;
            getListOfCurrentUsersPlaylistsRequest = Spotify.spotifyApi
                    .getListOfCurrentUsersPlaylists()
                    .limit(50)
                    .offset(index)
                    .build();
        } while (totalOfPlaylists == 50);
        //System.out.println("Total of playlists: " + total);
        return total;
    }
}
