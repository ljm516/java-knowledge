package com.javaReview.domain.module;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiangmingli on 2017/10/13.
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public int numberCreated() {
        return counter.get();
    }


}
