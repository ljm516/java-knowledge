package com.javaReview.pattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Moon {

    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name) {
        for (LandingObserver observer : observers) {
            observer.observerLanding(name);
        }
    }

    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }
}

