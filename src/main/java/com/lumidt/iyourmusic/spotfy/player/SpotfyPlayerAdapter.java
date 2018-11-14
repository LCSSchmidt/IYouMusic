/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lumidt.iyourmusic.spotfy.player;

import com.google.gson.JsonParser;
import com.lumidt.iyourmusic.PlayerAdapter;
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

    private static final String accessToken = "BQCsnzbAKQQaxJ7J47eGPrIy8cRnY0Vpba-SR6OFUasnuxTVS545QDNCJj5OLbd5heLNWUTQEMvcXfS9BFAugxsBa-pzSbG2QouBZL3lFOt9wljLTytGt94GcuUlfSKqhiFYc5ojKRmbpVh8EAToyuLaacH_Ap9ACDxeV6MAqo00QMrWxmK9wH5Su6Xr7TZ5vMhG83lP-lndb34yPY-dkWtWWUrZMpoePX2fzbLqDL-L5Pf2zV2n8wrXDcQkLnsbGsvguGwViVJs";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken)
            .build();

    @Override
    public void startResumeUserPlayback(String deviceId, String trackUri) {
        StartResumeUsersPlaybackRequest startResumeUsersPlaybackRequest = spotifyApi
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
        GetUsersAvailableDevicesRequest getUsersAvailableDevicesRequest = spotifyApi
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
        PauseUsersPlaybackRequest pauseUsersPlaybackRequest = spotifyApi.pauseUsersPlayback()
                .device_id(device)
                .build();
        try {
            final String string = pauseUsersPlaybackRequest.execute();

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
