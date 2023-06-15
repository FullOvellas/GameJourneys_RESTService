package com.iesteis.gamejourneys_restservice.model.dto;

import com.iesteis.gamejourneys_restservice.model.Pair;

import java.io.Serializable;
import java.util.List;

public class Journey implements Serializable {

    private String name;
    private List<JourneyNode> nodes;
    private List<Pair<Integer, Integer>> links;
    private List<Integer> weights;

    public Journey(String name, List<JourneyNode> nodes, List<Pair<Integer, Integer>> links, List<Integer> weights) {
        this.name = name;
        this.nodes = nodes;
        this.links = links;
        this.weights = weights;
    }

    public List<JourneyNode> getNodes() {
        return nodes;
    }

    public List<Pair<Integer, Integer>> getLinks() {
        return links;
    }

    public List<Integer> getWeights() {
        return weights;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "name='" + name + '\'' +
                ", \nnodes=" + nodes +
                ", \nlinks=" + links +
                ", \nweights=" + weights +
                '}';
    }
}
