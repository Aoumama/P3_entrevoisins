package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(RobolectricTestRunner.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;


    @Before
    public void setup() {

        service = DI.getNewInstanceApiService();

    }


    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }


    // Affiche la liste des favoris
    @Test
    public void getFavoriteNeighboursWithSuccess() {
        Context context = ApplicationProvider.getApplicationContext();
        SharedPreferencesUtils.getInstance(context).setBooleanPreference("1", true);
        List<Neighbour> neighbours = service.getFavoriteNeighbours(context);
        // valeur qu'on espere avoir
        assertEquals(1, neighbours.size());
        SharedPreferencesUtils.getInstance(context).setBooleanPreference("1", false);
        neighbours = service.getFavoriteNeighbours(context);
        assertEquals(0, neighbours.size());
    }





}
