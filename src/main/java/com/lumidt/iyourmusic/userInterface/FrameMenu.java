package com.lumidt.iyourmusic.userInterface;

import com.lumidt.iyourmusic.PlaylistContent;
import com.lumidt.iyourmusic.TrackContent;
import com.lumidt.iyourmusic.spotfy.player.SpotfyPlayerAdapter;
import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.lumidt.iyourmusic.spotfy.playlist.SpotfyPlaylistAdapter;
import com.sun.prism.impl.PrismSettings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

public class FrameMenu extends javax.swing.JFrame {

    SpotfySearchAdapter spotfySearch;
    SpotfyPlaylistAdapter spotfyPlaylist;
    SpotfyPlayerAdapter spotfyPlayer;
    List<PlaylistContent> playlistContents;
    List<TrackContent> trackContents;
    List<String> userPlaylistsName;
    List<String> userPlaylistsId;
    List<String> devices;
    DefaultTableModel defTableModel;
    DefaultTableModel defTableModelToSWUpdate;
    SWListTable swTableUserPlaylists;
    SWPanelHeader sWPanelHeader;
    SWTrackContentToTable sWTrackContentToTable;
    SWUptadeTableUserPlaylists sWUptadeTableUserPlaylists;
    TrackContent selectedTrack;
    Thread th;
    int selecetedRow;

    public FrameMenu() {
        initComponents();

        spotfySearch = new SpotfySearchAdapter();
        spotfyPlaylist = new SpotfyPlaylistAdapter();
        spotfyPlayer = new SpotfyPlayerAdapter();
        userPlaylistsName = new ArrayList<>();
        playlistContents = new ArrayList<>();
        trackContents = new ArrayList<>();
        devices = new ArrayList<>();
        swTableUserPlaylists = new SWListTable();
        jMPPanelHeader.setVisible(false);
        jMPPauseButton.setVisible(false);
        jMPBAddToPlaylist.setVisible(false);
        jMPBCreatePlaylist.setVisible(false);
        jMPPanelTables.setPreferredSize(new Dimension(this.getWidth(), (this.getHeight() - 40)));
        jMPPanelTables.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {

            @Override
            public void ancestorResized(HierarchyEvent he) {
                jMPPanelTables.setSize(jMPRedFreePanel.getWidth(), (jMPRedFreePanel.getHeight() - 40));
                jMPButtonOption.setLocation(he.getComponent().getWidth() - 40, (he.getComponent().getY() - 30));
                jMPPanelHeader.setLocation(he.getComponent().getWidth() - 174, 40);
            }
        });
        jTableUserPlaylists.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                selecetedRow = jTableUserPlaylists.getSelectedRow();
                jTableUserPlaylists.getSelectionModel().clearSelection();
                getTracksFromSelectedPlaylist(selecetedRow);
            }
        });
        jTableSearchResults.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                selecetedRow = jTableSearchResults.getSelectedRow();

            }
        });
        searchUserPlaylists();
        addUserPlaylistsToTable(userPlaylistsName);
