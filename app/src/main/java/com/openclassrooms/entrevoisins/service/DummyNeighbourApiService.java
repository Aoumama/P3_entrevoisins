package com.openclassrooms.entrevoisins.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.mbms.StreamingServiceInfo;
import android.widget.ListView;
import android.widget.TextView;


import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourDetailActivity;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbour = new ArrayList<>();

    private SharedPreferences preferences;
    private boolean spF;
    private String key;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Neighbour> getNeighbours() {return neighbours;}

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        // TODO : return favorite Neighbour

        for(Neighbour n : neighbours){
            spF = preferences.getBoolean(key,true); // SP et Key sont à null
            if(neighbours.contains()){  // idSP
                favoriteNeighbour.add(n);
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
