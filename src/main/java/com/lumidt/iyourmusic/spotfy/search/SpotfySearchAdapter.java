/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic.spotfy.search;

import com.lumidt.iyourmusic.spotfy.*;
import com.lumidt.iyourmusic.*;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stit_
 */
public class SpotfySearchAdapter implements SearchManager {

    @Override
    public void searchAlbum(String albumName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchArtist(String artistName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchPlaylist(String playlistName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<TrackContent> searchTrack(String trackName) {
        SearchTracksRequest searchTracksRequest = Spotify.spotifyApi.searchTracks(trackName).build();
        Object[] items;
        List<TrackContent> trackContents = new ArrayList<>();
        String tracksName;
        String tracksId;
        String tracksUri;
        String tracksHref;
        String tracksAlbum;
        String tracksArtist;
        try {
            final Paging paging = searchTracksRequest.execute();
            items = paging.getItems();
            for (Object item : items) {
                //System.out.println(((Track)item).getName());
                tracksName = (((Track)item).getName());
                tracksAlbum = (((Track)item).getAlbum().getName());
                tracksId = (((Track)item).getId());
                tracksUri = (((Track) item).getUri());
                tracksHref = (((Track) item).getHref());
                ArtistSimplified[] name = ((Track) item).getArtists();
                tracksArtist = name[0].getName();
                trackContents.add(new SpotfyTrackContent(tracksName, tracksAlbum, tracksHref, tracksId, tracksUri, tracksArtist));
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
        return trackContents;
    }
    
    public static String searchTrackUri(String trackName){
        SearchTracksRequest searchTracksRequest = Spotify.spotifyApi.searchTracks(trackName).build();
        Object[] items;
        try {
            final Paging paging = searchTracksRequest.execute();
            items = paging.getItems();
            for (Object item : items) {
                return ((Track) item).getUri();
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
        return null;
    }
}
