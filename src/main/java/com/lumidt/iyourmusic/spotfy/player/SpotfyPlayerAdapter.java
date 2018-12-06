/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic.spotfy.player;

import com.google.gson.JsonParser;
import com.lumidt.iyourmusic.PlayerAdapter;
import com.lumidt.iyourmusic.spotfy.Spotify;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.miscellaneous.Device;
import com.wrapper.spotify.requests.data.player.GetUsersAvailableDevicesRequest;
import com.wrapper.spotify.requests.data.player.PauseUsersPlaybackRequest;
import com.wrapper.spotify.requests.data.player.StartResumeUsersPlaybackRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stit_
 */
public class SpotfyPlayerAdapter implements PlayerAdapter {

    @Override
    public void startResumeUserPlayback(String deviceId, String trackUri) {
        StartResumeUsersPlaybackRequest startResumeUsersPlaybackRequest = Spotify.spotifyApi
                .startResumeUsersPlayback()
                .device_id(deviceId)
                .uris(new JsonParser().parse("[\"" + trackUri + "\"]").getAsJsonArray())
                .position_ms(0)
                .build();

        try {
            final String string = startResumeUsersPlaybackRequest.execute();

            System.out.println("Null: " + string);
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<String> getUserAvailableDevices() {
        GetUsersAvailableDevicesRequest getUsersAvailableDevicesRequest = Spotify.spotifyApi
                .getUsersAvailableDevices()
                .build();
        List<String> avaliableDevices = new ArrayList<>();
        try {
            final Device[] devices = getUsersAvailableDevicesRequest.execute();
            for (Device device : devices) {
                avaliableDevices.add(device.getId());
            }
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return avaliableDevices;
    }

    @Override
    public void pauseUserPlayback(String device) {
        PauseUsersPlaybackRequest pauseUsersPlaybackRequest = Spotify.spotifyApi.pauseUsersPlayback()
                .device_id(device)
                .build();
        try {
            final String string = pauseUsersPlaybackRequest.execute();

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
