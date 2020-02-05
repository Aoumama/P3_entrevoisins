package com.openclassrooms.entrevoisins.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.telephony.mbms.StreamingServiceInfo;
import android.widget.ListView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourDetailActivity;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbour = new ArrayList<>();

    private Integer idNeighbour;
    private Neighbour neighbour;
    private String id;


    /**
     * {@inheritDoc}
     */

    @Override
    public List<Neighbour> getNeighbours() {return neighbours;}

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        // TODO : return favorite Neighbours
        // On cree une liste vide de neighbours
        //On itere sur tous les utillisateurs avec un for :
        //Pour chaque utilisateur si l’ID de l’utilisateur existe dans les sharedpreferences
        //-> on l’ajoute dans la liste initialement vide
        //Si il n’existe pas
        //-> on fait rien
        idNeighbour = neighbour.getId();
        for (int i=0; i<neighbours.size(); i++) {
            if (neighbours.contains(idNeighbour)) {
                favoriteNeighbour.add(neighbour);
            }
        }

        return favoriteNeighbour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }
}
