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
public interface PlayerAdapter {
    public void startResumeUserPlayback(String deviceId, String trackUri);
    public List<String> getUserAvailableDevices();
    public void pauseUserPlayback(String device);
}
