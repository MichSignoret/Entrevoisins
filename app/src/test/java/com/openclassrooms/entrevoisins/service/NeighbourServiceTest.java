package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;
    private NeighbourApiService favoriteService;

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

    @Test
    public void addFavoriteNeigbourWithSuccess() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.setNeighbourFavor(neighbourToAdd, true);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAdd));
    }

    @Test
    public void deleteFromFavoriteNeigbourWithSuccess() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        neighbourToAdd.setIsFavorite(true);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAdd));
        service.setNeighbourFavor(neighbourToAdd, false);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToAdd));
    }

    @Test
    public void controlFavoriteList()
    {
        service.getNeighbours().get(0).setIsFavorite(true);
        service.getNeighbours().get(1).setIsFavorite(true);
        for (Neighbour n :service.getFavoriteNeighbours()
             ) {
            assertTrue(n.getIsFavorite()==true);
        }
        assertTrue(service.getFavoriteNeighbours().size()==2);
    }


}
