package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * getFavoriteNeighbours
     *
     */
    public List<Neighbour> getFavoriteNeighbours (){
        List<Neighbour> favorites = new ArrayList<Neighbour>();
        for(Neighbour neighbour: neighbours)  {
            if (neighbour.getIsFavorite()) {
                favorites.add(neighbour);
            }
        }
        return favorites;
    }

    public boolean setNeighbourFavor (Neighbour neighbourToFind, boolean favorite) {
        boolean found = false;
        for(Neighbour neighbour: neighbours)  {
            if (neighbour.equals(neighbourToFind)) {
                neighbour.setIsFavorite(favorite);
                found=true;
            }
        }
        return found;
    }
}
