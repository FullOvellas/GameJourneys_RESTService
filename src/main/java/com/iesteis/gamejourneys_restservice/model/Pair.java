package com.iesteis.gamejourneys_restservice.model;

public class Pair<T, U> {

    private T firstElement;
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
