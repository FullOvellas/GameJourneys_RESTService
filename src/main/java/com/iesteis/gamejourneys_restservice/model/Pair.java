package com.iesteis.gamejourneys_restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair<T, U> {

    @JsonProperty("source")
    private T firstElement;
    @JsonProperty("target")
    private U secondElement;

    public Pair(T firstElement, U secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }

    public U getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(U secondElement) {
        this.secondElement = secondElement;
    }

}
