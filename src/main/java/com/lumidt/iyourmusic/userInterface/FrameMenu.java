package com.lumidt.iyourmusic.userInterface;

import com.lumidt.iyourmusic.spotfy.search.SpotfySearchAdapter;
import com.lumidt.iyourmusic.spotfy.playlist.SpotfyPlaylistAdapter;
import com.sun.prism.impl.PrismSettings;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class FrameMenu extends javax.swing.JFrame {

    SpotfySearchAdapter spotfySearch;
    SpotfyPlaylistAdapter spotfyPlaylist;
    List<String> userPlaylistsName;
    DefaultTableModel defTableModel;
    SWTableUserPlaylists swTableUserPlaylists;

    public FrameMenu() {
        initComponents();
        spotfySearch = new SpotfySearchAdapter();
        spotfyPlaylist = new SpotfyPlaylistAdapter();
        userPlaylistsName = new ArrayList<>();
        swTableUserPlaylists = new SWTableUserPlaylists();
        searchUserPlaylists();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainPanel = new javax.swing.JPanel();
        jMPTopPanel = new javax.swing.JPanel();
        jMainPSearchM = new javax.swing.JButton();
        jTextFMPSearch = new javax.swing.JTextField();
        jScrollPMPPlaylists = new javax.swing.JScrollPane();
        jTableUserPlaylists = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSearchPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSearchPanelBuscas = new javax.swing.JPanel();
        jRBSearchPanelYoutube = new javax.swing.JRadioButton();
        jRBSearchPanelSpofty = new javax.swing.JRadioButton();
        jButtonSPBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jMainPanel.setBackground(new java.awt.Color(51, 51, 51));

        jMPTopPanel.setBackground(new java.awt.Color(102, 0, 0));

        jMainPSearchM.setText("Search");
        jMainPSearchM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMainPSearchMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jMPTopPanelLayout = new javax.swing.GroupLayout(jMPTopPanel);
        jMPTopPanel.setLayout(jMPTopPanelLayout);
        jMPTopPanelLayout.setHorizontalGroup(
            jMPTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMPTopPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFMPSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jMainPSearchM)
                .addGap(17, 17, 17))
        );
        jMPTopPanelLayout.setVerticalGroup(
            jMPTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMPTopPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jMPTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMainPSearchM)
                    .addComponent(jTextFMPSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTableUserPlaylists.setBackground(new java.awt.Color(0, 0, 0));
        jTableUserPlaylists.setForeground(new java.awt.Color(255, 255, 255));
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
        jTableUserPlaylists.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTableUserPlaylists.setShowHorizontalLines(false);
        jScrollPMPPlaylists.setViewportView(jTableUserPlaylists);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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
        jTable2.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPMPPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jMPTopPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPanelLayout.createSequentialGroup()
                .addComponent(jMPTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPMPPlaylists, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jMainPanel, "card2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jSearchPanelBuscas.setBackground(new java.awt.Color(255, 102, 102));
        jSearchPanelBuscas.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jRBSearchPanelYoutube.setText("Youtube");

        jRBSearchPanelSpofty.setText("Spotfy");
        jRBSearchPanelSpofty.setToolTipText("");
        jRBSearchPanelSpofty.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonSPBuscar.setText("Buscar");
        jButtonSPBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSPBuscarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jSearchPanelBuscasLayout = new javax.swing.GroupLayout(jSearchPanelBuscas);
        jSearchPanelBuscas.setLayout(jSearchPanelBuscasLayout);
        jSearchPanelBuscasLayout.setHorizontalGroup(
            jSearchPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSearchPanelBuscasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jRBSearchPanelYoutube)
                .addGap(52, 52, 52)
                .addComponent(jButtonSPBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                .addComponent(jRBSearchPanelSpofty)
                .addGap(30, 30, 30))
        );
        jSearchPanelBuscasLayout.setVerticalGroup(
            jSearchPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSearchPanelBuscasLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jSearchPanelBuscasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBSearchPanelYoutube)
                    .addComponent(jRBSearchPanelSpofty)
                    .addComponent(jButtonSPBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jSearchPanelLayout = new javax.swing.GroupLayout(jSearchPanel);
        jSearchPanel.setLayout(jSearchPanelLayout);
        jSearchPanelLayout.setHorizontalGroup(
            jSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSearchPanelBuscas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jSearchPanelLayout.setVerticalGroup(
            jSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSearchPanelLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSearchPanelBuscas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jSearchPanel, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchUserPlaylists() {
        userPlaylistsName.addAll(spotfyPlaylist.getListOfUsersPlaylist());
        addUserPlaylistsToTable(userPlaylistsName);
    }

    class SWTableUserPlaylists extends SwingWorker<DefaultTableModel, String> {

        Object[] rowData = new Object[1];
        int indice = 0;
        
        @Override
        protected DefaultTableModel doInBackground() throws Exception {
            
            for (String string : userPlaylistsName) {
                
//                for(int indice = 0; indice < userPlaylistsName.size(); indice++){
//                    if(!defTableModel.getValueAt(indice, 0).equals(string) || indice !=0 && defTableModel.getValueAt(indice - 1, 0).equals(string)){
//                        rowData[0] = userPlaylistsName;
//                        publish(rowData);
//                    }
//                }
                rowData[0] = string;
                System.out.println("bbb");
                defTableModel.addRow(rowData);
            }
            return defTableModel;
        }
    }

    private void addUserPlaylistsToTable(List<String> userPlaylists) {
        defTableModel = (DefaultTableModel) jTableUserPlaylists.getModel();
        try {
            swTableUserPlaylists.doInBackground();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void jButtonSPBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSPBuscarMouseEntered
        if (jRBSearchPanelSpofty.isEnabled()) {

        } else if (jRBSearchPanelYoutube.isEnabled()) {
        }
    }//GEN-LAST:event_jButtonSPBuscarMouseEntered

    private void jMainPSearchMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMainPSearchMMouseClicked
        jMainPanel.setVisible(false);
        jSearchPanel.setVisible(true);
    }//GEN-LAST:event_jMainPSearchMMouseClicked

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
    private javax.swing.JButton jButtonSPBuscar;
    private javax.swing.JPanel jMPTopPanel;
    private javax.swing.JButton jMainPSearchM;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBSearchPanelSpofty;
    private javax.swing.JRadioButton jRBSearchPanelYoutube;
    private javax.swing.JScrollPane jScrollPMPPlaylists;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jSearchPanel;
    private javax.swing.JPanel jSearchPanelBuscas;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableUserPlaylists;
    private javax.swing.JTextField jTextFMPSearch;
    // End of variables declaration//GEN-END:variables
}
