
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stit_
 */
public class Teste {
   SpotifyApi spotifyApi = new SpotifyApi.Builder()
        .setAccessToken("BQDF3gAc7jM0Pc5y2FtFF1e2pjjGFq8hU3dus-ZvxtifH0br9xvuPQ2W6dAU73O-P9rhp78lJxfO53zqKD_9jtdvFdtHewVpw9sYJKHJUQ2-bYQt1vOdv_cm-hM2Qwp1JWPR8llA7Jub-LsGm9Qa5zzKmohh4PAKSVn4oE27Ysr3KFJLa-WJSu9Pcljf3LOY_xUJnwzYTCcrcWYeCNTucLN4-xLvJU3aRg0q7Bd463d_dPxZittnlB_NHQsG-lklLFRL12au4Y9J")
        .build();
      final SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks("drake").build();

      void SearchTracksSync(){
          //searchTracksRequest.
          try {
            final Paging paging= searchTracksRequest.execute();
              Object[] items = paging.getItems();
              for (Object item : items) {
                  System.out.println(((Track)item).getName());
              }
        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
      }
}
