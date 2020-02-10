package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbour = new ArrayList<>();

    public String key;
    public boolean booleanPreference = true;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Neighbour> getNeighbours() {return neighbours;}

    @Override
    public List<Neighbour> getFavoriteNeighbours(Context context) {
        favoriteNeighbour.clear();
        for (Neighbour n : neighbours) {
            key = n.getId().toString();
            booleanPreference = SharedPreferencesUtils.getBooleanPreference(context, key);
            if (booleanPreference) {
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