//        th = new Thread() {
//            @Override
//            public void run() {
//                do {
//                    searchUserPlaylists();
//                    boolean itemJaExistente = false;
//                    List<String> newPlaylists = new ArrayList<>();
//                    defTableModelToSWUpdate = (DefaultTableModel) jTableUserPlaylists.getModel();
//                    for (String string : userPlaylistsName) {
//                        for (int indice = 0; indice < defTableModel.getRowCount(); indice++) {
//                            if (defTableModel.getValueAt(indice, 0).equals(string)) {
//                                itemJaExistente = true;
//                            }
//                            if (!itemJaExistente) {
//                                newPlaylists.add(string);
//                            }
//                        }
//                    }
//                    sWUptadeTableUserPlaylists = new SWUptadeTableUserPlaylists(newPlaylists);
//                    System.out.println("entrouuuuuuuuuu");
//                    try {
//                        swTableUserPlaylists.doInBackground();
//                    } catch (Exception e) {
//                        System.out.println("Erro na thread");
//                    }
//                    try {
//                        Thread.sleep(15000);
//                    } catch (Exception e) {
//                        System.out.println("Erro na thread");
//                    }
//                } while (true);
//            }
//        };
//        th.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMainPanel = new javax.swing.JPanel();
        jMPBackground = new javax.swing.JPanel();
        jMPRedFreePanel = new javax.swing.JPanel();
        jMPBSearch = new javax.swing.JButton();
        jMPBAddToPlaylist = new javax.swing.JButton();
        jMPBCreatePlaylist = new javax.swing.JButton();
        jTextFMPSearch = new javax.swing.JTextField();
        jMPButtonOption = new javax.swing.JLabel();
        jMPPanelHeader = new javax.swing.JPanel();
        jMPBToAddPlaylist = new javax.swing.JLabel();
        jMPBToNewPlaylist = new javax.swing.JLabel();
        jMPBToSearch = new javax.swing.JLabel();
        jMPPanelTables = new javax.swing.JPanel();
        jScrollPSearchResults = new javax.swing.JScrollPane();
        jTableSearchResults = new javax.swing.JTable();
        jScrollPMPPlaylists = new javax.swing.JScrollPane();
        jTableUserPlaylists = new javax.swing.JTable();
        jMPPlayButton = new javax.swing.JLabel();
        jMPPauseButton = new javax.swing.JLabel();
        jSearchPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jMainPanel.setBackground(new java.awt.Color(51, 51, 51));

        jMPBackground.setBackground(new java.awt.Color(0, 0, 0));

        jMPRedFreePanel.setBackground(new java.awt.Color(51, 51, 51));
        jMPRedFreePanel.setLayout(null);

        jMPBSearch.setText("Search");
        jMPBSearch.setOpaque(false);
        jMPBSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBSearchMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPBSearch);
        jMPBSearch.setBounds(290, 5, 75, 32);

        jMPBAddToPlaylist.setText("Add");
        jMPBAddToPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBAddToPlaylistMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPBAddToPlaylist);
        jMPBAddToPlaylist.setBounds(290, 5, 75, 32);

        jMPBCreatePlaylist.setText("Create");
        jMPBCreatePlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBCreatePlaylistMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPBCreatePlaylist);
        jMPBCreatePlaylist.setBounds(290, 5, 75, 32);
        jMPRedFreePanel.add(jTextFMPSearch);
        jTextFMPSearch.setBounds(120, 9, 140, 24);

        jMPButtonOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\stit_\\Desktop\\seta_baixo_2.png")); // NOI18N
        jMPButtonOption.setText("jLabel1");
        jMPButtonOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPButtonOptionMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPButtonOption);
        jMPButtonOption.setBounds(600, 3, 40, 30);

        jMPPanelHeader.setBackground(new java.awt.Color(51, 51, 51));
        jMPPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMPPanelHeader.setForeground(new java.awt.Color(255, 255, 255));

        jMPBToAddPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jMPBToAddPlaylist.setText("Add to Playlist");
        jMPBToAddPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBToAddPlaylistMouseClicked(evt);
            }
        });

        jMPBToNewPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jMPBToNewPlaylist.setText("New Playlist");
        jMPBToNewPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBToNewPlaylistMouseClicked(evt);
            }
        });

        jMPBToSearch.setForeground(new java.awt.Color(255, 255, 255));
        jMPBToSearch.setText("Search");
        jMPBToSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPBToSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jMPPanelHeaderLayout = new javax.swing.GroupLayout(jMPPanelHeader);
        jMPPanelHeader.setLayout(jMPPanelHeaderLayout);
        jMPPanelHeaderLayout.setHorizontalGroup(
            jMPPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMPPanelHeaderLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jMPBToSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMPPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jMPPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jMPPanelHeaderLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jMPBToNewPlaylist))
                    .addComponent(jMPBToAddPlaylist))
                .addGap(39, 39, 39))
        );
        jMPPanelHeaderLayout.setVerticalGroup(
            jMPPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMPPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMPBToSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMPBToAddPlaylist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMPBToNewPlaylist)
                .addGap(17, 17, 17))
        );

        jMPRedFreePanel.add(jMPPanelHeader);
        jMPPanelHeader.setBounds(440, 40, 160, 10);

        jMPPanelTables.setBackground(new java.awt.Color(51, 51, 51));

        jTableSearchResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Artista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSearchResults.setShowVerticalLines(false);
        jTableSearchResults.getTableHeader().setReorderingAllowed(false);
        jScrollPSearchResults.setViewportView(jTableSearchResults);

        jTableUserPlaylists.setBackground(new java.awt.Color(0, 0, 0));
        jTableUserPlaylists.setForeground(new java.awt.Color(76, 76, 76));
        jTableUserPlaylists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableUserPlaylists.setInheritsPopupMenu(true);
        jTableUserPlaylists.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTableUserPlaylists.setShowHorizontalLines(false);
        jScrollPMPPlaylists.setViewportView(jTableUserPlaylists);

        javax.swing.GroupLayout jMPPanelTablesLayout = new javax.swing.GroupLayout(jMPPanelTables);
        jMPPanelTables.setLayout(jMPPanelTablesLayout);
        jMPPanelTablesLayout.setHorizontalGroup(
            jMPPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMPPanelTablesLayout.createSequentialGroup()
                .addComponent(jScrollPMPPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        jMPPanelTablesLayout.setVerticalGroup(
            jMPPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPMPPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(jScrollPSearchResults, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jMPRedFreePanel.add(jMPPanelTables);
        jMPPanelTables.setBounds(0, 40, 640, 370);

        jMPPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playButton.png"))); // NOI18N
        jMPPlayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPPlayButtonMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPPlayButton);
        jMPPlayButton.setBounds(10, 0, 40, 40);

        jMPPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pauseButton.png"))); // NOI18N
        jMPPauseButton.setText("jLabel2");
        jMPPauseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPPauseButtonMouseClicked(evt);
            }
        });
        jMPRedFreePanel.add(jMPPauseButton);
        jMPPauseButton.setBounds(10, 0, 40, 40);

        javax.swing.GroupLayout jMPBackgroundLayout = new javax.swing.GroupLayout(jMPBackground);
        jMPBackground.setLayout(jMPBackgroundLayout);
        jMPBackgroundLayout.setHorizontalGroup(
            jMPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMPBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jMPRedFreePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
        );
        jMPBackgroundLayout.setVerticalGroup(
            jMPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMPRedFreePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMPBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMPBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jMainPanel, "card2");

        javax.swing.GroupLayout jSearchPanelLayout = new javax.swing.GroupLayout(jSearchPanel);
        jSearchPanel.setLayout(jSearchPanelLayout);
        jSearchPanelLayout.setHorizontalGroup(
            jSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        jSearchPanelLayout.setVerticalGroup(
            jSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        getContentPane().add(jSearchPanel, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void saveSelectedTrackFromTable(int selectedTrackIdentifier) {
        selectedTrack = trackContents.get(selectedTrackIdentifier);
    }

    public TrackContent getTrackFromSearchResults() {
        return trackContents.get(selecetedRow);
    }

    public void getTracksFromSelectedPlaylist(int selectedPlaylist) {
        String id = playlistContents.get(selectedPlaylist).getId();
        trackContents.clear();
        trackContents.addAll(spotfyPlaylist.getPlayListTracks(id));
        defTableModel = (DefaultTableModel) jTableSearchResults.getModel();
        defTableModel.setRowCount(0);
        System.out.println(defTableModel.getRowCount());
        sWTrackContentToTable = new SWTrackContentToTable(trackContents);
    }

    private void jMPBSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBSearchMouseClicked
        defTableModel = (DefaultTableModel) jTableSearchResults.getModel();
        defTableModel.setRowCount(0);
        try {
            trackContents.clear();
            trackContents.addAll(spotfySearch.searchTrack(jTextFMPSearch.getText()));
            try {
                sWTrackContentToTable = new SWTrackContentToTable(trackContents);
            } catch (Exception e) {
                System.out.println("Erro ao Entrar em Swing Woker Track Content to Table");
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMPBSearchMouseClicked

    private void jMPButtonOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPButtonOptionMouseClicked
        sWPanelHeader = new SWPanelHeader(this.getWidth());
        try {
            this.setResizable(false);
            sWPanelHeader.execute();
            this.setResizable(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMPButtonOptionMouseClicked

    private void jMPBAddToPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBAddToPlaylistMouseClicked
        selectedTrack = getTrackFromSearchResults();
        spotfyPlaylist.addTracksToPlayList(jTextFMPSearch.getText(), selectedTrack.getName());
    }//GEN-LAST:event_jMPBAddToPlaylistMouseClicked

    private void jMPPlayButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPPlayButtonMouseClicked
        jMPPlayButton.setVisible(false);
        TrackContent trackFromSearchResults = getTrackFromSearchResults();
        devices.clear();
        devices.addAll(spotfyPlayer.getUserAvailableDevices());
        spotfyPlayer.startResumeUserPlayback(devices.get(0), trackFromSearchResults.getUri());
        jMPPauseButton.setVisible(true);
    }//GEN-LAST:event_jMPPlayButtonMouseClicked

    private void jMPPauseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPPauseButtonMouseClicked
        jMPPauseButton.setVisible(false);
        spotfyPlayer.pauseUserPlayback(devices.get(0));
        jMPPlayButton.setVisible(true);
    }//GEN-LAST:event_jMPPauseButtonMouseClicked

    private void jMPBToAddPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBToAddPlaylistMouseClicked
        jMPBCreatePlaylist.setVisible(false);
        jMPBSearch.setVisible(false);
        jMPBAddToPlaylist.setVisible(true);
    }//GEN-LAST:event_jMPBToAddPlaylistMouseClicked

    private void jMPBToSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBToSearchMouseClicked
        jMPBCreatePlaylist.setVisible(false);
        jMPBAddToPlaylist.setVisible(false);
        jMPBSearch.setVisible(true);
    }//GEN-LAST:event_jMPBToSearchMouseClicked

    private void jMPBToNewPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBToNewPlaylistMouseClicked
        jMPBSearch.setVisible(false);
        jMPBAddToPlaylist.setVisible(false);
        jMPBCreatePlaylist.setVisible(true);
    }//GEN-LAST:event_jMPBToNewPlaylistMouseClicked

    private void jMPBCreatePlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPBCreatePlaylistMouseClicked
        spotfyPlaylist.createPlaylist(jTextFMPSearch.getText());
        sWUptadeTableUserPlaylists = new SWUptadeTableUserPlaylists(jTextFMPSearch.getText());
    }//GEN-LAST:event_jMPBCreatePlaylistMouseClicked

    private void searchUserPlaylists() {
        playlistContents.addAll(spotfyPlaylist.getListOfUsersPlaylist());
        for (PlaylistContent playlistContent : playlistContents) {
            userPlaylistsName.add(playlistContent.getName());
        }
    }

    private void addUserPlaylistsToTable(List<String> userPlaylists) {
        defTableModel = (DefaultTableModel) jTableUserPlaylists.getModel();
        try {
            swTableUserPlaylists.init(userPlaylistsName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private class SWUptadeTableUserPlaylists extends SwingWorker<Void, Void> {

        Object[] rowData;
        String name;

        public SWUptadeTableUserPlaylists(String name) {
            this.name = name;
            rowData = new Object[1];
            try {
                doInBackground();
            } catch (Exception e) {
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            defTableModelToSWUpdate = (DefaultTableModel) jTableUserPlaylists.getModel();
            rowData[0] = name;
            defTableModelToSWUpdate.addRow(rowData);
            return null;
        }

    }

    private class SWTrackContentToTable extends SwingWorker<DefaultTableModel, Void> {

        List<TrackContent> tracks;
        Object[] rowData = new Object[2];

        public SWTrackContentToTable(List<TrackContent> playlistTrackContents) {
            this.tracks = new ArrayList<>();
            this.tracks.addAll(playlistTrackContents);
            try {
                doInBackground();
            } catch (Exception e) {
                System.out.println("Swing Woker Track Content to Table error");
            }
        }

        @Override
        protected DefaultTableModel doInBackground() throws Exception {
            for (TrackContent track : tracks) {
                rowData[0] = track.getName();
                rowData[1] = track.getArtist();
                defTableModel.addRow(rowData);
            }
            done();
            return defTableModel;
        }

    }

    private class SWPanelHeader extends SwingWorker<Void, Void> {

        int windowWidth;

        public SWPanelHeader(int windowWidth) {
            this.windowWidth = windowWidth;
        }

        @Override
        protected Void doInBackground() throws Exception {
            if (jMPPanelHeader.getHeight() >= 120) {
                jMPPanelHeader.setSize(160, 10);
                jMPPanelHeader.setVisible(false);
            } else {
                jMPPanelHeader.setVisible(true);
                while (jMPPanelHeader.getHeight() <= 120) {
                    jMPPanelHeader.setLocation((windowWidth - 190), 40);
                    jMPPanelHeader.setSize(jMPPanelHeader.getWidth(), (jMPPanelHeader.getHeight() + 2));
                    Thread.sleep(1);
                    System.out.println(jMPPanelHeader.getY());
                }
            }
            return null;
        }
    }

    private class SWListTable extends SwingWorker<DefaultTableModel, String> {

        List<String> itemsToReceive;
        Object[] rowData;
        boolean itemJaExistente;

        public void init(List<String> str) {
            itemJaExistente = false;
            rowData = new Object[1];
            itemsToReceive = new ArrayList<>();
            itemsToReceive.addAll(str);
            try {
                doInBackground();
            } catch (Exception e) {

            }
        }

        @Override
        protected DefaultTableModel doInBackground() throws Exception {

            for (String string : itemsToReceive) {
                if (defTableModel.getRowCount() == 0) {
                    rowData[0] = string;
                    defTableModel.addRow(rowData);
                }
                itemJaExistente = false;
                for (int indice = 0; indice < defTableModel.getRowCount(); indice++) {
                    if (defTableModel.getValueAt(indice, 0).equals(string)) {
                        itemJaExistente = true;
                    }
                }
                if (!itemJaExistente) {
                    rowData[0] = string;
                    defTableModel.addRow(rowData);
                }

            }
            return defTableModel;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jMPBAddToPlaylist;
    private javax.swing.JButton jMPBCreatePlaylist;
    private javax.swing.JButton jMPBSearch;
    private javax.swing.JLabel jMPBToAddPlaylist;
    private javax.swing.JLabel jMPBToNewPlaylist;
    private javax.swing.JLabel jMPBToSearch;
    private javax.swing.JPanel jMPBackground;
    private javax.swing.JLabel jMPButtonOption;
    private javax.swing.JPanel jMPPanelHeader;
    private javax.swing.JPanel jMPPanelTables;
    private javax.swing.JLabel jMPPauseButton;
    private javax.swing.JLabel jMPPlayButton;
    private javax.swing.JPanel jMPRedFreePanel;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JScrollPane jScrollPMPPlaylists;
    private javax.swing.JScrollPane jScrollPSearchResults;
    private javax.swing.JPanel jSearchPanel;
    private javax.swing.JTable jTableSearchResults;
    private javax.swing.JTable jTableUserPlaylists;
    private javax.swing.JTextField jTextFMPSearch;
    // End of variables declaration//GEN-END:variables
}
