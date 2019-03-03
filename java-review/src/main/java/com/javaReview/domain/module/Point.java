package com.javaReview.domain.module;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangmingli on 2017/10/13.
 */
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static final Set<Point> unitCircle;
    static {
        unitCircle = new HashSet<>();
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(0, -1));
    }

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }

    //use getClass instead instanceof
    @Override public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}
