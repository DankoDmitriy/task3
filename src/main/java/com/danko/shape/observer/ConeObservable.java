package com.danko.shape.observer;

public interface ConeObservable {
    void attach(ConeObserver observer);

    void detach();

    void notifyObservers();
}
