package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class FavoriteNeighbourApiService implements NeighbourApiService{

    private List<Neighbour> neighbours = new ArrayList<>();

    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        return null;
    }

    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public boolean setNeighbourFavor(Neighbour neighbourToFind, boolean favorite) {
        return false;
    }
}
