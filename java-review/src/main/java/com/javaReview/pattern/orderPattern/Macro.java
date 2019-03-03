package com.javaReview.pattern.orderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Macro {

    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

}
