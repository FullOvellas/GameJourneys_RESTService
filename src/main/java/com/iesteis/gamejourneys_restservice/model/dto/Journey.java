package com.iesteis.gamejourneys_restservice.model.dto;

import com.iesteis.gamejourneys_restservice.model.Pair;

import java.util.List;

public class Journey {

    private JourneyNode[] nodes;
    private List<Pair<String, String>> links;
    private List<Integer> weights;

    public Journey(JourneyNode[] nodes, List<Pair<String, String>> links, List<Integer> weights) {
        this.nodes = nodes;
        this.links = links;
        this.weights = weights;
    }

    public JourneyNode[] getNodes() {
        return nodes;
    }

    public List<Pair<String, String>> getLinks() {
        return links;
    }

    public List<Integer> getWeights() {
        return weights;
    }

}
