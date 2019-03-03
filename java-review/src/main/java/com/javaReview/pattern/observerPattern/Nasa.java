package com.javaReview.pattern.observerPattern;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Nasa implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
